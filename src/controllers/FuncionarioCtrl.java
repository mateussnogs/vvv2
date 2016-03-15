package controllers;

import VVV.ErroValidacao;
import VVV.MensagemValidacao;
import daos.FuncionarioDAO;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Validation;
import javax.validation.Validator;
import model.Funcionario;
import lib.jBCrypt.BCrypt;


public class FuncionarioCtrl {
    
    public static final int GERENTE     = 0;
    public static final int FUNCIONARIO = 1;
    
    private static final Logger    LOGGER    = Logger.getLogger(FuncionarioCtrl.class.getName());
    private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();
    
    public static enum Campo{CPF, USUARIO}
    
    private static Funcionario logado = null;
    
    public static Funcionario getUsuarioLogado() {
        return logado;
    }
    
    public static boolean verificarExistenciaFuncionario(String valor, Campo campo) {
        List query = campo == Campo.USUARIO?
                FuncionarioDAO.encontrarFuncionarioPorUsuario(valor)
                : FuncionarioDAO.encontrarFuncionarioPorCpf(valor);
        
        return !(query == null || query.isEmpty());
    }
    
    public static Funcionario encontrarFuncionarioPorUsuario(String user) {
        List query = FuncionarioDAO.encontrarFuncionarioPorUsuario(user);
        return query == null || query.isEmpty()? null : (Funcionario)(query.get(0));
    }
    
    public static void cadastrarFuncionario(
            String nome,
            String endereco,
            String telefone,
            int cargo,
            String senha,
            String nomeDeUsuario,
            String cpf
    ) throws ErroValidacao {
        
        if(senha.length() < 6){
            MensagemValidacao.Senha.throwErroValidacao("Tamanho");
        }
        
        Funcionario funcionario = new Funcionario(
                nome,
                endereco,
                telefone,
                cargo,
                BCrypt.hashpw(senha, BCrypt.gensalt(12)).getBytes(),
                nomeDeUsuario,
                cpf
        );
        
        if(FuncionarioCtrl.verificarExistenciaFuncionario(nomeDeUsuario, FuncionarioCtrl.Campo.USUARIO)){
            MensagemValidacao.Usuario.throwErroValidacao("Unico");
        }
        
        if(FuncionarioCtrl.verificarExistenciaFuncionario(cpf, FuncionarioCtrl.Campo.CPF)){
            MensagemValidacao.Cpf.throwErroValidacao("Unico");
        }
        
        MensagemValidacao.assertValidacao(VALIDATOR.validate(funcionario));
        
        FuncionarioDAO.salvar(funcionario);
    }
    
    public static Boolean login(String usuario, String senha){
        Funcionario funcionario = FuncionarioCtrl.encontrarFuncionarioPorUsuario(usuario);
        
        if(FuncionarioCtrl.logado == null){
            if(funcionario != null && BCrypt.checkpw(senha, new String(funcionario.getSenha(), StandardCharsets.UTF_8))){
                FuncionarioCtrl.logado = funcionario;
                return true;
            }
        }else{
            LOGGER.log(Level.SEVERE, "Usuário já logado");
        }
        
        return false;
    }
    
    public static void logout(){
        FuncionarioCtrl.logado = null;
    }
}
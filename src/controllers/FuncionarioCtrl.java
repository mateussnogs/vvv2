package controllers;

import daos.FuncionarioDAO;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Funcionario;
import lib.jBCrypt.BCrypt;


public class FuncionarioCtrl {
    
    public static final int GERENTE     = 0;
    public static final int FUNCIONARIO = 1;
    
    private static final Logger LOGGER = Logger.getLogger(FuncionarioCtrl.class.getName());
    private static Funcionario  logado = null;
    
    public static Funcionario getUsuarioLogado() {
        return logado;
    }
    
    public static boolean verificarExistenciaFuncionario(String user) {
        List query = FuncionarioDAO.encontrarFuncionarioPorUsuario(user);
        return !(query == null || query.isEmpty());
    }
    
    public static Funcionario encontrarFuncionarioPorUsuario(String user) {
        List query = FuncionarioDAO.encontrarFuncionarioPorUsuario(user);
        return query == null? null : (Funcionario)(query.get(0));
    }
    
    /*@todo Add Bean Validation here**/
    public static void cadastrarFuncionario(String nome, String endereco, String telefone, int cargo, String senha, String userName, String cpf) {
        FuncionarioDAO.salvar(new Funcionario(
                nome,
                endereco,
                telefone,
                cargo,
                BCrypt.hashpw(senha, BCrypt.gensalt(12)).getBytes(),
                userName,
                cpf
        ));
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

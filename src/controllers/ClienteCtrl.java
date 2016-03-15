package controllers;

import VVV.ErroValidacao;
import VVV.MensagemValidacao;
import daos.ClienteDAO;
import java.util.List;
import javax.validation.Validation;
import javax.validation.Validator;
import model.Cliente;

public class ClienteCtrl {
    private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();
    
    public static Cliente encontrarClientePorCpf(String cpf) {
        List query = ClienteDAO.encontrarClientePorCpf(cpf);
        return query == null? null : (Cliente)(query.get(0));
    }
    
    public static boolean verificarExistenciaCliente(String cpf) {
        List resultList = ClienteDAO.encontrarClientePorCpf(cpf);
        return !(resultList != null && resultList.isEmpty());
    }
    
    public static void cadastrarCliente(String nome, String idadeTexto, String cpf, String telefone, String endereco, String profissao) throws ErroValidacao {
        int idade;
        
        try{
            idade = Integer.parseInt(idadeTexto);
            
        }catch(NumberFormatException ignored){
            MensagemValidacao.Idade.throwErroValidacao("Invalido");
            return;
        }
        
        Cliente cliente = new Cliente(nome, cpf, telefone, profissao, endereco, idade);
        
        MensagemValidacao.assertValidacao(VALIDATOR.validate(cliente));
        
        if(ClienteCtrl.verificarExistenciaCliente(cpf)){
            MensagemValidacao.Cpf.throwErroValidacao("Unico");
        }
        
        ClienteDAO.salvar(cliente);
    }
}

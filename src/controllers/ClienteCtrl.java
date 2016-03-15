/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import VVV.ErroValidacao;
import daos.ClienteDAO;
import java.util.List;
import model.Cliente;

/**
 *
 * @author mateus
 */
public class ClienteCtrl {
    
    
    public ClienteCtrl() {
        
    }    
    
    //Checa se o cliente já está cadastrado
    public boolean verificarExistenciaCliente(String cpf) {
        List resultList = ClienteDAO.encontrarClientePorCpf(cpf);
        return !(resultList != null && resultList.isEmpty());
    }
    
    public void cadastrarCliente(String nome, int idade, String cpf, String telefone, String endereco, String profissao) throws ErroValidacao {
        ClienteDAO.salvar(new Cliente(nome, cpf, telefone, profissao, endereco, idade));
    }
    
    public Cliente encontrarClientePorCpf(String cpf) {
        List query = ClienteDAO.encontrarClientePorCpf(cpf);
        return query == null? null : (Cliente)(query.get(0));
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

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
    public boolean checkUserRegistered(String user, String pass) {
        List resultList = ClienteDAO.getClienteByUserNameAndPass(user, pass);
        if (resultList != null && resultList.size() == 0) {
            return false;
        } else {
            return true;
        }
    }
    
    public void cadastrarCliente(Cliente cliente) {
        ClienteDAO.CadastrarCliente(cliente);
    }
    
    public Cliente getClienteByUserPass(String user, String pass) {
        Cliente c = (Cliente)ClienteDAO.getClienteByUserNameAndPass(user, pass).get(0);
        return c;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.FuncionarioDAO;
import java.util.List;
import model.Funcionario;

/**
 *
 * @author mateus
 */
public class FuncionarioCtrl {
    
    public FuncionarioCtrl() {
        
    }
    
    public boolean checkFuncionarioRegistered(String user, String pass) {
        List resultList = FuncionarioDAO.getFuncionarioByUserNameAndPass(user, pass);
        if (resultList != null && resultList.size() == 0) {
            return false;
        } else {
            return true;
        }
    }
    
    public Funcionario getFuncionarioByUserPass(String user, String pass) {
        Funcionario c = (Funcionario)FuncionarioDAO.getFuncionarioByUserNameAndPass(user, pass).get(0);
        return c;
    }
    
    public void cadastrarFuncionario(Funcionario func) {
        FuncionarioDAO.CadastrarFuncionario(func);
    }
    
    
}

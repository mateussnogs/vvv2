/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;
import java.util.logging.Logger;

public class FuncionarioDAO extends DOA{
    public static final Logger logger = Logger.getLogger(FuncionarioDAO.class.getName());
    
    public static List encontrarFuncionarioPorUsuario(String usuario){
        session.beginTransaction();
        return session.createQuery("select f from Funcionario as funcionario where funcionario.usuario = '" + usuario + "'").list();
    }
}

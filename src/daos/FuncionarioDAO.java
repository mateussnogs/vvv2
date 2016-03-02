/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;
import model.Funcionario;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import vvv2.HibernateUtil;

/**
 *
 * @author mateus
 */
public class FuncionarioDAO {
    
    
    public FuncionarioDAO() { }
    
    
    
    public static List getFuncionarioByUserNameAndPass(String user, String pass) {
        List resultList = null;
        
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery("select f from Funcionario as f where f.userName = " + "'" + user.toString() + "'" + " and f.password = " + "'" + pass.toString() + "'");
            resultList = q.list();
            
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        
        return resultList;
    }
    
    public static void CadastrarFuncionario(Funcionario f) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(f);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }
}

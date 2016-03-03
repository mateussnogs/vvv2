/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;
import model.Cliente;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import vvv2.HibernateUtil;

/**
 *
 * @author mateus
 */
public class ClienteDAO {
    
    public ClienteDAO() {
        
    }
    
    public static void CadastrarCliente(Cliente c) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(c);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }
    
    public static List getClienteByUserNameAndPass(String user, String pass) {
        List resultList = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery("select c from Cliente as c where c.userName = " + "'" + user.toString() + "'" + " and c.password = " + "'" + pass.toString() + "'");
            resultList = q.list();

        } catch (HibernateException he) {
            he.printStackTrace();
        }
        
        return resultList;
    }   
}

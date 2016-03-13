/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author mateus
 */
public class CidadeDAO {
    public CidadeDAO() {
        
    }
    
    public static String getNomeCidadeById(int id) {
        String nomeCidade = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery("Select c.nome from Cidade as c where c.id = " + id);
            List resultList = q.list();
            nomeCidade = resultList.get(0).toString();
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }

        return nomeCidade;
    }
}

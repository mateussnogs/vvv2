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
public class ModalDAO {
    public ModalDAO() {
        
    }
    
    public static String getNomeModalById(int id) {
        String nomeModal = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery("Select m.tipoModal from Modal as m where m.idModal = " + id);
            List resultList = q.list();
            nomeModal = resultList.get(0).toString();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        
        return nomeModal;

    }
}

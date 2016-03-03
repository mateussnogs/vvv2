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
import vvv2.HibernateUtil;

/**
 *
 * @author mateus
 */
public class EscalaDAO {
    public EscalaDAO() {
        
    }
    
    public static List getEscalasByViagemId(int id) {
        List resultList = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery("Select from Escala as e where e.viagem.id = " + id);
            resultList = q.list();            
        } catch (HibernateException he) {
            he.printStackTrace();
        }

        return resultList;
    }
}

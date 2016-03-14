package daos;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author HeavenVolkoff
 */
public class DOA {
    public static final Logger LOGGER = Logger.getLogger(DOA.class.getName());
    public static Session session;
    
    static{
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            
        } catch(HibernateException e){
            LOGGER.log(Level.SEVERE, null, e);
            session = null;
        }
    }
    
    public static Boolean salvar(Object o) {
        try{
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            
            return true;            
        }catch(RuntimeException e){
            LOGGER.log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
        }
        
        return false;
    }
}

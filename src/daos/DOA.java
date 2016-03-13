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
    public static final Logger logger = Logger.getLogger(DOA.class.getName());
    public static Session session;
    
    static{
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            
        } catch(HibernateException exception){
            logger.log(Level.SEVERE, null, exception);
            session = null;
        }
    }
    
    public static void salvar(Object o) {
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
    }
}

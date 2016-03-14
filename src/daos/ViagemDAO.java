package daos;

import static daos.DOA.LOGGER;
import static daos.DOA.session;
import java.util.List;
import java.util.logging.Level;
import org.hibernate.HibernateException;

public class ViagemDAO extends DOA{
    
    public static List pegarListaDeViagens() {
        List resultList = null;
        
        try {
            session.beginTransaction();
            resultList = session
                    .createQuery("FROM Viagem")
                    .list();
            
            session.getTransaction().commit();
        } catch (HibernateException e) {
            LOGGER.log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
        }
        
        return resultList;
    }
    
    public static List encontrarViagemPorId(int id) {
        List resultList = null;
        
        try {
            session.beginTransaction();
            resultList = session
                    .createQuery("SELECT FROM Viagem as v WHERE v.id = " + id)
                    .list();
            
            session.getTransaction().commit();
        } catch (HibernateException e) {
            LOGGER.log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
        }
        
        return resultList;
    }    
}

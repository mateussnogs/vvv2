package daos;

import static daos.DOA.LOGGER;
import static daos.DOA.session;
import java.util.List;
import java.util.logging.Level;
import org.hibernate.HibernateException;

public class ClienteDAO extends DOA{    
    public static List encontrarClientePorCpf(String cpf) {
        List resultList = null;
        
        try {
            session.beginTransaction();
            resultList = session
                    .createQuery("select c from Cliente as c where c.cpf = " + cpf)
                    .list();
            
            session.getTransaction().commit();
        } catch (HibernateException e) {
            LOGGER.log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
        }
        
        return resultList;
    }   
}

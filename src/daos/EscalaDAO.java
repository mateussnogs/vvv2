package daos;

import java.util.List;
import java.util.logging.Level;
import org.hibernate.HibernateException;

public class EscalaDAO extends DOA{
    public static List encontrarEscalaPorViagemId(int id) {
        List resultList = null;
        
        try {
            session.beginTransaction();
            resultList = session
                    .createQuery("Select from Escala as e where e.viagem.id = " + id)
                    .list();
            
            session.getTransaction().commit();
        } catch (HibernateException e) {
            LOGGER.log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
        }

        return resultList;
    }
}

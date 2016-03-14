package daos;

import static daos.DOA.LOGGER;
import static daos.DOA.session;
import java.util.logging.Level;
import org.hibernate.HibernateException;

public class ModalDAO extends DOA{    
    public static String encontrarNomeDeModalPorId(int id) {
        String nomeModal = null;
        
        try {
            session.beginTransaction();
            nomeModal = session
                    .createQuery("Select m.tipoModal from Modal as m where m.idModal = " + id)
                    .list().get(0).toString();
            
            session.getTransaction().commit();
        } catch (HibernateException e) {
            LOGGER.log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
        }
        
        return nomeModal;
    }
}

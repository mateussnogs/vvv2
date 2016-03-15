package daos;

import static daos.DOA.LOGGER;
import static daos.DOA.session;
import java.util.List;
import java.util.logging.Level;
import org.hibernate.HibernateException;

public class PontoDeVendaDAO extends DOA{
    public static List pegarListaDePontosDeVendas() {
        List resultList = null;
        
        try {
            session.beginTransaction();
            resultList = session
                    .createQuery("FROM Pontodevenda")
                    .list();
            
            session.getTransaction().commit();
        } catch (HibernateException e) {
            LOGGER.log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
        }
        
        return resultList;
    }
    
    public static List encontrarPontoDeVendaPorCnpj(String cnpj) {
        List resultList = null;
        
        try {
            session.beginTransaction();
            resultList = session
                    .createQuery(String.format("select p from Pontodevenda as p where p.cnpj = '%s'", cnpj))
                    .list();
            
            session.getTransaction().commit();
        } catch (HibernateException e) {
            LOGGER.log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
        }
        
        return resultList;
    }   
}

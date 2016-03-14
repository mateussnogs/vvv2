package daos;

import static daos.DOA.session;
import java.util.logging.Level;

public class CidadeDAO extends DOA{    
    public static String encontrarNomeDeCidadePorId(int id) {
        String nomeCidade = null;
        
        try{
            session.beginTransaction();
            nomeCidade = session
                    .createQuery("Select c.nome from Cidade as c where c.id = " + id)
                    .list().get(0).toString();
            
            session.getTransaction().commit();
        }catch(RuntimeException e){
            LOGGER.log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
        }

        return nomeCidade;
    }
}

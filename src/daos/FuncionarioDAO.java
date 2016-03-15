package daos;

import java.util.List;
import java.util.logging.Level;
import org.hibernate.HibernateException;

public class FuncionarioDAO extends DOA{    
    public static List encontrarFuncionarioPorUsuario(String usuario){
        List l = null;
                
        try{
            session.beginTransaction();
            l = session
                    .createQuery(String.format("select f from Funcionario as f where f.usuario = '%s'", usuario))
                    .list();
            
            session.getTransaction().commit();
        }catch(HibernateException e){
            LOGGER.log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
        }
        
        return l;
    }
    
    public static List encontrarFuncionarioPorCpf(String cpf) {
        List l = null;
        
        try {
            session.beginTransaction();
            l = session
                    .createQuery(String.format("select f from Funcionario as f where f.cpf = '%s'", cpf))
                    .list();
            
            session.getTransaction().commit();
        } catch (HibernateException e) {
            LOGGER.log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
        }
        
        return l;
    }   
}

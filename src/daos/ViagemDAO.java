/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;
import model.Viagem;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import vvv2.HibernateUtil;

/**
 *
 * @author mateus
 */
public class ViagemDAO {
    
    public static List getViagens() {
        List resultList = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery("FROM Viagem");
            resultList = q.list();
            //displayViagens(resultList);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        
        return resultList;
    }
    
    public static Viagem getViagemById(int id) {
        List resultList = null;
        Viagem viagem = new Viagem();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery("SELECT FROM Viagem as v WHERE v.id = " + id);
            resultList = q.list();
            viagem = (Viagem)resultList.get(0);
            
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return viagem;
    }
    
    public static List getVagasTotaisViagem(int viagemId) {
        List resultList = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery("SELECT m.vagasDisponiveis FROM Viagem as v, Modal as m, Escala as e WHERE v.id = " + viagemId + " and v.id = e.viagem.id and e.modal.idModal = m.idModal"); 
            resultList = q.list();

        } catch (HibernateException he) {
            he.printStackTrace();
        }
        
        return resultList;
        
    }
    
}

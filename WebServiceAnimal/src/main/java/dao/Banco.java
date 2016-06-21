/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Frank
 */
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Banco {

    private static Banco instancia;
    private EntityManager em;

    private Banco() {
        em = Persistence.createEntityManagerFactory("AnimalFriendsPU").createEntityManager();
    }

    public synchronized static Banco getInstancia() {
        if (instancia == null) {
            System.out.println("nulo");
            instancia = new Banco();
        }else{
            System.out.println("n�o nulo");
        }
        return instancia;
    }

    public EntityManager getEm() {
        return em;
    }

}

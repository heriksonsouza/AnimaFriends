package dao;

import java.lang.reflect.Method;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class DaoGenerico {
	EntityManager em;

	public List lista(Class classe) {
		Query q = null;

		try {
			em = Banco.getInstancia().getEm();
			em.getTransaction().begin();
			q = em.createQuery("from " + classe.getSimpleName());
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		return q.getResultList();
	}

	public List listaCondicao(Class classe, String condicao) {
		em = Banco.getInstancia().getEm();
		em.getTransaction().begin();
		Query q = em.createQuery("from " + classe.getSimpleName() + " where " + condicao);
		em.getTransaction().commit();
		return q.getResultList();
	}

	public void inserir(Object objeto) {
		try {
			em = Banco.getInstancia().getEm();
			em.getTransaction().begin();
			em.persist(objeto);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public void excluir(Object objeto) throws Exception {
		try {
			em = Banco.getInstancia().getEm();
			em.getTransaction().begin();
			Method getChave = objeto.getClass().getMethod("getId", new Class[0]);
			objeto = em.find(objeto.getClass(), getChave.invoke(objeto, new Object[0]));
			em.remove(objeto);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public void salvar(Object objeto) {
		em = Banco.getInstancia().getEm();
		em.getTransaction().begin();
		em.merge(objeto);
		em.getTransaction().commit();
	}

	public Object recupera(Class classe, Long id) {
		em = Banco.getInstancia().getEm();
		Object retornando = null;
		em.getTransaction().begin();
		retornando = em.find(classe, id);
		em.getTransaction().commit();
		return retornando;
	}
}

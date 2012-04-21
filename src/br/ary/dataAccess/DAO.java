
package br.ary.dataAccess;
/*
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
*/
import br.ary.Repository;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

/** 
 * @author Ary
 */
public class DAO<T> implements Repository<T> {
    private EntityManager manager;
    private Class classe;

    public DAO(Class t) {
        EntityManagerFactory f = Persistence.createEntityManagerFactory("vendasPU");
        manager = f.createEntityManager();
        classe = t;
    }

    protected EntityManager getEntityManager() {
        return manager;
    }

    @Override
    public T abrir(long Id) {
        return (T)manager.find(classe, Id);
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void apagar(T obj) {
        EntityTransaction tran = manager.getTransaction();
        try {
            tran.begin();
            manager.remove(obj);
            tran.commit();
        }
        catch(Exception ex) {
            tran.rollback();
            ex.printStackTrace();
        }
    }

    @Override
    public List<T> listar() {
        CriteriaBuilder query = manager.getCriteriaBuilder();
        Query q = manager.createQuery(query.createQuery());                                         
        return q.getResultList();
    }

    @Override
    public void salvar(T obj) {
        EntityTransaction tran = manager.getTransaction();
        try {
            tran.begin();
            manager.persist(obj);
            tran.commit();
        }
        catch (Exception ex) {
            tran.rollback();
            ex.printStackTrace();
        }
    }    
}

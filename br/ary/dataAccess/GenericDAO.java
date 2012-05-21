
package br.ary.dataAccess;

import br.ary.domainModel.Repositorio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Ary
 */
public class GenericDAO<T> implements Repositorio<T> {
    private Class tipo;
    
    @PersistenceContext (unitName = "OS-ejbPU")
    private EntityManager manager;
    
    protected EntityManager getManager(){
        return manager;
    }

    public GenericDAO() { //construtor padrão
    }
    
    public GenericDAO(Class t){ //construtor com argumento
        tipo = t;
    }

    @Override
    public boolean Salvar(T obj) {
        try {
            getManager().persist(obj);
            return true;
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean Apagar(T obj) {
        try {
            getManager().remove(obj);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return  false;
        }
    }

    @Override
    public T Abrir(long k) throws Exception {
        
        return (T)getManager().find(tipo, k);
    }    
}

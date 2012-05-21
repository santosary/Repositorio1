package br.ary.dataAccess;

import br.ary.domainModel.OS;
import br.ary.domainModel.OSRepositorio;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Ary
 */
@Stateless
public class OSDAO extends GenericDAO<OS> implements OSRepositorio{
   
    public OSDAO(){
        super(OS.class);
    }

    @Override
    public List<OS> getTodos() {
        javax.persistence.Query query = getManager().createQuery("select c from OS c order by c.data");
        return query.getResultList();
    }
   
}


package br.ary.dataAccess;

import br.ary.Cliente;
import br.ary.ClienteRepository;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;

/**
 * @author Ary
 */
public class ClienteDAO extends DAO<Cliente> implements ClienteRepository {
   
    public ClienteDAO(){
        super (Cliente.class);
    }

    @Override
    public List<Cliente> getAninversarianteMes() {
        Query consulta = getEntityManager().createQuery("select c from Cliente c where dtAninv = :p1");
        consulta.setParameter("p1", new Date());
        return consulta.getResultList();
    }
    
}

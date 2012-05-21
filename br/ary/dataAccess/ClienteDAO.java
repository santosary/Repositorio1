package br.ary.dataAccess;

import br.ary.domainModel.Cliente;
import br.ary.domainModel.ClienteRepositorio;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 * @author Ary
 */
@Stateless
public class ClienteDAO extends GenericDAO<Cliente> implements ClienteRepositorio{

    public ClienteDAO(){
        super(Cliente.class);
    }

    @Override
    public List<Cliente> getTodos() {
        Query query = getManager().createQuery("select c from Cliente c order by c.nome");
        return query.getResultList();
    }
}

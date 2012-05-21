package br.ary.dataAccess;

import br.ary.domainModel.Servico;
import br.ary.domainModel.ServicoRepositorio;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;


/**
 * @author Ary
 */
@Stateless //bean de sessão
public class ServicoDAO extends GenericDAO<Servico> implements ServicoRepositorio{
    
    public ServicoDAO(){
        super(Servico.class);
    }

    @Override
    public List<Servico> getTodos() {
        Query query = getManager().createQuery("select c from Servico c order by c.descricao");
        return query.getResultList();        
    }
}

package br.ary.dataAccess;

import br.ary.Produto;
import br.ary.ProdutoRepository;
import java.util.List;
import javax.persistence.Query;

/**
 * @author Ary
 */
public class ProdutoDAO extends DAO<Produto> implements ProdutoRepository {
    
    public ProdutoDAO(){
        super(Produto.class);
    }

    @Override
    public List<Produto> getProdutos() {
        Query consulta = getEntityManager().createQuery("select * from Produto where codigo = :p1");
        consulta.setParameter("p1", 1);        
        return consulta.getResultList();
    }
    
}

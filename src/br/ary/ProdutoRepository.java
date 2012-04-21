package br.ary;

import java.util.List;

/**
 * @author Ary
 */
public interface ProdutoRepository extends Repository<Produto> {
    
    List<Produto> getProdutos();
}

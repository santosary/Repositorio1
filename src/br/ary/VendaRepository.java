package br.ary;

import java.util.List;

/**
 * @author Ary
 */
public interface VendaRepository extends Repository<Venda>{
    
    List<Venda> getVendas();
}

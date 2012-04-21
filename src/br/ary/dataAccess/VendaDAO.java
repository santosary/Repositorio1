/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ary.dataAccess;

import br.ary.Venda;
import br.ary.VendaRepository;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Ary
 */
public class VendaDAO extends DAO<Venda> implements VendaRepository {
    
    public VendaDAO(){
        super (Venda.class);
    }

    @Override
    public List<Venda> getVendas() {
        Query consulta = getEntityManager().createQuery("select nome from Venda where codigo = :p1");
        consulta.setParameter("p1", 1);
        return consulta.getResultList();
    }    
}

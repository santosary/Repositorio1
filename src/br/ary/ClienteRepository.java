
package br.ary;

import java.util.List;

/**
 * @author Ary
 */
public interface ClienteRepository extends Repository<Cliente> {
    
    List<Cliente> getAninversarianteMes();
}

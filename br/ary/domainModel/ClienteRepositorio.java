package br.ary.domainModel;

import java.util.List;
import javax.ejb.Remote;

/**
 * @author Ary
 */
@Remote
public interface ClienteRepositorio extends Repositorio<Cliente> {
    List<Cliente> getTodos();
}

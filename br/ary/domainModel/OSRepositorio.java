package br.ary.domainModel;

import java.util.List;
import javax.ejb.Remote;

/**
 * @author Ary
 */
@Remote
public interface OSRepositorio extends Repositorio<OS> {
    List<OS> getTodos();
}

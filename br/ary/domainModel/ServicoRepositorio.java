package br.ary.domainModel;

import java.util.List;
import javax.ejb.Remote;

/**
 * @author Ary
 */
@Remote
public interface ServicoRepositorio extends Repositorio<Servico> {
    List<Servico> getTodos();
}

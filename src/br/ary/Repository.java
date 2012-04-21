
package br.ary;

import java.util.List;
/**
 * @author Ary
 */
public interface Repository<T> {
    void salvar (T obj);
    T abrir (long Id);
    void apagar (T obj);
    List<T> listar();
}

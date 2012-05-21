package br.ary.domainModel;

/**
 *
 * @author Ary
 */
public interface Repositorio<T> {//repositorio generico<T>
    boolean Salvar(T obj);
    boolean Apagar(T obj);
    T Abrir (long k) throws Exception;
}

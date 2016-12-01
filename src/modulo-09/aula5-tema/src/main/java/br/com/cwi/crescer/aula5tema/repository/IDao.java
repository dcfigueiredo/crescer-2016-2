package br.com.cwi.crescer.aula5tema.repository;

import java.util.List;

/**
 * @author daniel.figueiredo
 * @param <T>
 * @param <ID>
 */
public interface IDao<T, ID> {

    void insert(T t);

    void delete(T t);

    T find(ID id);

    List<T> list();

}

package br.com.cwi.crescer.aula5tema.repository;

import java.util.List;
import javax.persistence.EntityManager;

/**
 * @author daniel.figueiredo
 * @param <T>
 * @param <ID>
 *
 */
public abstract class AbstractDao<T, ID> implements IDao<T,ID>{

    public abstract EntityManager getEntityManager();

    private final Class<T> clazz;

    public AbstractDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void insert(T t) {
        this.getEntityManager().merge(t);
    }

    @Override
    public void delete(T t) {
        this.getEntityManager().remove(t);
    }

    @Override
    public T find(ID id) {
        return this.getEntityManager().find(clazz, id);
    }    
}

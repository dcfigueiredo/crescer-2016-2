/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author daniel.figueiredo
 * @param <T>
 * @param <ID>
 */
public interface IDao<T> {

    void insert(T t);
    void update(T t);
    void delete(T t);    
    List<T> list();
    void export();
}

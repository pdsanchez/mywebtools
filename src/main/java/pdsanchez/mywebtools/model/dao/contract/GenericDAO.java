/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdsanchez.mywebtools.model.dao.contract;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author pdsanchez
 * @param <T>
 * @param <PK>
 */
public interface GenericDAO<T, PK extends Serializable> {

  /**
   * Persist the object into database
   *
   * @param obj
   * @return
   */
  void create(T obj);

  /**
   * Save changes made to a persistent object.
   *
   * @param obj
   */
  void update(T obj);

  /**
   * Remove an object from persistent storage in the database
   *
   * @param obj
   */
  void delete(T obj);

  /**
   * Retrieve an object that was previously persisted to the database using the
   * indicated id as primary key
   *
   * @param id
   * @return
   */
  T find(PK id);

  List<T> findAll();

  int count();
}

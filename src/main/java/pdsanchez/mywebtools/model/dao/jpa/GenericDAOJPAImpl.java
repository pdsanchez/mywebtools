/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdsanchez.mywebtools.model.dao.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pdsanchez.mywebtools.model.dao.contract.GenericDAO;

/**
 *
 * @author pdsanchez
 * @param <T>
 * @param <PK>
 */
@Component
public abstract class GenericDAOJPAImpl<T, PK extends Serializable> implements GenericDAO<T, PK> {

  private final Class<T> entityClass;

  @PersistenceContext(unitName = "DEFAULT_PU")
  protected EntityManager em;

  public GenericDAOJPAImpl(Class<T> entityClass) {
    this.entityClass = entityClass;
  }

  protected EntityManager getEntityManager() {
    return em;
  }

  @Transactional
  @Override
  public void create(T entity) {
    getEntityManager().persist(entity);
  }

  @Transactional
  @Override
  public void update(T entity) {
    getEntityManager().merge(entity);
  }

  @Transactional
  @Override
  public void delete(T entity) {
    getEntityManager().remove(getEntityManager().merge(entity));
  }

  @Override
  public T find(PK id) {
    return getEntityManager().find(entityClass, id);
  }

  @Override
  public List<T> findAll() {
    javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
    cq.select(cq.from(entityClass));
    return getEntityManager().createQuery(cq).getResultList();
  }

  @Override
  public int count() {
    javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
    javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
    cq.select(getEntityManager().getCriteriaBuilder().count(rt));
    javax.persistence.Query q = getEntityManager().createQuery(cq);
    return ((Long) q.getSingleResult()).intValue();
  }

}

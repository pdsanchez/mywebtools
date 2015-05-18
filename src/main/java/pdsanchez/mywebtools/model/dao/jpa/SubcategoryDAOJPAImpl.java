/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdsanchez.mywebtools.model.dao.jpa;

import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Component;
import pdsanchez.mywebtools.entity.Category;
import pdsanchez.mywebtools.entity.Subcategory;
import pdsanchez.mywebtools.model.dao.contract.SubcategoryDAO;

/**
 *
 * @author pdsanchez
 */
@Component
public class SubcategoryDAOJPAImpl extends GenericDAOJPAImpl<Subcategory, Integer> implements SubcategoryDAO {

  public SubcategoryDAOJPAImpl() {
    super(Subcategory.class);
  }

  @Override
  public Subcategory find(String name) {
    Subcategory sc = null;
    
    Query q = getEntityManager().createQuery("select o from Subcategory o where lower(o.subcategoryName) = :name");
    q.setParameter("name", name.toLowerCase());
    List<Subcategory> list = q.getResultList();
    if (!list.isEmpty()) {
      sc = list.get(0);
    }
    
    return sc;
  }

    @Override
    public List<Subcategory> findAll(Category category) {
        Query q = getEntityManager().createQuery("select distinct o.subcategory from Tool o where lower(o.category.categoryName) = :name and o.isvalid = 1");
        q.setParameter("name", category.getCategoryName().toLowerCase());
        return q.getResultList();
    }
}

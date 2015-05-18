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
import pdsanchez.mywebtools.model.dao.contract.CategoryDAO;

/**
 *
 * @author pdsanchez
 */
@Component
public class CategoryDAOJPAImpl extends GenericDAOJPAImpl<Category, Integer> implements CategoryDAO {

  public CategoryDAOJPAImpl() {
    super(Category.class);
  }

  @Override
  public Category find(String name) {
    Category c = null;
    
    Query q = getEntityManager().createQuery("select o from Category o where lower(o.categoryName) = :name");
    q.setParameter("name", name.toLowerCase());
    List<Category> list = q.getResultList();
    if (!list.isEmpty()) {
      c = list.get(0);
    }
    
    return c;
  }
  
  
}

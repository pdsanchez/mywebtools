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
import pdsanchez.mywebtools.entity.Tool;
import pdsanchez.mywebtools.model.dao.contract.ToolDAO;

/**
 *
 * @author pdsanchez
 */
@Component
public class ToolDAOJPAImpl extends GenericDAOJPAImpl<Tool, Integer> implements ToolDAO {

  public ToolDAOJPAImpl() {
    super(Tool.class);
  }

    @Override
    public List<Tool> findAll(Category category) {
        Query q = getEntityManager().createQuery("select o from Tool o where lower(o.category.categoryName) = :name and o.isvalid = 1");
        q.setParameter("name", category.getCategoryName().toLowerCase());
        return q.getResultList();
    }

    @Override
    public List<Tool> findAll(Category category, Subcategory subcategory) {
        Query q = getEntityManager().createQuery("select o from Tool o where lower(o.category.categoryName) = :cname and lower(o.subcategory.subcategoryName) = :scname and o.isvalid = 1");
        q.setParameter("cname", category.getCategoryName().toLowerCase());
        q.setParameter("scname", subcategory.getSubcategoryName().toLowerCase());
        return q.getResultList();
    }
}

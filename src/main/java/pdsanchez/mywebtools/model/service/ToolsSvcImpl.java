/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdsanchez.mywebtools.model.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pdsanchez.mywebtools.entity.Category;
import pdsanchez.mywebtools.entity.Subcategory;
import pdsanchez.mywebtools.entity.Tool;
import pdsanchez.mywebtools.model.dao.contract.CategoryDAO;
import pdsanchez.mywebtools.model.dao.contract.SubcategoryDAO;
import pdsanchez.mywebtools.model.dao.contract.ToolDAO;
import pdsanchez.mywebtools.model.service.contract.ToolsSvc;

/**
 *
 * @author pdsanchez
 */
@Component
public class ToolsSvcImpl implements ToolsSvc {

  @Autowired
  private CategoryDAO categoryDAO;

  @Autowired
  private SubcategoryDAO subcategoryDAO;

  @Autowired
  private ToolDAO toolDAO;

  @Override
  public void addTool(Tool tool) {
    if (tool == null) {
      throw new NullPointerException();
    }
    
    Category category = this.addCategory(tool.getCategory());
    tool.setCategory(category);
    Subcategory subcategory = this.addSubcategory(tool.getSubcategory());
    tool.setSubcategory(subcategory);
    
    toolDAO.create(tool);
  }

  @Override
  public void updateTool(Tool tool) {
    if (tool == null) {
      throw new NullPointerException();
    }
    
    toolDAO.update(tool);
  }

  @Override
  public List<Tool> getTools(Category category, Subcategory subcategory) {
//    if (category == null || category.getCategoryName().isEmpty()) {
//      throw new NullPointerException("Category is null or its name is empty");
//    }
//    if (subcategory == null || subcategory.getSubcategoryName().isEmpty()) {
//      throw new NullPointerException("Subcategory is null or its name is empty");
//    }
    
    return toolDAO.findAll(category, subcategory);
  }

  @Override
  public List<Tool> getTools(Category category) {
//    if (category == null || category.getCategoryName().isEmpty()) {
//      throw new NullPointerException("Category is null or its name is empty");
//    }
    
    return toolDAO.findAll(category);
  }

  @Override
  public Category addCategory(Category category) {
    if (category == null || category.getCategoryName().isEmpty()) {
      throw new NullPointerException("Category is null or its name is empty");
    }
    
    // Si existe categoria no se crea
    Category dbCategory = categoryDAO.find(category.getCategoryName());
    if (dbCategory == null) {
      categoryDAO.create(category);
    }
    else {
      category = dbCategory;
    }
    
    return category;
  }

  @Override
  public Subcategory addSubcategory(Subcategory subcategory) {
    if (subcategory == null || subcategory.getSubcategoryName().isEmpty()) {
      throw new NullPointerException("Subcategory is null or its name is empty");
    }
    
    // Si existe subcategoria no se crea
    Subcategory dbSubcategory = subcategoryDAO.find(subcategory.getSubcategoryName());
    if (dbSubcategory == null) {
      subcategoryDAO.create(subcategory);
    }
    else {
      subcategory = dbSubcategory;
    }
    
    return subcategory;
  }

  @Override
  public List<Category> getCategories() {
    return categoryDAO.findAll();
  }

  @Override
  public List<Subcategory> getSubcategories() {
    return subcategoryDAO.findAll();
  }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdsanchez.mywebtools.model.service.contract;

import java.util.List;
import pdsanchez.mywebtools.entity.Category;
import pdsanchez.mywebtools.entity.Subcategory;
import pdsanchez.mywebtools.entity.Tool;

/**
 *
 * @author pdsanchez
 */
public interface ToolsSvc {
  void addTool(Tool tool);
  void updateTool(Tool tool);
  
  List<Tool> getTools(Category category, Subcategory subcategory);
  List<Tool> getTools(Category category);
  
  Category addCategory(Category category);
  Subcategory addSubcategory(Subcategory subcategory);
  
  List<Category> getCategories();
  List<Subcategory> getSubcategories();
}

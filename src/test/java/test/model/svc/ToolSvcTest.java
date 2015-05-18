/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.model.svc;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
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
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/java/testApplicationContext.xml")
public class ToolSvcTest {
  
  @Autowired
  private ToolsSvc toolSvc;
  
  @Autowired
  private ToolDAO toolDao;
  
  @Autowired
  private CategoryDAO catDao;
  
  @Autowired
  private SubcategoryDAO scatDao;
  
  @Test
  public void successAddCategoryTest() {
    Category category = new Category("Category1");
    toolSvc.addCategory(category);
    
    Assert.assertEquals(1, catDao.count());
    
    catDao.delete(category);
  }
  
  @Test(expected = NullPointerException.class)
  public void failureAddCategoryTest() {
    Category category = new Category("");
    toolSvc.addCategory(category);
  }
  
  @Test
  public void successAddSubcategoryTest() {
    Subcategory subcategory = new Subcategory("Subcategory1");
    toolSvc.addSubcategory(subcategory);
    
    Assert.assertEquals(1, scatDao.count());
    
    scatDao.delete(subcategory);
  }
  
  @Test(expected = NullPointerException.class)
  public void failureAddSubcategoryTest() {
    Subcategory subcategory = new Subcategory("");
    toolSvc.addSubcategory(subcategory);
  }
  
  @Test
  public void successAddToolWithNewCategoryAndSubcategoryTest() {
    Category category = new Category("Category1");
    Subcategory subcategory = new Subcategory("Subcategory1");
    
    Tool tool = new Tool("nameTool", "urlTool");
    tool.setCategory(category);
    tool.setSubcategory(subcategory);
    
    toolSvc.addTool(tool);
    
    Assert.assertEquals(1, toolDao.count());
    Assert.assertEquals(1, catDao.count());
    Assert.assertEquals(1, scatDao.count());
    
    toolDao.delete(tool);
    catDao.delete(category);
    scatDao.delete(subcategory);
  }
  
  @Test
  public void successAddToolWithExistingCategoryAndSubcategoryTest() {
    Category category = new Category("Category1");
    catDao.create(category);
    Subcategory subcategory = new Subcategory("Subcategory1");
    scatDao.create(subcategory);
    
    Tool tool = new Tool("nameTool", "urlTool");
    tool.setCategory(new Category("Category1"));
    tool.setSubcategory(new Subcategory("Subcategory1"));
    
    toolSvc.addTool(tool);
    
    Assert.assertEquals(1, toolDao.count());
    Assert.assertEquals(1, catDao.count());
    Assert.assertEquals(1, scatDao.count());
    
    toolDao.delete(tool);
    catDao.delete(category);
    scatDao.delete(subcategory);
  }
  
  @Test(expected = NullPointerException.class)
  public void failureAddToolTest() {
    toolSvc.addTool(null);
  }
  
  @Test
  public void successGetToolsByCategory() {
    
    
  }
}

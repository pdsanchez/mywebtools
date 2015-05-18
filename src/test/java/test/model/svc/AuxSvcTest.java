/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.model.svc;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pdsanchez.mywebtools.model.dao.contract.CategoryDAO;
import pdsanchez.mywebtools.model.dao.contract.SubcategoryDAO;
import pdsanchez.mywebtools.model.dao.contract.ToolDAO;
import pdsanchez.mywebtools.model.service.contract.AuxSvc;

/**
 *
 * @author pdsanchez
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/java/testApplicationContext.xml")
public class AuxSvcTest {
  
  @Autowired
  private AuxSvc auxSvc;
  
  @Autowired
  private ToolDAO toolDao;

  @Autowired
  private CategoryDAO catDao;
  
  @Autowired
  private SubcategoryDAO scatDao;
  
  @Test
  public void successLoaderTest() {
      int t = auxSvc.loadTools();
      
      Assert.assertEquals(127, t);
      Assert.assertEquals(127, toolDao.count()); // tools
      Assert.assertEquals(4, catDao.count()); // categories
      Assert.assertEquals(29, scatDao.count()); // subcategories
  }
  
}

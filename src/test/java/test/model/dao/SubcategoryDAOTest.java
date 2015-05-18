/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.model.dao;

import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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

/**
 *
 * @author pdsanchez
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/java/testApplicationContext.xml")
public class SubcategoryDAOTest {

    @Autowired
    private SubcategoryDAO scatDao;

    @Autowired
    private CategoryDAO catDao;

    @Autowired
    private ToolDAO toolDao;

//  @Before
//  public void setUp() {
//  }
//  
//  @After
//  public void tearDown() {
//  }
    @Test
    public void successCreateTest() {
        Subcategory subcategory = new Subcategory("Subcategoria1");
        scatDao.create(subcategory);
        assertEquals(scatDao.count(), 1);

        int id = subcategory.getIdSubcategory();
        assertNotNull(id);

        scatDao.delete(subcategory);
        assertEquals(scatDao.count(), 0);
    }

    @Test
    public void successFindTest() {
        Subcategory subcategory = new Subcategory("Subcategoria1");
        scatDao.create(subcategory);

        int id = subcategory.getIdSubcategory();
        Subcategory sc = scatDao.find(id);
        assertNotNull(sc);
        assertEquals(sc.getSubcategoryName(), subcategory.getSubcategoryName());

        List<Subcategory> list = scatDao.findAll();
        assertEquals(list.size(), 1);
        assertEquals(list.get(0).getSubcategoryName(), subcategory.getSubcategoryName());

        scatDao.delete(subcategory);
        assertEquals(scatDao.count(), 0);
    }

    @Test
    public void successUpdateTest() {
        Subcategory subcategory = new Subcategory("Subcategory1");
        scatDao.create(subcategory);

        int id = subcategory.getIdSubcategory();
        Subcategory sc = scatDao.find(id);
        sc.setSubcategoryName("NuevaSubcategoria");
        scatDao.update(sc);

        assertEquals(scatDao.find(id).getSubcategoryName(), "NuevaSubcategoria");

        scatDao.delete(subcategory);
        assertEquals(scatDao.count(), 0);
    }

    @Test
    public void successCountTest() {
        Subcategory subcategory = new Subcategory("Subcategory1");
        scatDao.create(subcategory);
        assertEquals(scatDao.count(), 1);

        scatDao.delete(subcategory);
        assertEquals(scatDao.count(), 0);
    }

    @Test
    public void successDeleteTest() {
        Subcategory subcategory = new Subcategory("Subcategory1");
        scatDao.create(subcategory);
        assertEquals(scatDao.count(), 1);

        scatDao.delete(subcategory);
        assertEquals(scatDao.count(), 0);

        scatDao.delete(subcategory);
        assertEquals(scatDao.count(), 0);
    }

    @Test
    public void successFindByNameTest() {
        Subcategory subcategory = new Subcategory("Subcategory1");
        scatDao.create(subcategory);

        Subcategory c1 = scatDao.find("Subcategory1");
        assertNotNull(c1);
        assertEquals(c1.getSubcategoryName(), "Subcategory1");
        
        Subcategory c2 = scatDao.find("SUBCATEGORY1");
        assertNotNull(c2);
        assertEquals(c2.getSubcategoryName(), "Subcategory1");

        Subcategory cnull = scatDao.find("SubcategoryNull");
        assertNull(cnull);

        scatDao.delete(subcategory);
        assertEquals(scatDao.count(), 0);
    }

    @Test
    public void successFindAllByCategoryTest() {
        Tool tool1 = new Tool("toolname1", "urltool2");
        Category category1 = new Category("Category1");
        tool1.setCategory(category1);
        Subcategory subcategory1 = new Subcategory("Subcategory1");
        tool1.setSubcategory(subcategory1);
        catDao.create(category1);
        scatDao.create(subcategory1);
        toolDao.create(tool1);

        Tool tool2 = new Tool("toolname2", "urltool2");
        // category1
        tool2.setCategory(category1);
        Subcategory subcategory2 = new Subcategory("Subcategory2");
        tool2.setSubcategory(subcategory2);
        scatDao.create(subcategory2);
        toolDao.create(tool2);
        
        Tool tool3 = new Tool("toolname3", "urltool3");
        Category category3 = new Category("Category2");
        tool3.setCategory(category3);
        Subcategory subcategory3 = new Subcategory("Subcategory3");
        tool3.setSubcategory(subcategory3);
        catDao.create(category3);
        scatDao.create(subcategory3);
        toolDao.create(tool3);
        
        Tool tool4 = new Tool("toolname4", "urltool4");
        tool4.setIsvalid(0);
        tool4.setCategory(category3);
        Subcategory subcategory4 = new Subcategory("Subcategory4");
        tool4.setSubcategory(subcategory4);
        scatDao.create(subcategory4);
        toolDao.create(tool4);
        
        List<Subcategory> list1 = scatDao.findAll(category1);
        assertEquals(2, list1.size());
        assertEquals("Subcategory1", list1.get(0).getSubcategoryName());
        assertEquals("Subcategory2", list1.get(1).getSubcategoryName());
        
        List<Subcategory> list2 = scatDao.findAll(category3);
        assertEquals(1, list2.size());
        assertEquals("Subcategory3", list2.get(0).getSubcategoryName());
        
        toolDao.delete(tool1);
        toolDao.delete(tool2);
        toolDao.delete(tool3);
        toolDao.delete(tool4);
        catDao.delete(category1);
        catDao.delete(category3);
        scatDao.delete(subcategory1);
        scatDao.delete(subcategory2);
        scatDao.delete(subcategory3);
        scatDao.delete(subcategory4);
    }
}

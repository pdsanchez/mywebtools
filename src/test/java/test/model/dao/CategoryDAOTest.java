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
import pdsanchez.mywebtools.model.dao.contract.CategoryDAO;

/**
 *
 * @author pdsanchez
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/java/testApplicationContext.xml")
public class CategoryDAOTest {

    @Autowired
    private CategoryDAO catDao;

//  @Before
//  public void setUp() {
//  }
//  
//  @After
//  public void tearDown() {
//  }
    @Test
    public void successCreateTest() {
        Category category = new Category("Category1");
        catDao.create(category);
        assertEquals(catDao.count(), 1);

        int id = category.getIdCategory();
        assertNotNull(id);

        catDao.delete(category);
        assertEquals(catDao.count(), 0);
    }

    @Test
    public void successFindTest() {
        Category category = new Category("Category1");
        catDao.create(category);

        int id = category.getIdCategory();
        Category c = catDao.find(id);
        assertNotNull(c);
        assertEquals(c.getCategoryName(), category.getCategoryName());

        List<Category> list = catDao.findAll();
        assertEquals(list.size(), 1);
        assertEquals(list.get(0).getCategoryName(), category.getCategoryName());

        catDao.delete(category);
        assertEquals(catDao.count(), 0);
    }

    @Test
    public void successUpdateTest() {
        Category category = new Category("Category1");
        catDao.create(category);

        int id = category.getIdCategory();
        Category c = catDao.find(id);
        c.setCategoryName("NuevaCategoria");
        catDao.update(c);

        assertEquals(catDao.find(id).getCategoryName(), "NuevaCategoria");

        catDao.delete(category);
        assertEquals(catDao.count(), 0);
    }

    @Test
    public void successCountTest() {
        Category category = new Category("Category1");
        catDao.create(category);
        assertEquals(catDao.count(), 1);

        catDao.delete(category);
        assertEquals(catDao.count(), 0);
    }

    @Test
    public void successDeleteTest() {
        Category category = new Category("Category1");
        catDao.create(category);
        assertEquals(catDao.count(), 1);

        catDao.delete(category);
        assertEquals(catDao.count(), 0);

        catDao.delete(category);
        assertEquals(catDao.count(), 0);
    }

    @Test
    public void successFindByNameTest() {
        Category category = new Category("Category1");
        catDao.create(category);

        Category c = catDao.find("Category1");
        assertNotNull(c);
        assertEquals(c.getCategoryName(), "Category1");

        Category c2 = catDao.find("CATEGORY1");
        assertNotNull(c2);
        assertEquals(c2.getCategoryName(), "Category1");

        Category cnull = catDao.find("CategoryNull");
        assertNull(cnull);

        catDao.delete(category);
        assertEquals(catDao.count(), 0);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.model.dao;

import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
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
public class ToolDAOTest {

    private Category category = new Category("Category1");
    private Subcategory subcategory = new Subcategory("Subcategoria1");

    @Autowired
    private ToolDAO toolDao;

    @Autowired
    private CategoryDAO catDao;

    @Autowired
    private SubcategoryDAO scatDao;

    @Before
    public void setUp() {
        catDao.create(category);
        scatDao.create(subcategory);
    }

    @After
    public void tearDown() {
        catDao.delete(category);
        scatDao.delete(subcategory);
    }

    @Test
    public void successCreateTest() {
        Tool tool = new Tool("toolname", "urltool");
        tool.setCategory(category);
        tool.setSubcategory(subcategory);
        toolDao.create(tool);
        assertEquals(toolDao.count(), 1);

        int id = tool.getIdTool();
        assertNotNull(id);

        toolDao.delete(tool);
        assertEquals(toolDao.count(), 0);
    }

    @Test
    public void successCategoryAndSubcategoryInToolTest() {
        Tool tool = new Tool("toolname", "urltool");
        tool.setCategory(category);
        tool.setSubcategory(subcategory);
        toolDao.create(tool);

        int id = tool.getIdTool();
        Tool t = toolDao.find(id);
        assertNotNull(t);

        assertEquals(t.getCategory().getCategoryName(), "Category1");
        assertEquals(t.getSubcategory().getSubcategoryName(), "Subcategoria1");

        toolDao.delete(tool);
        assertEquals(toolDao.count(), 0);

        assertEquals(catDao.count(), 1);
        assertEquals(scatDao.count(), 1);
    }

    @Test
    public void successFindTest() {
        Tool tool = new Tool("toolname", "urltool");
        tool.setCategory(category);
        tool.setSubcategory(subcategory);
        toolDao.create(tool);

        int id = tool.getIdTool();
        Tool t = toolDao.find(id);
        assertNotNull(t);
        assertEquals(t.getName(), "toolname");

        List<Tool> list = toolDao.findAll();
        assertEquals(list.size(), 1);
        assertEquals(list.get(0).getName(), "toolname");

        toolDao.delete(tool);
        assertEquals(toolDao.count(), 0);
    }

    @Test
    public void successUpdateTest() {
        Tool tool = new Tool("toolname", "urltool");
        tool.setCategory(category);
        tool.setSubcategory(subcategory);
        toolDao.create(tool);

        int id = tool.getIdTool();
        Tool t = toolDao.find(id);
        t.setName("toolNewName");
        toolDao.update(t);

        assertEquals(toolDao.find(id).getName(), "toolNewName");

        toolDao.delete(tool);
        assertEquals(toolDao.count(), 0);
    }

    @Test
    public void successCountTest() {
        Tool tool = new Tool("toolname", "urltool");
        tool.setCategory(category);
        tool.setSubcategory(subcategory);
        toolDao.create(tool);
        assertEquals(toolDao.count(), 1);

        toolDao.delete(tool);
        assertEquals(toolDao.count(), 0);
    }

    @Test
    public void successDeleteTest() {
        Tool tool = new Tool("toolname", "urltool");
        tool.setCategory(category);
        tool.setSubcategory(subcategory);
        toolDao.create(tool);
        assertEquals(toolDao.count(), 1);

        toolDao.delete(tool);
        assertEquals(toolDao.count(), 0);

        toolDao.delete(tool);
        assertEquals(toolDao.count(), 0);
    }

    @Test
    public void successFindByCategory() {
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
        // category3
        tool4.setCategory(category3);
        Subcategory subcategory4 = new Subcategory("Subcategory4");
        tool4.setSubcategory(subcategory4);
        scatDao.create(subcategory4);
        toolDao.create(tool4);

        List<Tool> list1 = toolDao.findAll(category1);
        assertEquals(2, list1.size());
        assertEquals("toolname1", list1.get(0).getName());
        assertEquals("toolname2", list1.get(1).getName());

        List<Tool> list2 = toolDao.findAll(category3);
        assertEquals(1, list2.size());
        assertEquals("toolname3", list2.get(0).getName());

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
    
    @Test
    public void successFindByCategoryAndSubcategory() {
        Tool tool1 = new Tool("toolname1", "urltool1");
        Category category1 = new Category("Category1");
        tool1.setCategory(category1);
        Subcategory subcategory1 = new Subcategory("Subcategory1");
        tool1.setSubcategory(subcategory1);
        catDao.create(category1);
        scatDao.create(subcategory1);
        toolDao.create(tool1);
        
        Tool tool1a = new Tool("toolname1a", "urltool1a");
        tool1a.setCategory(category1);
        tool1a.setSubcategory(subcategory1);
        toolDao.create(tool1a);

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
        // category3
        tool4.setCategory(category3);
        Subcategory subcategory4 = new Subcategory("Subcategory4");
        tool4.setSubcategory(subcategory4);
        scatDao.create(subcategory4);
        toolDao.create(tool4);

        List<Tool> list1 = toolDao.findAll(category1, subcategory1);
        assertEquals(2, list1.size());
        assertEquals("toolname1", list1.get(0).getName());
        assertEquals("toolname1a", list1.get(1).getName());

        List<Tool> list2 = toolDao.findAll(category3, subcategory4);
        assertEquals(0, list2.size());

        toolDao.delete(tool1);
        toolDao.delete(tool1a);
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

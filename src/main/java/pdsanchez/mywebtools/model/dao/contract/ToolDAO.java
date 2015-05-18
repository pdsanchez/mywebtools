/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdsanchez.mywebtools.model.dao.contract;

import java.util.List;
import pdsanchez.mywebtools.entity.Category;
import pdsanchez.mywebtools.entity.Subcategory;
import pdsanchez.mywebtools.entity.Tool;

/**
 *
 * @author pdsanchez
 */
public interface ToolDAO extends GenericDAO<Tool, Integer> {

    /**
     * Finds all the Tool VALID objects for the specified category
     * @param category
     * @return A list of valid Tool objects
     */
    List<Tool> findAll(Category category);

    /**
     * Finds all the Tool VALID objects for the specified category and Subcategory
     * @param category
     * @param subcategory
     * @return A list of valid Tool objects
     */
    List<Tool> findAll(Category category, Subcategory subcategory);
}

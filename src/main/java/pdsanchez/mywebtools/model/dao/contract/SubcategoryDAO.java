/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdsanchez.mywebtools.model.dao.contract;

import java.util.List;
import pdsanchez.mywebtools.entity.Category;
import pdsanchez.mywebtools.entity.Subcategory;

/**
 *
 * @author pdsanchez
 */
public interface SubcategoryDAO extends GenericDAO<Subcategory, Integer> {

    /**
     * Retrieves a Subcategory by its name
     * @param name
     * @return A Subcategory
     */
    Subcategory find(String name);

    /**
     * Finds all the Subcategory objects for the specified Category in a set of
     * VALID Tool objects
     * @param category
     * @return A list of Subcategory objects
     */
    List<Subcategory> findAll(Category category);
}

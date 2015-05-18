/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdsanchez.mywebtools.model.dao.contract;

import pdsanchez.mywebtools.entity.Category;

/**
 *
 * @author pdsanchez
 */
public interface CategoryDAO extends GenericDAO<Category, Integer> {

  Category find(String name);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdsanchez.mywebtools.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author pdsanchez
 */
@Entity
@Table(name = "category")
public class Category implements Serializable {
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_category")
  private Integer idCategory;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 256)
  @Column(name = "category")
  private String categoryName;

  public Category() {
  }

  public Category(Integer idCategory) {
    this.idCategory = idCategory;
  }

  public Category(String categoryName) {
    this.categoryName = categoryName;
  }

  public Integer getIdCategory() {
    return idCategory;
  }

  public void setIdCategory(Integer idCategory) {
    this.idCategory = idCategory;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idCategory != null ? idCategory.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Category)) {
      return false;
    }
    Category other = (Category) object;
    if ((this.idCategory == null && other.idCategory != null) || (this.idCategory != null && !this.idCategory.equals(other.idCategory))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "pdsanchez.mywebtools.entity.Category[ idCategory=" + idCategory + " ]";
  }
  
}

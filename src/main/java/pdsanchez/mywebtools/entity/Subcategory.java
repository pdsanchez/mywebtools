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
@Table(name = "subcategory")
public class Subcategory implements Serializable {
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_subcategory")
  private Integer idSubcategory;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 256)
  @Column(name = "subcategory")
  private String subcategoryName;
  
//  @Basic(optional = false)
//  @NotNull
//  @OneToOne
//  @JoinColumn(name="id_category")
//  private Category category;

  public Subcategory() {
  }

  public Subcategory(Integer idSubcategory) {
    this.idSubcategory = idSubcategory;
  }

  public Subcategory(String subcategoryName) {
    this.subcategoryName = subcategoryName;
  }

//  public Subcategory(String subcategoryName, Category category) {
//    this.subcategoryName = subcategoryName;
//    this.category = category;
//  }

  public Integer getIdSubcategory() {
    return idSubcategory;
  }

  public void setIdSubcategory(Integer idSubcategory) {
    this.idSubcategory = idSubcategory;
  }

  public String getSubcategoryName() {
    return subcategoryName;
  }

  public void setSubcategoryName(String subcategoryName) {
    this.subcategoryName = subcategoryName;
  }

//  public Category getCategory() {
//    return category;
//  }
//
//  public void setCategory(Category category) {
//    this.category = category;
//  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idSubcategory != null ? idSubcategory.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Subcategory)) {
      return false;
    }
    Subcategory other = (Subcategory) object;
    if ((this.idSubcategory == null && other.idSubcategory != null) || (this.idSubcategory != null && !this.idSubcategory.equals(other.idSubcategory))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "pdsanchez.mywebtools.entity.Subcategory[ idSubcategory=" + idSubcategory + " ]";
  }
  
}

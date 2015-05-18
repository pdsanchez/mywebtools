/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdsanchez.mywebtools.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author pdsanchez
 */
@Entity
@Table(name = "tool")
public class Tool implements Serializable {
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_tool")
  private Integer idTool;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 256)
  @Column(name = "name")
  private String name;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 256)
  @Column(name = "url")
  private String url;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "description")
  private String description;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "rating")
  private int rating;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "icon")
  private String icon;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "image")
  private String image;
  
  @Column(name = "date")
  @Temporal(TemporalType.TIMESTAMP)
  private Date date;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "isvalid")
  private int isvalid = 1;
  
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "id_category", referencedColumnName = "id_category")
  private Category category;
  
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "id_subcategory", referencedColumnName = "id_subcategory")
  private Subcategory subcategory;

  public Tool() {
  }

  public Tool(Integer idTool) {
    this.idTool = idTool;
  }

  public Tool(String name, String url) {
    this.name = name;
    this.url = url;
  }

  public Integer getIdTool() {
    return idTool;
  }

  public void setIdTool(Integer idTool) {
    this.idTool = idTool;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public int getIsvalid() {
    return isvalid;
  }

  public void setIsvalid(int isvalid) {
    this.isvalid = isvalid;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public Subcategory getSubcategory() {
    return subcategory;
  }

  public void setSubcategory(Subcategory subcategory) {
    this.subcategory = subcategory;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idTool != null ? idTool.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Tool)) {
      return false;
    }
    Tool other = (Tool) object;
    if ((this.idTool == null && other.idTool != null) || (this.idTool != null && !this.idTool.equals(other.idTool))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "pdsanchez.mywebtools.entity.Tool[ idTool=" + idTool + " ]";
  }
  
}

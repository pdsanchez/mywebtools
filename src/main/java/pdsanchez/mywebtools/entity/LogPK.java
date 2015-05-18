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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author pdsanchez
 */
@Embeddable
public class LogPK implements Serializable {
  @Basic(optional = false)
  @NotNull
  @Column(name = "timestamp")
  @Temporal(TemporalType.TIMESTAMP)
  private Date timestamp;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 32)
  @Column(name = "ip")
  private String ip;

  public LogPK() {
  }

  public LogPK(Date timestamp, String ip) {
    this.timestamp = timestamp;
    this.ip = ip;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (timestamp != null ? timestamp.hashCode() : 0);
    hash += (ip != null ? ip.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof LogPK)) {
      return false;
    }
    LogPK other = (LogPK) object;
    if ((this.timestamp == null && other.timestamp != null) || (this.timestamp != null && !this.timestamp.equals(other.timestamp))) {
      return false;
    }
    if ((this.ip == null && other.ip != null) || (this.ip != null && !this.ip.equals(other.ip))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "pdsanchez.mywebtools.entity.LogPK[ timestamp=" + timestamp + ", ip=" + ip + " ]";
  }
  
}

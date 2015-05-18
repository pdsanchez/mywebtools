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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author pdsanchez
 */
@Entity
@Table(name = "log")
public class Log implements Serializable {
  private static final long serialVersionUID = 1L;
  
  @EmbeddedId
  protected LogPK logPK;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 512)
  @Column(name = "agent")
  private String agent;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 512)
  @Column(name = "logger")
  private String logger;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 64)
  @Column(name = "level")
  private String level;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 1024)
  @Column(name = "message")
  private String message;
  
  @Size(max = 256)
  @Column(name = "file")
  private String file;
  
  @Column(name = "line")
  private Integer line;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "year")
  private int year;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "month")
  private int month;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "day")
  private int day;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "hour")
  private int hour;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "minute")
  private int minute;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "second")
  private int second;

  public Log() {
  }

  public Log(LogPK logPK) {
    this.logPK = logPK;
  }

  public Log(LogPK logPK, String agent, String logger, String level, String message, int year, int month, int day, int hour, int minute, int second) {
    this.logPK = logPK;
    this.agent = agent;
    this.logger = logger;
    this.level = level;
    this.message = message;
    this.year = year;
    this.month = month;
    this.day = day;
    this.hour = hour;
    this.minute = minute;
    this.second = second;
  }

  public Log(Date timestamp, String ip) {
    this.logPK = new LogPK(timestamp, ip);
  }

  public LogPK getLogPK() {
    return logPK;
  }

  public void setLogPK(LogPK logPK) {
    this.logPK = logPK;
  }

  public String getAgent() {
    return agent;
  }

  public void setAgent(String agent) {
    this.agent = agent;
  }

  public String getLogger() {
    return logger;
  }

  public void setLogger(String logger) {
    this.logger = logger;
  }

  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getFile() {
    return file;
  }

  public void setFile(String file) {
    this.file = file;
  }

  public Integer getLine() {
    return line;
  }

  public void setLine(Integer line) {
    this.line = line;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getMonth() {
    return month;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public int getDay() {
    return day;
  }

  public void setDay(int day) {
    this.day = day;
  }

  public int getHour() {
    return hour;
  }

  public void setHour(int hour) {
    this.hour = hour;
  }

  public int getMinute() {
    return minute;
  }

  public void setMinute(int minute) {
    this.minute = minute;
  }

  public int getSecond() {
    return second;
  }

  public void setSecond(int second) {
    this.second = second;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (logPK != null ? logPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Log)) {
      return false;
    }
    Log other = (Log) object;
    if ((this.logPK == null && other.logPK != null) || (this.logPK != null && !this.logPK.equals(other.logPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "pdsanchez.mywebtools.entity.Log[ logPK=" + logPK + " ]";
  }
  
}

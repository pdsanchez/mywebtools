/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdsanchez.mywebtools.model.dao.jpa;

import org.springframework.stereotype.Component;
import pdsanchez.mywebtools.entity.Log;
import pdsanchez.mywebtools.entity.LogPK;
import pdsanchez.mywebtools.model.dao.contract.LogDAO;

/**
 *
 * @author pdsanchez
 */
@Component
public class LogDAOJPAImpl extends GenericDAOJPAImpl<Log, LogPK> implements LogDAO {

  public LogDAOJPAImpl() {
    super(Log.class);
  }
}

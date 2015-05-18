/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.model.dao;

import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pdsanchez.mywebtools.entity.Log;
import pdsanchez.mywebtools.entity.LogPK;
import pdsanchez.mywebtools.model.dao.contract.LogDAO;

/**
 *
 * @author pdsanchez
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/java/testApplicationContext.xml")
public class LogDAOTest {

  private LogPK pk = new LogPK(new Date(), "127.0.0.1");

  @Autowired
  private LogDAO logDao;

//  @Before
//  public void setUp() {
//  }
//  
//  @After
//  public void tearDown() {
//  }
  @Test
  public void successCreateTest() {
    Log log = new Log(pk, "agent", "logger", "level", "msg", 2015, 5, 15, 11, 46, 0);
    logDao.create(log);
    assertEquals(logDao.count(), 1);

    logDao.delete(log);
    assertEquals(logDao.count(), 0);
  }

  @Test
  public void successFindTest() {
    Log log = new Log(pk, "agent", "logger", "level", "msg", 2015, 5, 15, 11, 46, 0);
    logDao.create(log);

    Log l = logDao.find(pk);
    assertNotNull(l);
    assertEquals(l.getAgent(), "agent");

    List<Log> list = logDao.findAll();
    assertEquals(list.size(), 1);
    assertEquals(list.get(0).getYear(), 2015);

    logDao.delete(log);
    assertEquals(logDao.count(), 0);
  }

  @Test
  public void successUpdateTest() {
    Log log = new Log(pk, "agent", "logger", "level", "msg", 2015, 5, 15, 11, 46, 0);
    logDao.create(log);

    Log l = logDao.find(pk);
    l.setLevel("newlevel");
    logDao.update(l);

    assertEquals(logDao.find(pk).getLevel(), "newlevel");

    logDao.delete(log);
    assertEquals(logDao.count(), 0);
  }

  @Test
  public void successCountTest() {
    Log log = new Log(pk, "agent", "logger", "level", "msg", 2015, 5, 15, 11, 46, 0);
    logDao.create(log);
    assertEquals(logDao.count(), 1);

    logDao.delete(log);
    assertEquals(logDao.count(), 0);
  }

  @Test
  public void successDeleteTest() {
    Log log = new Log(pk, "agent", "logger", "level", "msg", 2015, 5, 15, 11, 46, 0);
    logDao.create(log);
    assertEquals(logDao.count(), 1);

    logDao.delete(log);
    assertEquals(logDao.count(), 0);

    logDao.delete(log);
    assertEquals(logDao.count(), 0);
  }
}

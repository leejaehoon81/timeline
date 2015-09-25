// create by YJ 0916
package net.bitacademy.java72.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.bitacademy.java72.dao.ChronicleDao;
import net.bitacademy.java72.domain.Chronicle;
import net.bitacademy.java72.service.ChronicleService;

@Service
public class ChronicleServiceImpl implements ChronicleService {
  @Autowired ChronicleDao chronicleDao;

  @Override
  public List<Chronicle> list(int no) {
    return chronicleDao.list(no);
  }

  @Override
  public int delete(int no) {
    return chronicleDao.delete(no);
  }

  @Override
  public int update(Chronicle chronicle) {
    return chronicleDao.update(chronicle);
  }

  @Override
  public int insert(Chronicle chronicle) {
    return chronicleDao.insert(chronicle);
  }

  @Override
  public Chronicle get(int no) {
    return chronicleDao.get(no);
  }

  @Override
  public int countAll() {
    return chronicleDao.countAll();
  }

  @Override
  public int deleteWithPic(int no) {
    return chronicleDao.deleteWithPic(no);
  }
  
}

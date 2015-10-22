// create by YJ 0916
package net.bitacademy.java72.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.bitacademy.java72.dao.ChronicleMainDao;
import net.bitacademy.java72.domain.ChronicleMain;
import net.bitacademy.java72.service.ChronicleMainService;

@Service
public class ChronicleMainServiceImpl implements ChronicleMainService {
  @Autowired ChronicleMainDao chronicleMainDao;

  @Override
  public List<ChronicleMain> list(int no) {
    return chronicleMainDao.list(no);
  }

  @Override
  public int delete(int no) {
    return chronicleMainDao.delete(no);
  }

  @Override
  public int update(ChronicleMain chronicleMain) {
    return chronicleMainDao.update(chronicleMain);
  }

  @Override
  public int insert(ChronicleMain chronicleMain) {
    return chronicleMainDao.insert(chronicleMain);
  }

  @Override
  public ChronicleMain get(int no) {
    return chronicleMainDao.get(no);
  }

  @Override
  public int countAll() {
    return chronicleMainDao.countAll();
  }

  @Override
  public List<ChronicleMain> newMain(int no) {
    return chronicleMainDao.newMain(no);
  }

  @Override
  public ChronicleMain getMain(int mainNo, int mno) {
    HashMap<String,Integer> map = new HashMap<String,Integer>();
    map.put("mainNo", mainNo);
    map.put("mno", mno);
    return chronicleMainDao.getMain(map);
  }

  @Override
  public int delMainWithPic(int no) {
    return chronicleMainDao.delMainWithPic(no);
  }

  @Override
  public int delWithNo(int no) {
    return chronicleMainDao.delWithNo(no);
  }
  
}

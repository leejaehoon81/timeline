// create by YJ 0916
package net.bitacademy.java72.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.bitacademy.java72.dao.DialogPhotoDao;
import net.bitacademy.java72.domain.DialogPhoto;
import net.bitacademy.java72.service.DialogPhotoService;

@Service
public class DialogPhotoServiceImpl implements DialogPhotoService {
  @Autowired DialogPhotoDao dialogPhotoDao;

  @Override
  public List<DialogPhoto> list() {
    return dialogPhotoDao.list();
  }

  @Override
  public int delete(int no) {
    return dialogPhotoDao.delete(no);
  }

  @Override
  public int update(DialogPhoto dialogPhoto) {
    return dialogPhotoDao.update(dialogPhoto);
  }

  @Override
  public int insert(DialogPhoto dialogPhoto) {
    return dialogPhotoDao.insert(dialogPhoto);
  }

  @Override
  public DialogPhoto get(int no) {
    return dialogPhotoDao.get(no);
  }

  @Override
  public int countAll() {
    return dialogPhotoDao.countAll();
  }
  
}

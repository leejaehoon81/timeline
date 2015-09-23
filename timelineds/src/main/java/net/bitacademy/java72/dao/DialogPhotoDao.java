// create by YJ 0916
package net.bitacademy.java72.dao;

import java.util.List;

import net.bitacademy.java72.domain.DialogPhoto;

public interface DialogPhotoDao {
  List<DialogPhoto> list();
  int delete(int no);
  int update(DialogPhoto dialogPhoto);
  int insert(DialogPhoto dialogPhoto);
  DialogPhoto get(int no);
  int countAll();
}

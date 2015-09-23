// create by YJ 0915
package net.bitacademy.java72.service;

import java.util.List;

import net.bitacademy.java72.domain.DialogPhoto;

public interface DialogPhotoService {
  List<DialogPhoto> list();
  int delete(int no);
  int update(DialogPhoto dialogPhoto);
  int insert(DialogPhoto dialogPhoto);
  DialogPhoto get(int no);
  int countAll();
}

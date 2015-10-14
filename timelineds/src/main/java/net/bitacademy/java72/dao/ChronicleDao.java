// create by YJ 0916
package net.bitacademy.java72.dao;

import java.util.List;

import net.bitacademy.java72.domain.Chronicle;;

public interface ChronicleDao {
  List<Chronicle> list(int no);
  int delete(int no);
  int deleteWithPic(int no);
  int update(Chronicle chronicle);
  int insert(Chronicle chronicle);
  Chronicle get(int no);
  int countAll();
  List<Chronicle> getIndex();
}

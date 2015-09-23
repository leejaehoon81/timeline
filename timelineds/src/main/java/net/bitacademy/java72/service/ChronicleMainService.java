// create by YJ 0915
package net.bitacademy.java72.service;

import java.util.List;

import net.bitacademy.java72.domain.ChronicleMain;

public interface ChronicleMainService {
  List<ChronicleMain> list(int no);
  int delete(int no);
  int update(ChronicleMain chronicleMain);
  int insert(ChronicleMain chronicleMain);
  ChronicleMain get(int no);
  int countAll();
}

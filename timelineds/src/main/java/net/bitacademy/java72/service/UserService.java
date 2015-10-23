package net.bitacademy.java72.service;

import net.bitacademy.java72.domain.User;

public interface UserService {
//  List<Member> list(int pageNo, int pageSize);
//  int delete(int no);
//  int update(Member member);
  int update(User user);
  int insert(User user);
  User userInfo(String email);
//  User get(int no);
//  User getUser(String email, String password);
//  int countAll();
  User checkUser(String email, String password);
  int facebookInsert(User user);
  User checkFacebook(String fbID);
}








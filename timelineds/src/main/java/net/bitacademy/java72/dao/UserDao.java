package net.bitacademy.java72.dao;

import java.util.Map;

import net.bitacademy.java72.domain.User;

public interface UserDao {
//  List<Member> list(Map<String,Object> paramMap);
//  int delete(int no);
//  int update(Member member);
  int insert(User user);
  int update(User user);
//  User get(int no);
//  User exist(Map<String,String> map);
//  int countAll();
//  int countEmail(String email);
  User checkUser(Map<String,String> map);
  User userInfo(String email);
  int facebookInsert(User user);
  User checkFacebook(String fbID);
}












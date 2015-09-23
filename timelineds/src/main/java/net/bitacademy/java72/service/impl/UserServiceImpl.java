package net.bitacademy.java72.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.bitacademy.java72.dao.UserDao;
import net.bitacademy.java72.domain.User;
import net.bitacademy.java72.service.UserService;

@Service
public class UserServiceImpl implements UserService {
  @Autowired UserDao userDao;
  
//  @Override
//  public List<Member> list(int pageNo, int pageSize) {
//    int startIndex = (pageNo - 1) * pageSize;
//    if (startIndex < 0) {
//      startIndex = 0;
//    }
//    
//    Map<String,Object> paramMap = 
//        new HashMap<String,Object>();
//    paramMap.put("startIndex", startIndex);
//    paramMap.put("pageSize", pageSize);
//    
//    return memberDao.list(paramMap);
//  }
//
//  @Override
//  public int delete(int no) {
//    return memberDao.delete(no);
//  }
//
//  @Override
//  public int update(Member member) {
//    return memberDao.update(member);
//  }
//
  @Override
  public int insert(User user) {
    return userDao.insert(user);
  }

//  @Override
//  public User get(int no) {
//    return userDao.get(no);
//  }
//
//  @Override
//  public User getUser(String email, String password) {
//    HashMap<String,String> map = 
//        new HashMap<String,String>();
//    map.put("email", email);
//    map.put("password", password);
//    
//    return userDao.exist(map);
//  }
//
//  @Override
//  public int countAll() {
//    return userDao.countAll();
//  }

  @Override
  public User checkUser(String email, String password) {
    
    HashMap<String,String> map = 
        new HashMap<String,String>();
    map.put("email", email);
    map.put("password", password);
    
    System.out.println("=====>" + userDao.checkUser(map));
    
    if (userDao.checkUser(map) != null) {
      return userDao.checkUser(map);
    } else {
      return null;
    }
    
    
  }

  @Override
  public User userInfo(String email) {
    User user = userDao.userInfo(email);
    return user;
  }

}


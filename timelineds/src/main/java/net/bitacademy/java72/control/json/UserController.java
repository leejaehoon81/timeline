package net.bitacademy.java72.control.json;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.bitacademy.java72.domain.User;
import net.bitacademy.java72.service.UserService;

@Controller("json.UserController")
@RequestMapping("/json/user")
public class UserController {
  @Autowired UserService userService;
  @Autowired ServletContext sc;
  

  @RequestMapping("/insert")
  public Object insert(User user) throws Exception {
    int count = userService.insert(user);
    
    Map<String,Object> result = 
        new HashMap<String,Object>();
   
    if (count > 0) {
      result.put("data", "success");
     
      createFile(user);
    
    } else {
      result.put("data", "failure");
    }
    
    return result;
  }
  
  
  public Object facebookInsert(User user,  HttpServletResponse response, HttpSession session) throws Exception {
    int count = userService.facebookInsert(user);
    System.out.println("facebookInsert~~!!!");
    Map<String,Object> result = 
        new HashMap<String,Object>();
    
    if (count > 0) {
      result.put("data", "success");
      
      createFile(user);
      
    } else {
      result.put("data", "failure");
    }
    user = userService.checkFacebook(user.getFbID());
    
    if (user != null) {
      result.put("data", "yes");
      result.put("userdata", user);
      session.setAttribute("user", user);
      System.out.println("session ==>> " + user);
      String refererUrl=(String)session.getAttribute("refererUrl");
      System.out.println("refererUrl===>"+refererUrl);
      if(refererUrl !=null){
        result.put("refererUrl", refererUrl);
      }
    } else {
      session.invalidate();
      result.put("data", "no");
    }
    return result;
  }
  
  public void createFile(User user) {
    if(user.getFbID()!=null){
      user= userService.checkFacebook(user.getFbID());
    }else{
      user = userService.userInfo(user.getEmail());
    }
    int folderName =user.getMno();
    String afterFilePath=sc.getRealPath("/userFolder")+"/";
    String path = afterFilePath+folderName;
    String path1=path+"_thumb";
    
    File dir = new File(path);
    File dir1 = new File(path1);
    try{
    if (!dir.exists()) { //폴더 없으면 폴더 생성
        dir.mkdirs();
        File.createTempFile("123", ".txt", dir);
        System.out.println("===>"+dir);
    }
    
    if(!dir1.exists()){
      dir1.mkdirs();
      File.createTempFile("123", ".txt", dir1);
      System.out.println("===>"+dir1);
    }
    }catch(Exception e){
      e.printStackTrace();
    }

}
  
  @RequestMapping("/loginInfo")
  public Object loginInfo(
      HttpSession session) {
    
    Map<String,Object> result = 
        new HashMap<String,Object>();

    User user = 
        (User)session.getAttribute("user");
    String loding=(String)session.getAttribute("loding");
    if (user == null) {
      result.put("state", "no");
    } else {
      result.put("state", "yes");
      result.put("data", user);
      result.put("loding", loding);
    }
    
    return result;
  }
  

 /* 
  @RequestMapping("/update")
  public Object update(Member member) throws Exception {
    int count = userService.update(member);
    
    Map<String,Object> result = 
        new HashMap<String,Object>();
    if (count > 0) {
      result.put("data", "success");
    } else {
      result.put("data", "failure");
    }
    return result;
  }
*/ 
  
@RequestMapping("/logout")
public Object logout(HttpSession session) {
  Map<String,Object> result = 
      new HashMap<String,Object>();
  User user = 
      (User)session.getAttribute("user");
  if(user.getFbID() !=null){
    result.put("face", "yes");
  }
  session.invalidate(); 
  
  result.put("data", "yes");
  
  return result;
}

  @RequestMapping("/login")
  public Object checkUser(String email, String password, HttpServletResponse response, HttpSession session) {
   
    System.out.println("Email:"+email);
    System.out.println("Password:"+password);
    
    Map<String,Object> result = 
        new HashMap<String,Object>();
    User user = userService.checkUser(email, password);
    if (user != null) {
      result.put("data", "yes");
      result.put("userdata", user);
      session.setAttribute("user", user);
      System.out.println("session ==>> " + user);
      String refererUrl=(String)session.getAttribute("refererUrl");
      System.out.println("refererUrl===>"+refererUrl);
      if(refererUrl !=null){
        result.put("refererUrl", refererUrl);
      }
    } else {
      session.invalidate();
      result.put("data", "no");
    }
    return result;
  }
  
  @RequestMapping("/facebooklogin")
  public Object checkFacebook(User user,  HttpServletResponse response, HttpSession session) {
    System.out.println("checkFaceBook~~!!!");
    System.out.println("fbID:"+user.getFbID());
    
    Map<String,Object> result = 
        new HashMap<String,Object>();
    User getuser = userService.checkFacebook(user.getFbID());
    if (getuser != null) {
      result.put("data", "yes");
      result.put("userdata", getuser);
      session.setAttribute("user", getuser);
      System.out.println("session ==>> " + getuser);
      String refererUrl=(String)session.getAttribute("refererUrl");
      System.out.println("refererUrl===>"+refererUrl);
      if(refererUrl !=null){
        result.put("refererUrl", refererUrl);
      }
    } else {
      try {
        facebookInsert(user, response, session);
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      result.put("data", "no");
    }
    return result;
  }
  
 
}







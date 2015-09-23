package net.bitacademy.java72.control.json;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
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
  
/* 
  @RequestMapping("/delete") 
  public Object delete(int no) {
    int count = userService.delete(no);
    
    Map<String,Object> result = 
        new HashMap<String,Object>();
    if (count > 0) {
      result.put("data", "success");
    } else {
      result.put("data", "failure");
    }
    
    return result;
  }
  
  @RequestMapping("/detail")
  public Object detail(int no) {
    Map<String,Object> result = 
        new HashMap<String,Object>();
    result.put("data", userService.get(no));
    
    return result;
  }
*/
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
  
  public void createFile(User user) {
    user = userService.userInfo(user.getEmail());
    
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
  
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception { 
    
    
    HttpSession session  =  request.getSession();
    
    String member_id = (String)session.getAttribute("email_id");
    
    System.out.println("현재 로그인하려는 member_id = "+member_id);
    if ( member_id == null) {   //session check
      response.sendRedirect("loginpage.do");
      return false;
    }

    else{
      return true;
    }
    
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
  
  @RequestMapping("/checkUser")
  public Object checkUser(String email, String password) {
   
    System.out.println("Email:"+email);
    System.out.println("Password:"+password);
    
    Map<String,Object> result = 
        new HashMap<String,Object>();
    
    if (userService.checkUser(email, password) != null) {
      result.put("data", "yes");
      result.put("userdata", userService.checkUser(email, password));
    } else {
      result.put("data", "no");
    }
    return result;
  }
  
 
}







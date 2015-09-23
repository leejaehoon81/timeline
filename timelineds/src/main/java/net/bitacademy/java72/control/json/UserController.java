package net.bitacademy.java72.control.json;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

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
      
      String folderName =user.getEmail();
      String fileName="1.txt";
      String beforeFilePath= sc.getRealPath("/files")+"/1.txt";
      String afterFilePath=sc.getRealPath("/userFolder")+"/";
      String thumbFilePath = sc.getRealPath("/userFolder")+"/";
      moveFile(folderName, fileName, beforeFilePath, afterFilePath, thumbFilePath);
    
    } else {
      result.put("data", "failure");
    }
    
    return result;
  }
  
  public void moveFile(String folderName, String fileName, String beforeFilePath, String afterFilePath, String thumbFilePath) {

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
/*  
  @RequestMapping("/list")
  public Object list(
      @RequestParam(required=false, defaultValue="1") 
      int pageNo,
      @RequestParam(required=false, defaultValue="3")
      int pageSize) {
    
    Map<String,Object> result = 
        new HashMap<String,Object>();
    
    result.put("pageNo", pageNo);

    int totalCount = userService.countAll();
    int lastPageNo = totalCount / pageSize;
    if ((totalCount % pageSize)  > 0) {
      lastPageNo++;
    }
    
    if (pageNo < lastPageNo) { // 다음 페이지가 있다면
      result.put("isNextPage", true);
    } else {
      result.put("isNextPage", false);
    }
    
    result.put("pageSize", pageSize);
    result.put("data", 
        userService.list(pageNo, pageSize));
    
    return result;
  }
  
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







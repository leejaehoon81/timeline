package net.bitacademy.java72.control.json;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import net.bitacademy.java72.domain.ChronicleMain;
import net.bitacademy.java72.domain.User;
import net.bitacademy.java72.service.ChronicleMainService;
import net.bitacademy.java72.util.ResponseFactory;

@Controller("json.ChronicleMainController")
//@RequestMapping("/chronicle/src/")
public class ChronicleMainController {
  @Autowired ChronicleMainService chronicleMainService;
  @Autowired ServletContext servletContext;

  
  @RequestMapping("/mainInsert")
  public ResponseEntity<String> insert(ChronicleMain chronicleMain, HttpSession session, 
      @RequestParam(required=false) MultipartFile file1) throws Exception {
    session.setAttribute("loding","loding");
      User user = (User) session.getAttribute("user");
      System.out.println(user.getMno());
      
      chronicleMain.setMemberKeyNo(user.getMno());
      int count = chronicleMainService.insert(chronicleMain);
      
      Map<String,Object> result = new HashMap<String,Object>();
      if (count > 0) {
        result.put("Events", "success");
       
        //session.setAttribute("main", newMain(user.getMno()));
        session.setAttribute("mainNo", newMain(user.getMno()).getMainNo());
        System.out.println("mainNo session => "+session.getAttribute("mainNo"));
      } else {
        result.put("Events", "failure");
      }
      
      return ResponseFactory.createResponse(result);
  }
  
  public ChronicleMain newMain(int no){
  
    List<ChronicleMain> main = chronicleMainService.newMain(no);
    ChronicleMain newMain = main.get(0);
    return newMain;
  }
  
  @RequestMapping("/getNo")
  public  ResponseEntity<String> getMain(ChronicleMain chronicleMain, HttpSession session) throws Exception {
    //User user = (User) session.getAttribute("user");
    session.setAttribute("loding","loding");
    System.out.println("mainno = >"+chronicleMain.getMainNo());
    session.setAttribute("mainNo", chronicleMain.getMainNo());
    
    Map<String,Object> result = new HashMap<String,Object>();
    //chronicleMain = chronicleMainService.getMain(chronicleMain.getMainNo(),user.getMno());
    result.put("success", "ok");
    return ResponseFactory.createResponse(result);
  }
  
  @RequestMapping("/mainList")
  public ResponseEntity<String> list(HttpSession session) {
    Map<String,Object> result = new HashMap<String,Object>();
    User user = (User) session.getAttribute("user");
    
    List<ChronicleMain> main = chronicleMainService.list(user.getMno());
    
    result.put("Events", main);
    
    return ResponseFactory.createResponse(result);
  }
  
}

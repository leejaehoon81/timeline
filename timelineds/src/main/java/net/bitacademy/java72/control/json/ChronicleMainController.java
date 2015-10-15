package net.bitacademy.java72.control.json;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import net.bitacademy.java72.domain.Chronicle;
import net.bitacademy.java72.domain.ChronicleMain;
import net.bitacademy.java72.domain.User;
import net.bitacademy.java72.service.ChronicleMainService;
import net.bitacademy.java72.service.ChronicleService;
import net.bitacademy.java72.util.ResponseFactory;

@Controller("json.ChronicleMainController")
//@RequestMapping("/chronicle/src/")
public class ChronicleMainController {
  @Autowired ChronicleMainService chronicleMainService;
  @Autowired ServletContext servletContext;

  
  @RequestMapping("/mainInsert")
  public ResponseEntity<String> insert(ChronicleMain chronicleMain, HttpSession session, 
      @RequestParam(required=false) MultipartFile file1) throws Exception {
      
      User user = (User) session.getAttribute("user");
      System.out.println(user.getMno());
      chronicleMain.setMemberKeyNo(user.getMno());
      int count = chronicleMainService.insert(chronicleMain);
      
      Map<String,Object> result = new HashMap<String,Object>();
      if (count > 0) {
        result.put("Events", "success");
        session.setAttribute("loding", "loding");
      } else {
        result.put("Events", "failure");
      }
      
      return ResponseFactory.createResponse(result);
  }
  
}

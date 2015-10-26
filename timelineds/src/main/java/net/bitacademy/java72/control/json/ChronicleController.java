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

import net.bitacademy.java72.domain.Chronicle;
import net.bitacademy.java72.domain.ChronicleMain;
import net.bitacademy.java72.domain.User;
import net.bitacademy.java72.service.ChronicleMainService;
import net.bitacademy.java72.service.ChronicleService;
import net.bitacademy.java72.service.DialogPhotoService;
import net.bitacademy.java72.util.ResponseFactory;

@Controller("json.ChronicleController")
@RequestMapping("/chronicle/src/")
public class ChronicleController {
  @Autowired ChronicleService chronicleService;
  @Autowired ChronicleMainService chronicleMainService;
  @Autowired ServletContext servletContext;
  @Autowired DialogPhotoService dialogPhotoService;

  
  @RequestMapping("/getMain")
  public ResponseEntity<String> getNo(HttpSession session) {
    Map<String,Object> result = new HashMap<String,Object>();
    session.setAttribute("loding", "");
    User user = (User)session.getAttribute("user");
    int no = (int)session.getAttribute("mainNo");
    int userNo;
    ChronicleMain chronicleMain=null;
    if(user ==null){
      userNo = (int)session.getAttribute("no");
      chronicleMain = chronicleMainService.getMain(no,userNo);
    }else{
      
      chronicleMain = chronicleMainService.getMain(no,user.getMno());
    }
    System.out.println("no==>"+no);
   
    System.out.println("chronicleMain.getTitle()"+ chronicleMain.getTitle());
    result.put("Title",chronicleMain.getTitle());
    result.put("FeatureImagePath", chronicleMain.getFeatureImagePath());
    result.put("Body", chronicleMain.getBody());
    result.put("InitialCaption", chronicleMain.getInitialCaption());
    result.put("IsOpenEnded", chronicleMain.getIsOpenEnded());
    result.put("EarliestJulianDay", chronicleMain.getEarliestJulianDay());
    result.put("StartDateDisplay", chronicleMain.getStartDateDisplay());
    result.put("LastJulianDay", chronicleMain.getLastJulianDay());
    result.put("EndDateDisplay", chronicleMain.getEndDateDisplay());
    result.put("BackgroundEvents", "");
    
    result.put("Events", chronicleService.list(no));
    
    
    return ResponseFactory.createResponse(result);
  }
  @RequestMapping("/delete")
  public ResponseEntity<String> delete(HttpSession session,  int no) {
    Map<String,Object> result = new HashMap<String,Object>();
    
    int count = chronicleService.deleteWithPic(no);
    
    if (count > 0) {
      result.put("Events", "success");
    } else {
      result.put("Events", "failure");
    }
    
    count = chronicleService.delete(no);
    
    if (count > 0) {
      result.put("Events", "success");
      session.setAttribute("loding", "loding");
    } else {
      result.put("Events", "failure");
    }
    
    
    return ResponseFactory.createResponse(result);
  }
  
  @RequestMapping("/detail")
  public ResponseEntity<String> detail(int no) {
    Map<String,Object> result = new HashMap<String,Object>();
    result.put("Events", chronicleService.get(no));
    result.put("Photos", dialogPhotoService.get(no));
    
    return ResponseFactory.createResponse(result);
  }

  @RequestMapping("/insert")
  public ResponseEntity<String> insert(Chronicle chronicle, HttpSession session, 
      @RequestParam(required=false) MultipartFile file1) throws Exception {
      
      int mainNo = (int) session.getAttribute("mainNo");
      chronicle.setMainNo(mainNo);
      int count = chronicleService.insert(chronicle);
      
      Map<String,Object> result = new HashMap<String,Object>();
      if (count > 0) {
        result.put("Events", "success");
        session.setAttribute("loding", "loding");
      } else {
        result.put("Events", "failure");
      }
      
      return ResponseFactory.createResponse(result);
  }
  
  @RequestMapping("/getIndex")
  public ResponseEntity<String> getIndex(Chronicle chronicle, HttpSession session) throws Exception {
    
    List<Chronicle> getIndex = chronicleService.getIndex();
    Chronicle c = getIndex.get(0);
    System.out.println("c_index =>"+c.getEventId());
    Map<String,Object> result = new HashMap<String,Object>();
//    if (count > 0) {
//      result.put("Events", "success");
//      session.setAttribute("loding", "loding");
//    } else {
//      result.put("Events", "failure");
//    }
    if(c!=null){
      result.put("data", "ok");
      result.put("iNumber", c.getEventId());
      session.setAttribute("iNumber", c.getEventId());
    }
    return ResponseFactory.createResponse(result);
  }
  
  @RequestMapping("/update")
  public ResponseEntity<String> boardUpdate (
      Chronicle chronicle, HttpSession session, 
      @RequestParam(required=false) MultipartFile file1) throws Exception {

    int count = chronicleService.update(chronicle);

    Map<String,Object> result = 
        new HashMap<String,Object>();
    if (count > 0) {
      result.put("Events", "success");
      session.setAttribute("loding", "loding");
    } else {
      result.put("Events", "failure");
    }
    
    return ResponseFactory.createResponse(result);
  }
}

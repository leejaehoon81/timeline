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
import net.bitacademy.java72.service.ChronicleMainService;
import net.bitacademy.java72.service.ChronicleService;
import net.bitacademy.java72.util.ResponseFactory;

@Controller("json.ChronicleController")
@RequestMapping("/chronicle/src/")
public class ChronicleController {
  @Autowired ChronicleService chronicleService;
  @Autowired ChronicleMainService chronicleMainService;
  @Autowired ServletContext servletContext;

  
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
    
    return ResponseFactory.createResponse(result);
  }

  @RequestMapping("/insert")
  public ResponseEntity<String> insert(Chronicle chronicle, HttpSession session, 
      @RequestParam(required=false) MultipartFile file1) throws Exception {
    
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
  
  @RequestMapping("/list")
  public ResponseEntity<String> list(int no) {
    
    Map<String,Object> result = new HashMap<String,Object>();
    
    List<ChronicleMain> main = chronicleMainService.list(no);
    
    result.put("Title", main.get(no).getTitle());
    result.put("FeatureImagePath", main.get(no).getFeatureImagePath());
    result.put("Body", main.get(no).getBody());
    result.put("InitialCaption", main.get(no).getInitialCaption());
    result.put("IsOpenEnded", main.get(no).getIsOpenEnded());
    result.put("EarliestJulianDay", main.get(no).getEarliestJulianDay());
    result.put("StartDateDisplay", main.get(no).getStartDateDisplay());
    result.put("LastJulianDay", main.get(no).getLastJulianDay());
    result.put("EndDateDisplay", main.get(no).getEndDateDisplay());
    result.put("BackgroundEvents", "");
    
    result.put("Events", chronicleService.list(no));
    
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

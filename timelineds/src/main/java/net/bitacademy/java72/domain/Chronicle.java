// create by YJ 0918
package net.bitacademy.java72.domain;

import java.io.Serializable;

public class Chronicle extends DialogPhoto implements Serializable {
  private static final long serialVersionUID = 1L;
  
  protected int     mainNo;           // 연대기 일련번호(자동증가)
  protected int     EventId;          // 이벤트 인덱스(자동증가)
  protected int     JulianDayStart;   // 시작일
  protected String  Title;            // 이벤트 제목
  protected String  Body;             // 이벤트 내용
  protected int     Priority;         // 우선순위
  protected String  JulianDayEnd;
  protected String  LinkText;
  protected String  LinkTarget;  
  protected String  StartDisplay;
  protected String  StartDisplayYear;
  protected String  EndDisplay;
  protected String  EndDisplayYear;
  protected String  Year;
  
  
  
  public int getMainNo() {
    return mainNo;
  }
  public void setMainNo(int mainNo) {
    this.mainNo = mainNo;
  }
  public int getEventId() {
    return EventId;
  }
  public void setEventId(int eventId) {
    EventId = eventId;
  }
  public int getJulianDayStart() {
    return JulianDayStart;
  }
  public void setJulianDayStart(int julianDayStart) {
    JulianDayStart = julianDayStart;
  }
  public String getTitle() {
    return Title;
  }
  public void setTitle(String title) {
    Title = title;
  }
  public String getBody() {
    return Body;
  }
  public void setBody(String body) {
    Body = body;
  }
  public int getPriority() {
    return Priority;
  }
  public void setPriority(int priority) {
    Priority = priority;
  }
  public String getJulianDayEnd() {
    return JulianDayEnd;
  }
  public void setJulianDayEnd(String julianDayEnd) {
    JulianDayEnd = julianDayEnd;
  }
  public String getLinkText() {
    return LinkText;
  }
  public void setLinkText(String linkText) {
    LinkText = linkText;
  }
  public String getLinkTarget() {
    return LinkTarget;
  }
  public void setLinkTarget(String linkTarget) {
    LinkTarget = linkTarget;
  }
  public String getStartDisplay() {
    return StartDisplay;
  }
  public void setStartDisplay(String startDisplay) {
    StartDisplay = startDisplay;
  }
  public String getStartDisplayYear() {
    return StartDisplayYear;
  }
  public void setStartDisplayYear(String startDisplayYear) {
    StartDisplayYear = startDisplayYear;
  }
  public String getEndDisplay() {
    return EndDisplay;
  }
  public void setEndDisplay(String endDisplay) {
    EndDisplay = endDisplay;
  }
  public String getEndDisplayYear() {
    return EndDisplayYear;
  }
  public void setEndDisplayYear(String endDisplayYear) {
    EndDisplayYear = endDisplayYear;
  }
  public String getYear() {
    return Year;
  }
  public void setYear(String year) {
    Year = year;
  }
  
   
}
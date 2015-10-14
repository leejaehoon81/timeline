// create by YJ 0918
package net.bitacademy.java72.domain;

import java.io.Serializable;

public class ChronicleMain  implements Serializable {
  private static final long serialVersionUID = 1L;
  
  protected int     memberKeyNo;      // 회원 키값
  protected int     mainNo;           // 연대기 일련번호(자동증가)
  protected String  Title;            // 연대기 제목
  protected int     EarliestJulianDay;// 연대기 첫 날짜
  protected int     LastJulianDay;    // 연대기 종료 날짜
  protected String  Body;             // 연대기 소개
  protected String  FeatureImagePath; // 메인 사진(첫화면의 디테일 사진)
  protected boolean share;            // 공개유무 
  protected int     mainCount;        // 메인 연대기 갯수(카운트함)
  protected String  InitialCaption;
  protected String  IsOpenEnded;
  protected String  StartDateDisplay;
  protected String  EndDateDisplay;
  protected String  BackgroundEvents;
  
  
  
  public int getMainNo() {
    return mainNo;
  }
  public void setMainNo(int mainNo) {
    this.mainNo = mainNo;
  }
  public int getMemberKeyNo() {
    return memberKeyNo;
  }
  public void setMemberKeyNo(int memberKeyNo) {
    this.memberKeyNo = memberKeyNo;
  }
  public int getMainCount() {
    return mainCount;
  }
  public void setMainCount(int mainCount) {
    this.mainCount = mainCount;
  }
  public String getTitle() {
    return Title;
  }
  public void setTitle(String title) {
    Title = title;
  }
  public int getEarliestJulianDay() {
    return EarliestJulianDay;
  }
  public void setEarliestJulianDay(int earliestJulianDay) {
    EarliestJulianDay = earliestJulianDay;
  }
  public int getLastJulianDay() {
    return LastJulianDay;
  }
  public void setLastJulianDay(int lastJulianDay) {
    LastJulianDay = lastJulianDay;
  }
  public String getBody() {
    return Body;
  }
  public void setBody(String body) {
    Body = body;
  }
  public String getFeatureImagePath() {
    return FeatureImagePath;
  }
  public void setFeatureImagePath(String featureImagePath) {
    FeatureImagePath = featureImagePath;
  }
  public boolean isShare() {
    return share;
  }
  public void setShare(boolean share) {
    this.share = share;
  }
  public String getInitialCaption() {
    return InitialCaption;
  }
  public void setInitialCaption(String initialCaption) {
    InitialCaption = initialCaption;
  }
  public String getIsOpenEnded() {
    return IsOpenEnded;
  }
  public void setIsOpenEnded(String isOpenEnded) {
    IsOpenEnded = isOpenEnded;
  }
  public String getStartDateDisplay() {
    return StartDateDisplay;
  }
  public void setStartDateDisplay(String startDateDisplay) {
    StartDateDisplay = startDateDisplay;
  }
  public String getEndDateDisplay() {
    return EndDateDisplay;
  }
  public void setEndDateDisplay(String endDateDisplay) {
    EndDateDisplay = endDateDisplay;
  }
  public String getBackgroundEvents() {
    return BackgroundEvents;
  }
  public void setBackgroundEvents(String backgroundEvents) {
    BackgroundEvents = backgroundEvents;
  }
  
  
}

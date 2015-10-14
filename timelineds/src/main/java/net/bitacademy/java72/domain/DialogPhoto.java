// create by YJ 0918
package net.bitacademy.java72.domain;

import java.io.Serializable;

public class DialogPhoto implements Serializable {
  private static final long serialVersionUID = 1L;
  
  protected int     photoNo;          // 첨부이미지 일련번호(자동증가)
  protected String  ThumbnailPath;    // 썸네일 이미지 경로(70x70)
  protected String  FeatureImagePath; // 다이얼로그 이미지 경로(220x220) 
  protected String  detailPath;       // 디테일 이미지 경로(original image)
  protected String  PromoImagePath;
  protected String  ImageCredit;
  protected String  UsedBy;
  protected int EventId;
  
  
  public int getEventId() {
    return EventId;
  }
  public void setEventId(int eventId) {
    EventId = eventId;
  }
  public int getPhotoNo() {
    return photoNo;
  }
  public void setPhotoNo(int photoNo) {
    this.photoNo = photoNo;
  }
  public String getThumbnailPath() {
    return ThumbnailPath;
  }
  public void setThumbnailPath(String thumbnailPath) {
    ThumbnailPath = thumbnailPath;
  }
  public String getFeatureImagePath() {
    return FeatureImagePath;
  }
  public void setFeatureImagePath(String featureImagePath) {
    FeatureImagePath = featureImagePath;
  }
  public String getDetailPath() {
    return detailPath;
  }
  public void setDetailPath(String detailPath) {
    this.detailPath = detailPath;
  }
  public String getPromoImagePath() {
    return PromoImagePath;
  }
  public void setPromoImagePath(String promoImagePath) {
    PromoImagePath = promoImagePath;
  }
  public String getImageCredit() {
    return ImageCredit;
  }
  public void setImageCredit(String imageCredit) {
    ImageCredit = imageCredit;
  }
  public String getUsedBy() {
    return UsedBy;
  }
  public void setUsedBy(String usedBy) {
    UsedBy = usedBy;
  }
  
  
}

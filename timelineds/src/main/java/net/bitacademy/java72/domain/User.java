package net.bitacademy.java72.domain;

import java.io.Serializable;

public class User implements Serializable {
  private static final long serialVersionUID = 1L;

  protected int mno;
  protected String email;
  protected String password;
  protected String name;
  protected String flag;
  protected String mypic;
  protected String fbID;

  public int getMno() {
    return mno;
  }

  public void setMno(int mno) {
    this.mno = mno;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  public String getMypic() {
    return mypic;
  }

  public void setMypic(String mypic) {
    this.mypic = mypic;
  }

  public String getFbID() {
    return fbID;
  }

  public void setFbID(String fbID) {
    this.fbID = fbID;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

}

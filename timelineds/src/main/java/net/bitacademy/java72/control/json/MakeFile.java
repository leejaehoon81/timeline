package net.bitacademy.java72.control.json;

import java.io.File;

public class MakeFile {

  public static void main(String[] args) {
    MakeFile fileMove = new MakeFile();
    
    String folderName = "new";//폴더 생성할 이름
    String fileName = "가수이미지11.jpg"; //바뀔 이름
    String beforeFilePath = "C:/tmp/upload/2015/06/25/앨범속지1.jpg"; //옮길 대상 경로
    String afterFilePath = "C:/tmp/upload/"; //옮겨질 경로
     
    String result = fileMove.moveFile(folderName, fileName, beforeFilePath, afterFilePath);
    if(result!=null){
        System.out.println("SUCCESS: "+result);
    }else{
        System.out.println("FAIL");
    }
}

public String moveFile(String folderName, String fileName, String beforeFilePath, String afterFilePath) {

    String path = afterFilePath+"/"+folderName;
    String filePath = path+"/"+fileName;

    File dir = new File(path);

    if (!dir.exists()) { //폴더 없으면 폴더 생성
        dir.mkdirs();
    }

    try{

        File file =new File(beforeFilePath);

        if(file.renameTo(new File(filePath))){ //파일 이동
            return filePath; //성공시 성공 파일 경로 return
        }else{
            return null;
        }

    }catch(Exception e){
        e.printStackTrace();
        return null;
    }

}
}

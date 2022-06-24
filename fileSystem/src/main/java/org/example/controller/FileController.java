package org.example.controller;

import org.example.Service.FileService;
import org.example.Service.RecordService;
import org.example.Service.UserService;
import org.example.pojo.User;
import org.example.pojo.file;
import org.example.utils.toJson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
public class FileController {
    @Resource
    private UserService userService;

    @Resource
    private FileService fileService;

    @Resource
    private RecordService recordService;


    @RequestMapping("getFile")
    public toJson getFile(String userName){
        Integer nowUserRole= userService.getNowUserRole(userName);
        List<file> fileList = fileService.getFileList(nowUserRole);
        return new toJson(fileList);
    }


    @RequestMapping("getSearchFile")
    public toJson getSearchFile(String fileName,String userName){
        System.out.println(fileName);
        List<file> fileList = fileService.searchFile(fileName,userService.getNowUserRole(userName));
        return new toJson(fileList);
    }
    @RequestMapping("getOneFile")
    public toJson getOneFile(String fileName){
        file myFile=fileService.getOneFile(fileName);
        return new toJson(myFile);
    }
    @RequestMapping("deleteFile")
    public toJson deleteFile(String fileName){
        System.out.println(fileName);
        recordService.InsertRecord(fileName,"删除");
        fileService.deleteFile(fileName);
        return new toJson("成功删除");
    }

//    url: "/addFile?userName=" + userName+"&fileName="+fileName+"&fileContent="+fileContent+"&type="+type,
//String date;
//    String type;
//    Integer role;
//    String fileContent;

    @RequestMapping("addFile")
    public toJson addFile(String userName,String fileName,String fileContent,String type){
        //获取用户权限
        Integer nowUserRole= userService.getNowUserRole(userName);
        Date utilDate = new Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());//获取java.util.Date对象---也即当前时间
        file myFile=new file(fileName,userName,sqlDate,type,nowUserRole,fileContent);
        fileService.addFile(myFile);
        recordService.InsertRecord(fileName,"增加");
        return new toJson("成功增加");
    }

    @RequestMapping("modifyFile")
    public toJson modifyFile(String userName,String fileName,String fileContent,String type){
        //获取用户权限
        Integer nowUserRole= userService.getNowUserRole(userName);
        Date utilDate = new Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());//获取java.util.Date对象---也即当前时间
        file myFile=new file(fileName,userName,sqlDate,type,nowUserRole,fileContent);
        fileService.modifyFile(myFile);
        recordService.InsertRecord(fileName,"修改");
        return new toJson("成功修改");
    }



}


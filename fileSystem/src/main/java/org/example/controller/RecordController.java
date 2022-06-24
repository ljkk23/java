package org.example.controller;

import org.example.Service.FileService;
import org.example.Service.RecordService;
import org.example.Service.UserService;
import org.example.pojo.OptRecord;
import org.example.pojo.User;
import org.example.pojo.file;
import org.example.utils.toJson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Objects;

@RestController
public class RecordController {
    @Resource
    private RecordService recordService;
    @Resource
    private FileService fileService;

//    public OptRecord(String fileName, String user, Date date, String type, Integer role, String fileContent, String opt) {

    @RequestMapping("getRecordList")
    public toJson getRecordList(){
        return new toJson(recordService.getRecordList());
    }

}


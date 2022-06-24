package org.example.Service.impl;

import org.example.Service.FileService;
import org.example.Service.RecordService;
import org.example.Service.UserService;
import org.example.mapper.RecordMapper;
import org.example.mapper.UserMapper;
import org.example.pojo.OptRecord;
import org.example.pojo.User;
import org.example.pojo.file;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service
public class RecordServiceImpl implements RecordService {

    @Resource
    private RecordMapper recordMapper;
    @Resource
    private FileService fileService;


    @Override
    public void InsertRecord(String fileName,String opt) {
        file myfile=fileService.getOneFile(fileName);
        OptRecord record=new OptRecord(myfile.getFileName(),myfile.getUser(),myfile.getDate(),myfile.getType(),myfile.getRole(),myfile.getFileContent(),opt);
        recordMapper.InsertRecord(record);
    }

    @Override
    public List<OptRecord> getRecordList() {
        return recordMapper.getRecordList();
    }
}

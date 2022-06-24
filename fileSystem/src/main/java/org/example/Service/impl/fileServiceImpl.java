package org.example.Service.impl;


import org.example.Service.FileService;

import org.example.mapper.FileMapper;

import org.example.pojo.file;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class fileServiceImpl implements FileService {
    @Resource
   private FileMapper fileMapper;


    @Override
    public List<file> getFileList(Integer Role) {
        return fileMapper.getFileList(Role);
    }

    @Override
    public List<file> searchFile(String fileName,Integer role) {
        return fileMapper.searchFile(fileName,role);
    }

    @Override
    public void deleteFile(String fileName) {
        fileMapper.deleteFile(fileName);
    }

    @Override
    public void addFile(file myFile) {
        fileMapper.addFile(myFile);
    }
    @Override
    public void modifyFile(file myFile) {
        fileMapper.modifyFile(myFile);
    }

    @Override
    public file getOneFile(String fileName) {
        return fileMapper.getOneFile(fileName);
    }
}

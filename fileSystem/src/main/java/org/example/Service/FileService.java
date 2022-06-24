package org.example.Service;

import org.example.pojo.file;

import java.util.List;

public interface FileService {
    //获取fileList
    List<file> getFileList(Integer Role);

    List<file> searchFile(String fileName,Integer role);


    void deleteFile(String fileName);

    void addFile(file myFile);

    void modifyFile(file myFile);

    file getOneFile(String fileName);
}

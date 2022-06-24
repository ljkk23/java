package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.file;

import java.util.List;

@Mapper
public interface FileMapper {

    List<file> getFileList(int Role);

    void deleteFile(String fileName);
    void addFile(file myFile);

    void modifyFile(file myFile);

    file getOneFile(String fileName);

    List<file> searchFile(String fileName,Integer role);





}

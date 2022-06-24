package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.pojo.OptRecord;
import org.example.pojo.User;

import java.util.List;

@Mapper
public interface RecordMapper {

    List<OptRecord> getRecordList();

    void InsertRecord(OptRecord record);

}

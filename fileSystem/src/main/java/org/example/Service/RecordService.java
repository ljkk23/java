package org.example.Service;

import org.example.pojo.OptRecord;
import org.example.pojo.User;

import java.util.List;

public interface RecordService {

  void InsertRecord(String fileName,String opt);

  List<OptRecord> getRecordList();
}

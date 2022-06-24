package org.example.pojo;

import java.util.Date;

public class OptRecord {

    String fileName;
    String user;
    Date date;

    String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public OptRecord(String fileName, String user, Date date, String type, Integer role, String fileContent, String opt) {
        this.fileName = fileName;
        this.user = user;
        this.date = date;
        this.type = type;
        this.role = role;
        this.fileContent = fileContent;
        this.opt = opt;
    }

    Integer role;
    String fileContent;
    String opt;



    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public OptRecord(String fileName, String user, Date date, Integer role, String fileContent, String opt) {
        this.fileName = fileName;
        this.user = user;
        this.date = date;
        this.role = role;
        this.fileContent = fileContent;
        this.opt = opt;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }
}

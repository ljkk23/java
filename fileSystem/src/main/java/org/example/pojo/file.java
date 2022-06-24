package org.example.pojo;

import java.util.Date;

public class file {
    String fileName;
    String user;
    Date date;
    String type;
    Integer role;
    String fileContent;

    public file(String fileName, String user, Date date, String type, Integer role, String fileContent) {
        this.fileName = fileName;
        this.user = user;
        this.date = date;
        this.type = type;
        this.role = role;
        this.fileContent = fileContent;
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

    public Integer getRole() {
        return role;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

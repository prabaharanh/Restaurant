package com.example.admin.kavik;

public class GetTable {
    private String tblDate;
    private String tblTime;
    private String tblPersons;
    private String tblName;
    private String tblPhone;
    private String tblEmail;
    private String tblInstruction;

    public GetTable(String tblDate, String tblTime, String tblPersons, String tblName, String tblPhone, String tblEmail, String tblInstruction) {
        this.tblDate = tblDate;
        this.tblTime = tblTime;
        this.tblPersons = tblPersons;
        this.tblName = tblName;
        this.tblPhone = tblPhone;
        this.tblEmail = tblEmail;
        this.tblInstruction = tblInstruction;
    }

    public String getTblDate() {
        return tblDate;
    }

    public void setTblDate(String tblDate) {
        this.tblDate = tblDate;
    }

    public String getTblTime() {
        return tblTime;
    }

    public void setTblTime(String tblTime) {
        this.tblTime = tblTime;
    }

    public String getTblPersons() {
        return tblPersons;
    }

    public void setTblPersons(String tblPersons) {
        this.tblPersons = tblPersons;
    }

    public String getTblName() {
        return tblName;
    }

    public void setTblName(String tblName) {
        this.tblName = tblName;
    }

    public String getTblPhone() {
        return tblPhone;
    }

    public void setTblPhone(String tblPhone) {
        this.tblPhone = tblPhone;
    }

    public String getTblEmail() {
        return tblEmail;
    }

    public void setTblEmail(String tblEmail) {
        this.tblEmail = tblEmail;
    }

    public String getTblInstruction() {
        return tblInstruction;
    }

    public void setTblInstruction(String tblInstruction) {
        this.tblInstruction = tblInstruction;
    }
}

package model;

import java.time.LocalDate;
import java.util.Date;

public class JobSeekerdto {
    private String name;
    private String address;
    private String gender;
    private LocalDate dob;
    private String technicalSkills;
    private int wxp;
    private String cv;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getTechnicalSkills() {
        return technicalSkills;
    }

    public void setTechnicalSkills(String technicalSkills) {
        this.technicalSkills = technicalSkills;
    }

    public int getWxp() {
        return wxp;
    }

    public void setWxp(int wxp) {
        this.wxp = wxp;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public JobSeekerdto() {
    }
}

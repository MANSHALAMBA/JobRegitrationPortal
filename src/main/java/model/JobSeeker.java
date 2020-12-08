package model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JobSeeker {
@NotBlank
@Pattern(regexp="^[a-zA-Z]*$")
private String name;

@NotBlank
private String address;


//@NotNull
private char gender;


@NotNull
@NotEmpty
//@DateTimeFormat(pattern = "dd-mm-yyyy")
@Pattern(regexp="^(1[0-2]|0[1-9])/(3[01]"
        + "|[12][0-9]|0[1-9])/[0-9]{4}$")
private String dob;

//@Length(min = 2)

@Size(min = 2)
private List<String> technicalSkills =new ArrayList<String>();

@NotNull
@Min(value = 1)
private int wxp;

@NotNull
private File cv;

    public JobSeeker() {
    }

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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public List<String> getTechnicalSkills() {
        return technicalSkills;
    }

    public void setTechnicalSkills(List<String> technicalSkills) {
        this.technicalSkills = technicalSkills;
    }

    public int getWxp() {
        return wxp;
    }

    public void setWxp(int wxp) {
        this.wxp = wxp;
    }

    public File getCv() {
        return cv;
    }

    public void setCv(File cv) {
        this.cv = cv;
    }
}

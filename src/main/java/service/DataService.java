package service;


import dao.OracleDao;
import model.JobSeeker;
import model.JobSeekerdto;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DataService {

    @Autowired
    OracleDao dao;

    public int saveData(JobSeeker js) throws SQLException {
        //prepare dto
        JobSeekerdto jsdto=new JobSeekerdto();
        jsdto.setName(js.getName());
        jsdto.setAddress(js.getAddress());
        jsdto.setGender(Character.toString(js.getGender()));
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        jsdto.setDob(LocalDate.parse(js.getDob(), format));

        List<String> skills=js.getTechnicalSkills();
        String serializedSkills="";
        for(String s:skills){
            serializedSkills+=(s+",");
        };

        jsdto.setTechnicalSkills(serializedSkills);
        jsdto.setWxp(js.getWxp());
        jsdto.setCv(js.getCv().getAbsolutePath());

        return  dao.saveJobSeeker(jsdto);



    };

    public List<String> getJobSeekers() throws SQLException {
       return dao.getJobSeekers();
    };

    public JobSeeker getJobSeeker(String name) throws SQLException {
            JobSeekerdto jsdto=dao.getJobSeeker(name);
            JobSeeker js=new JobSeeker();
             // convert jsdto to js
           js.setName(jsdto.getName());
           js.setAddress(jsdto.getAddress());
           js.setGender(jsdto.getGender().charAt(0));
            js.setDob(jsdto.getDob().toString());
             List<String> l=new ArrayList<String>(Arrays.asList(jsdto.getTechnicalSkills().split(",")) ) ;
             js.setTechnicalSkills(l);

             js.setWxp(jsdto.getWxp());
             js.setCv(new File(jsdto.getCv()));
             return js;




    };


}

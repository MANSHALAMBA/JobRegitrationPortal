package dao;

import model.JobSeekerdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OracleDao {

@Autowired
private DataSource dataSource;

public int saveJobSeeker(JobSeekerdto jsdto) throws SQLException {

    Connection conn=dataSource.getConnection();
    PreparedStatement p=conn.prepareStatement("insert into jobseekers values(?,?,?,?,?,?,?)");
    p.setString(1,jsdto.getName());
    p.setString(2,jsdto.getAddress());
    p.setString(3,jsdto.getGender());
    p.setDate(4,java.sql.Date.valueOf(jsdto.getDob()));
    p.setString(5,jsdto.getTechnicalSkills());
    p.setInt(6,jsdto.getWxp());
    p.setString(7,jsdto.getCv());

    return p.executeUpdate();

}

public List getJobSeekers() throws SQLException{

    Connection conn=dataSource.getConnection();
    PreparedStatement p=conn.prepareStatement("select name from jobseekers");
    ResultSet rs=p.executeQuery();
    List<String> jobseekers=new ArrayList<String>();
    while(rs.next()){
               jobseekers.add(rs.getString(1));

    }
    return jobseekers;

}

public JobSeekerdto getJobSeeker(String name) throws SQLException {
                Connection conn= dataSource.getConnection();
                PreparedStatement p=conn.prepareStatement("select * from jobseekers where name=?");
                p.setString(1,name);
               ResultSet rs=p.executeQuery();
               JobSeekerdto jsdto=new JobSeekerdto();
        while(rs.next()){
                    jsdto.setName(rs.getString(1));
                    jsdto.setAddress(rs.getString(2));
                    jsdto.setGender(rs.getString(3));
                    jsdto.setDob(rs.getDate(4).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                    jsdto.setTechnicalSkills(rs.getString(5));
                    jsdto.setWxp(rs.getInt(6));
                    jsdto.setCv(rs.getString(7));

          }
        return jsdto;
}




}


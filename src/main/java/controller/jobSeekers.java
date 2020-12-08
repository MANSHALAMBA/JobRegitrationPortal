package controller;


import model.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.DataService;

import java.sql.SQLException;
import java.util.List;

@Controller
public class jobSeekers {
    @Autowired
    DataService ds;

    @RequestMapping("/jobSeekerList")
    public ModelAndView getJobSeekers() throws SQLException {

        List<String> jobSeekers=ds.getJobSeekers();
        return new ModelAndView("jobSeekerList","jobseekers",jobSeekers);

    }

    @RequestMapping("/jobseeker/{name}")
    public ModelAndView getJobSeeker(@PathVariable("name") String name) throws SQLException {
             JobSeeker js=ds.getJobSeeker(name);
               return new ModelAndView("jobSeeker","jobseeker",js);

    };


}

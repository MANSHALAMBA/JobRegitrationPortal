package controller;

import dao.OracleDao;
import model.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.DataService;

import javax.validation.Valid;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class registration {
/*@Autowired
OracleDao o;*/
@Autowired
DataService ds;

    @InitBinder
    public void bindingPreparation(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, orderDateEditor);
    }

@GetMapping("/register")
    public String getForm(@ModelAttribute("js") JobSeeker js ,@ModelAttribute("dob") Date date){
       return "RegisterationForm";
}

@PostMapping("/register")
public String register(@ModelAttribute("js") @Valid JobSeeker js , BindingResult br) throws SQLException {
if(br.hasErrors()) {
    return "RegisterationForm";
}
else{
    //System.out.println(js.getDob());
    //call service
    ds.saveData(js);
    return "forward:/jobSeekerList";
}

}

@ExceptionHandler(SQLException.class)
public ModelAndView exceptionHandlerMethod()
    {
        return new ModelAndView("errors","mesaage","There was " +
                "some error saving data into your database");
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandlerMethod2() {
        return new ModelAndView("errors","mesaage","There was " +
                "some error Please retry after some time");
    }





}

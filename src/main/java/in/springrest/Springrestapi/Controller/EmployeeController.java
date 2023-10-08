package in.springrest.Springrestapi.Controller;

import in.springrest.Springrestapi.Model.EmployeeModel;
import in.springrest.Springrestapi.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    /*
    @Value("${app.name}") -->Getting values from application.properties
    private String appName;
    @Value("${app.version : v1 }")
    private String appVersion;

    @GetMapping("/appdetails")
    public String appdetails()
    {
        return appName+"-"+appVersion;
    }

     */
    @Autowired
    private EmployeeService eService;
    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeModel>> employees()
    {
        //return eService.getEmployees();
        return new ResponseEntity<List<EmployeeModel>>(eService.getEmployees(), HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeModel> getemployee(@PathVariable long id)
    {
        //return eService.getEmployee(id);
        return new ResponseEntity<EmployeeModel>(eService.getEmployee(id), HttpStatus.OK);
    }

    @PostMapping("/employee/save")
    public ResponseEntity<EmployeeModel> saveemployee(@Valid @RequestBody EmployeeModel employee)
    {
        //return eService.saveEmployee(employee);
        return new ResponseEntity<EmployeeModel>(eService.saveEmployee(employee),HttpStatus.CREATED);
    }

    @PutMapping("employee/update/{id}")
    public ResponseEntity<EmployeeModel> updateemployee(@PathVariable("id") long id, @RequestBody EmployeeModel employee)
    {
        employee.setId(id);
        //return eService.updateEmployee(employee);
        return new ResponseEntity<EmployeeModel>(eService.updateEmployee(employee), HttpStatus.OK);
    }

    @DeleteMapping("employee/delete")
    public ResponseEntity<HttpStatus> deleteemployee(@RequestParam("id") long id)
    {
         eService.deleteEmployee(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("employee/getby")
    public ResponseEntity<List<EmployeeModel>> getemployeeByName(@RequestParam String name)
    {
        return new ResponseEntity<List<EmployeeModel>>(eService.getEmployeeByName(name), HttpStatus.OK);
    }
    @GetMapping("employee/getbynameandlocation")
    public ResponseEntity<List<EmployeeModel>> getemployeeByNameAndLocation(@RequestParam String name,@RequestParam String location)
    {
        return new ResponseEntity<List<EmployeeModel>>(eService.getEmployeeByNameAndLocation(name, location), HttpStatus.OK);
    }

    @GetMapping("employee/getbykeyword")
    public ResponseEntity<List<EmployeeModel>> getemployeeByKeyword(@RequestParam String keyword)
    {
        return new ResponseEntity<List<EmployeeModel>>(eService.getEmployeeByKeyword(keyword), HttpStatus.OK);
    }

    @GetMapping("employee/page")
    public ResponseEntity<List<EmployeeModel>> employeespage(@RequestParam int pagenumber,@RequestParam int pagesize)
    {
        return new ResponseEntity<List<EmployeeModel>>(eService.getEmployeesPage(pagenumber, pagesize), HttpStatus.OK);
    }
    @DeleteMapping("employee/deletebyname/{name}")
    public ResponseEntity<String> deleteemployee(@PathVariable String name)
    {
        return new ResponseEntity<String>(eService.deleteEmployeeBy(name)+ "No of records deleted", HttpStatus.NO_CONTENT);
    }
}

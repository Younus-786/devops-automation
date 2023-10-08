package in.springrest.Springrestapi.Service;

import in.springrest.Springrestapi.Model.EmployeeModel;

import java.util.List;

public interface EmployeeService {

    List<EmployeeModel> getEmployees();
    EmployeeModel getEmployee(Long id);
    EmployeeModel saveEmployee(EmployeeModel employee);
    EmployeeModel updateEmployee(EmployeeModel employee);

    void deleteEmployee(Long id);
    List<EmployeeModel> getEmployeeByName(String name);
    List<EmployeeModel> getEmployeeByNameAndLocation(String name, String location);
    List<EmployeeModel> getEmployeeByKeyword(String keyword);
    List<EmployeeModel> getEmployeesPage(int pagenumber, int pagesize);
    Integer deleteEmployeeBy(String name);

}

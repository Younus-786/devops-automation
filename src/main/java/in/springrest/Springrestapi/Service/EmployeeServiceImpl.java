package in.springrest.Springrestapi.Service;

import in.springrest.Springrestapi.Model.EmployeeModel;
import in.springrest.Springrestapi.Repository.EmployeeRepository;
import in.springrest.Springrestapi.Repository.EmployeepageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
/*
    private static List<EmployeeModel> list =new ArrayList<>();
    static {
        EmployeeModel e = new EmployeeModel();
        e.setName("Ganesan");
        e.setAge(28);
        e.setEmail("Ganesan109@gmail.com");
        e.setLocation("Melur");
        e.setDepartment("Mech");
        list.add(e);

        e = new EmployeeModel();
        e.setName("Harish");
        e.setAge(22);
        e.setEmail("Harish88@gmail.com");
        e.setLocation("Thanjavur");
        e.setDepartment("CSE");
        list.add(e);
    }

 */
    @Autowired
    private EmployeeRepository eRepository;
    @Autowired
    private EmployeepageRepository epRepository;
    @Override
    public List<EmployeeModel> getEmployees() {
        //Sorting by id
        Sort sort=Sort.by(Sort.Direction.ASC, "id");
        return epRepository.findAll(sort);
    }

    @Override
    public EmployeeModel getEmployee(Long id) {
        Optional<EmployeeModel> e = eRepository.findById(id);
        if(e.isPresent()){
            return e.get();
        }
        throw new RuntimeException("Employee not found with id"+ id);
    }

    @Override
    public EmployeeModel saveEmployee(EmployeeModel employee) {
        return eRepository.save(employee);
    }

    @Override
    public EmployeeModel updateEmployee(EmployeeModel employee) {
        return eRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
         eRepository.deleteById(id);
    }

    @Override
    public List<EmployeeModel> getEmployeeByName(String name) {
        return eRepository.findByName(name);
    }

    @Override
    public List<EmployeeModel> getEmployeeByNameAndLocation(String name, String location) {
        //return eRepository.findByNameAndLocation(name, location);
        return eRepository.getByNameAndLocation(name, location);
    }

    @Override
    public List<EmployeeModel> getEmployeeByKeyword(String keyword) {
        return eRepository.findByNameContaining(keyword);
    }

    @Override
    public List<EmployeeModel> getEmployeesPage(int pagenumber, int pagesize) {
        //PageRequest pages = PageRequest.of(pagenumber, pagesize);
        PageRequest pages = PageRequest.of(pagenumber, pagesize, Sort.Direction.ASC, "id");
        return epRepository.findAll(pages).getContent();
    }

    @Override
    public Integer deleteEmployeeBy(String name) {
        return eRepository.deleteEmployyeByName(name);
    }


}

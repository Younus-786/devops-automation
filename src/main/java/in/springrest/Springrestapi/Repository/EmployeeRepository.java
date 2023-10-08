package in.springrest.Springrestapi.Repository;

import in.springrest.Springrestapi.Model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {

    List<EmployeeModel> findByName(String name);
    //Select * From Table Where name="Younus" And location="srivi";
    //List<EmployeeModel> findByNameAndLocation(String name, String location);
    @Query("FROM EmployeeModel WHERE name = :name AND location = :location")
    List<EmployeeModel> getByNameAndLocation(String name, String location);
    //Select * From Table Where name LIKE %you%;
    List<EmployeeModel> findByNameContaining(String keyword);
    @Transactional
    @Modifying
    @Query("DELETE FROM EmployeeModel WHERE name =:name")
    Integer deleteEmployyeByName(String name);

}

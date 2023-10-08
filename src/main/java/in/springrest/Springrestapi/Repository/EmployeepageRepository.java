package in.springrest.Springrestapi.Repository;

import in.springrest.Springrestapi.Model.EmployeeModel;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeepageRepository extends PagingAndSortingRepository<EmployeeModel, Long> {
    List<EmployeeModel> findAll(Sort sort);
}

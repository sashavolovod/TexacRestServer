package gefest.rest.repo;

import gefest.rest.domain.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepo extends CrudRepository<Employee, Long> { }

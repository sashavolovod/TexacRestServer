package gefest.rest.repo;

import gefest.rest.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository  extends CrudRepository<Customer,Long> { }

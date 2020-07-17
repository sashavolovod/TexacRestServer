package gefest.rest.repo;

import gefest.rest.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends CrudRepository<Order, Long> { }


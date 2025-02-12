package gefest.rest.repo;

import gefest.rest.domain.Order;
import org.springframework.data.repository.CrudRepository;

    public interface OrderRepository extends CrudRepository<Order, Long> { }

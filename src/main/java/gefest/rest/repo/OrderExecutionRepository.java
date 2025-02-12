package gefest.rest.repo;

import gefest.rest.domain.OrderExecution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderExecutionRepository extends JpaRepository<OrderExecution, Long> {
}

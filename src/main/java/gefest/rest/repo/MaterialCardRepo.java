package gefest.rest.repo;

import gefest.rest.domain.MaterialCard;
import org.springframework.data.repository.CrudRepository;

public interface MaterialCardRepo extends CrudRepository<MaterialCard, Long> {
    Iterable<MaterialCard> findByOrderId(long orderId);
}

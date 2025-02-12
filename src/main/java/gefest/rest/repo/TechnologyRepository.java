package gefest.rest.repo;

import gefest.rest.domain.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyRepository extends JpaRepository<Technology,Long> {
}

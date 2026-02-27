package gefest.rest.repo;

import gefest.rest.domain.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequirementRepository extends JpaRepository<Requirement, Long> { }

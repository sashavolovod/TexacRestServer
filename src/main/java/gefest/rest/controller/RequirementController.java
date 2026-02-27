package gefest.rest.controller;

import gefest.rest.domain.Employee;
import gefest.rest.domain.Requirement;
import gefest.rest.repo.RequirementRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/requirements")
public class RequirementController {

    final RequirementRepository requirementRepository;

    public RequirementController(RequirementRepository requirementRepository) {
        this.requirementRepository = requirementRepository;
    }

    @GetMapping
    public Iterable<Requirement> getList() {
        return requirementRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Requirement> getEntity(@PathVariable("id") long requirementId) {
        return requirementRepository.findById(requirementId);
    }
}

package gefest.rest.controller;

import gefest.rest.domain.Employee;
import gefest.rest.repo.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    final EmployeeRepository employeeRepo;

    public EmployeeController(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @GetMapping
    public Iterable<Employee> getList()
    {
        return employeeRepo.findAll();
    }

    @GetMapping("{id}")
    public Optional<Employee> getEntity(@PathVariable("id") long employeeId) {
        System.out.println(employeeId);
        return employeeRepo.findById(employeeId);
    }

    @PostMapping()
    public Employee addEmployee(@RequestBody Employee e) {
        return employeeRepo.save(e);
    }
}

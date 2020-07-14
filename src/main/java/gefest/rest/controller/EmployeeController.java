package gefest.rest.controller;

import gefest.rest.domain.Employee;
import gefest.rest.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    EmployeeRepo employeeRepo;

    @GetMapping
    public Iterable<gefest.rest.domain.Employee> getList()
    {
        return employeeRepo.findAll();
    }

    @GetMapping("{id}")
    public Optional<Employee> getEntity(@PathVariable("id") long employeeId) {
        return employeeRepo.findById(employeeId);
    }

    @PostMapping()
    public Employee addEmployee(@RequestBody Employee e) {
        return employeeRepo.save(e);
    }


}

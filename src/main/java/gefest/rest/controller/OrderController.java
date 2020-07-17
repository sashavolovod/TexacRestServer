package gefest.rest.controller;

import gefest.rest.domain.Order;
import gefest.rest.domain.User;
import gefest.rest.repo.OrderRepo;
import gefest.rest.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderRepo orderRepo;

    @GetMapping
    public Iterable<Order> getEntityList()
    {
        return orderRepo.findAll();
    }

    @GetMapping("{id}")
    public Optional<Order> getEntityById(@PathVariable("id") long orderId) {
        return orderRepo.findById(orderId);
    }

    @PostMapping()
    public Order saveEntity(@RequestBody Order o) {
        return orderRepo.save(o);  }

}

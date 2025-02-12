package gefest.rest.controller;

import gefest.rest.domain.Order;
import gefest.rest.repo.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api")
public class OrderController {
    final OrderRepository orderRepository;
    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


}

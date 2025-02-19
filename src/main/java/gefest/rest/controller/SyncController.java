package gefest.rest.controller;
import gefest.rest.domain.*;
import gefest.rest.repo.*;
import org.slf4j.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/sync")

public class SyncController {
    final OrderRepository orderRepository;
    final MaterialCardRepository materialCardRepository;
    final EmployeeRepository employeeRepository;
    final OrderExecutionRepository orderExecutionRepository;
    final TechnologyRepository technologyRepository;
    final CustomerRepository customerRepository;

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);


    public SyncController(OrderRepository orderRepository, MaterialCardRepository materialCardRepository, EmployeeRepository employeeRepository, OrderExecutionRepository orderExecutionRepository, TechnologyRepository technologyRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.materialCardRepository = materialCardRepository;
        this.employeeRepository = employeeRepository;
        this.orderExecutionRepository = orderExecutionRepository;
        this.technologyRepository = technologyRepository;
        this.customerRepository = customerRepository;
    }

    @PostMapping("/orders")
    public ResponseEntity<?> syncOrder(@RequestBody List<Order> orders) {
        try {
            if (orders == null || orders.isEmpty()) {
                return ResponseEntity.badRequest().body(new ApiError(LocalDateTime.now(), "Orders list is empty or null"));
            }

            log.info("Получено: {} записей", orders.size());
            Map<Long, Order> existingOrders = new HashMap<>();
            log.info("Начало загрузки существующих заказов");

            try {
                Iterable<Order> allOrders = orderRepository.findAll();
                for (Order o : allOrders) {
                    existingOrders.put(o.getOrderId(), o);
                }
            } catch (Exception e) {
                log.error("Ошибка при загрузке существующих заказов", e);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(new ApiError(LocalDateTime.now(), "Ошибка при работе с базой данной при загрузке существующих записей"));
            }

            log.info("Map готова");
            List<Order> forSaveOrders = new ArrayList<>();

            for (Order o : orders) {
                Order exOrder = existingOrders.get(o.getOrderId());
                if (exOrder == null || !o.toString().equals(exOrder.toString())) {
                    forSaveOrders.add(o);
                }
            }

            log.info("forSaveOrders List готова");

            try {
                orderRepository.saveAll(forSaveOrders);
                log.info("Обновлено: {} записей", forSaveOrders.size());
            } catch (Exception e) {
                log.error("Ошибка при сохранении заказов", e);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(new ApiError(LocalDateTime.now(), "Database error while saving orders"));
            }

            return ResponseEntity.ok(new ApiResponse(LocalDateTime.now(),
                    String.format("Успешно синхронизировано %d записей", forSaveOrders.size())));

        } catch (Exception e) {
            log.error("Необработанная ошибка при синхронизации заказов", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiError(LocalDateTime.now(), "Произошла неизвестная ошибка при синхронизации"));
        }
    }

    @PostMapping("/meterial_cards")
    public ResponseEntity<?> syncMaterialCard(@RequestBody List<MaterialCard> materialCards) {
        try {
            if (materialCards == null || materialCards.isEmpty()) {
                return ResponseEntity.badRequest().body(new ApiError(LocalDateTime.now(), "Список значений пуст или не существует"));
            }

            log.info("Получено: {} записей", materialCards.size());
            System.out.println(materialCards.get(0).toString());

            Map<Long, MaterialCard> existingItems = new HashMap<>();
            log.info("Начало загрузки существующих записей");

            try {
                Iterable<MaterialCard> allItems = materialCardRepository.findAll();
                for (MaterialCard item : allItems) {
                    existingItems.put(item.getMaterialCardId(), item);
                }
            } catch (Exception e) {
                log.error("Ошибка при загрузке существующих записей", e);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(new ApiError(LocalDateTime.now(), "Ошибка при работе с базой данной при загрузке существующих записей"));
            }

            log.info("Map готова");
            List<MaterialCard> forSaveItems = new ArrayList<>();

            for (MaterialCard item : materialCards) {
                MaterialCard exItem = existingItems.get(item.getMaterialCardId());
                if (exItem == null || !item.toString().equals(exItem.toString())) {
                    forSaveItems.add(item);
                }
            }

            log.info("forSaveItems List готова");

            try {
                materialCardRepository.saveAll(forSaveItems);
                log.info("Обновлено: {} записей", forSaveItems.size());
            } catch (Exception e) {
                log.error("Ошибка при сохранении заказов", e);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(new ApiError(LocalDateTime.now(), "Database error while saving orders"));
            }

            return ResponseEntity.ok(new ApiResponse(LocalDateTime.now(),
                    String.format("Успешно синхронизировано %d записей", forSaveItems.size())));

        } catch (Exception e) {
            log.error("Необработанная ошибка при синхронизации заказов", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiError(LocalDateTime.now(), "Произошла неизвестная ошибка при синхронизации"));
        }
    }
    @PostMapping("/employees")
    public ResponseEntity<?> syncEmployees(@RequestBody List<Employee> employees) {
        try {
            if (employees == null || employees.isEmpty()) {
                return ResponseEntity.badRequest()
                        .body(new ApiError(LocalDateTime.now(), "Employees list is empty or null"));
            }
            log.info("Получено: {} записей", employees.size());

            Map<Long, Employee> existingEmployees = new HashMap<>();
            log.info("Начало загрузки существующих сотрудников");

            try {
                Iterable<Employee> allEmployees = employeeRepository.findAll();
                for (Employee e : allEmployees) {
                    existingEmployees.put(e.getEmployeeId(), e);
                }
            } catch (Exception e) {
                log.error("Ошибка при загрузке существующих сотрудников", e);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(new ApiError(LocalDateTime.now(),
                                "Ошибка при работе с базой данных при загрузке существующих записей"));
            }
            log.info("Map готова");

            List<Employee> forSaveEmployees = new ArrayList<>();
            for (Employee e : employees) {
                Employee existingEmployee = existingEmployees.get(e.getEmployeeId());
                if (existingEmployee == null || !e.toString().equals(existingEmployee.toString())) {
                    forSaveEmployees.add(e);
                }
            }
            log.info("forSaveEmployees List готова");

            try {
                employeeRepository.saveAll(forSaveEmployees);
                log.info("Обновлено: {} записей", forSaveEmployees.size());
            } catch (Exception e) {
                log.error("Ошибка при сохранении сотрудников", e);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(new ApiError(LocalDateTime.now(), "Database error while saving employees"));
            }

            return ResponseEntity.ok(new ApiResponse(LocalDateTime.now(),
                    String.format("Успешно синхронизировано %d записей", forSaveEmployees.size())));

        } catch (Exception e) {
            log.error("Необработанная ошибка при синхронизации сотрудников", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiError(LocalDateTime.now(),
                            "Произошла неизвестная ошибка при синхронизации"));
        }
    }

    @PostMapping("/order_executions")
    public ResponseEntity<?> syncOrderExecutions(@RequestBody List<OrderExecution> orderExecutions) {
        try {
            if (orderExecutions == null || orderExecutions.isEmpty()) {
                return ResponseEntity.badRequest()
                        .body(new ApiError(LocalDateTime.now(), "Order executions list is empty or null"));
            }
            log.info("Получено: {} записей", orderExecutions.size());
            Map<Long, OrderExecution> existingOrderExecutions = new HashMap<>();
            log.info("Начало загрузки существующих записей выполнения заказов");
            try {
                Iterable<OrderExecution> allOrderExecutions = orderExecutionRepository.findAll();
                for (OrderExecution oe : allOrderExecutions) {
                    existingOrderExecutions.put(oe.getOrderExecutionId(), oe);
                }
            } catch (Exception e) {
                log.error("Ошибка при загрузке существующих записей выполнения заказов", e);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(new ApiError(LocalDateTime.now(),
                                "Ошибка при работе с базой данных при загрузке существующих записей"));
            }
            log.info("Map готова");
            List<OrderExecution> forSaveOrderExecutions = new ArrayList<>();
            for (OrderExecution oe : orderExecutions) {
                OrderExecution existingOrderExecution = existingOrderExecutions.get(oe.getOrderExecutionId());
                if (existingOrderExecution == null || !oe.toString().equals(existingOrderExecution.toString())) {
                    forSaveOrderExecutions.add(oe);
                }
            }
            log.info("forSaveOrderExecutions List готова");
            try {
                orderExecutionRepository.saveAll(forSaveOrderExecutions);
                log.info("Обновлено: {} записей", forSaveOrderExecutions.size());
            } catch (Exception e) {
                log.error("Ошибка при сохранении записей выполнения заказов", e);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(new ApiError(LocalDateTime.now(), "Database error while saving order executions"));
            }
            return ResponseEntity.ok(new ApiResponse(LocalDateTime.now(),
                    String.format("Успешно синхронизировано %d записей", forSaveOrderExecutions.size())));
        } catch (Exception e) {
            log.error("Необработанная ошибка при синхронизации записей выполнения заказов", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiError(LocalDateTime.now(),
                            "Произошла неизвестная ошибка при синхронизации"));
        }
    }

    @PostMapping("/technologies")
    public ResponseEntity<?> syncTechnologies(@RequestBody List<Technology> technologies) {
        try {
            if (technologies == null || technologies.isEmpty()) {
                return ResponseEntity.badRequest()
                        .body(new ApiError(LocalDateTime.now(), "Technologies list is empty or null"));
            }
            log.info("Получено: {} записей", technologies.size());

            Map<Long, Technology> existingTechnologies = new HashMap<>();
            log.info("Начало загрузки существующих записей технологий");
            try {
                Iterable<Technology> allTechnologies = technologyRepository.findAll();
                for (Technology tech : allTechnologies) {
                    existingTechnologies.put(tech.getTechnologyId(), tech);
                }
            } catch (Exception e) {
                log.error("Ошибка при загрузке существующих записей технологий", e);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(new ApiError(LocalDateTime.now(),
                                "Ошибка при работе с базой данных при загрузке существующих записей"));
            }
            log.info("Map готова");

            List<Technology> forSaveTechnologies = new ArrayList<>();
            for (Technology tech : technologies) {
                Technology existingTechnology = existingTechnologies.get(tech.getTechnologyId());
                if (existingTechnology == null || !tech.toString().equals(existingTechnology.toString())) {
                    forSaveTechnologies.add(tech);
                }
            }
            log.info("forSaveTechnologies List готова");

            try {
                technologyRepository.saveAll(forSaveTechnologies);
                log.info("Обновлено: {} записей", forSaveTechnologies.size());
            } catch (Exception e) {
                log.error("Ошибка при сохранении записей технологий", e);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(new ApiError(LocalDateTime.now(), "Database error while saving technologies"));
            }

            return ResponseEntity.ok(new ApiResponse(LocalDateTime.now(),
                    String.format("Успешно синхронизировано %d записей", forSaveTechnologies.size())));
        } catch (Exception e) {
            log.error("Необработанная ошибка при синхронизации записей технологий", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiError(LocalDateTime.now(),
                            "Произошла неизвестная ошибка при синхронизации"));
        }
    }

    @PostMapping("/customers")
    public ResponseEntity<?> syncCustomers(@RequestBody List<Customer> customers) {
        try {
            if (customers == null || customers.isEmpty()) {
                return ResponseEntity.badRequest()
                        .body(new ApiError(LocalDateTime.now(), "Customers list is empty or null"));
            }
            log.info("Получено: {} записей", customers.size());
            Map<Long, Customer> existingCustomers = new HashMap<>();
            log.info("Начало загрузки существующих записей заказчиков");
            try {
                Iterable<Customer> allCustomers = customerRepository.findAll();
                for (Customer customer : allCustomers) {
                    existingCustomers.put(customer.getCustomerId(), customer);
                }
            } catch (Exception e) {
                log.error("Ошибка при загрузке существующих записей заказчиков", e);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(new ApiError(LocalDateTime.now(),
                                "Ошибка при работе с базой данных при загрузке существующих записей"));
            }
            log.info("Map готова");
            List<Customer> forSaveCustomers = new ArrayList<>();
            for (Customer customer : customers) {
                Customer existingCustomer = existingCustomers.get(customer.getCustomerId());
                if (existingCustomer == null || !customer.toString().equals(existingCustomer.toString())) {
                    forSaveCustomers.add(customer);
                }
            }
            log.info("forSaveCustomers List готова");
            try {
                customerRepository.saveAll(forSaveCustomers);
                log.info("Обновлено: {} записей", forSaveCustomers.size());
            } catch (Exception e) {
                log.error("Ошибка при сохранении записей заказчиков", e);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(new ApiError(LocalDateTime.now(), "Database error while saving customers"));
            }
            return ResponseEntity.ok(new ApiResponse(LocalDateTime.now(),
                    String.format("Успешно синхронизировано %d записей", forSaveCustomers.size())));
        } catch (Exception e) {
            log.error("Необработанная ошибка при синхронизации записей заказчиков", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiError(LocalDateTime.now(),
                            "Произошла неизвестная ошибка при синхронизации"));
        }
    }

}

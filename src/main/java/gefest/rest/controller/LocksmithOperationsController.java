package gefest.rest.controller;

import gefest.rest.repo.LocksmithOperationViewRepository;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.slf4j.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import gefest.rest.domain.LocksmithOperationView;
@RestController
@RequestMapping("/api/locksmith-operations")
public class LocksmithOperationsController {

    private final LocksmithOperationViewRepository locksmithRepository;
    private final Logger log = LoggerFactory.getLogger(LocksmithOperationsController.class);

    public LocksmithOperationsController(LocksmithOperationViewRepository locksmithRepository) {
        this.locksmithRepository = locksmithRepository;
    }

    /**
     * Получить суммарную норму времени по категориям за указанный период
     */
    @GetMapping("/by-category")
    public ResponseEntity<?> getTimeNormByCategories(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        try {
            log.info("Запрос данных по категориям за период с {} по {}", startDate, endDate);
            List<LocksmithOperationView> result = locksmithRepository.getSumTimeNormByCategories(startDate, endDate);

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            log.error("Ошибка при получении данных по категориям", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiError(LocalDateTime.now(), "Ошибка при получении данных: " + e.getMessage()));
        }
    }

    /**
     * Получить суммарную норму времени по категориям и слесарям за указанный период
     */
    @GetMapping("/by-category-and-locksmith")
    public ResponseEntity<?> getTimeNormByCategoriesAndLocksmiths(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        try {
            log.info("Запрос данных по категориям и слесарям за период с {} по {}", startDate, endDate);
            List<LocksmithOperationView> result =
                    locksmithRepository.getSumTimeNormByCategoriesAndLocksmiths(startDate, endDate);

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            log.error("Ошибка при получении данных по категориям и слесарям", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiError(LocalDateTime.now(), "Ошибка при получении данных: " + e.getMessage()));
        }
    }

    /**
     * Получить суммарную норму времени по категориям и заказчикам за указанный период
     */
    @GetMapping("/by-category-and-customer")
    public ResponseEntity<?> getTimeNormByCategoriesAndCustomers(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        try {
            log.info("Запрос данных по категориям и заказчикам за период с {} по {}", startDate, endDate);
            List<LocksmithOperationView> result =
                    locksmithRepository.getSumTimeNormByCategoriesAndCustomers(startDate, endDate);

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            log.error("Ошибка при получении данных по категориям и заказчикам", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiError(LocalDateTime.now(), "Ошибка при получении данных: " + e.getMessage()));
        }
    }

    /**
     * Получить все отчеты за указанный период в одном запросе
     */
    @GetMapping("/reports")
    public ResponseEntity<?> getAllReports(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        try {
            log.info("Запрос всех отчетов за период с {} по {}", startDate, endDate);

            Map<String, Object> reports = new HashMap<>();

            reports.put("byCategory", locksmithRepository.getSumTimeNormByCategories(startDate, endDate));
            reports.put("byCategoryAndLocksmith",
                    locksmithRepository.getSumTimeNormByCategoriesAndLocksmiths(startDate, endDate));
            reports.put("byCategoryAndCustomer",
                    locksmithRepository.getSumTimeNormByCategoriesAndCustomers(startDate, endDate));

            return ResponseEntity.ok(reports);
        } catch (Exception e) {
            log.error("Ошибка при получении отчетов", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiError(LocalDateTime.now(), "Ошибка при получении отчетов: " + e.getMessage()));
        }
    }
}
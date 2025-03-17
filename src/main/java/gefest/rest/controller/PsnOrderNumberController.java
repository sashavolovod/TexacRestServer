package gefest.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/psn-order-number")
public class PsnOrderNumberController {
    private final JdbcTemplate jdbcTemplate;
    private static final Logger log = LoggerFactory.getLogger(PsnOrderNumberController.class);

    public PsnOrderNumberController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public Integer getNextOrderNumber() {
        int orderNumber = jdbcTemplate.queryForObject("SELECT nextval('psn_order_number_seq')", Integer.class);
        log.info("Сформирован номер документа: " + orderNumber);
        return orderNumber;
    }

    @PostMapping("/reset")
    public void resetSequence() {
        jdbcTemplate.execute("ALTER SEQUENCE psn_order_number_seq RESTART WITH 1");

    }

    @PostMapping("/start-value/{value}")
    public void setStartValue(@PathVariable Integer startValue) {
        if (startValue <= 0) {
            throw new IllegalArgumentException("Start value must be positive");
        }
        jdbcTemplate.execute(
                String.format("ALTER SEQUENCE psn_order_number_seq RESTART WITH %d", startValue)
        );
    }
}

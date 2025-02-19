package gefest.rest.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Immutable;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Immutable
@Table(name = "locksmith_operations_view")
public class LocksmithOperationView {
    @Id
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "oboz_to")
    private String obozTo;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "locksmith_name")
    private String locksmithName;

    @Column(name = "customer_title")
    private String customerTitle;

    @Column(name = "time_norm")
    private Double timeNorm;

    // Конструктор без параметров для JPA
    public LocksmithOperationView() {
    }

    // Конструктор для запроса с группировкой
    public LocksmithOperationView(Long orderId, LocalDate orderDate, String obozTo,
                                   String categoryName, String locksmithName,
                                   String customerTitle, Double timeNorm) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.obozTo = obozTo;
        this.categoryName = categoryName;
        this.locksmithName = locksmithName;
        this.customerTitle = customerTitle;
        this.timeNorm = timeNorm;
    }
    public LocksmithOperationView(String categoryName, Double timeNorm) {
        this.categoryName = categoryName;
        this.timeNorm = timeNorm;
    }

    public LocksmithOperationView(String categoryName, String locksmithName, Double timeNorm) {
        this.categoryName = categoryName;
        this.locksmithName = locksmithName;
        this.timeNorm = timeNorm;
    }
    public LocksmithOperationView(String categoryName, Double timeNorm, String customerTitle) {
        this.categoryName = categoryName;
        this.customerTitle = customerTitle;
        this.timeNorm = timeNorm;
    }


}

package gefest.rest.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {

    @Id
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "customer_title", length = 100)
    private String customerTitle;

    @Column(name = "customer_short_title", length = 15)
    private String customerShortTitle;

    @Column(name = "manager_name", length = 50)
    private String managerName;

    @Override
    @JsonIgnore
    public Long getId() {
        return customerId;
    }
}

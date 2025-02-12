package gefest.rest.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "psn_entity")
public class Psn extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "psn_seq_gen")
    @SequenceGenerator(name = "psn_seq_gen", sequenceName = "psn_entity_psn_entity_id_seq", allocationSize = 1)
    private Long psnEntityId;
    private String docNumber;
    private LocalDateTime docDate;
    private int orderId;
    private String orderNumber;
    private String orderDescription;
    private String customer;
    private int qty;
    private String unitName;
    private String computerName;

    @Override
    @JsonIgnore
    public Long getId() {
        return psnEntityId;
    }

    public Psn() {    }

    public Psn(String docNumber, LocalDateTime docDate, int orderId, String orderNumber, String orderDescription, String customer, int qty, String unitName, String computerName) {
        this.docNumber = docNumber;
        this.docDate = docDate;
        this.orderId = orderId;
        this.orderNumber = orderNumber;
        this.orderDescription = orderDescription;
        this.customer = customer;
        this.qty = qty;
        this.unitName = unitName;
        this.computerName = computerName;
    }

    public Psn(String docNumber, String orderNumber) {
        this.docNumber = docNumber;
        this.orderNumber = orderNumber;
    }
}

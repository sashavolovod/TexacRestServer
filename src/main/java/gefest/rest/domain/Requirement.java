package gefest.rest.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Table(name = "requirements")
public class Requirement extends BaseEntity{
    @Id
    @Column(name = "requirement_id")
    private Long requirementId;

    @Column(name = "doc_number")
    private Long docNumber;

    @Column(name = "doc_date")
    private LocalDateTime docDate;

    @Column(name = "warehouse_id")
    private Long warehouseId;

    @Column(name = "workshop_number")
    private Long workshopNumber;

    @Column(name = "status")
    private Integer status;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "order_number", length = 20)
    private String orderNumber;

    @Column(name = "cost_code", length = 16)
    private String costCode;

    @Column(name = "recipient", length = 50)
    private String recipient;

    @Column(name = "recipient_position", length = 30)
    private String recipientPosition;

    @Column(name = "customer", length = 50)
    private String customer;

    @Column(name = "customer_position", length = 30)
    private String customerPosition;

    @Column(name = "basis", length = 255)
    private String basis;

    @Column(name = "workshop_code", length = 30)
    private String workshopCode;

    @Column(name = "pdo_date")
    private LocalDateTime pdoDate;

    @Column(name = "description", length = 100)
    private String description;

    @OneToMany(mappedBy = "requirement", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<RequirementDetail> details = new ArrayList<>();

    @Override
    @JsonIgnore
    public Long getId() {
        return requirementId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Requirement that = (Requirement) o;
        return Objects.equals(requirementId, that.requirementId) && Objects.equals(docNumber, that.docNumber) && Objects.equals(docDate, that.docDate) && Objects.equals(warehouseId, that.warehouseId) && Objects.equals(workshopNumber, that.workshopNumber) && Objects.equals(status, that.status) && Objects.equals(orderId, that.orderId) && Objects.equals(orderNumber, that.orderNumber) && Objects.equals(costCode, that.costCode) && Objects.equals(recipient, that.recipient) && Objects.equals(recipientPosition, that.recipientPosition) && Objects.equals(customer, that.customer) && Objects.equals(customerPosition, that.customerPosition) && Objects.equals(basis, that.basis) && Objects.equals(workshopCode, that.workshopCode) && Objects.equals(pdoDate, that.pdoDate) && Objects.equals(description, that.description) && Objects.equals(details, that.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), requirementId, docNumber, docDate, warehouseId, workshopNumber, status, orderId, orderNumber, costCode, recipient, recipientPosition, customer, customerPosition, basis, workshopCode, pdoDate, description, details);
    }

}
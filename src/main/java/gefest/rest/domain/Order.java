package gefest.rest.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Entity
@Data
@Table(name = "orders")
public class Order extends BaseEntity {
    @Id
    private Long orderId;
    private String orderNumber;
    private String orderFullNumber;
    private Long graphId;
    private Long graphTypeId;
    private Long reasonOrder;
    private LocalDate orderDate;
    private String obozTo;
    private Long kodTo;
    private String itemNo;
    private String detailNo;
    private Integer qty;
    private Integer realQty;
    private Long customerId;
    private LocalDate planDate;
    private Long priorityId;
    private LocalDate planTechDate;
    private LocalDate techDate;
    private LocalDate shopDate;
    private LocalDate factReadyDate;
    private double planNv;
    private Long performerShop;
    private Boolean includeInReport;
    private LocalDate reportDate;
    private Long technologistId;
    private Long locksmithId;
    private String orderNote;
    private double factNv;
    private String consignmentNote;
    private String actNumber;
    private String destStore;
    private Boolean anotherTimeReady;
    private Long designerId;
    private Long unitTypeId;
    private Boolean stopped;
    private Long orderCard;
    private Integer serviceLifeYear;
    private Integer serviceLifeDay;
    private Long objectType;
    private Boolean urgent;
    private LocalDate materialDate;
    private Boolean spare;
    private Integer resistance;
    private Boolean additionalOrder;
    private String classifier;
    private LocalDate priceDate;
    private LocalDateTime peoDate;
    private LocalDateTime otizDate;
    private Integer weight;
    private String customerMaterial;
    private Boolean reconstruction;

    @Override
    @JsonIgnore
    public Long getId() {
        return orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Order order = (Order) o;
        return Double.compare(planNv, order.planNv) == 0 && Double.compare(factNv, order.factNv) == 0 && Objects.equals(orderId, order.orderId) && Objects.equals(orderNumber, order.orderNumber) && Objects.equals(orderFullNumber, order.orderFullNumber) && Objects.equals(graphId, order.graphId) && Objects.equals(graphTypeId, order.graphTypeId) && Objects.equals(reasonOrder, order.reasonOrder) && Objects.equals(orderDate, order.orderDate) && Objects.equals(obozTo, order.obozTo) && Objects.equals(kodTo, order.kodTo) && Objects.equals(itemNo, order.itemNo) && Objects.equals(detailNo, order.detailNo) && Objects.equals(qty, order.qty) && Objects.equals(realQty, order.realQty) && Objects.equals(customerId, order.customerId) && Objects.equals(planDate, order.planDate) && Objects.equals(priorityId, order.priorityId) && Objects.equals(planTechDate, order.planTechDate) && Objects.equals(techDate, order.techDate) && Objects.equals(shopDate, order.shopDate) && Objects.equals(factReadyDate, order.factReadyDate) && Objects.equals(performerShop, order.performerShop) && Objects.equals(includeInReport, order.includeInReport) && Objects.equals(reportDate, order.reportDate) && Objects.equals(technologistId, order.technologistId) && Objects.equals(locksmithId, order.locksmithId) && Objects.equals(orderNote, order.orderNote) && Objects.equals(consignmentNote, order.consignmentNote) && Objects.equals(actNumber, order.actNumber) && Objects.equals(destStore, order.destStore) && Objects.equals(anotherTimeReady, order.anotherTimeReady) && Objects.equals(designerId, order.designerId) && Objects.equals(unitTypeId, order.unitTypeId) && Objects.equals(stopped, order.stopped) && Objects.equals(orderCard, order.orderCard) && Objects.equals(serviceLifeYear, order.serviceLifeYear) && Objects.equals(serviceLifeDay, order.serviceLifeDay) && Objects.equals(objectType, order.objectType) && Objects.equals(urgent, order.urgent) && Objects.equals(materialDate, order.materialDate) && Objects.equals(spare, order.spare) && Objects.equals(resistance, order.resistance) && Objects.equals(additionalOrder, order.additionalOrder) && Objects.equals(classifier, order.classifier) && Objects.equals(priceDate, order.priceDate) && Objects.equals(peoDate, order.peoDate) && Objects.equals(otizDate, order.otizDate) && Objects.equals(weight, order.weight) && Objects.equals(customerMaterial, order.customerMaterial) && Objects.equals(reconstruction, order.reconstruction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), orderId, orderNumber, orderFullNumber, graphId, graphTypeId, reasonOrder, orderDate, obozTo, kodTo, itemNo, detailNo, qty, realQty, customerId, planDate, priorityId, planTechDate, techDate, shopDate, factReadyDate, planNv, performerShop, includeInReport, reportDate, technologistId, locksmithId, orderNote, factNv, consignmentNote, actNumber, destStore, anotherTimeReady, designerId, unitTypeId, stopped, orderCard, serviceLifeYear, serviceLifeDay, objectType, urgent, materialDate, spare, resistance, additionalOrder, classifier, priceDate, peoDate, otizDate, weight, customerMaterial, reconstruction);
    }
}

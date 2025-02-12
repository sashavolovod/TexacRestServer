package gefest.rest.domain;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "material_cards")
public class MaterialCard extends BaseEntity {
    @Id
    private Long materialCardId;

    @Column(name = "order_number")
    private Integer orderNumber;

    @Column(name = "detail_number")
    private Integer detailNumber;

    @Column(name = "tooling_detail_number", nullable = false, length = 32)
    private String toolingDetailNumber;

    @Column(name = "detail_name", length = 64)
    private String detailName;

    @Column(length = 100)
    private String material;

    @Column(name = "forging_operation", length = 30)
    private String forgingOperation;

    @Column(name = "detail_dimensions", length = 20)
    private String detailDimensions;

    @Column(nullable = false)
    private Float quantity;

    @Column(name = "details_quantity", nullable = false)
    private Float detailsQuantity;

    @Column(name = "milling_processing", length = 15)
    private String millingProcessing;

    @Column(name = "planing_processing", length = 30)
    private String planingProcessing;

    @Column(name = "grinding_processing", length = 50)
    private String grindingProcessing;

    @Column(name = "milling_time")
    private Float millingTime;

    @Column(name = "planing_time")
    private Float planingTime;

    @Column(name = "grinding_time")
    private Float grindingTime;

    @Column(name = "blank_weight")
    private Float blankWeight;

    @Column(name = "total_weight")
    private Float totalWeight;

    @Column(name = "additional_for_work_order")
    private Boolean additionalForWorkOrder;

    @Column(name = "tech_edit_date")
    private LocalDateTime techEditDate;

    private Integer warehouse;

    @Column(name = "unit_code")
    private Integer unitCode;

    @Column(name = "material_code")
    private Integer materialCode;

    private Boolean annealing;

    private String term;

    @Column(name = "planing_term", length = 50)
    private String planingTerm;

    @Column(name = "detail_weight")
    private Double detailWeight;

    private Boolean ordered;

    @Column(length = 100)
    private String material2;

    @Column(name = "card_num")
    private Integer cardNum;
}
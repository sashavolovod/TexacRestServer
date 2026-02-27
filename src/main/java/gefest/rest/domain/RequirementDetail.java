package gefest.rest.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
@Table(name = "requirement_details")
public class RequirementDetail extends BaseEntity{
    @Id
    @Column(name = "requirement_detail_id")
    private Long requirementDetailId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "requirement_id", nullable = false)
    @JsonIgnore
    private Requirement requirement;
    public void setRequirement(Requirement requirement) {
        this.requirement = requirement;
    }

    @Column(name = "material_card_id")
    private Long materialCardId;

    @Column(name = "material_code")
    private Long materialCode;

    @Column(name = "material", length = 128)
    private String material;

    @Column(name = "unit", length = 10)
    private String unit;

    @Column(name = "quantity1")
    private Double quantity1;

    @Column(name = "quantity2")
    private Double quantity2;

    @Column(name = "asup_code")
    private Long asupCode;

    @Column(name = "order_id")
    private Long orderId;

    @Override
    @JsonIgnore
    public Long getId() {
        return requirementDetailId;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RequirementDetail that = (RequirementDetail) o;
        return Objects.equals(requirementDetailId, that.requirementDetailId) && Objects.equals(requirement, that.requirement) && Objects.equals(materialCardId, that.materialCardId) && Objects.equals(materialCode, that.materialCode) && Objects.equals(material, that.material) && Objects.equals(unit, that.unit) && Objects.equals(quantity1, that.quantity1) && Objects.equals(quantity2, that.quantity2) && Objects.equals(asupCode, that.asupCode) && Objects.equals(orderId, that.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), requirementDetailId, requirement, materialCardId, materialCode, material, unit, quantity1, quantity2, asupCode, orderId);
    }
}

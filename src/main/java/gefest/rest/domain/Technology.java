package gefest.rest.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "technologies")
public class Technology extends BaseEntity {

    @Id
    @Column(name = "technology_id", nullable = false)
    private Long technologyId;

    @Column(name = "order_id", nullable = false)
    private Integer orderId;

    @Column(name = "detail_number", nullable = false)
    private Integer detailNumber;

    @Column(name = "operation_number", nullable = false)
    private Integer operationNumber;

    @Column(name = "operation", length = 21, nullable = false)
    private String operation;

    @Column(name = "operation_content")
    private String operationContent;

    @Column(name = "time_norm")
    private Float timeNorm;

    @Column(name = "need_program")
    private Boolean needProgram;

    @Column(name = "optic_program")
    private Boolean opticProgram;

    @Column(name = "optic_program_date")
    private LocalDateTime opticProgramDate;

    @Override
    @JsonIgnore
    public Long getId() {
        return technologyId;
    }
}
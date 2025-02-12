package gefest.rest.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "order_execution")
public class OrderExecution extends BaseEntity{
    @Id
    @Column(name = "order_execution_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_execution_seq_gen")
    @SequenceGenerator(name = "order_execution_seq_gen", sequenceName = "order_execution_order_execution_id_seq", allocationSize = 1)
    private Long orderExecutionId;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "detail_number")
    private Integer detailNumber;

    @Column(name = "batch", nullable = false)
    private Integer batch;

    @Column(name = "operation_number", nullable = false)
    private Integer operationNumber;

    @Column(name = "part", nullable = false)
    private Integer part;

    @Column(name = "operation", length = 21, nullable = false)
    private String operation;

    @Column(name = "operation_content")
    private String operationContent;

    @Column(name = "time_norm")
    private Float timeNorm;

    @Column(name = "executor", length = 50)
    private String executor;

    @Column(name = "machine_coefficient")
    private Boolean machineCoefficient;

    @Column(name = "initial_quantity")
    private Float initialQuantity;

    @Column(name = "work_start_date")
    private LocalDateTime workStartDate;

    @Column(name = "final_quantity")
    private Float finalQuantity;

    @Column(name = "work_end_date")
    private LocalDateTime workEndDate;

    @Column(name = "first_shift")
    private Integer firstShift;

    @Column(name = "second_shift")
    private Integer secondShift;

    @Column(name = "midnight_shift")
    private Integer midnightShift;

    @Column(name = "note", length = 200)
    private String note;

    @Column(name = "log")
    private String log;

    @Column(name = "prog_start")
    private LocalDateTime progStart;

    @Column(name = "prog_end")
    private LocalDateTime progEnd;

    @Column(name = "programmer", length = 50)
    private String programmer;

    @Column(name = "submitted_to_qc")
    private LocalDateTime submittedToQc;

    @Column(name = "urgent_qc")
    private Boolean urgentQc;

    @Column(name = "prog_type")
    private Integer progType;

    @Column(name = "erosion_type")
    private Boolean erosionType;

    @Column(name = "prog_time")
    private LocalDateTime progTime;

    @Override
    @JsonIgnore
    public Long getId() {
        return orderExecutionId;
    }
}

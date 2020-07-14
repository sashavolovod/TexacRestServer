package gefest.rest.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detail_seq_gen")
    @SequenceGenerator(name = "detail_seq_gen", sequenceName = "detail_id_seq", allocationSize=1)
    private Long detailId;
    private String title;
    private Double amount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="master_id", nullable = false)
    @JsonIgnore
    private Master master;

    public Detail() {   }

    public Detail(String title, Double amount, Master master) {
        this.title = title;
        this.amount = amount;
        this.master = master;
    }

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Master getMaster() {
        return master;
    }

    public Long getMasterId() {
        return master == null ? null : master.getMasterId();
    }

    public void setMaster(Master master) {
        this.master = master;
    }
}

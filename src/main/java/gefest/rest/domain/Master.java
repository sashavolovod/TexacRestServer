package gefest.rest.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Master {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "master_seq_gen")
    @SequenceGenerator(name = "master_seq_gen", sequenceName = "master_id_seq", allocationSize=1)
    private Long masterId;
    private String caption;

    @OneToMany(mappedBy = "master", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Detail> details = new ArrayList<>();

    public Long getMasterId() {
        return masterId;
    }

    public void setMasterId(Long masterId) {
        this.masterId = masterId;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }

    public void addDetail(Detail d)
    {
        d.setMaster(this);
        details.add(d);
    }
}

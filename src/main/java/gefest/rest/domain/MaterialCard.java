package gefest.rest.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mat_card")
public class MaterialCard {

    @Id
    private long matCardId;

    private long orderId;


    private int detailNumber;

    @Column(length = 32)
    private String detailTONumber;

    @Column(length = 64)
    private String detailTOTitle;

    @Column(length = 128)
    private String materialTitle;


    @Column(length = 32)
    private String blackSmithOp; // кузнечная операция

    @Column(length = 32)
    private String detailSize;

    @Column(nullable = false)
    private double blankQty;

    @Column(nullable = false)
    private double detailQty;

    @Column(length = 32)
    private String millingOp;     // фрезерная обработка

    @Column(length = 32)
    private String planerOp;      // строгальная обработка

    @Column(length = 32)
    private String grindingOp;    // шлифовальная обработка

    private double millingTime;   // время фрезерной обработки
    private double planerTime;    // время строгальной обработки
    private double grindingTime;  // время шлифовальной обработки

    private double wight;         // вес одной заготовки
    private double wightTotal;    // вес всего ++



    /*
    DopolnDlyaZakNar boolean, DataRedaktTehn timestamp, Sklad integer, KodEdIzm integer, CODEMAT integer, annealing boolean, term varchar(50), strogterm varchar(50), VesDetali real, ordered boolean, Materia varchar(100));


     */

}

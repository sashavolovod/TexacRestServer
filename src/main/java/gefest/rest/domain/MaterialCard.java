package gefest.rest.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mat_card", indexes = { @Index(name = "idx_order_id", columnList = "orderId")})
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
    private String materialTitle;// название материала

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

    private double wight;         // масса одной заготовки
    private double wightTotal;    // общая масса

    private boolean supplementToOrder;  // дополнение для заказ-наряда

    private Date technologyEditTime;    // дата изменения технологии

    private int storeId;                // склад

    private long unitOfMeasureId;  // код единицы измерения

    private int materialCode;

    private boolean annealing;

    @Column(length = 64)
    private  String thermalOp;

    @Column(length = 64)
    private String planerThermalOp;

    private double detailWeight;

    private boolean ordered;

    public MaterialCard() {   }

    public long getMatCardId() {
        return matCardId;
    }

    public void setMatCardId(long matCardId) {
        this.matCardId = matCardId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public int getDetailNumber() {
        return detailNumber;
    }

    public void setDetailNumber(int detailNumber) {
        this.detailNumber = detailNumber;
    }

    public String getDetailTONumber() {
        return detailTONumber;
    }

    public void setDetailTONumber(String detailTONumber) {
        this.detailTONumber = detailTONumber;
    }

    public String getDetailTOTitle() {
        return detailTOTitle;
    }

    public void setDetailTOTitle(String detailTOTitle) {
        this.detailTOTitle = detailTOTitle;
    }

    public String getMaterialTitle() {
        return materialTitle;
    }

    public void setMaterialTitle(String materialTitle) {
        this.materialTitle = materialTitle;
    }

    public String getBlackSmithOp() {
        return blackSmithOp;
    }

    public void setBlackSmithOp(String blackSmithOp) {
        this.blackSmithOp = blackSmithOp;
    }

    public String getDetailSize() {
        return detailSize;
    }

    public void setDetailSize(String detailSize) {
        this.detailSize = detailSize;
    }

    public double getBlankQty() {
        return blankQty;
    }

    public void setBlankQty(double blankQty) {
        this.blankQty = blankQty;
    }

    public double getDetailQty() {
        return detailQty;
    }

    public void setDetailQty(double detailQty) {
        this.detailQty = detailQty;
    }

    public String getMillingOp() {
        return millingOp;
    }

    public void setMillingOp(String millingOp) {
        this.millingOp = millingOp;
    }

    public String getPlanerOp() {
        return planerOp;
    }

    public void setPlanerOp(String planerOp) {
        this.planerOp = planerOp;
    }

    public String getGrindingOp() {
        return grindingOp;
    }

    public void setGrindingOp(String grindingOp) {
        this.grindingOp = grindingOp;
    }

    public double getMillingTime() {
        return millingTime;
    }

    public void setMillingTime(double millingTime) {
        this.millingTime = millingTime;
    }

    public double getPlanerTime() {
        return planerTime;
    }

    public void setPlanerTime(double planerTime) {
        this.planerTime = planerTime;
    }

    public double getGrindingTime() {
        return grindingTime;
    }

    public void setGrindingTime(double grindingTime) {
        this.grindingTime = grindingTime;
    }

    public double getWight() {
        return wight;
    }

    public void setWight(double wight) {
        this.wight = wight;
    }

    public double getWightTotal() {
        return wightTotal;
    }

    public void setWightTotal(double wightTotal) {
        this.wightTotal = wightTotal;
    }

    public boolean isSupplementToOrder() {
        return supplementToOrder;
    }

    public void setSupplementToOrder(boolean supplementToOrder) {
        this.supplementToOrder = supplementToOrder;
    }

    public Date getTechnologyEditTime() {
        return technologyEditTime;
    }

    public void setTechnologyEditTime(Date technologyEditTime) {
        this.technologyEditTime = technologyEditTime;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public long getUnitOfMeasureId() {
        return unitOfMeasureId;
    }

    public void setUnitOfMeasureId(long unitOfMeasureId) {
        this.unitOfMeasureId = unitOfMeasureId;
    }

    public int getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(int materialCode) {
        this.materialCode = materialCode;
    }

    public boolean isAnnealing() {
        return annealing;
    }

    public void setAnnealing(boolean annealing) {
        this.annealing = annealing;
    }

    public String getThermalOp() {
        return thermalOp;
    }

    public void setThermalOp(String thermalOp) {
        this.thermalOp = thermalOp;
    }

    public String getPlanerThermalOp() {
        return planerThermalOp;
    }

    public void setPlanerThermalOp(String planerThermalOp) {
        this.planerThermalOp = planerThermalOp;
    }

    public double getDetailWeight() {
        return detailWeight;
    }

    public void setDetailWeight(double detailWeight) {
        this.detailWeight = detailWeight;
    }

    public boolean isOrdered() {
        return ordered;
    }

    public void setOrdered(boolean ordered) {
        this.ordered = ordered;
    }
}

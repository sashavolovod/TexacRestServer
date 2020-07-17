package gefest.rest.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    private long orderId;

    @Column (length = 32)
    private String orderNumber;

    @Column (length = 32)
    private String orderFullNumber;

    private long graphId;

    @Column (nullable = false)
    private long graphTypeId;

    @Column (nullable = false)
    private long reasonOrder;

    @Column (nullable = false)
    private Date orderDate;

    @Column (length = 32, nullable = false)
    private String obozTo;

    @Column (nullable = false)
    private long kodTO;

    @Column (length = 32, nullable = false)
    private String  productNumber;

    @Column (length = 32, nullable = false)
    private String  partNumber;

    @Column (nullable = false)
    private int qty;

    @Column (nullable = false)
    private int realQty;

    @Column (nullable = false)
    private long customerId;

    private Date planDate;

    private  long priorityId;

    private Date planTechDate;

    private Date techDate;

    private Date shopDate;

    private Date factReadyDate;

    private double planLabourIntensity;

    private long performerShop;

    @Column (nullable = false)
    private boolean includeInReport;

    private Date reportDate;

    private long technologistId;

    private long locksmithId;

    @Column (length = 4096)
    private String orderNote;

    private double factLabourIntensity;

    @Column (length = 32)
    private String consignmentNote;

    @Column (length = 32)
    private String actNumber;

    @Column (length = 32)
    private String destinationStore;

    private boolean anotherTimeReady;

    private long designerId;

    private long unitOfMeasureId;

    private boolean stopped;

    private long orderCard;

    private int serviceLifeYear;

    private int serviceLifeDay;

    private long objectType;

    private boolean urgent;

    private Date materialDate;

    private boolean spare;

    private int resistance;

    private boolean additionalOrder;

    @Column (length = 16)
    private String classifier;

    private Date priceDate;

    private Date peoDate;

    private Date otizDate;

    public Order() {  }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderFullNumber() {
        return orderFullNumber;
    }

    public void setOrderFullNumber(String orderFullNumber) {
        this.orderFullNumber = orderFullNumber;
    }

    public long getGraphId() {
        return graphId;
    }

    public void setGraphId(long graphId) {
        this.graphId = graphId;
    }

    public long getGraphTypeId() {
        return graphTypeId;
    }

    public void setGraphTypeId(long graphTypeId) {
        this.graphTypeId = graphTypeId;
    }

    public long getReasonOrder() {
        return reasonOrder;
    }

    public void setReasonOrder(long reasonOrder) {
        this.reasonOrder = reasonOrder;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getObozTo() {
        return obozTo;
    }

    public void setObozTo(String obozTo) {
        this.obozTo = obozTo;
    }

    public long getKodTO() {
        return kodTO;
    }

    public void setKodTO(long kodTO) {
        this.kodTO = kodTO;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getRealQty() {
        return realQty;
    }

    public void setRealQty(int realQty) {
        this.realQty = realQty;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public long getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(long priorityId) {
        this.priorityId = priorityId;
    }

    public Date getPlanTechDate() {
        return planTechDate;
    }

    public void setPlanTechDate(Date planTechDate) {
        this.planTechDate = planTechDate;
    }

    public Date getTechDate() {
        return techDate;
    }

    public void setTechDate(Date techDate) {
        this.techDate = techDate;
    }

    public Date getShopDate() {
        return shopDate;
    }

    public void setShopDate(Date shopDate) {
        this.shopDate = shopDate;
    }

    public Date getFactReadyDate() {
        return factReadyDate;
    }

    public void setFactReadyDate(Date factReadyDate) {
        this.factReadyDate = factReadyDate;
    }

    public double getPlanLabourIntensity() {
        return planLabourIntensity;
    }

    public void setPlanLabourIntensity(double planLabourIntensity) {
        this.planLabourIntensity = planLabourIntensity;
    }

    public long getPerformerShop() {
        return performerShop;
    }

    public void setPerformerShop(long performerShop) {
        this.performerShop = performerShop;
    }

    public boolean isIncludeInReport() {
        return includeInReport;
    }

    public void setIncludeInReport(boolean includeInReport) {
        this.includeInReport = includeInReport;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public long getTechnologistId() {
        return technologistId;
    }

    public void setTechnologistId(long technologistId) {
        this.technologistId = technologistId;
    }

    public long getLocksmithId() {
        return locksmithId;
    }

    public void setLocksmithId(long locksmithId) {
        this.locksmithId = locksmithId;
    }

    public String getOrderNote() {
        return orderNote;
    }

    public void setOrderNote(String orderNote) {
        this.orderNote = orderNote;
    }

    public double getFactLabourIntensity() {
        return factLabourIntensity;
    }

    public void setFactLabourIntensity(double factLabourIntensity) {
        this.factLabourIntensity = factLabourIntensity;
    }

    public String getConsignmentNote() {
        return consignmentNote;
    }

    public void setConsignmentNote(String consignmentNote) {
        this.consignmentNote = consignmentNote;
    }

    public String getActNumber() {
        return actNumber;
    }

    public void setActNumber(String actNumber) {
        this.actNumber = actNumber;
    }

    public String getDestinationStore() {
        return destinationStore;
    }

    public void setDestinationStore(String destinationStore) {
        this.destinationStore = destinationStore;
    }

    public boolean isAnotherTimeReady() {
        return anotherTimeReady;
    }

    public void setAnotherTimeReady(boolean anotherTimeReady) {
        this.anotherTimeReady = anotherTimeReady;
    }

    public long getDesignerId() {
        return designerId;
    }

    public void setDesignerId(long designerId) {
        this.designerId = designerId;
    }

    public long getUnitOfMeasureId() {
        return unitOfMeasureId;
    }

    public void setUnitOfMeasureId(long unitOfMeasureId) {
        this.unitOfMeasureId = unitOfMeasureId;
    }

    public boolean isStopped() {
        return stopped;
    }

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }

    public long getOrderCard() {
        return orderCard;
    }

    public void setOrderCard(long orderCard) {
        this.orderCard = orderCard;
    }

    public int getServiceLifeYear() {
        return serviceLifeYear;
    }

    public void setServiceLifeYear(int serviceLifeYear) {
        this.serviceLifeYear = serviceLifeYear;
    }

    public int getServiceLifeDay() {
        return serviceLifeDay;
    }

    public void setServiceLifeDay(int serviceLifeDay) {
        this.serviceLifeDay = serviceLifeDay;
    }

    public long getObjectType() {
        return objectType;
    }

    public void setObjectType(long objectType) {
        this.objectType = objectType;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }

    public Date getMaterialDate() {
        return materialDate;
    }

    public void setMaterialDate(Date materialDate) {
        this.materialDate = materialDate;
    }

    public boolean isSpare() {
        return spare;
    }

    public void setSpare(boolean spare) {
        this.spare = spare;
    }

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public boolean isAdditionalOrder() {
        return additionalOrder;
    }

    public void setAdditionalOrder(boolean additionalOrder) {
        this.additionalOrder = additionalOrder;
    }

    public String getClassifier() {
        return classifier;
    }

    public void setClassifier(String classifier) {
        this.classifier = classifier;
    }

    public Date getPriceDate() {
        return priceDate;
    }

    public void setPriceDate(Date priceDate) {
        this.priceDate = priceDate;
    }

    public Date getPeoDate() {
        return peoDate;
    }

    public void setPeoDate(Date peoDate) {
        this.peoDate = peoDate;
    }

    public Date getOtizDate() {
        return otizDate;
    }

    public void setOtizDate(Date otizDate) {
        this.otizDate = otizDate;
    }
}

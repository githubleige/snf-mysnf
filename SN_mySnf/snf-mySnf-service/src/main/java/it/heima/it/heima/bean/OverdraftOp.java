package it.heima.it.heima.bean;



import it.heima.bean.OrderCategoryID;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * SoOverdraftOp entity. @author MyEclipse Persistence Tools
 */

@Entity(name = "SO_OVERDRAFT_OP")
public class OverdraftOp extends OrderCategoryID implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    // Fields

    /** The row id. */
    private Long rowId;

    /** The entity type. */
    private String entityType;

    /** The pay type. */
    private String payType;

    /** The bill type. */
    private Integer billType;

    /** The order item id. */
    private String orderItemId;

    /** The bol no. */
    private String bolNo;

    /** The store code. */
    private String storeCode;

    /** The pay date. */
    private String payDate;

    /** The status. */
    private String status;

    /** The bank ret info. */
    private String bankRetInfo;

    /** The trade money. */
    private Double tradeMoney;

    /** The bank batch no. */
    private String bankBatchNo;

    /** The serial no. */
    private String serialNo;

    /** The type. */
    private String type;

    /** The tearminal no. */
    private String tearminalNo;

    /** The card no. */
    private String cardNo;

    /** The ex date. */
    private String exDate;

    /** The ex time. */
    private String exTime;

    /** The bank name. */
    private String bankName;

    /** The created by. */
    private String createdBy;

    /** The created time. */
    private Timestamp createdTime;

    /** The last upd by. */
    private String lastUpdBy;

    /** The last upd time. */
    private Timestamp lastUpdTime;

    /** The active flag. */
    private Integer activeFlag;

    /** The remark. */
    private String remark;

    /** The supplier code. */
    private String supplierCode;

    /** The posorder id. */
    private String posorderId;

    /** The operator. */
    private String operator;

    /** The institute code. */
    private String instituteCode;

    /** The pay code. */
    private String payCode;

    /** The tran lev. */
    private String tranLev;

    /** The trade order no. */
    private String tradeOrderNo;

    /** The sale org. */
    private String saleOrg;

    /** The orditm class. */
    private String orditmClass;

    /** The exe flag. */
    private String exeFlag;

    /** 参考号，中国银行是用来对账用，银联商务是用来退货用。. */
    private String refNo;

    /** 版本号. */
    private Integer editionId;

    // Constructors

    /**
     * default constructor.
     */
    public OverdraftOp() {
    }

    /**
     * full constructor.
     * 
     * @param entityType the entity type
     * @param payType the pay type
     * @param billType the bill type
     * @param orderItemId the order item id
     * @param bolNo the bol no
     * @param storeCode the store code
     * @param payDate the pay date
     * @param status the status
     * @param bankRetInfo the bank ret info
     * @param tradeMoney the trade money
     * @param bankBatchNo the bank batch no
     * @param serialNo the serial no
     * @param type the type
     * @param tearminalNo the tearminal no
     * @param cardNo the card no
     * @param exDate the ex date
     * @param exTime the ex time
     * @param bankName the bank name
     * @param createdBy the created by
     * @param createdTime the created time
     * @param lastUpdBy the last upd by
     * @param lastUpdTime the last upd time
     * @param activeFlag the active flag
     * @param remark the remark
     * @param supplierCode the supplier code
     * @param posorderId the posorder id
     * @param operator the operator
     * @param instituteCode the institute code
     * @param payCode the pay code
     * @param tranLev the tran lev
     * @param tradeOrderNo the trade order no
     * @param saleOrg the sale org
     * @param orditmClass the orditm class
     * @param exeFlag the exe flag
     * @param refNo the ref no
     * @param editionId the edition id
     */
    public OverdraftOp(String entityType, String payType, Integer billType, String orderItemId, String bolNo,
                       String storeCode, String payDate, String status, String bankRetInfo, Double tradeMoney, String bankBatchNo,
                       String serialNo, String type, String tearminalNo, String cardNo, String exDate, String exTime,
                       String bankName, String createdBy, Timestamp createdTime, String lastUpdBy, Timestamp lastUpdTime,
                       Integer activeFlag, String remark, String supplierCode, String posorderId, String operator,
                       String instituteCode, String payCode, String tranLev, String tradeOrderNo, String saleOrg,
                       String orditmClass, String exeFlag, String refNo, Integer editionId) {
        this.entityType = entityType;
        this.payType = payType;
        this.billType = billType;
        this.orderItemId = orderItemId;
        this.bolNo = bolNo;
        this.storeCode = storeCode;
        this.payDate = payDate;
        this.status = status;
        this.bankRetInfo = bankRetInfo;
        this.tradeMoney = tradeMoney;
        this.bankBatchNo = bankBatchNo;
        this.serialNo = serialNo;
        this.type = type;
        this.tearminalNo = tearminalNo;
        this.cardNo = cardNo;
        this.exDate = exDate;
        this.exTime = exTime;
        this.bankName = bankName;
        this.createdBy = createdBy;
        this.createdTime = createdTime;
        this.lastUpdBy = lastUpdBy;
        this.lastUpdTime = lastUpdTime;
        this.activeFlag = activeFlag;
        this.remark = remark;
        this.supplierCode = supplierCode;
        this.posorderId = posorderId;
        this.operator = operator;
        this.instituteCode = instituteCode;
        this.payCode = payCode;
        this.tranLev = tranLev;
        this.tradeOrderNo = tradeOrderNo;
        this.saleOrg = saleOrg;
        this.orditmClass = orditmClass;
        this.exeFlag = exeFlag;
        this.refNo = refNo;
        this.editionId = editionId;
    }

    // Property accessors
    /**
     * Gets the row id.
     * 
     * @return the row id
     */
    @Id
    @Column(name = "ROW_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getRowId() {
        return this.rowId;
    }

    /**
     * Sets the row id.
     * 
     * @param rowId the new row id
     */
    public void setRowId(Long rowId) {
        this.rowId = rowId;
    }

    /**
     * Gets the entity type.
     * 
     * @return the entity type
     */
    @Column(name = "ENTITY_TYPE", length = 6)
    public String getEntityType() {
        return this.entityType;
    }

    /**
     * Sets the entity type.
     * 
     * @param entityType the new entity type
     */
    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    /**
     * Gets the pay type.
     * 
     * @return the pay type
     */
    @Column(name = "PAY_TYPE", length = 10)
    public String getPayType() {
        return this.payType;
    }

    /**
     * Sets the pay type.
     * 
     * @param payType the new pay type
     */
    public void setPayType(String payType) {
        this.payType = payType;
    }

    /**
     * Gets the bill type.
     * 
     * @return the bill type
     */
    @Column(name = "BILL_TYPE")
    public Integer getBillType() {
        return this.billType;
    }

    /**
     * Sets the bill type.
     * 
     * @param billType the new bill type
     */
    public void setBillType(Integer billType) {
        this.billType = billType;
    }

    /**
     * Gets the order item id.
     * 
     * @return the order item id
     */
    @Column(name = "ORDER_ITEM_ID", length = 20)
    public String getOrderItemId() {
        return this.orderItemId;
    }

    /**
     * Sets the order item id.
     * 
     * @param orderItemId the new order item id
     */
    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
    }

    /**
     * Gets the bol no.
     * 
     * @return the bol no
     */
    @Column(name = "BOL_NO", length = 15)
    public String getBolNo() {
        return this.bolNo;
    }

    /**
     * Sets the bol no.
     * 
     * @param bolNo the new bol no
     */
    public void setBolNo(String bolNo) {
        this.bolNo = bolNo;
    }

    /**
     * Gets the store code.
     * 
     * @return the store code
     */
    @Column(name = "STORE_CODE", length = 4)
    public String getStoreCode() {
        return this.storeCode;
    }

    /**
     * Sets the store code.
     * 
     * @param storeCode the new store code
     */
    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    /**
     * Gets the pay date.
     * 
     * @return the pay date
     */
    @Column(name = "PAY_DATE", length = 10)
    public String getPayDate() {
        return this.payDate;
    }

    /**
     * Sets the pay date.
     * 
     * @param payDate the new pay date
     */
    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    /**
     * Gets the status.
     * 
     * @return the status
     */
    @Column(name = "STATUS", length = 10)
    public String getStatus() {
        return this.status;
    }

    /**
     * Sets the status.
     * 
     * @param status the new status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the bank ret info.
     * 
     * @return the bank ret info
     */
    @Column(name = "BANK_RET_INFO")
    public String getBankRetInfo() {
        return this.bankRetInfo;
    }

    /**
     * Sets the bank ret info.
     * 
     * @param bankRetInfo the new bank ret info
     */
    public void setBankRetInfo(String bankRetInfo) {
        this.bankRetInfo = bankRetInfo;
    }

    /**
     * Gets the trade money.
     * 
     * @return the trade money
     */
    @Column(name = "TRADE_MONEY", precision = 16)
    public Double getTradeMoney() {
        return this.tradeMoney;
    }

    /**
     * Sets the trade money.
     * 
     * @param tradeMoney the new trade money
     */
    public void setTradeMoney(Double tradeMoney) {
        this.tradeMoney = tradeMoney;
    }

    /**
     * Gets the bank batch no.
     * 
     * @return the bank batch no
     */
    @Column(name = "BANK_BATCH_NO", length = 32)
    public String getBankBatchNo() {
        return this.bankBatchNo;
    }

    /**
     * Sets the bank batch no.
     * 
     * @param bankBatchNo the new bank batch no
     */
    public void setBankBatchNo(String bankBatchNo) {
        this.bankBatchNo = bankBatchNo;
    }

    /**
     * Gets the serial no.
     * 
     * @return the serial no
     */
    @Column(name = "SERIAL_NO", length = 32)
    public String getSerialNo() {
        return this.serialNo;
    }

    /**
     * Sets the serial no.
     * 
     * @param serialNo the new serial no
     */
    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    /**
     * Gets the type.
     * 
     * @return the type
     */
    @Column(name = "TYPE", length = 10)
    public String getType() {
        return this.type;
    }

    /**
     * Sets the type.
     * 
     * @param type the new type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the tearminal no.
     * 
     * @return the tearminal no
     */
    @Column(name = "TEARMINAL_NO", length = 32)
    public String getTearminalNo() {
        return this.tearminalNo;
    }

    /**
     * Sets the tearminal no.
     * 
     * @param tearminalNo the new tearminal no
     */
    public void setTearminalNo(String tearminalNo) {
        this.tearminalNo = tearminalNo;
    }

    /**
     * Gets the card no.
     * 
     * @return the card no
     */
    @Column(name = "CARD_NO", length = 32)
    public String getCardNo() {
        return this.cardNo;
    }

    /**
     * Sets the card no.
     * 
     * @param cardNo the new card no
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    /**
     * Gets the ex date.
     * 
     * @return the ex date
     */
    @Column(name = "EX_DATE", length = 10)
    public String getExDate() {
        return this.exDate;
    }

    /**
     * Sets the ex date.
     * 
     * @param exDate the new ex date
     */
    public void setExDate(String exDate) {
        this.exDate = exDate;
    }

    /**
     * Gets the ex time.
     * 
     * @return the ex time
     */
    @Column(name = "EX_TIME", length = 10)
    public String getExTime() {
        return this.exTime;
    }

    /**
     * Sets the ex time.
     * 
     * @param exTime the new ex time
     */
    public void setExTime(String exTime) {
        this.exTime = exTime;
    }

    /**
     * Gets the bank name.
     * 
     * @return the bank name
     */
    @Column(name = "BANK_NAME", length = 32)
    public String getBankName() {
        return this.bankName;
    }

    /**
     * Sets the bank name.
     * 
     * @param bankName the new bank name
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * Gets the created by.
     * 
     * @return the created by
     */
    @Column(name = "CREATED_BY", length = 32)
    public String getCreatedBy() {
        return this.createdBy;
    }

    /**
     * Sets the created by.
     * 
     * @param createdBy the new created by
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Gets the created time.
     * 
     * @return the created time
     */
    @Column(name = "CREATED_TIME", insertable = false, length = 26)
    public Timestamp getCreatedTime() {
        return this.createdTime;
    }

    /**
     * Sets the created time.
     * 
     * @param createdTime the new created time
     */
    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * Gets the last upd by.
     * 
     * @return the last upd by
     */
    @Column(name = "LAST_UPD_BY", length = 32)
    public String getLastUpdBy() {
        return this.lastUpdBy;
    }

    /**
     * Sets the last upd by.
     * 
     * @param lastUpdBy the new last upd by
     */
    public void setLastUpdBy(String lastUpdBy) {
        this.lastUpdBy = lastUpdBy;
    }

    /**
     * Gets the last upd time.
     * 
     * @return the last upd time
     */
    @Column(name = "LAST_UPD_TIME", insertable = false, length = 26)
    public Timestamp getLastUpdTime() {
        return this.lastUpdTime;
    }

    /**
     * Sets the last upd time.
     * 
     * @param lastUpdTime the new last upd time
     */
    public void setLastUpdTime(Timestamp lastUpdTime) {
        this.lastUpdTime = lastUpdTime;
    }

    /**
     * Gets the active flag.
     * 
     * @return the active flag
     */
    @Column(name = "ACTIVE_FLAG", insertable = false)
    public Integer getActiveFlag() {
        return this.activeFlag;
    }

    /**
     * Sets the active flag.
     * 
     * @param activeFlag the new active flag
     */
    public void setActiveFlag(Integer activeFlag) {
        this.activeFlag = activeFlag;
    }

    /**
     * Gets the remark.
     * 
     * @return the remark
     */
    @Column(name = "REMARK")
    public String getRemark() {
        return this.remark;
    }

    /**
     * Sets the remark.
     * 
     * @param remark the new remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * Gets the supplier code.
     * 
     * @return the supplier code
     */
    @Column(name = "SUPPLIER_CODE", length = 32)
    public String getSupplierCode() {
        return this.supplierCode;
    }

    /**
     * Sets the supplier code.
     * 
     * @param supplierCode the new supplier code
     */
    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    /**
     * Gets the posorder id.
     * 
     * @return the posorder id
     */
    @Column(name = "POSORDER_ID", length = 32)
    public String getPosorderId() {
        return this.posorderId;
    }

    /**
     * Sets the posorder id.
     * 
     * @param posorderId the new posorder id
     */
    public void setPosorderId(String posorderId) {
        this.posorderId = posorderId;
    }

    /**
     * Gets the operator.
     * 
     * @return the operator
     */
    @Column(name = "OPERATOR", length = 32)
    public String getOperator() {
        return this.operator;
    }

    /**
     * Sets the operator.
     * 
     * @param operator the new operator
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * Gets the institute code.
     * 
     * @return the institute code
     */
    @Column(name = "INSTITUTE_CODE", length = 10)
    public String getInstituteCode() {
        return this.instituteCode;
    }

    /**
     * Sets the institute code.
     * 
     * @param instituteCode the new institute code
     */
    public void setInstituteCode(String instituteCode) {
        this.instituteCode = instituteCode;
    }

    /**
     * Gets the pay code.
     * 
     * @return the pay code
     */
    @Column(name = "PAY_CODE", length = 32)
    public String getPayCode() {
        return this.payCode;
    }

    /**
     * Sets the pay code.
     * 
     * @param payCode the new pay code
     */
    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }

    /**
     * Gets the tran lev.
     * 
     * @return the tran lev
     */
    @Column(name = "TRAN_LEV", length = 6)
    public String getTranLev() {
        return this.tranLev;
    }

    /**
     * Sets the tran lev.
     * 
     * @param tranLev the new tran lev
     */
    public void setTranLev(String tranLev) {
        this.tranLev = tranLev;
    }

    /**
     * Gets the trade order no.
     * 
     * @return the trade order no
     */
    @Column(name = "TRADE_ORDER_NO", length = 32)
    public String getTradeOrderNo() {
        return this.tradeOrderNo;
    }

    /**
     * Sets the trade order no.
     * 
     * @param tradeOrderNo the new trade order no
     */
    public void setTradeOrderNo(String tradeOrderNo) {
        this.tradeOrderNo = tradeOrderNo;
    }

    /**
     * Gets the sale org.
     * 
     * @return the sale org
     */
    @Column(name = "SALE_ORG", length = 4)
    public String getSaleOrg() {
        return this.saleOrg;
    }

    /**
     * Sets the sale org.
     * 
     * @param saleOrg the new sale org
     */
    public void setSaleOrg(String saleOrg) {
        this.saleOrg = saleOrg;
    }

    /**
     * Gets the orditm class.
     * 
     * @return the orditm class
     */
    @Column(name = "ORDITM_CLASS", length = 4)
    public String getOrditmClass() {
        return this.orditmClass;
    }

    /**
     * Sets the orditm class.
     * 
     * @param orditmClass the new orditm class
     */
    public void setOrditmClass(String orditmClass) {
        this.orditmClass = orditmClass;
    }

    /**
     * Gets the exe flag.
     * 
     * @return the exe flag
     */
    @Column(name = "EXE_FLAG", insertable = false, length = 2)
    public String getExeFlag() {
        return exeFlag;
    }

    /**
     * Sets the exe flag.
     * 
     * @param exeFlag the new exe flag
     */
    public void setExeFlag(String exeFlag) {
        this.exeFlag = exeFlag;
    }

    /**
     * Gets the ref no.
     * 
     * @return the ref no
     */
    @Column(name = "REFNO", length = 10)
    public String getRefNo() {
        return refNo;
    }

    /**
     * Sets the ref no.
     * 
     * @param refNo the new ref no
     */
    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    /**
     * Gets the edition id.
     * 
     * @return the edition id
     */
    @Column(name = "EDITION_ID")
    public Integer getEditionId() {
        return editionId;
    }

    /**
     * Sets the edition id.
     * 
     * @param editionId the new edition id
     */
    public void setEditionId(Integer editionId) {
        this.editionId = editionId;
    }
}
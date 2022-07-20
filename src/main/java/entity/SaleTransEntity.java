package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "SALE_TRANS", schema = "BCCS_IM")
public class SaleTransEntity implements Serializable {
    private Long saleTransId;
    private Time saleTransDate;
    private String saleTransType;
    private String status;
    private String checkStock;
    private Integer invoiceUsedId;
    private Time invoiceCreateDate;
    private Integer shopId;
    private Integer staffId;
    private String payMethod;
    private Long saleServiceId;
    private Long saleServicePriceId;
    private Long amountService;
    private Long amountModel;
    private Long discount;
    private Long promotion;
    private Double amountTax;
    private Double amountNotTax;
    private Long vat;
    private Long tax;
    private Long subId;
    private String isdn;
    private String custName;
    private String contractNo;
    private String telNumber;
    private String company;
    private String address;
    private String tin;
    private String note;
    private String destroyUser;
    private Time destroyDate;
    private String approverUser;
    private Time approverDate;
    private Integer reasonId;
    private Long telecomServiceId;
    private String transferGoods;
    private String saleTransCode;
    private Integer stockTransId;
    private Integer createStaffId;
    private Integer receiverId;
    private String synStatus;
    private Boolean receiverType;
    private String inTransId;
    private Integer fromSaleTransId;
    private Integer recordWorkId;
    private String transactionId;
    private String airtimeId;
    private String currency;
    private Long channel;
    private Integer programId;
    private String programCode;
    private String programName;
    private Integer posId;
    private Integer developerId;
    private String custNameKh;
    private String companyKh;
    private Integer exchangeRate;

    @Id
    @Basic
    @Column(name = "SALE_TRANS_ID")
    public Long getSaleTransId() {
        return saleTransId;
    }

    public void setSaleTransId(Long saleTransId) {
        this.saleTransId = saleTransId;
    }

    @Basic
    @Column(name = "SALE_TRANS_DATE")
    public Time getSaleTransDate() {
        return saleTransDate;
    }

    public void setSaleTransDate(Time saleTransDate) {
        this.saleTransDate = saleTransDate;
    }

    @Basic
    @Column(name = "SALE_TRANS_TYPE")
    public String getSaleTransType() {
        return saleTransType;
    }

    public void setSaleTransType(String saleTransType) {
        this.saleTransType = saleTransType;
    }

    @Basic
    @Column(name = "STATUS")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "CHECK_STOCK")
    public String getCheckStock() {
        return checkStock;
    }

    public void setCheckStock(String checkStock) {
        this.checkStock = checkStock;
    }

    @Basic
    @Column(name = "INVOICE_USED_ID")
    public Integer getInvoiceUsedId() {
        return invoiceUsedId;
    }

    public void setInvoiceUsedId(Integer invoiceUsedId) {
        this.invoiceUsedId = invoiceUsedId;
    }

    @Basic
    @Column(name = "INVOICE_CREATE_DATE")
    public Time getInvoiceCreateDate() {
        return invoiceCreateDate;
    }

    public void setInvoiceCreateDate(Time invoiceCreateDate) {
        this.invoiceCreateDate = invoiceCreateDate;
    }

    @Basic
    @Column(name = "SHOP_ID")
    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    @Basic
    @Column(name = "STAFF_ID")
    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    @Basic
    @Column(name = "PAY_METHOD")
    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    @Basic
    @Column(name = "SALE_SERVICE_ID")
    public Long getSaleServiceId() {
        return saleServiceId;
    }

    public void setSaleServiceId(Long saleServiceId) {
        this.saleServiceId = saleServiceId;
    }

    @Basic
    @Column(name = "SALE_SERVICE_PRICE_ID")
    public Long getSaleServicePriceId() {
        return saleServicePriceId;
    }

    public void setSaleServicePriceId(Long saleServicePriceId) {
        this.saleServicePriceId = saleServicePriceId;
    }

    @Basic
    @Column(name = "AMOUNT_SERVICE")
    public Long getAmountService() {
        return amountService;
    }

    public void setAmountService(Long amountService) {
        this.amountService = amountService;
    }

    @Basic
    @Column(name = "AMOUNT_MODEL")
    public Long getAmountModel() {
        return amountModel;
    }

    public void setAmountModel(Long amountModel) {
        this.amountModel = amountModel;
    }

    @Basic
    @Column(name = "DISCOUNT")
    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    @Basic
    @Column(name = "PROMOTION")
    public Long getPromotion() {
        return promotion;
    }

    public void setPromotion(Long promotion) {
        this.promotion = promotion;
    }

    @Basic
    @Column(name = "AMOUNT_TAX")
    public Double getAmountTax() {
        return amountTax;
    }

    public void setAmountTax(Double amountTax) {
        this.amountTax = amountTax;
    }

    @Basic
    @Column(name = "AMOUNT_NOT_TAX")
    public Double getAmountNotTax() {
        return amountNotTax;
    }

    public void setAmountNotTax(Double amountNotTax) {
        this.amountNotTax = amountNotTax;
    }

    @Basic
    @Column(name = "VAT")
    public Long getVat() {
        return vat;
    }

    public void setVat(Long vat) {
        this.vat = vat;
    }

    @Basic
    @Column(name = "TAX")
    public Long getTax() {
        return tax;
    }

    public void setTax(Long tax) {
        this.tax = tax;
    }

    @Basic
    @Column(name = "SUB_ID")
    public Long getSubId() {
        return subId;
    }

    public void setSubId(Long subId) {
        this.subId = subId;
    }

    @Basic
    @Column(name = "ISDN")
    public String getIsdn() {
        return isdn;
    }

    public void setIsdn(String isdn) {
        this.isdn = isdn;
    }

    @Basic
    @Column(name = "CUST_NAME")
    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    @Basic
    @Column(name = "CONTRACT_NO")
    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    @Basic
    @Column(name = "TEL_NUMBER")
    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    @Basic
    @Column(name = "COMPANY")
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Basic
    @Column(name = "ADDRESS")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "TIN")
    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    @Basic
    @Column(name = "NOTE")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Basic
    @Column(name = "DESTROY_USER")
    public String getDestroyUser() {
        return destroyUser;
    }

    public void setDestroyUser(String destroyUser) {
        this.destroyUser = destroyUser;
    }

    @Basic
    @Column(name = "DESTROY_DATE")
    public Time getDestroyDate() {
        return destroyDate;
    }

    public void setDestroyDate(Time destroyDate) {
        this.destroyDate = destroyDate;
    }

    @Basic
    @Column(name = "APPROVER_USER")
    public String getApproverUser() {
        return approverUser;
    }

    public void setApproverUser(String approverUser) {
        this.approverUser = approverUser;
    }

    @Basic
    @Column(name = "APPROVER_DATE")
    public Time getApproverDate() {
        return approverDate;
    }

    public void setApproverDate(Time approverDate) {
        this.approverDate = approverDate;
    }

    @Basic
    @Column(name = "REASON_ID")
    public Integer getReasonId() {
        return reasonId;
    }

    public void setReasonId(Integer reasonId) {
        this.reasonId = reasonId;
    }

    @Basic
    @Column(name = "TELECOM_SERVICE_ID")
    public Long getTelecomServiceId() {
        return telecomServiceId;
    }

    public void setTelecomServiceId(Long telecomServiceId) {
        this.telecomServiceId = telecomServiceId;
    }

    @Basic
    @Column(name = "TRANSFER_GOODS")
    public String getTransferGoods() {
        return transferGoods;
    }

    public void setTransferGoods(String transferGoods) {
        this.transferGoods = transferGoods;
    }

    @Basic
    @Column(name = "SALE_TRANS_CODE")
    public String getSaleTransCode() {
        return saleTransCode;
    }

    public void setSaleTransCode(String saleTransCode) {
        this.saleTransCode = saleTransCode;
    }

    @Basic
    @Column(name = "STOCK_TRANS_ID")
    public Integer getStockTransId() {
        return stockTransId;
    }

    public void setStockTransId(Integer stockTransId) {
        this.stockTransId = stockTransId;
    }

    @Basic
    @Column(name = "CREATE_STAFF_ID")
    public Integer getCreateStaffId() {
        return createStaffId;
    }

    public void setCreateStaffId(Integer createStaffId) {
        this.createStaffId = createStaffId;
    }

    @Basic
    @Column(name = "RECEIVER_ID")
    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    @Basic
    @Column(name = "SYN_STATUS")
    public String getSynStatus() {
        return synStatus;
    }

    public void setSynStatus(String synStatus) {
        this.synStatus = synStatus;
    }

    @Basic
    @Column(name = "RECEIVER_TYPE")
    public Boolean getReceiverType() {
        return receiverType;
    }

    public void setReceiverType(Boolean receiverType) {
        this.receiverType = receiverType;
    }

    @Basic
    @Column(name = "IN_TRANS_ID")
    public String getInTransId() {
        return inTransId;
    }

    public void setInTransId(String inTransId) {
        this.inTransId = inTransId;
    }

    @Basic
    @Column(name = "FROM_SALE_TRANS_ID")
    public Integer getFromSaleTransId() {
        return fromSaleTransId;
    }

    public void setFromSaleTransId(Integer fromSaleTransId) {
        this.fromSaleTransId = fromSaleTransId;
    }

    @Basic
    @Column(name = "RECORD_WORK_ID")
    public Integer getRecordWorkId() {
        return recordWorkId;
    }

    public void setRecordWorkId(Integer recordWorkId) {
        this.recordWorkId = recordWorkId;
    }

    @Basic
    @Column(name = "TRANSACTION_ID")
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @Basic
    @Column(name = "AIRTIME_ID")
    public String getAirtimeId() {
        return airtimeId;
    }

    public void setAirtimeId(String airtimeId) {
        this.airtimeId = airtimeId;
    }

    @Basic
    @Column(name = "CURRENCY")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Basic
    @Column(name = "CHANNEL")
    public Long getChannel() {
        return channel;
    }

    public void setChannel(Long channel) {
        this.channel = channel;
    }

    @Basic
    @Column(name = "PROGRAM_ID")
    public Integer getProgramId() {
        return programId;
    }

    public void setProgramId(Integer programId) {
        this.programId = programId;
    }

    @Basic
    @Column(name = "PROGRAM_CODE")
    public String getProgramCode() {
        return programCode;
    }

    public void setProgramCode(String programCode) {
        this.programCode = programCode;
    }

    @Basic
    @Column(name = "PROGRAM_NAME")
    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    @Basic
    @Column(name = "POS_ID")
    public Integer getPosId() {
        return posId;
    }

    public void setPosId(Integer posId) {
        this.posId = posId;
    }

    @Basic
    @Column(name = "DEVELOPER_ID")
    public Integer getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(Integer developerId) {
        this.developerId = developerId;
    }

    @Basic
    @Column(name = "CUST_NAME_KH")
    public String getCustNameKh() {
        return custNameKh;
    }

    public void setCustNameKh(String custNameKh) {
        this.custNameKh = custNameKh;
    }

    @Basic
    @Column(name = "COMPANY_KH")
    public String getCompanyKh() {
        return companyKh;
    }

    public void setCompanyKh(String companyKh) {
        this.companyKh = companyKh;
    }

    @Basic
    @Column(name = "EXCHANGE_RATE")
    public Integer getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Integer exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleTransEntity that = (SaleTransEntity) o;
        return saleTransId == that.saleTransId &&
                Objects.equals(saleTransDate, that.saleTransDate) &&
                Objects.equals(saleTransType, that.saleTransType) &&
                Objects.equals(status, that.status) &&
                Objects.equals(checkStock, that.checkStock) &&
                Objects.equals(invoiceUsedId, that.invoiceUsedId) &&
                Objects.equals(invoiceCreateDate, that.invoiceCreateDate) &&
                Objects.equals(shopId, that.shopId) &&
                Objects.equals(staffId, that.staffId) &&
                Objects.equals(payMethod, that.payMethod) &&
                Objects.equals(saleServiceId, that.saleServiceId) &&
                Objects.equals(saleServicePriceId, that.saleServicePriceId) &&
                Objects.equals(amountService, that.amountService) &&
                Objects.equals(amountModel, that.amountModel) &&
                Objects.equals(discount, that.discount) &&
                Objects.equals(promotion, that.promotion) &&
                Objects.equals(amountTax, that.amountTax) &&
                Objects.equals(amountNotTax, that.amountNotTax) &&
                Objects.equals(vat, that.vat) &&
                Objects.equals(tax, that.tax) &&
                Objects.equals(subId, that.subId) &&
                Objects.equals(isdn, that.isdn) &&
                Objects.equals(custName, that.custName) &&
                Objects.equals(contractNo, that.contractNo) &&
                Objects.equals(telNumber, that.telNumber) &&
                Objects.equals(company, that.company) &&
                Objects.equals(address, that.address) &&
                Objects.equals(tin, that.tin) &&
                Objects.equals(note, that.note) &&
                Objects.equals(destroyUser, that.destroyUser) &&
                Objects.equals(destroyDate, that.destroyDate) &&
                Objects.equals(approverUser, that.approverUser) &&
                Objects.equals(approverDate, that.approverDate) &&
                Objects.equals(reasonId, that.reasonId) &&
                Objects.equals(telecomServiceId, that.telecomServiceId) &&
                Objects.equals(transferGoods, that.transferGoods) &&
                Objects.equals(saleTransCode, that.saleTransCode) &&
                Objects.equals(stockTransId, that.stockTransId) &&
                Objects.equals(createStaffId, that.createStaffId) &&
                Objects.equals(receiverId, that.receiverId) &&
                Objects.equals(synStatus, that.synStatus) &&
                Objects.equals(receiverType, that.receiverType) &&
                Objects.equals(inTransId, that.inTransId) &&
                Objects.equals(fromSaleTransId, that.fromSaleTransId) &&
                Objects.equals(recordWorkId, that.recordWorkId) &&
                Objects.equals(transactionId, that.transactionId) &&
                Objects.equals(airtimeId, that.airtimeId) &&
                Objects.equals(currency, that.currency) &&
                Objects.equals(channel, that.channel) &&
                Objects.equals(programId, that.programId) &&
                Objects.equals(programCode, that.programCode) &&
                Objects.equals(programName, that.programName) &&
                Objects.equals(posId, that.posId) &&
                Objects.equals(developerId, that.developerId) &&
                Objects.equals(custNameKh, that.custNameKh) &&
                Objects.equals(companyKh, that.companyKh) &&
                Objects.equals(exchangeRate, that.exchangeRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(saleTransId, saleTransDate, saleTransType, status, checkStock, invoiceUsedId, invoiceCreateDate, shopId, staffId, payMethod, saleServiceId, saleServicePriceId, amountService, amountModel, discount, promotion, amountTax, amountNotTax, vat, tax, subId, isdn, custName, contractNo, telNumber, company, address, tin, note, destroyUser, destroyDate, approverUser, approverDate, reasonId, telecomServiceId, transferGoods, saleTransCode, stockTransId, createStaffId, receiverId, synStatus, receiverType, inTransId, fromSaleTransId, recordWorkId, transactionId, airtimeId, currency, channel, programId, programCode, programName, posId, developerId, custNameKh, companyKh, exchangeRate);
    }
}

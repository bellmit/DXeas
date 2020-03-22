package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBatchContractInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractBatchContractInfo()
    {
        this("id");
    }
    protected AbstractBatchContractInfo(String pkField)
    {
        super(pkField);
        put("ReceiveBillEntry", new com.kingdee.eas.farm.stocking.processbizill.BatchContractReceiveBillEntryCollection());
    }
    /**
     * Object:批次合同's 是否生成凭证property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    /**
     * Object:批次合同's 单据状态property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBillStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("billStatus", item.getValue());
		}
    }
    /**
     * Object: 批次合同 's 财务组织 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("company", item);
    }
    /**
     * Object:批次合同's 审核时间property 
     */
    public java.util.Date getAuditTime()
    {
        return getDate("auditTime");
    }
    public void setAuditTime(java.util.Date item)
    {
        setDate("auditTime", item);
    }
    /**
     * Object:批次合同's 是否模板property 
     */
    public boolean isIsTemplate()
    {
        return getBoolean("isTemplate");
    }
    public void setIsTemplate(boolean item)
    {
        setBoolean("isTemplate", item);
    }
    /**
     * Object: 批次合同 's 养户名称 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmersInfo getFarmer()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmersInfo)get("farmer");
    }
    public void setFarmer(com.kingdee.eas.farm.stocking.basedata.FarmersInfo item)
    {
        put("farmer", item);
    }
    /**
     * Object:批次合同's 身份证号property 
     */
    public String getIdentity()
    {
        return getString("identity");
    }
    public void setIdentity(String item)
    {
        setString("identity", item);
    }
    /**
     * Object:批次合同's 合同开始日期property 
     */
    public java.util.Date getContractDate()
    {
        return getDate("contractDate");
    }
    public void setContractDate(java.util.Date item)
    {
        setDate("contractDate", item);
    }
    /**
     * Object: 批次合同 's 技术员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("person");
    }
    public void setPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("person", item);
    }
    /**
     * Object:批次合同's 手机号property 
     */
    public String getMobileTel()
    {
        return getString("mobileTel");
    }
    public void setMobileTel(String item)
    {
        setString("mobileTel", item);
    }
    /**
     * Object:批次合同's 合同内容property 
     */
    public String getContractContext()
    {
        return getString("contractContext");
    }
    public void setContractContext(String item)
    {
        setString("contractContext", item);
    }
    /**
     * Object:批次合同's 养殖类型property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StockingTypeEnum getBreedType()
    {
        return com.kingdee.eas.farm.stocking.basedata.StockingTypeEnum.getEnum(getInt("breedType"));
    }
    public void setBreedType(com.kingdee.eas.farm.stocking.basedata.StockingTypeEnum item)
    {
		if (item != null) {
        setInt("breedType", item.getValue());
		}
    }
    /**
     * Object: 批次合同 's 上苗批次 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo getStockingBatch()
    {
        return (com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo)get("stockingBatch");
    }
    public void setStockingBatch(com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo item)
    {
        put("stockingBatch", item);
    }
    /**
     * Object:批次合同's 预计上苗日期property 
     */
    public java.util.Date getBreedDate()
    {
        return getDate("breedDate");
    }
    public void setBreedDate(java.util.Date item)
    {
        setDate("breedDate", item);
    }
    /**
     * Object:批次合同's 公禽数量property 
     */
    public java.math.BigDecimal getBreedQty()
    {
        return getBigDecimal("breedQty");
    }
    public void setBreedQty(java.math.BigDecimal item)
    {
        setBigDecimal("breedQty", item);
    }
    /**
     * Object: 批次合同 's 保证金 property 
     */
    public com.kingdee.eas.farm.stocking.basebizbill.MarginBillInfo getMarginBill()
    {
        return (com.kingdee.eas.farm.stocking.basebizbill.MarginBillInfo)get("MarginBill");
    }
    public void setMarginBill(com.kingdee.eas.farm.stocking.basebizbill.MarginBillInfo item)
    {
        put("MarginBill", item);
    }
    /**
     * Object:批次合同's 保证金金额property 
     */
    public java.math.BigDecimal getMarginBillAmount()
    {
        return getBigDecimal("MarginBillAmount");
    }
    public void setMarginBillAmount(java.math.BigDecimal item)
    {
        setBigDecimal("MarginBillAmount", item);
    }
    /**
     * Object: 批次合同 's 品种 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BreedDataInfo getBreedData()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BreedDataInfo)get("breedData");
    }
    public void setBreedData(com.kingdee.eas.farm.stocking.basedata.BreedDataInfo item)
    {
        put("breedData", item);
    }
    /**
     * Object: 批次合同 's 结算政策 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StatementsPolicyInfo getSettlementPolicy()
    {
        return (com.kingdee.eas.farm.stocking.basedata.StatementsPolicyInfo)get("settlementPolicy");
    }
    public void setSettlementPolicy(com.kingdee.eas.farm.stocking.basedata.StatementsPolicyInfo item)
    {
        put("settlementPolicy", item);
    }
    /**
     * Object: 批次合同 's 养殖场 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmInfo getFarm()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.stocking.basedata.FarmInfo item)
    {
        put("farm", item);
    }
    /**
     * Object:批次合同's 母禽数量property 
     */
    public java.math.BigDecimal getFemaleBreedQty()
    {
        return getBigDecimal("femaleBreedQty");
    }
    public void setFemaleBreedQty(java.math.BigDecimal item)
    {
        setBigDecimal("femaleBreedQty", item);
    }
    /**
     * Object:批次合同's 初始化单据property 
     */
    public boolean isIsInit()
    {
        return getBoolean("isInit");
    }
    public void setIsInit(boolean item)
    {
        setBoolean("isInit", item);
    }
    /**
     * Object: 批次合同 's 保证金 property 
     */
    public com.kingdee.eas.fi.cas.ReceivingBillInfo getReceiveBill()
    {
        return (com.kingdee.eas.fi.cas.ReceivingBillInfo)get("receiveBill");
    }
    public void setReceiveBill(com.kingdee.eas.fi.cas.ReceivingBillInfo item)
    {
        put("receiveBill", item);
    }
    /**
     * Object:批次合同's 合同结束日期property 
     */
    public java.util.Date getContractEndDate()
    {
        return getDate("contractEndDate");
    }
    public void setContractEndDate(java.util.Date item)
    {
        setDate("contractEndDate", item);
    }
    /**
     * Object: 批次合同 's 初次种苗领用单 property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.BreedSeedBillInfo getFirstBreedBillSeel()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.BreedSeedBillInfo)get("firstBreedBillSeel");
    }
    public void setFirstBreedBillSeel(com.kingdee.eas.farm.stocking.processbizill.BreedSeedBillInfo item)
    {
        put("firstBreedBillSeel", item);
    }
    /**
     * Object:批次合同's 实际上苗日期property 
     */
    public java.util.Date getActualBreedDate()
    {
        return getDate("actualBreedDate");
    }
    public void setActualBreedDate(java.util.Date item)
    {
        setDate("actualBreedDate", item);
    }
    /**
     * Object:批次合同's 实际公禽数量property 
     */
    public java.math.BigDecimal getActualbreedQty()
    {
        return getBigDecimal("actualbreedQty");
    }
    public void setActualbreedQty(java.math.BigDecimal item)
    {
        setBigDecimal("actualbreedQty", item);
    }
    /**
     * Object:批次合同's 实际母禽数量property 
     */
    public java.math.BigDecimal getActualFemaleQty()
    {
        return getBigDecimal("actualFemaleQty");
    }
    public void setActualFemaleQty(java.math.BigDecimal item)
    {
        setBigDecimal("actualFemaleQty", item);
    }
    /**
     * Object: 批次合同 's 收款明细 property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.BatchContractReceiveBillEntryCollection getReceiveBillEntry()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.BatchContractReceiveBillEntryCollection)get("ReceiveBillEntry");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("CBC4A327");
    }
}
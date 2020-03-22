package com.kingdee.eas.farm.carnivorous.basebiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCustomerViewReqBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractCustomerViewReqBillInfo()
    {
        this("id");
    }
    protected AbstractCustomerViewReqBillInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:客诉申请单's 是否生成凭证property 
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
     * Object: 客诉申请单 's 财务组织 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getFICompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("FICompany");
    }
    public void setFICompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("FICompany", item);
    }
    /**
     * Object:客诉申请单's 单据状态property 
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
     * Object: 客诉申请单 's 养殖户 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo getFarmer()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo)get("farmer");
    }
    public void setFarmer(com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo item)
    {
        put("farmer", item);
    }
    /**
     * Object: 客诉申请单 's 养殖场 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmInfo getFarm()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.carnivorous.basedata.FarmInfo item)
    {
        put("farm", item);
    }
    /**
     * Object: 客诉申请单 's 批次合同 property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo getBatchContract()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo)get("batchContract");
    }
    public void setBatchContract(com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo item)
    {
        put("batchContract", item);
    }
    /**
     * Object: 客诉申请单 's 养殖批次 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.BatchInfo getBatch()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.BatchInfo)get("batch");
    }
    public void setBatch(com.kingdee.eas.farm.carnivorous.basedata.BatchInfo item)
    {
        put("batch", item);
    }
    /**
     * Object:客诉申请单's 上苗日期property 
     */
    public java.util.Date getInDate()
    {
        return getDate("inDate");
    }
    public void setInDate(java.util.Date item)
    {
        setDate("inDate", item);
    }
    /**
     * Object:客诉申请单's 批次数量property 
     */
    public java.math.BigDecimal getBatchQty()
    {
        return getBigDecimal("batchQty");
    }
    public void setBatchQty(java.math.BigDecimal item)
    {
        setBigDecimal("batchQty", item);
    }
    /**
     * Object: 客诉申请单 's 业务员 property 
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
     * Object:客诉申请单's 申请金额property 
     */
    public java.math.BigDecimal getAmount()
    {
        return getBigDecimal("amount");
    }
    public void setAmount(java.math.BigDecimal item)
    {
        setBigDecimal("amount", item);
    }
    /**
     * Object:客诉申请单's 审核日期property 
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
     * Object: 客诉申请单 's 客诉类型 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.CustomerViewTypeInfo getViewType()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.CustomerViewTypeInfo)get("viewType");
    }
    public void setViewType(com.kingdee.eas.farm.carnivorous.basedata.CustomerViewTypeInfo item)
    {
        put("viewType", item);
    }
    /**
     * Object:客诉申请单's 客诉说明property 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    /**
     * Object:客诉申请单's 回收日期property 
     */
    public java.util.Date getRecDate()
    {
        return getDate("recDate");
    }
    public void setRecDate(java.util.Date item)
    {
        setDate("recDate", item);
    }
    /**
     * Object:客诉申请单's 回收只数property 
     */
    public int getRecQty()
    {
        return getInt("recQty");
    }
    public void setRecQty(int item)
    {
        setInt("recQty", item);
    }
    /**
     * Object:客诉申请单's 耗料重量property 
     */
    public java.math.BigDecimal getFeedWgt()
    {
        return getBigDecimal("feedWgt");
    }
    public void setFeedWgt(java.math.BigDecimal item)
    {
        setBigDecimal("feedWgt", item);
    }
    /**
     * Object:客诉申请单's 回收率property 
     */
    public java.math.BigDecimal getRecRate()
    {
        return getBigDecimal("recRate");
    }
    public void setRecRate(java.math.BigDecimal item)
    {
        setBigDecimal("recRate", item);
    }
    /**
     * Object:客诉申请单's 料肉比property 
     */
    public java.math.BigDecimal getFmRate()
    {
        return getBigDecimal("fmRate");
    }
    public void setFmRate(java.math.BigDecimal item)
    {
        setBigDecimal("fmRate", item);
    }
    /**
     * Object:客诉申请单's 用药金额property 
     */
    public java.math.BigDecimal getDrugAmt()
    {
        return getBigDecimal("drugAmt");
    }
    public void setDrugAmt(java.math.BigDecimal item)
    {
        setBigDecimal("drugAmt", item);
    }
    /**
     * Object:客诉申请单's 单只用药(元/只)property 
     */
    public java.math.BigDecimal getSingleDrugAmt()
    {
        return getBigDecimal("singleDrugAmt");
    }
    public void setSingleDrugAmt(java.math.BigDecimal item)
    {
        setBigDecimal("singleDrugAmt", item);
    }
    /**
     * Object:客诉申请单's 饲养欧指property 
     */
    public java.math.BigDecimal getOValue()
    {
        return getBigDecimal("oValue");
    }
    public void setOValue(java.math.BigDecimal item)
    {
        setBigDecimal("oValue", item);
    }
    /**
     * Object:客诉申请单's 审批金额property 
     */
    public java.math.BigDecimal getAuditAmt()
    {
        return getBigDecimal("auditAmt");
    }
    public void setAuditAmt(java.math.BigDecimal item)
    {
        setBigDecimal("auditAmt", item);
    }
    /**
     * Object:客诉申请单's 回收净重property 
     */
    public java.math.BigDecimal getRecSuttle()
    {
        return getBigDecimal("recSuttle");
    }
    public void setRecSuttle(java.math.BigDecimal item)
    {
        setBigDecimal("recSuttle", item);
    }
    /**
     * Object:客诉申请单's 代养费property 
     */
    public java.math.BigDecimal getDyFee()
    {
        return getBigDecimal("dyFee");
    }
    public void setDyFee(java.math.BigDecimal item)
    {
        setBigDecimal("dyFee", item);
    }
    /**
     * Object:客诉申请单's 单只代养费property 
     */
    public java.math.BigDecimal getSingleDyFee()
    {
        return getBigDecimal("singleDyFee");
    }
    public void setSingleDyFee(java.math.BigDecimal item)
    {
        setBigDecimal("singleDyFee", item);
    }
    /**
     * Object:客诉申请单's 毛鸡均重property 
     */
    public java.math.BigDecimal getCAverageWgt()
    {
        return getBigDecimal("cAverageWgt");
    }
    public void setCAverageWgt(java.math.BigDecimal item)
    {
        setBigDecimal("cAverageWgt", item);
    }
    /**
     * Object:客诉申请单's 饲养天数property 
     */
    public int getFeedDays()
    {
        return getInt("feedDays");
    }
    public void setFeedDays(int item)
    {
        setInt("feedDays", item);
    }
    /**
     * Object:客诉申请单's 单只耗料property 
     */
    public java.math.BigDecimal getSingleFeedWgt()
    {
        return getBigDecimal("singleFeedWgt");
    }
    public void setSingleFeedWgt(java.math.BigDecimal item)
    {
        setBigDecimal("singleFeedWgt", item);
    }
    /**
     * Object: 客诉申请单 's 品种 property 
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
     * Object:客诉申请单's 苗来源property 
     */
    public String getSeedSource()
    {
        return getString("seedSource");
    }
    public void setSeedSource(String item)
    {
        setString("seedSource", item);
    }
    /**
     * Object: 客诉申请单 's 养殖政策 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo getSettlePolicy()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo)get("settlePolicy");
    }
    public void setSettlePolicy(com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo item)
    {
        put("settlePolicy", item);
    }
    /**
     * Object:客诉申请单's 雏苗单价property 
     */
    public java.math.BigDecimal getBreedPrice()
    {
        return getBigDecimal("breedPrice");
    }
    public void setBreedPrice(java.math.BigDecimal item)
    {
        setBigDecimal("breedPrice", item);
    }
    /**
     * Object:客诉申请单's 申请补雏数量property 
     */
    public java.math.BigDecimal getApplyGetBreed()
    {
        return getBigDecimal("applyGetBreed");
    }
    public void setApplyGetBreed(java.math.BigDecimal item)
    {
        setBigDecimal("applyGetBreed", item);
    }
    /**
     * Object:客诉申请单's 审批补雏数量property 
     */
    public java.math.BigDecimal getAuditGetBreed()
    {
        return getBigDecimal("auditGetBreed");
    }
    public void setAuditGetBreed(java.math.BigDecimal item)
    {
        setBigDecimal("auditGetBreed", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B45036AB");
    }
}
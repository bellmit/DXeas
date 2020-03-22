package com.kingdee.eas.farm.feedfactory;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractQualityCheckBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractQualityCheckBillInfo()
    {
        this("id");
    }
    protected AbstractQualityCheckBillInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.feedfactory.QualityCheckBillEntryCollection());
    }
    /**
     * Object: 质检单 's 分录 property 
     */
    public com.kingdee.eas.farm.feedfactory.QualityCheckBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.feedfactory.QualityCheckBillEntryCollection)get("entrys");
    }
    /**
     * Object:质检单's 是否生成凭证property 
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
     * Object: 质检单 's 过磅单 property 
     */
    public com.kingdee.eas.weighbridge.InStorageBillInfo getWeightBill()
    {
        return (com.kingdee.eas.weighbridge.InStorageBillInfo)get("weightBill");
    }
    public void setWeightBill(com.kingdee.eas.weighbridge.InStorageBillInfo item)
    {
        put("weightBill", item);
    }
    /**
     * Object: 质检单 's 质检员 property 
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
     * Object: 质检单 's 检验原料 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("material");
    }
    public void setMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("material", item);
    }
    /**
     * Object: 质检单 's 供应商 property 
     */
    public com.kingdee.eas.basedata.master.cssp.SupplierInfo getSupplier()
    {
        return (com.kingdee.eas.basedata.master.cssp.SupplierInfo)get("supplier");
    }
    public void setSupplier(com.kingdee.eas.basedata.master.cssp.SupplierInfo item)
    {
        put("supplier", item);
    }
    /**
     * Object:质检单's 车号property 
     */
    public String getTruckNumber()
    {
        return getString("truckNumber");
    }
    public void setTruckNumber(String item)
    {
        setString("truckNumber", item);
    }
    /**
     * Object:质检单's 到货日期property 
     */
    public java.util.Date getArriveDate()
    {
        return getDate("arriveDate");
    }
    public void setArriveDate(java.util.Date item)
    {
        setDate("arriveDate", item);
    }
    /**
     * Object:质检单's 送检日期property 
     */
    public java.util.Date getSendDate()
    {
        return getDate("sendDate");
    }
    public void setSendDate(java.util.Date item)
    {
        setDate("sendDate", item);
    }
    /**
     * Object:质检单's 审核时间property 
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
     * Object:质检单's 状态property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBaseStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("baseStatus", item.getValue());
		}
    }
    /**
     * Object:质检单's 检验结论property 
     */
    public String getConclusion()
    {
        return getString("conclusion");
    }
    public void setConclusion(String item)
    {
        setString("conclusion", item);
    }
    /**
     * Object:质检单's 样品编号property 
     */
    public String getSampleNumber()
    {
        return getString("sampleNumber");
    }
    public void setSampleNumber(String item)
    {
        setString("sampleNumber", item);
    }
    /**
     * Object:质检单's 扣价（元/吨）property 
     */
    public java.math.BigDecimal getTakeOffPrice()
    {
        return getBigDecimal("takeOffPrice");
    }
    public void setTakeOffPrice(java.math.BigDecimal item)
    {
        setBigDecimal("takeOffPrice", item);
    }
    /**
     * Object:质检单's 扣价（元/公斤）property 
     */
    public java.math.BigDecimal getTakeOffBasePrice()
    {
        return getBigDecimal("takeOffBasePrice");
    }
    public void setTakeOffBasePrice(java.math.BigDecimal item)
    {
        setBigDecimal("takeOffBasePrice", item);
    }
    /**
     * Object:质检单's 扣重（公斤）property 
     */
    public java.math.BigDecimal getTakeOffWeight()
    {
        return getBigDecimal("takeOffWeight");
    }
    public void setTakeOffWeight(java.math.BigDecimal item)
    {
        setBigDecimal("takeOffWeight", item);
    }
    /**
     * Object: 质检单 's 采购订单 property 
     */
    public com.kingdee.eas.scm.sm.pur.PurOrderInfo getPurOrder()
    {
        return (com.kingdee.eas.scm.sm.pur.PurOrderInfo)get("purOrder");
    }
    public void setPurOrder(com.kingdee.eas.scm.sm.pur.PurOrderInfo item)
    {
        put("purOrder", item);
    }
    /**
     * Object:质检单's 采购订单编码property 
     */
    public String getPurOrderNumber()
    {
        return getString("purOrderNumber");
    }
    public void setPurOrderNumber(String item)
    {
        setString("purOrderNumber", item);
    }
    /**
     * Object:质检单's 扣价后单价（元/公斤）property 
     */
    public java.math.BigDecimal getPriceAfterTakeOff()
    {
        return getBigDecimal("priceAfterTakeOff");
    }
    public void setPriceAfterTakeOff(java.math.BigDecimal item)
    {
        setBigDecimal("priceAfterTakeOff", item);
    }
    /**
     * Object:质检单's 扣价前单价（元/公斤）property 
     */
    public java.math.BigDecimal getPriceBeforeTakeOff()
    {
        return getBigDecimal("priceBeforeTakeOff");
    }
    public void setPriceBeforeTakeOff(java.math.BigDecimal item)
    {
        setBigDecimal("priceBeforeTakeOff", item);
    }
    /**
     * Object:质检单's 生产厂家property 
     */
    public String getProductFactory()
    {
        return getString("productFactory");
    }
    public void setProductFactory(String item)
    {
        setString("productFactory", item);
    }
    /**
     * Object:质检单's 送货人property 
     */
    public String getSendPerson()
    {
        return getString("sendPerson");
    }
    public void setSendPerson(String item)
    {
        setString("sendPerson", item);
    }
    /**
     * Object:质检单's 卸货地点property 
     */
    public String getUnloadArea()
    {
        return getString("unloadArea");
    }
    public void setUnloadArea(String item)
    {
        setString("unloadArea", item);
    }
    /**
     * Object:质检单's 合同条款property 
     */
    public String getContractItem()
    {
        return getString("contractItem");
    }
    public void setContractItem(String item)
    {
        setString("contractItem", item);
    }
    /**
     * Object:质检单's 应扣金额property 
     */
    public java.math.BigDecimal getBuckAmount()
    {
        return getBigDecimal("BuckAmount");
    }
    public void setBuckAmount(java.math.BigDecimal item)
    {
        setBigDecimal("BuckAmount", item);
    }
    /**
     * Object:质检单's 实际扣款property 
     */
    public java.math.BigDecimal getRealAmount()
    {
        return getBigDecimal("realAmount");
    }
    public void setRealAmount(java.math.BigDecimal item)
    {
        setBigDecimal("realAmount", item);
    }
    /**
     * Object:质检单's 过磅净重property 
     */
    public java.math.BigDecimal getSumweight()
    {
        return getBigDecimal("sumweight");
    }
    public void setSumweight(java.math.BigDecimal item)
    {
        setBigDecimal("sumweight", item);
    }
    /**
     * Object:质检单's 总检验结论property 
     */
    public com.kingdee.eas.farm.feedfactory.QCReturn getTotalcon()
    {
        return com.kingdee.eas.farm.feedfactory.QCReturn.getEnum(getString("totalcon"));
    }
    public void setTotalcon(com.kingdee.eas.farm.feedfactory.QCReturn item)
    {
		if (item != null) {
        setString("totalcon", item.getValue());
		}
    }
    /**
     * Object:质检单's 是否过磅property 
     */
    public boolean isIsWeight()
    {
        return getBoolean("isWeight");
    }
    public void setIsWeight(boolean item)
    {
        setBoolean("isWeight", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D62CF0D2");
    }
}
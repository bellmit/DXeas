package com.kingdee.eas.farm.stocking.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractEggSettleBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractEggSettleBillInfo()
    {
        this("id");
    }
    protected AbstractEggSettleBillInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.stocking.hatch.EggSettleBillEntryCollection());
    }
    /**
     * Object: 种蛋结算单 's 分录 property 
     */
    public com.kingdee.eas.farm.stocking.hatch.EggSettleBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.stocking.hatch.EggSettleBillEntryCollection)get("entrys");
    }
    /**
     * Object:种蛋结算单's 是否生成凭证property 
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
     * Object:种蛋结算单's 单据状态property 
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
     * Object: 种蛋结算单 's 财务组织 property 
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
     * Object:种蛋结算单's 审核时间property 
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
     * Object: 种蛋结算单 's 库存组织 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStorageOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("storageOrgUnit");
    }
    public void setStorageOrgUnit(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("storageOrgUnit", item);
    }
    /**
     * Object:种蛋结算单's 初始化单据property 
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
     * Object:种蛋结算单's 种蛋来源property 
     */
    public com.kingdee.eas.farm.hatch.EggSourceType getEggSource()
    {
        return com.kingdee.eas.farm.hatch.EggSourceType.getEnum(getInt("eggSource"));
    }
    public void setEggSource(com.kingdee.eas.farm.hatch.EggSourceType item)
    {
		if (item != null) {
        setInt("eggSource", item.getValue());
		}
    }
    /**
     * Object:种蛋结算单's 合格率property 
     */
    public java.math.BigDecimal getQualityRate()
    {
        return getBigDecimal("qualityRate");
    }
    public void setQualityRate(java.math.BigDecimal item)
    {
        setBigDecimal("qualityRate", item);
    }
    /**
     * Object:种蛋结算单's 破损率property 
     */
    public java.math.BigDecimal getBadRate()
    {
        return getBigDecimal("badRate");
    }
    public void setBadRate(java.math.BigDecimal item)
    {
        setBigDecimal("badRate", item);
    }
    /**
     * Object: 种蛋结算单 's 养殖户 property 
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
     * Object:种蛋结算单's 结算金额property 
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
     * Object:种蛋结算单's 来源接收单property 
     */
    public String getSrcRecBill()
    {
        return getString("srcRecBill");
    }
    public void setSrcRecBill(String item)
    {
        setString("srcRecBill", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("7DD0D62D");
    }
}
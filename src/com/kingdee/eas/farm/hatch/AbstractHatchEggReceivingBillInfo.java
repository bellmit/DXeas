package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractHatchEggReceivingBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractHatchEggReceivingBillInfo()
    {
        this("id");
    }
    protected AbstractHatchEggReceivingBillInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.hatch.HatchEggReceivingBillEntryCollection());
        put("GoodsEntrys", new com.kingdee.eas.farm.hatch.HatchEggReceivingBillGoodsEntryCollection());
    }
    /**
     * Object: 种蛋接收单 's 分录 property 
     */
    public com.kingdee.eas.farm.hatch.HatchEggReceivingBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.hatch.HatchEggReceivingBillEntryCollection)get("entrys");
    }
    /**
     * Object:种蛋接收单's 是否生成凭证property 
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
     * Object:种蛋接收单's 种蛋来源类型property 
     */
    public com.kingdee.eas.farm.hatch.EggSourceType getEggSourceType()
    {
        return com.kingdee.eas.farm.hatch.EggSourceType.getEnum(getInt("EggSourceType"));
    }
    public void setEggSourceType(com.kingdee.eas.farm.hatch.EggSourceType item)
    {
		if (item != null) {
        setInt("EggSourceType", item.getValue());
		}
    }
    /**
     * Object: 种蛋接收单 's 孵化场 property 
     */
    public com.kingdee.eas.farm.hatch.HatchBaseDataInfo getHatchFactory()
    {
        return (com.kingdee.eas.farm.hatch.HatchBaseDataInfo)get("hatchFactory");
    }
    public void setHatchFactory(com.kingdee.eas.farm.hatch.HatchBaseDataInfo item)
    {
        put("hatchFactory", item);
    }
    /**
     * Object:种蛋接收单's 审核时间property 
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
     * Object:种蛋接收单's 接收批次号property 
     */
    public String getReceivingLot()
    {
        return getString("receivingLot");
    }
    public void setReceivingLot(String item)
    {
        setString("receivingLot", item);
    }
    /**
     * Object:种蛋接收单's 状态property 
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
     * Object: 种蛋接收单 's 库存组织 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getKczz()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("kczz");
    }
    public void setKczz(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("kczz", item);
    }
    /**
     * Object:种蛋接收单's 品系property 
     */
    public com.kingdee.eas.farm.stocking.hatch.GenderType getGrendt()
    {
        return com.kingdee.eas.farm.stocking.hatch.GenderType.getEnum(getString("grendt"));
    }
    public void setGrendt(com.kingdee.eas.farm.stocking.hatch.GenderType item)
    {
		if (item != null) {
        setString("grendt", item.getValue());
		}
    }
    /**
     * Object: 种蛋接收单 's 种蛋交接表 property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.TheEggTableInfo getTheEggTable()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.TheEggTableInfo)get("TheEggTable");
    }
    public void setTheEggTable(com.kingdee.eas.farm.stocking.processbizill.TheEggTableInfo item)
    {
        put("TheEggTable", item);
    }
    /**
     * Object:种蛋接收单's 交蛋日期property 
     */
    public java.util.Date getReceivingDate()
    {
        return getDate("receivingDate");
    }
    public void setReceivingDate(java.util.Date item)
    {
        setDate("receivingDate", item);
    }
    /**
     * Object: 种蛋接收单 's 商品蛋分录 property 
     */
    public com.kingdee.eas.farm.hatch.HatchEggReceivingBillGoodsEntryCollection getGoodsEntrys()
    {
        return (com.kingdee.eas.farm.hatch.HatchEggReceivingBillGoodsEntryCollection)get("GoodsEntrys");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("08FC7214");
    }
}
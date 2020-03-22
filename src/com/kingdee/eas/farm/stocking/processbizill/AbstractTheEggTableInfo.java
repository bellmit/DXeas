package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractTheEggTableInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractTheEggTableInfo()
    {
        this("id");
    }
    protected AbstractTheEggTableInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.stocking.processbizill.TheEggTableEntryCollection());
    }
    /**
     * Object: �͵��� 's ��¼ property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.TheEggTableEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.TheEggTableEntryCollection)get("entrys");
    }
    /**
     * Object:�͵���'s �Ƿ�����ƾ֤property 
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
     * Object:�͵���'s ����״̬property 
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
     * Object: �͵��� 's ������֯ property 
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
     * Object:�͵���'s ���ʱ��property 
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
     * Object: �͵��� 's �����֯ property 
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
     * Object:�͵���'s �ֵ���Դproperty 
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
     * Object:�͵���'s ����property 
     */
    public int getBIMUDF0129()
    {
        return getInt("BIMUDF0129");
    }
    public void setBIMUDF0129(int item)
    {
        setInt("BIMUDF0129", item);
    }
    /**
     * Object:�͵���'s Ʒϵproperty 
     */
    public com.kingdee.eas.farm.stocking.hatch.GenderType getGrentP()
    {
        return com.kingdee.eas.farm.stocking.hatch.GenderType.getEnum(getString("GrentP"));
    }
    public void setGrentP(com.kingdee.eas.farm.stocking.hatch.GenderType item)
    {
		if (item != null) {
        setString("GrentP", item.getValue());
		}
    }
    /**
     * Object: �͵��� 's ������ property 
     */
    public com.kingdee.eas.farm.hatch.HatchBaseDataInfo getHatchfactory()
    {
        return (com.kingdee.eas.farm.hatch.HatchBaseDataInfo)get("hatchfactory");
    }
    public void setHatchfactory(com.kingdee.eas.farm.hatch.HatchBaseDataInfo item)
    {
        put("hatchfactory", item);
    }
    /**
     * Object: �͵��� 's ��ֳ�ձ� property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo getStockingBillNum()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo)get("stockingBillNum");
    }
    public void setStockingBillNum(com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo item)
    {
        put("stockingBillNum", item);
    }
    /**
     * Object:�͵���'s ˾��property 
     */
    public String getDriver()
    {
        return getString("driver");
    }
    public void setDriver(String item)
    {
        setString("driver", item);
    }
    /**
     * Object:�͵���'s ���ƺ�property 
     */
    public String getCarNum()
    {
        return getString("carNum");
    }
    public void setCarNum(String item)
    {
        setString("carNum", item);
    }
    /**
     * Object:�͵���'s �Ƿ����ɿ�����property 
     */
    public boolean isIsinventory()
    {
        return getBoolean("isinventory");
    }
    public void setIsinventory(boolean item)
    {
        setBoolean("isinventory", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("92FD45D5");
    }
}
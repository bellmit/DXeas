package com.kingdee.eas.farm.breed.layegg;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractLayEggPlanInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractLayEggPlanInfo()
    {
        this("id");
    }
    protected AbstractLayEggPlanInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.breed.layegg.LayEggPlanEntryCollection());
    }
    /**
     * Object: �����ƻ� 's ��¼ property 
     */
    public com.kingdee.eas.farm.breed.layegg.LayEggPlanEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.breed.layegg.LayEggPlanEntryCollection)get("entrys");
    }
    /**
     * Object:�����ƻ�'s �Ƿ�����ƾ֤property 
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
     * Object: �����ƻ� 's ������ property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getFarm()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("farm", item);
    }
    /**
     * Object:�����ƻ�'s ״̬property 
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
     * Object: �����ƻ� 's �ڼ䣨�·ݣ� property 
     */
    public com.kingdee.eas.basedata.assistant.PeriodInfo getPeriod()
    {
        return (com.kingdee.eas.basedata.assistant.PeriodInfo)get("period");
    }
    public void setPeriod(com.kingdee.eas.basedata.assistant.PeriodInfo item)
    {
        put("period", item);
    }
    /**
     * Object:�����ƻ�'s ���ʱ��property 
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
     * Object:�����ƻ�'s �³�����property 
     */
    public int getInitWeek()
    {
        return getInt("initWeek");
    }
    public void setInitWeek(int item)
    {
        setInt("initWeek", item);
    }
    /**
     * Object:�����ƻ�'s �³�����property 
     */
    public int getInitDays()
    {
        return getInt("initDays");
    }
    public void setInitDays(int item)
    {
        setInt("initDays", item);
    }
    /**
     * Object:�����ƻ�'s �³���������ĸ����property 
     */
    public int getInitHenQty()
    {
        return getInt("initHenQty");
    }
    public void setInitHenQty(int item)
    {
        setInt("initHenQty", item);
    }
    /**
     * Object:�����ƻ�'s ��������property 
     */
    public java.util.Date getBeginDate()
    {
        return getDate("beginDate");
    }
    public void setBeginDate(java.util.Date item)
    {
        setDate("beginDate", item);
    }
    /**
     * Object:�����ƻ�'s ˫�Ƶ�����property 
     */
    public java.math.BigDecimal getTxtallDoubleYolkEggQty()
    {
        return getBigDecimal("txtallDoubleYolkEggQty");
    }
    public void setTxtallDoubleYolkEggQty(java.math.BigDecimal item)
    {
        setBigDecimal("txtallDoubleYolkEggQty", item);
    }
    /**
     * Object:�����ƻ�'s �Ƶ�����property 
     */
    public java.math.BigDecimal getAllBrokenEggQty()
    {
        return getBigDecimal("allBrokenEggQty");
    }
    public void setAllBrokenEggQty(java.math.BigDecimal item)
    {
        setBigDecimal("allBrokenEggQty", item);
    }
    /**
     * Object:�����ƻ�'s ���ε�����property 
     */
    public java.math.BigDecimal getAllFreakEggQty()
    {
        return getBigDecimal("allFreakEggQty");
    }
    public void setAllFreakEggQty(java.math.BigDecimal item)
    {
        setBigDecimal("allFreakEggQty", item);
    }
    /**
     * Object:�����ƻ�'s �ϸ�����property 
     */
    public java.math.BigDecimal getAllUpEggQty()
    {
        return getBigDecimal("allUpEggQty");
    }
    public void setAllUpEggQty(java.math.BigDecimal item)
    {
        setBigDecimal("allUpEggQty", item);
    }
    /**
     * Object:�����ƻ�'s ��������property 
     */
    public java.math.BigDecimal getAllEggQty()
    {
        return getBigDecimal("allEggQty");
    }
    public void setAllEggQty(java.math.BigDecimal item)
    {
        setBigDecimal("allEggQty", item);
    }
    /**
     * Object:�����ƻ�'s �ϸ񵰿��property 
     */
    public java.math.BigDecimal getQuantityEggs()
    {
        return getBigDecimal("quantityEggs");
    }
    public void setQuantityEggs(java.math.BigDecimal item)
    {
        setBigDecimal("quantityEggs", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("53C73AD7");
    }
}
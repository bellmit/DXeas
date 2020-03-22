package com.kingdee.eas.farm.dayratecost;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDayRateCostDetailInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractDayRateCostDetailInfo()
    {
        this("id");
    }
    protected AbstractDayRateCostDetailInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.dayratecost.DayRateCostDetailEntryCollection());
    }
    /**
     * Object: �������ճɱ���ϸ�� 's ��¼ property 
     */
    public com.kingdee.eas.farm.dayratecost.DayRateCostDetailEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.dayratecost.DayRateCostDetailEntryCollection)get("entrys");
    }
    /**
     * Object:�������ճɱ���ϸ��'s �Ƿ�����ƾ֤property 
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
     * Object: �������ճɱ���ϸ�� 's ������֯ property 
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
     * Object:�������ճɱ���ϸ��'s ���ʱ��property 
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
     * Object: �������ճɱ���ϸ�� 's �ɱ����� property 
     */
    public com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo getCostCentor()
    {
        return (com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo)get("costCentor");
    }
    public void setCostCentor(com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo item)
    {
        put("costCentor", item);
    }
    /**
     * Object: �������ճɱ���ϸ�� 's �ڼ� property 
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
     * Object:�������ճɱ���ϸ��'s ����property 
     */
    public int getWeekDay()
    {
        return getInt("weekDay");
    }
    public void setWeekDay(int item)
    {
        setInt("weekDay", item);
    }
    /**
     * Object:�������ճɱ���ϸ��'s ����property 
     */
    public int getWeek()
    {
        return getInt("week");
    }
    public void setWeek(int item)
    {
        setInt("week", item);
    }
    /**
     * Object:�������ճɱ���ϸ��'s  ״̬property 
     */
    public int getStatus()
    {
        return getInt("status");
    }
    public void setStatus(int item)
    {
        setInt("status", item);
    }
    /**
     * Object:�������ճɱ���ϸ��'s ��ĩֻ��property 
     */
    public int getEndBreedQty()
    {
        return getInt("endBreedQty");
    }
    public void setEndBreedQty(int item)
    {
        setInt("endBreedQty", item);
    }
    /**
     * Object:�������ճɱ���ϸ��'s �䶯ֻ��property 
     */
    public int getOccurBreedQty()
    {
        return getInt("occurBreedQty");
    }
    public void setOccurBreedQty(int item)
    {
        setInt("occurBreedQty", item);
    }
    /**
     * Object:�������ճɱ���ϸ��'s �ڳ�ֻ��property 
     */
    public int getBeginBreedQty()
    {
        return getInt("beginBreedQty");
    }
    public void setBeginBreedQty(int item)
    {
        setInt("beginBreedQty", item);
    }
    /**
     * Object: �������ճɱ���ϸ�� 's ��ֳ�� property 
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
     * Object: �������ճɱ���ϸ�� 's ��ֳ�� property 
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
     * Object: �������ճɱ���ϸ�� 's ���� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmInfo getHouse()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmInfo)get("house");
    }
    public void setHouse(com.kingdee.eas.farm.stocking.basedata.FarmInfo item)
    {
        put("house", item);
    }
    /**
     * Object:�������ճɱ���ϸ��'s ��ʼ������property 
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
     * Object:�������ճɱ���ϸ��'s �׶ν�ת���property 
     */
    public boolean isIsStageBalance()
    {
        return getBoolean("isStageBalance");
    }
    public void setIsStageBalance(boolean item)
    {
        setBoolean("isStageBalance", item);
    }
    /**
     * Object: �������ճɱ���ϸ�� 's ��ֳ���� property 
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
     * Object:�������ճɱ���ϸ��'s ��ֳ�׶�property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmStageEnum getBreedStage()
    {
        return com.kingdee.eas.farm.stocking.basedata.FarmStageEnum.getEnum(getInt("breedStage"));
    }
    public void setBreedStage(com.kingdee.eas.farm.stocking.basedata.FarmStageEnum item)
    {
		if (item != null) {
        setInt("breedStage", item.getValue());
		}
    }
    /**
     * Object:�������ճɱ���ϸ��'s ��Ӧ�ս��property 
     */
    public java.math.BigDecimal getAllArAmount()
    {
        return getBigDecimal("allArAmount");
    }
    public void setAllArAmount(java.math.BigDecimal item)
    {
        setBigDecimal("allArAmount", item);
    }
    /**
     * Object:�������ճɱ���ϸ��'s ����״̬property 
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
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("18C12B75");
    }
}
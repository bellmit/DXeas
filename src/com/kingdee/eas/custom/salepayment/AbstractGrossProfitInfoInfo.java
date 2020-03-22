package com.kingdee.eas.custom.salepayment;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractGrossProfitInfoInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractGrossProfitInfoInfo()
    {
        this("id");
    }
    protected AbstractGrossProfitInfoInfo(String pkField)
    {
        super(pkField);
        put("RecEntry", new com.kingdee.eas.custom.salepayment.GrossProfitInfoRecEntryCollection());
        put("entrys", new com.kingdee.eas.custom.salepayment.GrossProfitInfoEntryCollection());
    }
    /**
     * Object: ë��������� 's ��¼ property 
     */
    public com.kingdee.eas.custom.salepayment.GrossProfitInfoEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.salepayment.GrossProfitInfoEntryCollection)get("entrys");
    }
    /**
     * Object:ë���������'s �Ƿ�����ƾ֤property 
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
     * Object: ë��������� 's ��˾ property 
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
     * Object:ë���������'s ��property 
     */
    public int getYear()
    {
        return getInt("year");
    }
    public void setYear(int item)
    {
        setInt("year", item);
    }
    /**
     * Object:ë���������'s ��property 
     */
    public int getMonth()
    {
        return getInt("month");
    }
    public void setMonth(int item)
    {
        setInt("month", item);
    }
    /**
     * Object:ë���������'s ���ʱ��property 
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
     * Object:ë���������'s ������ë��property 
     */
    public java.math.BigDecimal getAllGrossProfit()
    {
        return getBigDecimal("allGrossProfit");
    }
    public void setAllGrossProfit(java.math.BigDecimal item)
    {
        setBigDecimal("allGrossProfit", item);
    }
    /**
     * Object:ë���������'s ״̬property 
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
     * Object:ë���������'s ָ������property 
     */
    public com.kingdee.eas.custom.salepayment.IndexType getIndexType()
    {
        return com.kingdee.eas.custom.salepayment.IndexType.getEnum(getString("indexType"));
    }
    public void setIndexType(com.kingdee.eas.custom.salepayment.IndexType item)
    {
		if (item != null) {
        setString("indexType", item.getValue());
		}
    }
    /**
     * Object: ë��������� 's ����������� property 
     */
    public com.kingdee.eas.custom.salepayment.SalerStimulateSetInfo getSaleStimulateInfo()
    {
        return (com.kingdee.eas.custom.salepayment.SalerStimulateSetInfo)get("saleStimulateInfo");
    }
    public void setSaleStimulateInfo(com.kingdee.eas.custom.salepayment.SalerStimulateSetInfo item)
    {
        put("saleStimulateInfo", item);
    }
    /**
     * Object:ë���������'s ����property 
     */
    public com.kingdee.eas.custom.salepayment.Quarter getQuarter()
    {
        return com.kingdee.eas.custom.salepayment.Quarter.getEnum(getString("quarter"));
    }
    public void setQuarter(com.kingdee.eas.custom.salepayment.Quarter item)
    {
		if (item != null) {
        setString("quarter", item.getValue());
		}
    }
    /**
     * Object:ë���������'s ���»ؿ��property 
     */
    public java.math.BigDecimal getMonthRecAmount()
    {
        return getBigDecimal("monthRecAmount");
    }
    public void setMonthRecAmount(java.math.BigDecimal item)
    {
        setBigDecimal("monthRecAmount", item);
    }
    /**
     * Object:ë���������'s ����˰���۶�property 
     */
    public java.math.BigDecimal getAllNoTaxAmount()
    {
        return getBigDecimal("allNoTaxAmount");
    }
    public void setAllNoTaxAmount(java.math.BigDecimal item)
    {
        setBigDecimal("allNoTaxAmount", item);
    }
    /**
     * Object:ë���������'s ���۱�׼�ɱ�property 
     */
    public java.math.BigDecimal getAllStandardCost()
    {
        return getBigDecimal("allStandardCost");
    }
    public void setAllStandardCost(java.math.BigDecimal item)
    {
        setBigDecimal("allStandardCost", item);
    }
    /**
     * Object: ë��������� 's ����Ա property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getSaler()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("saler");
    }
    public void setSaler(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("saler", item);
    }
    /**
     * Object:ë���������'s �ؿ��׼�ɱ�property 
     */
    public java.math.BigDecimal getRecStandardCost()
    {
        return getBigDecimal("recStandardCost");
    }
    public void setRecStandardCost(java.math.BigDecimal item)
    {
        setBigDecimal("recStandardCost", item);
    }
    /**
     * Object:ë���������'s �ؿ���ë��property 
     */
    public java.math.BigDecimal getRecGrossProfit()
    {
        return getBigDecimal("recGrossProfit");
    }
    public void setRecGrossProfit(java.math.BigDecimal item)
    {
        setBigDecimal("recGrossProfit", item);
    }
    /**
     * Object: ë��������� 's ���ۻؿ���ϸ property 
     */
    public com.kingdee.eas.custom.salepayment.GrossProfitInfoRecEntryCollection getRecEntry()
    {
        return (com.kingdee.eas.custom.salepayment.GrossProfitInfoRecEntryCollection)get("RecEntry");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("2D158D02");
    }
}
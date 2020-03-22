package com.kingdee.eas.custom.salepayment;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMonthFeeInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractMonthFeeInfo()
    {
        this("id");
    }
    protected AbstractMonthFeeInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.salepayment.MonthFeeEntryCollection());
    }
    /**
     * Object: �·����ۼ� 's ��¼ property 
     */
    public com.kingdee.eas.custom.salepayment.MonthFeeEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.salepayment.MonthFeeEntryCollection)get("entrys");
    }
    /**
     * Object:�·����ۼ�'s �Ƿ�����ƾ֤property 
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
     * Object:�·����ۼ�'s ��property 
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
     * Object:�·����ۼ�'s ��property 
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
     * Object:�·����ۼ�'s ����property 
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
     * Object:�·����ۼ�'s ���ʱ��property 
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
     * Object: �·����ۼ� 's ��˾ property 
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
     * Object:�·����ۼ�'s ָ������property 
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
     * Object: �·����ۼ� 's ����������� property 
     */
    public com.kingdee.eas.custom.salepayment.SalerStimulateSetInfo getSaleStimulateSet()
    {
        return (com.kingdee.eas.custom.salepayment.SalerStimulateSetInfo)get("saleStimulateSet");
    }
    public void setSaleStimulateSet(com.kingdee.eas.custom.salepayment.SalerStimulateSetInfo item)
    {
        put("saleStimulateSet", item);
    }
    /**
     * Object:�·����ۼ�'s ״̬property 
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
     * Object: �·����ۼ� 's ����Ա property 
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
     * Object:�·����ۼ�'s ��˾������property 
     */
    public java.math.BigDecimal getCompanySaleQty()
    {
        return getBigDecimal("companySaleQty");
    }
    public void setCompanySaleQty(java.math.BigDecimal item)
    {
        setBigDecimal("companySaleQty", item);
    }
    /**
     * Object:�·����ۼ�'s ������property 
     */
    public java.math.BigDecimal getSaleQty()
    {
        return getBigDecimal("saleQty");
    }
    public void setSaleQty(java.math.BigDecimal item)
    {
        setBigDecimal("saleQty", item);
    }
    /**
     * Object:�·����ۼ�'s ��̯����property 
     */
    public java.math.BigDecimal getSharedFeeAmount()
    {
        return getBigDecimal("sharedFeeAmount");
    }
    public void setSharedFeeAmount(java.math.BigDecimal item)
    {
        setBigDecimal("sharedFeeAmount", item);
    }
    /**
     * Object:�·����ۼ�'s ���˷���property 
     */
    public java.math.BigDecimal getOwnFeeAmount()
    {
        return getBigDecimal("ownFeeAmount");
    }
    public void setOwnFeeAmount(java.math.BigDecimal item)
    {
        setBigDecimal("ownFeeAmount", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("AFB5FBDA");
    }
}
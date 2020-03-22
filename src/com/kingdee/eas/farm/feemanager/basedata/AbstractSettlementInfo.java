package com.kingdee.eas.farm.feemanager.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSettlementInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractSettlementInfo()
    {
        this("id");
    }
    protected AbstractSettlementInfo(String pkField)
    {
        super(pkField);
        put("ME", new com.kingdee.eas.farm.feemanager.basedata.SettlementMECollection());
        put("CE", new com.kingdee.eas.farm.feemanager.basedata.SettlementCECollection());
        put("DE", new com.kingdee.eas.farm.feemanager.basedata.SettlementDECollection());
    }
    /**
     * Object: �������� 's ��� property 
     */
    public com.kingdee.eas.farm.feemanager.basedata.SettlementTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.feemanager.basedata.SettlementTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.feemanager.basedata.SettlementTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:��������'s ��Чʱ��property 
     */
    public java.util.Date getStartdate()
    {
        return getDate("startdate");
    }
    public void setStartdate(java.util.Date item)
    {
        setDate("startdate", item);
    }
    /**
     * Object:��������'s ʧЧʱ��property 
     */
    public java.util.Date getEnddate()
    {
        return getDate("enddate");
    }
    public void setEnddate(java.util.Date item)
    {
        setDate("enddate", item);
    }
    /**
     * Object: �������� 's ������֯ property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompanyOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("companyOrgUnit");
    }
    public void setCompanyOrgUnit(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("companyOrgUnit", item);
    }
    /**
     * Object: �������� 's �������� property 
     */
    public com.kingdee.eas.farm.feemanager.basedata.SettlementMECollection getME()
    {
        return (com.kingdee.eas.farm.feemanager.basedata.SettlementMECollection)get("ME");
    }
    /**
     * Object:��������'s ����״̬property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getState()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("state"));
    }
    public void setState(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("state", item.getValue());
		}
    }
    /**
     * Object: �������� 's Զ���벹�� property 
     */
    public com.kingdee.eas.farm.feemanager.basedata.SettlementDECollection getDE()
    {
        return (com.kingdee.eas.farm.feemanager.basedata.SettlementDECollection)get("DE");
    }
    /**
     * Object:��������'s Ѽ�粹������property 
     */
    public java.math.BigDecimal getDuckamount()
    {
        return getBigDecimal("duckamount");
    }
    public void setDuckamount(java.math.BigDecimal item)
    {
        setBigDecimal("duckamount", item);
    }
    /**
     * Object: �������� 's ���͵��� property 
     */
    public com.kingdee.eas.farm.feemanager.basedata.OilPriceInfo getOilprice()
    {
        return (com.kingdee.eas.farm.feemanager.basedata.OilPriceInfo)get("oilprice");
    }
    public void setOilprice(com.kingdee.eas.farm.feemanager.basedata.OilPriceInfo item)
    {
        put("oilprice", item);
    }
    /**
     * Object:��������'s ʵ���˷�property 
     */
    public java.math.BigDecimal getPolicyfreight()
    {
        return getBigDecimal("policyfreight");
    }
    public void setPolicyfreight(java.math.BigDecimal item)
    {
        setBigDecimal("policyfreight", item);
    }
    /**
     * Object:��������'s �ͼ�����property 
     */
    public java.math.BigDecimal getOilfloat()
    {
        return getBigDecimal("oilfloat");
    }
    public void setOilfloat(java.math.BigDecimal item)
    {
        setBigDecimal("oilfloat", item);
    }
    /**
     * Object:��������'s �˷�����property 
     */
    public java.math.BigDecimal getFrightfloat()
    {
        return getBigDecimal("frightfloat");
    }
    public void setFrightfloat(java.math.BigDecimal item)
    {
        setBigDecimal("frightfloat", item);
    }
    /**
     * Object: �������� 's ���ͱ�׼���� property 
     */
    public com.kingdee.eas.farm.feemanager.basedata.OilStandPriceInfo getOilstandprice()
    {
        return (com.kingdee.eas.farm.feemanager.basedata.OilStandPriceInfo)get("oilstandprice");
    }
    public void setOilstandprice(com.kingdee.eas.farm.feemanager.basedata.OilStandPriceInfo item)
    {
        put("oilstandprice", item);
    }
    /**
     * Object: �������� 's ���� property 
     */
    public com.kingdee.eas.farm.feemanager.basedata.SettlementCECollection getCE()
    {
        return (com.kingdee.eas.farm.feemanager.basedata.SettlementCECollection)get("CE");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B488B9D5");
    }
}
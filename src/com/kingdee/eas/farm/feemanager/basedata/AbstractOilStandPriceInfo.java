package com.kingdee.eas.farm.feemanager.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractOilStandPriceInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractOilStandPriceInfo()
    {
        this("id");
    }
    protected AbstractOilStandPriceInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ���ͱ�׼�۸�ά�� 's ��� property 
     */
    public com.kingdee.eas.farm.feemanager.basedata.OilStandPriceTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.feemanager.basedata.OilStandPriceTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.feemanager.basedata.OilStandPriceTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:���ͱ�׼�۸�ά��'s ��Ʒ����property 
     */
    public String getOilname()
    {
        return getString("oilname");
    }
    public void setOilname(String item)
    {
        setString("oilname", item);
    }
    /**
     * Object:���ͱ�׼�۸�ά��'s ��Ч����property 
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
     * Object:���ͱ�׼�۸�ά��'s ʧЧ����property 
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
     * Object:���ͱ�׼�۸�ά��'s ����״̬property 
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
     * Object:���ͱ�׼�۸�ά��'s ��׼�۸�property 
     */
    public java.math.BigDecimal getStandardprice()
    {
        return getBigDecimal("standardprice");
    }
    public void setStandardprice(java.math.BigDecimal item)
    {
        setBigDecimal("standardprice", item);
    }
    /**
     * Object: ���ͱ�׼�۸�ά�� 's ������֯ property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompanyorgunit()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("companyorgunit");
    }
    public void setCompanyorgunit(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("companyorgunit", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("6738DE59");
    }
}
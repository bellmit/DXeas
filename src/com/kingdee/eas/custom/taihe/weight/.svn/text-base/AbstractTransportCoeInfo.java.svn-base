package com.kingdee.eas.custom.taihe.weight;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractTransportCoeInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlDataBaseInfo implements Serializable 
{
    public AbstractTransportCoeInfo()
    {
        this("id");
    }
    protected AbstractTransportCoeInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.custom.taihe.weight.TransportCoeEntryCollection());
    }
    /**
     * Object: 运费计算系数 's 公司 property 
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
     * Object:运费计算系数's 开始日期property 
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
     * Object:运费计算系数's 结束日期property 
     */
    public java.util.Date getEndDate()
    {
        return getDate("endDate");
    }
    public void setEndDate(java.util.Date item)
    {
        setDate("endDate", item);
    }
    /**
     * Object: 运费计算系数 's 运费系数分录 property 
     */
    public com.kingdee.eas.custom.taihe.weight.TransportCoeEntryCollection getEntry()
    {
        return (com.kingdee.eas.custom.taihe.weight.TransportCoeEntryCollection)get("Entry");
    }
    /**
     * Object:运费计算系数's 胴体单价property 
     */
    public java.math.BigDecimal getCarcassPrice()
    {
        return getBigDecimal("carcassPrice");
    }
    public void setCarcassPrice(java.math.BigDecimal item)
    {
        setBigDecimal("carcassPrice", item);
    }
    /**
     * Object:运费计算系数's 实现类property 
     */
    public String getDAOImpl()
    {
        return getString("DAOImpl");
    }
    public void setDAOImpl(String item)
    {
        setString("DAOImpl", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("FA931AC6");
    }
}
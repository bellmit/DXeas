package com.kingdee.eas.farm.feemanager.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCarriageFormatInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractCarriageFormatInfo()
    {
        this("id");
    }
    protected AbstractCarriageFormatInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 车厢 's 组别 property 
     */
    public com.kingdee.eas.farm.feemanager.basedata.CarriageFormatTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.feemanager.basedata.CarriageFormatTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.feemanager.basedata.CarriageFormatTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:车厢's 车厢名称property 
     */
    public String getCarriagename()
    {
        return getString("carriagename");
    }
    public void setCarriagename(String item)
    {
        setString("carriagename", item);
    }
    /**
     * Object:车厢's 车厢规格property 
     */
    public String getCarriagesize()
    {
        return getString("carriagesize");
    }
    public void setCarriagesize(String item)
    {
        setString("carriagesize", item);
    }
    /**
     * Object:车厢's 资料状态property 
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
     * Object:车厢's 每公里运费property 
     */
    public java.math.BigDecimal getFKilpfreightkil()
    {
        return getBigDecimal("FKilpfreightkil");
    }
    public void setFKilpfreightkil(java.math.BigDecimal item)
    {
        setBigDecimal("FKilpfreightkil", item);
    }
    /**
     * Object: 车厢 's 财务组织 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompanyOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("CompanyOrgUnit");
    }
    public void setCompanyOrgUnit(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("CompanyOrgUnit", item);
    }
    /**
     * Object:车厢's 生效日期property 
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
     * Object:车厢's 失效日期property 
     */
    public java.util.Date getEnddate()
    {
        return getDate("enddate");
    }
    public void setEnddate(java.util.Date item)
    {
        setDate("enddate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("78A06FD7");
    }
}
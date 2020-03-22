package com.kingdee.eas.custom.salepayment;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCompanyTargetAreaEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCompanyTargetAreaEntryInfo()
    {
        this("id");
    }
    protected AbstractCompanyTargetAreaEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 大区指标 's null property 
     */
    public com.kingdee.eas.custom.salepayment.CompanyTargetInfo getParent()
    {
        return (com.kingdee.eas.custom.salepayment.CompanyTargetInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.salepayment.CompanyTargetInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 大区指标 's 大区编码 property 
     */
    public com.kingdee.eas.custom.salepayment.AreaSetInfo getArea()
    {
        return (com.kingdee.eas.custom.salepayment.AreaSetInfo)get("area");
    }
    public void setArea(com.kingdee.eas.custom.salepayment.AreaSetInfo item)
    {
        put("area", item);
    }
    /**
     * Object:大区指标's 大区名称property 
     */
    public String getAreaName()
    {
        return getString("areaName");
    }
    public void setAreaName(String item)
    {
        setString("areaName", item);
    }
    /**
     * Object:大区指标's 大区经理property 
     */
    public String getAreaManager()
    {
        return getString("areaManager");
    }
    public void setAreaManager(String item)
    {
        setString("areaManager", item);
    }
    /**
     * Object:大区指标's 大区指标（元）property 
     */
    public int getAreaProfitTarget()
    {
        return getInt("areaProfitTarget");
    }
    public void setAreaProfitTarget(int item)
    {
        setInt("areaProfitTarget", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("7B36AB0B");
    }
}
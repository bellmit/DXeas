package com.kingdee.eas.weighbridge;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractWeighLogInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractWeighLogInfo()
    {
        this("id");
    }
    protected AbstractWeighLogInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 过磅记录 's 过磅人 property 
     */
    public com.kingdee.eas.base.permission.UserInfo getUser()
    {
        return (com.kingdee.eas.base.permission.UserInfo)get("user");
    }
    public void setUser(com.kingdee.eas.base.permission.UserInfo item)
    {
        put("user", item);
    }
    /**
     * Object:过磅记录's 车牌号property 
     */
    public String getOtherCarInfo()
    {
        return getString("otherCarInfo");
    }
    public void setOtherCarInfo(String item)
    {
        setString("otherCarInfo", item);
    }
    /**
     * Object: 过磅记录 's 内部车辆 property 
     */
    public com.kingdee.eas.publicdata.CarInfo getCarNumber()
    {
        return (com.kingdee.eas.publicdata.CarInfo)get("carNumber");
    }
    public void setCarNumber(com.kingdee.eas.publicdata.CarInfo item)
    {
        put("carNumber", item);
    }
    /**
     * Object:过磅记录's 过磅重量property 
     */
    public java.math.BigDecimal getWeight()
    {
        return getBigDecimal("weight");
    }
    public void setWeight(java.math.BigDecimal item)
    {
        setBigDecimal("weight", item);
    }
    /**
     * Object:过磅记录's 数据来源property 
     */
    public String getDataSource()
    {
        return getString("dataSource");
    }
    public void setDataSource(String item)
    {
        setString("dataSource", item);
    }
    /**
     * Object: 过磅记录 's 公司 property 
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
     * Object: 过磅记录 's 磅秤 property 
     */
    public com.kingdee.eas.weighbridge.WeighBridgeInfo getPlatform()
    {
        return (com.kingdee.eas.weighbridge.WeighBridgeInfo)get("platform");
    }
    public void setPlatform(com.kingdee.eas.weighbridge.WeighBridgeInfo item)
    {
        put("platform", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("BE8A9903");
    }
}
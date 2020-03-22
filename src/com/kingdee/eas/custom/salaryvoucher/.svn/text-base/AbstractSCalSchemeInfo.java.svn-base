package com.kingdee.eas.custom.salaryvoucher;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSCalSchemeInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractSCalSchemeInfo()
    {
        this("id");
    }
    protected AbstractSCalSchemeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:薪酬方案's 薪酬方案编码property 
     */
    public String getSCalSchemeCode()
    {
        return getString("sCalSchemeCode");
    }
    public void setSCalSchemeCode(String item)
    {
        setString("sCalSchemeCode", item);
    }
    /**
     * Object:薪酬方案's 薪酬方案名称property 
     */
    public String getScalSchemeName()
    {
        return getString("scalSchemeName");
    }
    public void setScalSchemeName(String item)
    {
        setString("scalSchemeName", item);
    }
    /**
     * Object:薪酬方案's 薪酬方案IDproperty 
     */
    public String getScalSchemeID()
    {
        return getString("scalSchemeID");
    }
    public void setScalSchemeID(String item)
    {
        setString("scalSchemeID", item);
    }
    /**
     * Object:薪酬方案's 统计年property 
     */
    public int getPeriodYear()
    {
        return getInt("periodYear");
    }
    public void setPeriodYear(int item)
    {
        setInt("periodYear", item);
    }
    /**
     * Object:薪酬方案's 统计月property 
     */
    public int getPeriodMonth()
    {
        return getInt("periodMonth");
    }
    public void setPeriodMonth(int item)
    {
        setInt("periodMonth", item);
    }
    /**
     * Object:薪酬方案's 启用property 
     */
    public boolean isEnabled()
    {
        return getBoolean("enabled");
    }
    public void setEnabled(boolean item)
    {
        setBoolean("enabled", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("DDE6036F");
    }
}
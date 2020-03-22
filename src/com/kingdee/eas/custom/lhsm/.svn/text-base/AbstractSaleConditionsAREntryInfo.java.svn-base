package com.kingdee.eas.custom.lhsm;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSaleConditionsAREntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSaleConditionsAREntryInfo()
    {
        this("id");
    }
    protected AbstractSaleConditionsAREntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 应收单 's null property 
     */
    public com.kingdee.eas.custom.lhsm.SaleConditionsInfo getParent()
    {
        return (com.kingdee.eas.custom.lhsm.SaleConditionsInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.lhsm.SaleConditionsInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:应收单's 条件property 
     */
    public String getCondition()
    {
        return getString("condition");
    }
    public void setCondition(String item)
    {
        setString("condition", item);
    }
    /**
     * Object:应收单's 选择property 
     */
    public boolean isChoose()
    {
        return getBoolean("choose");
    }
    public void setChoose(boolean item)
    {
        setBoolean("choose", item);
    }
    /**
     * Object:应收单's 字段名称property 
     */
    public String getFieldName()
    {
        return getString("fieldName");
    }
    public void setFieldName(String item)
    {
        setString("fieldName", item);
    }
    /**
     * Object:应收单's sql语句property 
     */
    public String getSqlString()
    {
        return getString("sqlString");
    }
    public void setSqlString(String item)
    {
        setString("sqlString", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("212BFE35");
    }
}
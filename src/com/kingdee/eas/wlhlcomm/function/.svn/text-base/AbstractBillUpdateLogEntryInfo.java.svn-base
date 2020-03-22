package com.kingdee.eas.wlhlcomm.function;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBillUpdateLogEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBillUpdateLogEntryInfo()
    {
        this("id");
    }
    protected AbstractBillUpdateLogEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.wlhlcomm.function.BillUpdateLogInfo getParent()
    {
        return (com.kingdee.eas.wlhlcomm.function.BillUpdateLogInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.wlhlcomm.function.BillUpdateLogInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 字段名称property 
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
     * Object:分录's 原IDproperty 
     */
    public String getOldID()
    {
        return getString("oldID");
    }
    public void setOldID(String item)
    {
        setString("oldID", item);
    }
    /**
     * Object:分录's 原编码property 
     */
    public String getOldNumber()
    {
        return getString("oldNumber");
    }
    public void setOldNumber(String item)
    {
        setString("oldNumber", item);
    }
    /**
     * Object:分录's 原名称property 
     */
    public String getOldName()
    {
        return getString("oldName");
    }
    public void setOldName(String item)
    {
        setString("oldName", item);
    }
    /**
     * Object:分录's 原值property 
     */
    public java.math.BigDecimal getOldValue()
    {
        return getBigDecimal("oldValue");
    }
    public void setOldValue(java.math.BigDecimal item)
    {
        setBigDecimal("oldValue", item);
    }
    /**
     * Object:分录's 新IDproperty 
     */
    public String getNewID()
    {
        return getString("newID");
    }
    public void setNewID(String item)
    {
        setString("newID", item);
    }
    /**
     * Object:分录's 新编码property 
     */
    public String getNewNumber()
    {
        return getString("newNumber");
    }
    public void setNewNumber(String item)
    {
        setString("newNumber", item);
    }
    /**
     * Object:分录's 新名称property 
     */
    public String getNewName()
    {
        return getString("newName");
    }
    public void setNewName(String item)
    {
        setString("newName", item);
    }
    /**
     * Object:分录's 新值property 
     */
    public java.math.BigDecimal getNewValue()
    {
        return getBigDecimal("newValue");
    }
    public void setNewValue(java.math.BigDecimal item)
    {
        setBigDecimal("newValue", item);
    }
    /**
     * Object:分录's 字段位置property 
     */
    public com.kingdee.eas.wlhlcomm.FieldType getFieldType()
    {
        return com.kingdee.eas.wlhlcomm.FieldType.getEnum(getString("fieldType"));
    }
    public void setFieldType(com.kingdee.eas.wlhlcomm.FieldType item)
    {
		if (item != null) {
        setString("fieldType", item.getValue());
		}
    }
    /**
     * Object:分录's 更新表名property 
     */
    public String getTableName()
    {
        return getString("tableName");
    }
    public void setTableName(String item)
    {
        setString("tableName", item);
    }
    /**
     * Object:分录's 表字段property 
     */
    public String getFieldColumn()
    {
        return getString("fieldColumn");
    }
    public void setFieldColumn(String item)
    {
        setString("fieldColumn", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("9DE738BD");
    }
}
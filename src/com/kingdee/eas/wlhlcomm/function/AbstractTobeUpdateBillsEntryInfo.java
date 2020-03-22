package com.kingdee.eas.wlhlcomm.function;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractTobeUpdateBillsEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractTobeUpdateBillsEntryInfo()
    {
        this("id");
    }
    protected AbstractTobeUpdateBillsEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: �ֶ���Ϣ 's ����ͷ property 
     */
    public com.kingdee.eas.wlhlcomm.function.TobeUpdateBillsInfo getParent()
    {
        return (com.kingdee.eas.wlhlcomm.function.TobeUpdateBillsInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.wlhlcomm.function.TobeUpdateBillsInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:�ֶ���Ϣ's �ֶ�λ��property 
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
     * Object:�ֶ���Ϣ's �ֶ�����property 
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
     * Object:�ֶ���Ϣ's ����property 
     */
    public String getFieldTable()
    {
        return getString("fieldTable");
    }
    public void setFieldTable(String item)
    {
        setString("fieldTable", item);
    }
    /**
     * Object:�ֶ���Ϣ's ����property 
     */
    public String getFieldColumn()
    {
        return getString("fieldColumn");
    }
    public void setFieldColumn(String item)
    {
        setString("fieldColumn", item);
    }
    /**
     * Object:�ֶ���Ϣ's �ֶ�����property 
     */
    public com.kingdee.eas.wlhlcomm.FieldDataType getFieldDataType()
    {
        return com.kingdee.eas.wlhlcomm.FieldDataType.getEnum(getString("fieldDataType"));
    }
    public void setFieldDataType(com.kingdee.eas.wlhlcomm.FieldDataType item)
    {
		if (item != null) {
        setString("fieldDataType", item.getValue());
		}
    }
    /**
     * Object:�ֶ���Ϣ's ö������property 
     */
    public String getEnumClass()
    {
        return getString("enumClass");
    }
    public void setEnumClass(String item)
    {
        setString("enumClass", item);
    }
    /**
     * Object:�ֶ���Ϣ's F7queryproperty 
     */
    public String getF7Query()
    {
        return getString("f7Query");
    }
    public void setF7Query(String item)
    {
        setString("f7Query", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("11F369EC");
    }
}
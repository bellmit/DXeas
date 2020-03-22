package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSettlementItemMaterialEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSettlementItemMaterialEntryInfo()
    {
        this("id");
    }
    protected AbstractSettlementItemMaterialEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ���Ϸ�¼ 's null property 
     */
    public com.kingdee.eas.farm.stocking.basedata.SettlementItemInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basedata.SettlementItemInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basedata.SettlementItemInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ���Ϸ�¼ 's ���ϱ��� property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("material");
    }
    public void setMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("material", item);
    }
    /**
     * Object:���Ϸ�¼'s ��������property 
     */
    public String getMaterialName()
    {
        return getString("materialName");
    }
    public void setMaterialName(String item)
    {
        setString("materialName", item);
    }
    /**
     * Object:���Ϸ�¼'s ���property 
     */
    public String getModel()
    {
        return getString("model");
    }
    public void setModel(String item)
    {
        setString("model", item);
    }
    /**
     * Object:���Ϸ�¼'s ���յ��ֶ�property 
     */
    public String getFiledNum()
    {
        return getString("filedNum");
    }
    public void setFiledNum(String item)
    {
        setString("filedNum", item);
    }
    /**
     * Object:���Ϸ�¼'s ���յ��ֶα���property 
     */
    public String getFiledName()
    {
        return getString("filedName");
    }
    public void setFiledName(String item)
    {
        setString("filedName", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("EC87E71E");
    }
}
package com.kingdee.eas.custom.eas2temp;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBarMaterialRelInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractBarMaterialRelInfo()
    {
        this("id");
    }
    protected AbstractBarMaterialRelInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: BarMaterialRel 's 组别 property 
     */
    public com.kingdee.eas.custom.eas2temp.BarMaterialRelTreeInfo getTreeid()
    {
        return (com.kingdee.eas.custom.eas2temp.BarMaterialRelTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.custom.eas2temp.BarMaterialRelTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:BarMaterialRel's 目标系统物料编码property 
     */
    public String getBarMaterialNum()
    {
        return getString("barMaterialNum");
    }
    public void setBarMaterialNum(String item)
    {
        setString("barMaterialNum", item);
    }
    /**
     * Object: BarMaterialRel 's EAS物料 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getEasMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("easMaterial");
    }
    public void setEasMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("easMaterial", item);
    }
    /**
     * Object:BarMaterialRel's EAS物料名称property 
     */
    public String getEasMaterialName()
    {
        return getString("easMaterialName");
    }
    public void setEasMaterialName(String item)
    {
        setString("easMaterialName", item);
    }
    /**
     * Object: BarMaterialRel 's 库存组织 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStorageOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("storageOrgUnit");
    }
    public void setStorageOrgUnit(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("storageOrgUnit", item);
    }
    /**
     * Object:BarMaterialRel's 非主要使用property 
     */
    public boolean isNotMainUsed()
    {
        return getBoolean("notMainUsed");
    }
    public void setNotMainUsed(boolean item)
    {
        setBoolean("notMainUsed", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F69D76B3");
    }
}
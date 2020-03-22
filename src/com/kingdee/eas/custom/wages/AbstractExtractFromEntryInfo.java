package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractExtractFromEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractExtractFromEntryInfo()
    {
        this("id");
    }
    protected AbstractExtractFromEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 物料明细 's null property 
     */
    public com.kingdee.eas.custom.wages.ExtractFromInfo getParent()
    {
        return (com.kingdee.eas.custom.wages.ExtractFromInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.wages.ExtractFromInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 物料明细 's 物料名称 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMateriel()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("materiel");
    }
    public void setMateriel(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("materiel", item);
    }
    /**
     * Object:物料明细's 物料编码property 
     */
    public String getMnumber()
    {
        return getString("mnumber");
    }
    public void setMnumber(String item)
    {
        setString("mnumber", item);
    }
    /**
     * Object:物料明细's 规格型号property 
     */
    public String getMtype()
    {
        return getString("mtype");
    }
    public void setMtype(String item)
    {
        setString("mtype", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("680C4B6F");
    }
}
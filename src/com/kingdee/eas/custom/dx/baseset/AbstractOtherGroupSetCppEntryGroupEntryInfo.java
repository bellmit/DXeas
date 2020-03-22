package com.kingdee.eas.custom.dx.baseset;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractOtherGroupSetCppEntryGroupEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractOtherGroupSetCppEntryGroupEntryInfo()
    {
        this("id");
    }
    protected AbstractOtherGroupSetCppEntryGroupEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 物料分类分录 's null property 
     */
    public com.kingdee.eas.custom.dx.baseset.OtherGroupSetCppEntryInfo getParent1()
    {
        return (com.kingdee.eas.custom.dx.baseset.OtherGroupSetCppEntryInfo)get("parent1");
    }
    public void setParent1(com.kingdee.eas.custom.dx.baseset.OtherGroupSetCppEntryInfo item)
    {
        put("parent1", item);
    }
    /**
     * Object: 物料分类分录 's 对应标准分类 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialGroupInfo getMaterialgroup()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialGroupInfo)get("Materialgroup");
    }
    public void setMaterialgroup(com.kingdee.eas.basedata.master.material.MaterialGroupInfo item)
    {
        put("Materialgroup", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("49074D49");
    }
}
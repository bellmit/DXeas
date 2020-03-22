package com.kingdee.eas.bdm.bdapply;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMaterialInfoReqMaterialStdEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractMaterialInfoReqMaterialStdEntryInfo()
    {
        this("id");
    }
    protected AbstractMaterialInfoReqMaterialStdEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 物料分类标准 's null property 
     */
    public com.kingdee.eas.bdm.bdapply.MaterialInfoReqInfo getParent()
    {
        return (com.kingdee.eas.bdm.bdapply.MaterialInfoReqInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.bdm.bdapply.MaterialInfoReqInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 物料分类标准 's 分类 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialGroupInfo getMaterialClassify()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialGroupInfo)get("materialClassify");
    }
    public void setMaterialClassify(com.kingdee.eas.basedata.master.material.MaterialGroupInfo item)
    {
        put("materialClassify", item);
    }
    /**
     * Object: 物料分类标准 's 分类标准 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialGroupStandardInfo getMaterialClassifyStd()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialGroupStandardInfo)get("materialClassifyStd");
    }
    public void setMaterialClassifyStd(com.kingdee.eas.basedata.master.material.MaterialGroupStandardInfo item)
    {
        put("materialClassifyStd", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("96035308");
    }
}
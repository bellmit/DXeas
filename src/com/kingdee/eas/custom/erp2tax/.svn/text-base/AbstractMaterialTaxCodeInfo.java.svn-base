package com.kingdee.eas.custom.erp2tax;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMaterialTaxCodeInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractMaterialTaxCodeInfo()
    {
        this("id");
    }
    protected AbstractMaterialTaxCodeInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.custom.erp2tax.MaterialTaxCodeEntryCollection());
    }
    /**
     * Object: 物料分类代码维护 's 物料明细 property 
     */
    public com.kingdee.eas.custom.erp2tax.MaterialTaxCodeEntryCollection getEntry()
    {
        return (com.kingdee.eas.custom.erp2tax.MaterialTaxCodeEntryCollection)get("Entry");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E13EE15A");
    }
}
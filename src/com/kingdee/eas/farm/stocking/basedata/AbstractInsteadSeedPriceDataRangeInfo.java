package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractInsteadSeedPriceDataRangeInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractInsteadSeedPriceDataRangeInfo()
    {
        this("id");
    }
    protected AbstractInsteadSeedPriceDataRangeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 作用范围 's null property 
     */
    public com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 作用范围 's 公司 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("company", item);
    }
    /**
     * Object: 作用范围 's 供应商 property 
     */
    public com.kingdee.eas.basedata.master.cssp.SupplierInfo getSupplier()
    {
        return (com.kingdee.eas.basedata.master.cssp.SupplierInfo)get("supplier");
    }
    public void setSupplier(com.kingdee.eas.basedata.master.cssp.SupplierInfo item)
    {
        put("supplier", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("CC9B79EC");
    }
}
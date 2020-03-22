package com.kingdee.eas.farm.pig.ccpig;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCCPigBatchPigletBatchEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCCPigBatchPigletBatchEntryInfo()
    {
        this("id");
    }
    protected AbstractCCPigBatchPigletBatchEntryInfo(String pkField)
    {
        super(pkField);
        put("PbEarNumbers", new com.kingdee.eas.farm.pig.ccpig.CCPigBatchPigletBatchEntryPbEarNumberCollection());
    }
    /**
     * Object: �������� 's null property 
     */
    public com.kingdee.eas.farm.pig.ccpig.CCPigBatchInfo getParent()
    {
        return (com.kingdee.eas.farm.pig.ccpig.CCPigBatchInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.pig.ccpig.CCPigBatchInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: �������� 's ������Դ property 
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
     * Object: �������� 's �������� property 
     */
    public com.kingdee.eas.basedata.assistant.CostObjectInfo getCostObject()
    {
        return (com.kingdee.eas.basedata.assistant.CostObjectInfo)get("costObject");
    }
    public void setCostObject(com.kingdee.eas.basedata.assistant.CostObjectInfo item)
    {
        put("costObject", item);
    }
    /**
     * Object:��������'s ͷ��property 
     */
    public int getQty()
    {
        return getInt("qty");
    }
    public void setQty(int item)
    {
        setInt("qty", item);
    }
    /**
     * Object: �������� 's ������ϸ property 
     */
    public com.kingdee.eas.farm.pig.ccpig.CCPigBatchPigletBatchEntryPbEarNumberCollection getPbEarNumbers()
    {
        return (com.kingdee.eas.farm.pig.ccpig.CCPigBatchPigletBatchEntryPbEarNumberCollection)get("PbEarNumbers");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("BA55B291");
    }
}
package com.kingdee.eas.farm.pig.ccpig;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCCPigBatchPigDetailInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCCPigBatchPigDetailInfo()
    {
        this("id");
    }
    protected AbstractCCPigBatchPigDetailInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 耳标明细 's null property 
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
     * Object:耳标明细's 耳标property 
     */
    public String getPigNumber()
    {
        return getString("pigNumber");
    }
    public void setPigNumber(String item)
    {
        setString("pigNumber", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("64DE9973");
    }
}
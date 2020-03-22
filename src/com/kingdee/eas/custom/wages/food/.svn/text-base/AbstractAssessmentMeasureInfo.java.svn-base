package com.kingdee.eas.custom.wages.food;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAssessmentMeasureInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractAssessmentMeasureInfo()
    {
        this("id");
    }
    protected AbstractAssessmentMeasureInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.wages.food.AssessmentMeasureEntryCollection());
    }
    /**
     * Object: øº∫À≤‚À„µ• 's ∑÷¬º property 
     */
    public com.kingdee.eas.custom.wages.food.AssessmentMeasureEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.wages.food.AssessmentMeasureEntryCollection)get("entrys");
    }
    /**
     * Object:øº∫À≤‚À„µ•'s µ•æ›◊¥Ã¨property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBillStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("BillStatus"));
    }
    public void setBillStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("BillStatus", item.getValue());
		}
    }
    /**
     * Object: øº∫À≤‚À„µ• 's ≤‚À„∏⁄Œª property 
     */
    public com.kingdee.eas.custom.wages.food.ProdasseindexInfo getAssessmentIndex()
    {
        return (com.kingdee.eas.custom.wages.food.ProdasseindexInfo)get("AssessmentIndex");
    }
    public void setAssessmentIndex(com.kingdee.eas.custom.wages.food.ProdasseindexInfo item)
    {
        put("AssessmentIndex", item);
    }
    /**
     * Object:øº∫À≤‚À„µ•'s øº∫À∏∫‘»Àproperty 
     */
    public String getCSperson()
    {
        return getString("CSperson");
    }
    public void setCSperson(String item)
    {
        setString("CSperson", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("6816D77A");
    }
}
package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBatchBreedApplyBillAssessEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBatchBreedApplyBillAssessEntryInfo()
    {
        this("id");
    }
    protected AbstractBatchBreedApplyBillAssessEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 评定分录 's null property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.BatchBreedApplyBillInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.BatchBreedApplyBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.processbizill.BatchBreedApplyBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 评定分录 's 评定项目 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.CheckItemInfo getCheckItem()
    {
        return (com.kingdee.eas.farm.stocking.basedata.CheckItemInfo)get("checkItem");
    }
    public void setCheckItem(com.kingdee.eas.farm.stocking.basedata.CheckItemInfo item)
    {
        put("checkItem", item);
    }
    /**
     * Object:评定分录's 评定内容property 
     */
    public String getCheckContext()
    {
        return getString("checkContext");
    }
    public void setCheckContext(String item)
    {
        setString("checkContext", item);
    }
    /**
     * Object:评定分录's 评定结果property 
     */
    public com.kingdee.eas.farm.stocking.basedata.CheckResultEnum getCheckResult()
    {
        return com.kingdee.eas.farm.stocking.basedata.CheckResultEnum.getEnum(getInt("checkResult"));
    }
    public void setCheckResult(com.kingdee.eas.farm.stocking.basedata.CheckResultEnum item)
    {
		if (item != null) {
        setInt("checkResult", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("36A15DB8");
    }
}
package com.kingdee.eas.farm.stocking.basebizbill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFarmerApplyBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractFarmerApplyBillEntryInfo()
    {
        this("id");
    }
    protected AbstractFarmerApplyBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ������¼ 's ����ͷ property 
     */
    public com.kingdee.eas.farm.stocking.basebizbill.FarmerApplyBillInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basebizbill.FarmerApplyBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basebizbill.FarmerApplyBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:������¼'s �������property 
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
    /**
     * Object: ������¼ 's ������Ŀ property 
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
     * Object:������¼'s ��������property 
     */
    public String getCheckContext()
    {
        return getString("checkContext");
    }
    public void setCheckContext(String item)
    {
        setString("checkContext", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("9564B781");
    }
}
package com.kingdee.eas.farm.carnivorous.basebiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFarmerQualicationApplEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractFarmerQualicationApplEntryInfo()
    {
        this("id");
    }
    protected AbstractFarmerQualicationApplEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ������¼ 's ����ͷ property 
     */
    public com.kingdee.eas.farm.carnivorous.basebiz.FarmerQualicationApplInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.FarmerQualicationApplInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basebiz.FarmerQualicationApplInfo item)
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
    public com.kingdee.eas.farm.carnivorous.basedata.FarmingCheckItemInfo getCheckItem()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmingCheckItemInfo)get("checkItem");
    }
    public void setCheckItem(com.kingdee.eas.farm.carnivorous.basedata.FarmingCheckItemInfo item)
    {
        put("checkItem", item);
    }
    /**
     * Object:������¼'s ��������property 
     */
    public String getCheckContent()
    {
        return getString("checkContent");
    }
    public void setCheckContent(String item)
    {
        setString("checkContent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1949BA15");
    }
}
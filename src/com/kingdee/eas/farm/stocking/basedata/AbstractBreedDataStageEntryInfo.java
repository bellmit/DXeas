package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBreedDataStageEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBreedDataStageEntryInfo()
    {
        this("id");
    }
    protected AbstractBreedDataStageEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: �׶ζ��� 's null property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BreedDataInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BreedDataInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basedata.BreedDataInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:�׶ζ���'s �׶�property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmStageEnum getFarmStage()
    {
        return com.kingdee.eas.farm.stocking.basedata.FarmStageEnum.getEnum(getInt("farmStage"));
    }
    public void setFarmStage(com.kingdee.eas.farm.stocking.basedata.FarmStageEnum item)
    {
		if (item != null) {
        setInt("farmStage", item.getValue());
		}
    }
    /**
     * Object:�׶ζ���'s ��ʼ����property 
     */
    public int getWeek()
    {
        return getInt("week");
    }
    public void setWeek(int item)
    {
        setInt("week", item);
    }
    /**
     * Object:�׶ζ���'s ��ʼ����property 
     */
    public int getDays()
    {
        return getInt("days");
    }
    public void setDays(int item)
    {
        setInt("days", item);
    }
    /**
     * Object:�׶ζ���'s ��������property 
     */
    public int getEndWeek()
    {
        return getInt("endWeek");
    }
    public void setEndWeek(int item)
    {
        setInt("endWeek", item);
    }
    /**
     * Object:�׶ζ���'s ��������property 
     */
    public int getEndDays()
    {
        return getInt("endDays");
    }
    public void setEndDays(int item)
    {
        setInt("endDays", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C3E7C701");
    }
}
package com.kingdee.eas.farm.breed;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBreedBatchEditBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBreedBatchEditBillEntryInfo()
    {
        this("id");
    }
    protected AbstractBreedBatchEditBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.breed.BreedBatchEditBillInfo getParent()
    {
        return (com.kingdee.eas.farm.breed.BreedBatchEditBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.breed.BreedBatchEditBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 鸡舍 property 
     */
    public com.kingdee.eas.farm.breed.HenhouseInfo getHenHouse()
    {
        return (com.kingdee.eas.farm.breed.HenhouseInfo)get("henHouse");
    }
    public void setHenHouse(com.kingdee.eas.farm.breed.HenhouseInfo item)
    {
        put("henHouse", item);
    }
    /**
     * Object:分录's 鸡舍名称property 
     */
    public String getHenhouseName()
    {
        return getString("henhouseName");
    }
    public void setHenhouseName(String item)
    {
        setString("henhouseName", item);
    }
    /**
     * Object:分录's 新增数量property 
     */
    public int getAddQty()
    {
        return getInt("addQty");
    }
    public void setAddQty(int item)
    {
        setInt("addQty", item);
    }
    /**
     * Object:分录's 鸡类别property 
     */
    public com.kingdee.eas.farm.breed.ChikenType getChikenType()
    {
        return com.kingdee.eas.farm.breed.ChikenType.getEnum(getString("chikenType"));
    }
    public void setChikenType(com.kingdee.eas.farm.breed.ChikenType item)
    {
		if (item != null) {
        setString("chikenType", item.getValue());
		}
    }
    /**
     * Object:分录's 备注property 
     */
    public String getDescription()
    {
        return getString("description");
    }
    public void setDescription(String item)
    {
        setString("description", item);
    }
    /**
     * Object:分录's 变更日期property 
     */
    public java.util.Date getEditDate()
    {
        return getDate("editDate");
    }
    public void setEditDate(java.util.Date item)
    {
        setDate("editDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B040E6A1");
    }
}
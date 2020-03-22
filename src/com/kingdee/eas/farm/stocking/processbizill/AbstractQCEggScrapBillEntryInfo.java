package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractQCEggScrapBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractQCEggScrapBillEntryInfo()
    {
        this("id");
    }
    protected AbstractQCEggScrapBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.QCEggScrapBillInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.QCEggScrapBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.processbizill.QCEggScrapBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ��¼ 's ���� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo getBatch()
    {
        return (com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo)get("batch");
    }
    public void setBatch(com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo item)
    {
        put("batch", item);
    }
    /**
     * Object: ��¼ 's ��ֳ�� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmInfo getFarm()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.stocking.basedata.FarmInfo item)
    {
        put("farm", item);
    }
    /**
     * Object: ��¼ 's ���� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo getHouse()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo)get("house");
    }
    public void setHouse(com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo item)
    {
        put("house", item);
    }
    /**
     * Object:��¼'s ��������property 
     */
    public java.math.BigDecimal getQty()
    {
        return getBigDecimal("qty");
    }
    public void setQty(java.math.BigDecimal item)
    {
        setBigDecimal("qty", item);
    }
    /**
     * Object:��¼'s ��������property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.scrapType getType()
    {
        return com.kingdee.eas.farm.stocking.processbizill.scrapType.getEnum(getString("type"));
    }
    public void setType(com.kingdee.eas.farm.stocking.processbizill.scrapType item)
    {
		if (item != null) {
        setString("type", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("99BAE7E8");
    }
}
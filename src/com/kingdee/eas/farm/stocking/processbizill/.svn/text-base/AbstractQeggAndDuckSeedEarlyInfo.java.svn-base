package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractQeggAndDuckSeedEarlyInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractQeggAndDuckSeedEarlyInfo()
    {
        this("id");
    }
    protected AbstractQeggAndDuckSeedEarlyInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.stocking.processbizill.QeggAndDuckSeedEarlyEntryCollection());
    }
    /**
     * Object: 期初合格蛋和鸭苗库存 's 分录 property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.QeggAndDuckSeedEarlyEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.QeggAndDuckSeedEarlyEntryCollection)get("entrys");
    }
    /**
     * Object:期初合格蛋和鸭苗库存's 是否生成凭证property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    /**
     * Object:期初合格蛋和鸭苗库存's 单据状态property 
     */
    public com.kingdee.eas.ncm.common.BillBaseStatusEnum getBillStatus()
    {
        return com.kingdee.eas.ncm.common.BillBaseStatusEnum.getEnum(getInt("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.ncm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("billStatus", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("63C0631B");
    }
}
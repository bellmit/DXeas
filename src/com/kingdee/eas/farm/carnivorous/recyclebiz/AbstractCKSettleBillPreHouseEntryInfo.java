package com.kingdee.eas.farm.carnivorous.recyclebiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCKSettleBillPreHouseEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCKSettleBillPreHouseEntryInfo()
    {
        this("id");
    }
    protected AbstractCKSettleBillPreHouseEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 棚前过磅 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:棚前过磅's 业务日期property 
     */
    public java.util.Date getBizDate()
    {
        return getDate("bizDate");
    }
    public void setBizDate(java.util.Date item)
    {
        setDate("bizDate", item);
    }
    /**
     * Object:棚前过磅's 单据编号property 
     */
    public String getBillNumber()
    {
        return getString("billNumber");
    }
    public void setBillNumber(String item)
    {
        setString("billNumber", item);
    }
    /**
     * Object:棚前过磅's 单据状态property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBillStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("billStatus", item.getValue());
		}
    }
    /**
     * Object:棚前过磅's 棚前只数property 
     */
    public int getPreHouseQty()
    {
        return getInt("preHouseQty");
    }
    public void setPreHouseQty(int item)
    {
        setInt("preHouseQty", item);
    }
    /**
     * Object:棚前过磅's 棚前皮重property 
     */
    public java.math.BigDecimal getPreHouseTare()
    {
        return getBigDecimal("preHouseTare");
    }
    public void setPreHouseTare(java.math.BigDecimal item)
    {
        setBigDecimal("preHouseTare", item);
    }
    /**
     * Object:棚前过磅's 棚前毛重property 
     */
    public java.math.BigDecimal getPreHouseGross()
    {
        return getBigDecimal("preHouseGross");
    }
    public void setPreHouseGross(java.math.BigDecimal item)
    {
        setBigDecimal("preHouseGross", item);
    }
    /**
     * Object:棚前过磅's 棚前净重property 
     */
    public java.math.BigDecimal getPreHouseSuttle()
    {
        return getBigDecimal("preHouseSuttle");
    }
    public void setPreHouseSuttle(java.math.BigDecimal item)
    {
        setBigDecimal("preHouseSuttle", item);
    }
    /**
     * Object:棚前过磅's 回收只数property 
     */
    public int getRecQty()
    {
        return getInt("recQty");
    }
    public void setRecQty(int item)
    {
        setInt("recQty", item);
    }
    /**
     * Object:棚前过磅's 结算净重property 
     */
    public java.math.BigDecimal getSettleWgt()
    {
        return getBigDecimal("settleWgt");
    }
    public void setSettleWgt(java.math.BigDecimal item)
    {
        setBigDecimal("settleWgt", item);
    }
    /**
     * Object:棚前过磅's 回收净重property 
     */
    public java.math.BigDecimal getRecSuttle()
    {
        return getBigDecimal("recSuttle");
    }
    public void setRecSuttle(java.math.BigDecimal item)
    {
        setBigDecimal("recSuttle", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("FF79E5FE");
    }
}
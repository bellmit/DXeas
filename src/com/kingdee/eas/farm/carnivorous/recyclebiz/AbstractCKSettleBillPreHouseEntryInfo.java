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
     * Object: ��ǰ���� 's null property 
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
     * Object:��ǰ����'s ҵ������property 
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
     * Object:��ǰ����'s ���ݱ��property 
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
     * Object:��ǰ����'s ����״̬property 
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
     * Object:��ǰ����'s ��ǰֻ��property 
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
     * Object:��ǰ����'s ��ǰƤ��property 
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
     * Object:��ǰ����'s ��ǰë��property 
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
     * Object:��ǰ����'s ��ǰ����property 
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
     * Object:��ǰ����'s ����ֻ��property 
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
     * Object:��ǰ����'s ���㾻��property 
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
     * Object:��ǰ����'s ���վ���property 
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
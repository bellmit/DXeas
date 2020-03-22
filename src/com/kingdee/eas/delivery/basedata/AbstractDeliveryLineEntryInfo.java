package com.kingdee.eas.delivery.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDeliveryLineEntryInfo extends com.kingdee.eas.framework.BillEntryBaseInfo implements Serializable 
{
    public AbstractDeliveryLineEntryInfo()
    {
        this("id");
    }
    protected AbstractDeliveryLineEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 第1个表体 's null property 
     */
    public com.kingdee.eas.delivery.basedata.DeliveryLineInfo getParent()
    {
        return (com.kingdee.eas.delivery.basedata.DeliveryLineInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.delivery.basedata.DeliveryLineInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 第1个表体 's 明细路线 property 
     */
    public com.kingdee.eas.delivery.basedata.DeliveryLineInfo getDetailLine()
    {
        return (com.kingdee.eas.delivery.basedata.DeliveryLineInfo)get("detailLine");
    }
    public void setDetailLine(com.kingdee.eas.delivery.basedata.DeliveryLineInfo item)
    {
        put("detailLine", item);
    }
    /**
     * Object:第1个表体's 里程（公里）property 
     */
    public java.math.BigDecimal getDetailMileage()
    {
        return getBigDecimal("detailMileage");
    }
    public void setDetailMileage(java.math.BigDecimal item)
    {
        setBigDecimal("detailMileage", item);
    }
    /**
     * Object: 第1个表体 's 默认承运商 property 
     */
    public com.kingdee.eas.basedata.master.cssp.SupplierInfo getDetailCarrier()
    {
        return (com.kingdee.eas.basedata.master.cssp.SupplierInfo)get("detailCarrier");
    }
    public void setDetailCarrier(com.kingdee.eas.basedata.master.cssp.SupplierInfo item)
    {
        put("detailCarrier", item);
    }
    /**
     * Object:第1个表体's 默认运输方式property 
     */
    public com.kingdee.eas.scm.im.dt.TransportTypeEnum getDetailTranType()
    {
        return com.kingdee.eas.scm.im.dt.TransportTypeEnum.getEnum(getInt("detailTranType"));
    }
    public void setDetailTranType(com.kingdee.eas.scm.im.dt.TransportTypeEnum item)
    {
		if (item != null) {
        setInt("detailTranType", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F9A3773F");
    }
}
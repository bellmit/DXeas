package com.kingdee.eas.custom.taihe.weight;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractInWgtBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractInWgtBillInfo()
    {
        this("id");
    }
    protected AbstractInWgtBillInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:毛鸡过磅单's 是否生成凭证property 
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
     * Object: 毛鸡过磅单 's 派车单号 property 
     */
    public com.kingdee.eas.custom.taihe.weight.CarSendBillInfo getSendCarNum()
    {
        return (com.kingdee.eas.custom.taihe.weight.CarSendBillInfo)get("sendCarNum");
    }
    public void setSendCarNum(com.kingdee.eas.custom.taihe.weight.CarSendBillInfo item)
    {
        put("sendCarNum", item);
    }
    /**
     * Object:毛鸡过磅单's 车牌property 
     */
    public String getCarNum()
    {
        return getString("carNum");
    }
    public void setCarNum(String item)
    {
        setString("carNum", item);
    }
    /**
     * Object: 毛鸡过磅单 's 司机 property 
     */
    public com.kingdee.eas.farm.feemanager.basedata.DriverInfo getDriver()
    {
        return (com.kingdee.eas.farm.feemanager.basedata.DriverInfo)get("driver");
    }
    public void setDriver(com.kingdee.eas.farm.feemanager.basedata.DriverInfo item)
    {
        put("driver", item);
    }
    /**
     * Object:毛鸡过磅单's 毛重property 
     */
    public java.math.BigDecimal getGrossWgt()
    {
        return getBigDecimal("grossWgt");
    }
    public void setGrossWgt(java.math.BigDecimal item)
    {
        setBigDecimal("grossWgt", item);
    }
    /**
     * Object:毛鸡过磅单's 皮重property 
     */
    public java.math.BigDecimal getAreWgt()
    {
        return getBigDecimal("areWgt");
    }
    public void setAreWgt(java.math.BigDecimal item)
    {
        setBigDecimal("areWgt", item);
    }
    /**
     * Object:毛鸡过磅单's 净重property 
     */
    public java.math.BigDecimal getSuttleWgt()
    {
        return getBigDecimal("suttleWgt");
    }
    public void setSuttleWgt(java.math.BigDecimal item)
    {
        setBigDecimal("suttleWgt", item);
    }
    /**
     * Object:毛鸡过磅单's 出厂时间property 
     */
    public java.util.Date getOutDate()
    {
        return getDate("outDate");
    }
    public void setOutDate(java.util.Date item)
    {
        setDate("outDate", item);
    }
    /**
     * Object:毛鸡过磅单's 入厂时间property 
     */
    public java.util.Date getInTime()
    {
        return getDate("inTime");
    }
    public void setInTime(java.util.Date item)
    {
        setDate("inTime", item);
    }
    /**
     * Object:毛鸡过磅单's 审核时间property 
     */
    public java.util.Date getAuditTime()
    {
        return getDate("auditTime");
    }
    public void setAuditTime(java.util.Date item)
    {
        setDate("auditTime", item);
    }
    /**
     * Object:毛鸡过磅单's 单据状态property 
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
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B2478F70");
    }
}
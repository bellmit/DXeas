package com.kingdee.eas.custom.taihe.weight;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCarcassInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBaseInfo implements Serializable 
{
    public AbstractCarcassInfo()
    {
        this("id");
    }
    protected AbstractCarcassInfo(String pkField)
    {
        super(pkField);
        put("EntrysS", new com.kingdee.eas.custom.taihe.weight.CarcassEntrysSCollection());
        put("Entrys", new com.kingdee.eas.custom.taihe.weight.CarcassEntryCollection());
    }
    /**
     * Object:胴体接收单's 是否生成凭证property 
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
     * Object: 胴体接收单 's 派车单号 property 
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
     * Object:胴体接收单's 车牌property 
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
     * Object: 胴体接收单 's 司机 property 
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
     * Object:胴体接收单's 净重property 
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
     * Object:胴体接收单's 只数property 
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
     * Object:胴体接收单's 胴体类型property 
     */
    public com.kingdee.eas.custom.taihe.weight.CarcassType getCarcassType()
    {
        return com.kingdee.eas.custom.taihe.weight.CarcassType.getEnum(getString("carcassType"));
    }
    public void setCarcassType(com.kingdee.eas.custom.taihe.weight.CarcassType item)
    {
		if (item != null) {
        setString("carcassType", item.getValue());
		}
    }
    /**
     * Object: 胴体接收单 's 公司 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("company", item);
    }
    /**
     * Object: 胴体接收单 's 接收明细 property 
     */
    public com.kingdee.eas.custom.taihe.weight.CarcassEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.taihe.weight.CarcassEntryCollection)get("Entrys");
    }
    /**
     * Object:胴体接收单's 合同号property 
     */
    public String getMaterialNum()
    {
        return getString("materialNum");
    }
    public void setMaterialNum(String item)
    {
        setString("materialNum", item);
    }
    /**
     * Object:胴体接收单's 嗉子重量property 
     */
    public java.math.BigDecimal getChickenSZWgt()
    {
        return getBigDecimal("chickenSZWgt");
    }
    public void setChickenSZWgt(java.math.BigDecimal item)
    {
        setBigDecimal("chickenSZWgt", item);
    }
    /**
     * Object: 胴体接收单 's 详细信息 property 
     */
    public com.kingdee.eas.custom.taihe.weight.CarcassEntrysSCollection getEntrysS()
    {
        return (com.kingdee.eas.custom.taihe.weight.CarcassEntrysSCollection)get("EntrysS");
    }
    /**
     * Object:胴体接收单's 车次property 
     */
    public int getTrain()
    {
        return getInt("train");
    }
    public void setTrain(int item)
    {
        setInt("train", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("2B05421C");
    }
}
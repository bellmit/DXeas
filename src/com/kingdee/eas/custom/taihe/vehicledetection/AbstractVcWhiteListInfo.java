package com.kingdee.eas.custom.taihe.vehicledetection;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractVcWhiteListInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractVcWhiteListInfo()
    {
        this("id");
    }
    protected AbstractVcWhiteListInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 白名单 's 组别 property 
     */
    public com.kingdee.eas.custom.taihe.vehicledetection.VcWhiteListTreeInfo getTreeid()
    {
        return (com.kingdee.eas.custom.taihe.vehicledetection.VcWhiteListTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.custom.taihe.vehicledetection.VcWhiteListTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: 白名单 's 通道 property 
     */
    public com.kingdee.eas.custom.taihe.vehicledetection.VdChannelSettingInfo getVdChannel()
    {
        return (com.kingdee.eas.custom.taihe.vehicledetection.VdChannelSettingInfo)get("VdChannel");
    }
    public void setVdChannel(com.kingdee.eas.custom.taihe.vehicledetection.VdChannelSettingInfo item)
    {
        put("VdChannel", item);
    }
    /**
     * Object: 白名单 's 公司 property 
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
     * Object:白名单's 车牌号property 
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
     * Object: 白名单 's 车辆 property 
     */
    public com.kingdee.eas.publicdata.CarInfo getCar()
    {
        return (com.kingdee.eas.publicdata.CarInfo)get("car");
    }
    public void setCar(com.kingdee.eas.publicdata.CarInfo item)
    {
        put("car", item);
    }
    /**
     * Object:白名单's 类别property 
     */
    public com.kingdee.eas.custom.taihe.vehicledetection.WhiteOrBlackEnum getWhiteOrBlack()
    {
        return com.kingdee.eas.custom.taihe.vehicledetection.WhiteOrBlackEnum.getEnum(getInt("whiteOrBlack"));
    }
    public void setWhiteOrBlack(com.kingdee.eas.custom.taihe.vehicledetection.WhiteOrBlackEnum item)
    {
		if (item != null) {
        setInt("whiteOrBlack", item.getValue());
		}
    }
    /**
     * Object:白名单's 状态property 
     */
    public com.kingdee.eas.basedata.master.material.UsedStatusEnum getBaseStatus()
    {
        return com.kingdee.eas.basedata.master.material.UsedStatusEnum.getEnum(getInt("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.basedata.master.material.UsedStatusEnum item)
    {
		if (item != null) {
        setInt("baseStatus", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B5AED865");
    }
}
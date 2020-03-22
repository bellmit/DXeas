package com.kingdee.eas.custom.taihe.vehicledetection;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractVdChannelSettingInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractVdChannelSettingInfo()
    {
        this("id");
    }
    protected AbstractVdChannelSettingInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 通道设置 's 组别 property 
     */
    public com.kingdee.eas.custom.taihe.vehicledetection.VdChannelSettingTreeInfo getTreeid()
    {
        return (com.kingdee.eas.custom.taihe.vehicledetection.VdChannelSettingTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.custom.taihe.vehicledetection.VdChannelSettingTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:通道设置's 出入口property 
     */
    public com.kingdee.eas.custom.taihe.vehicledetection.InOrOutDoorEnum getInOrOut()
    {
        return com.kingdee.eas.custom.taihe.vehicledetection.InOrOutDoorEnum.getEnum(getInt("inOrOut"));
    }
    public void setInOrOut(com.kingdee.eas.custom.taihe.vehicledetection.InOrOutDoorEnum item)
    {
		if (item != null) {
        setInt("inOrOut", item.getValue());
		}
    }
    /**
     * Object:通道设置's IP地址property 
     */
    public String getIp()
    {
        return getString("ip");
    }
    public void setIp(String item)
    {
        setString("ip", item);
    }
    /**
     * Object:通道设置's 机器识别码property 
     */
    public String getCpuID()
    {
        return getString("cpuID");
    }
    public void setCpuID(String item)
    {
        setString("cpuID", item);
    }
    /**
     * Object: 通道设置 's 公司 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("company", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("7CF024D0");
    }
}
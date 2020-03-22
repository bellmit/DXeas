package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAttendanceDockingSettingInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractAttendanceDockingSettingInfo()
    {
        this("id");
    }
    protected AbstractAttendanceDockingSettingInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:考勤机对接设置's 本机机器码property 
     */
    public String getCpuId()
    {
        return getString("cpuId");
    }
    public void setCpuId(String item)
    {
        setString("cpuId", item);
    }
    /**
     * Object:考勤机对接设置's 数据文件路径property 
     */
    public String getDbFilePath()
    {
        return getString("dbFilePath");
    }
    public void setDbFilePath(String item)
    {
        setString("dbFilePath", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("241FB1D2");
    }
}
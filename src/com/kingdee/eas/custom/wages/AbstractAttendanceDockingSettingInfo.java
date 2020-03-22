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
     * Object:���ڻ��Խ�����'s ����������property 
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
     * Object:���ڻ��Խ�����'s �����ļ�·��property 
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
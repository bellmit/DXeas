package com.kingdee.eas.publicdata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCardReaderInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractCardReaderInfo()
    {
        this("id");
    }
    protected AbstractCardReaderInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ˢ���� 's ��� property 
     */
    public com.kingdee.eas.publicdata.CardReaderTreeInfo getTreeid()
    {
        return (com.kingdee.eas.publicdata.CardReaderTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.publicdata.CardReaderTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:ˢ����'s �˿�property 
     */
    public com.kingdee.eas.weighbridge.PortNum getPort()
    {
        return com.kingdee.eas.weighbridge.PortNum.getEnum(getString("Port"));
    }
    public void setPort(com.kingdee.eas.weighbridge.PortNum item)
    {
		if (item != null) {
        setString("Port", item.getValue());
		}
    }
    /**
     * Object:ˢ����'s ������property 
     */
    public int getBaudRate()
    {
        return getInt("BaudRate");
    }
    public void setBaudRate(int item)
    {
        setInt("BaudRate", item);
    }
    /**
     * Object:ˢ����'s ��żУ��property 
     */
    public com.kingdee.eas.weighbridge.Parity getParity()
    {
        return com.kingdee.eas.weighbridge.Parity.getEnum(getString("Parity"));
    }
    public void setParity(com.kingdee.eas.weighbridge.Parity item)
    {
		if (item != null) {
        setString("Parity", item.getValue());
		}
    }
    /**
     * Object:ˢ����'s ����λproperty 
     */
    public com.kingdee.eas.weighbridge.DataBits getDataBits()
    {
        return com.kingdee.eas.weighbridge.DataBits.getEnum(getString("DataBits"));
    }
    public void setDataBits(com.kingdee.eas.weighbridge.DataBits item)
    {
		if (item != null) {
        setString("DataBits", item.getValue());
		}
    }
    /**
     * Object:ˢ����'s ֹͣλproperty 
     */
    public com.kingdee.eas.weighbridge.StopBits getStopBits()
    {
        return com.kingdee.eas.weighbridge.StopBits.getEnum(getString("StopBits"));
    }
    public void setStopBits(com.kingdee.eas.weighbridge.StopBits item)
    {
		if (item != null) {
        setString("StopBits", item.getValue());
		}
    }
    /**
     * Object:ˢ����'s ��ʼ�ַ�property 
     */
    public String getBeginChar()
    {
        return getString("beginChar");
    }
    public void setBeginChar(String item)
    {
        setString("beginChar", item);
    }
    /**
     * Object:ˢ����'s �����ַ�property 
     */
    public String getEndChar()
    {
        return getString("endChar");
    }
    public void setEndChar(String item)
    {
        setString("endChar", item);
    }
    /**
     * Object:ˢ����'s ȡ��JS�ű�property 
     */
    public String getTxtJSScript()
    {
        return getString("txtJSScript");
    }
    public void setTxtJSScript(String item)
    {
        setString("txtJSScript", item);
    }
    /**
     * Object:ˢ����'s �ı�property 
     */
    public String getBIMUDF0013()
    {
        return getString("BIMUDF0013");
    }
    public void setBIMUDF0013(String item)
    {
        setString("BIMUDF0013", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("56CC9416");
    }
}
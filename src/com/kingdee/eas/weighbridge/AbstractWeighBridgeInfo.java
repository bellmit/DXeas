package com.kingdee.eas.weighbridge;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractWeighBridgeInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractWeighBridgeInfo()
    {
        this("id");
    }
    protected AbstractWeighBridgeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ���� 's ��� property 
     */
    public com.kingdee.eas.weighbridge.WeighBridgeTreeInfo getTreeid()
    {
        return (com.kingdee.eas.weighbridge.WeighBridgeTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.weighbridge.WeighBridgeTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:����'s �˿�property 
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
     * Object:����'s ������property 
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
     * Object:����'s ��żУ��property 
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
     * Object:����'s ����λproperty 
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
     * Object:����'s ֹͣλproperty 
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
     * Object:����'s ��ʼ�ַ�property 
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
     * Object:����'s �����ַ�property 
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
     * Object:����'s ȡ��JS�ű�property 
     */
    public String getTxtJSScript()
    {
        return getString("txtJSScript");
    }
    public void setTxtJSScript(String item)
    {
        setString("txtJSScript", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("71E0616A");
    }
}
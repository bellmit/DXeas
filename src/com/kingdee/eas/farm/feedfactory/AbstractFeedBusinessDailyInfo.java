package com.kingdee.eas.farm.feedfactory;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFeedBusinessDailyInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractFeedBusinessDailyInfo()
    {
        this("id");
    }
    protected AbstractFeedBusinessDailyInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:���Ͼ�Ӫ�ձ�'s �Ƿ�����ƾ֤property 
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
     * Object:���Ͼ�Ӫ�ձ�'s ���ʱ��property 
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
     * Object:���Ͼ�Ӫ�ձ�'s ״̬property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBaseStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("baseStatus", item.getValue());
		}
    }
    /**
     * Object:���Ͼ�Ӫ�ձ�'s ��עproperty 
     */
    public String getHatchDescription()
    {
        return getString("hatchDescription");
    }
    public void setHatchDescription(String item)
    {
        setString("hatchDescription", item);
    }
    /**
     * Object:���Ͼ�Ӫ�ձ�'s �����������property 
     */
    public int getAttendanceQty()
    {
        return getInt("attendanceQty");
    }
    public void setAttendanceQty(int item)
    {
        setInt("attendanceQty", item);
    }
    /**
     * Object:���Ͼ�Ӫ�ձ�'s ������ְ����property 
     */
    public int getLeaveQty()
    {
        return getInt("leaveQty");
    }
    public void setLeaveQty(int item)
    {
        setInt("leaveQty", item);
    }
    /**
     * Object:���Ͼ�Ӫ�ձ�'s ������ְ����property 
     */
    public int getEntryQty()
    {
        return getInt("entryQty");
    }
    public void setEntryQty(int item)
    {
        setInt("entryQty", item);
    }
    /**
     * Object:���Ͼ�Ӫ�ձ�'s �����ʼ����property 
     */
    public int getInitQty()
    {
        return getInt("initQty");
    }
    public void setInitQty(int item)
    {
        setInt("initQty", item);
    }
    /**
     * Object: ���Ͼ�Ӫ�ձ� 's �����֯ property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStoOrg()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("stoOrg");
    }
    public void setStoOrg(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("stoOrg", item);
    }
    /**
     * Object:���Ͼ�Ӫ�ձ�'s ���ÿ��property 
     */
    public java.math.BigDecimal getOwnInventory()
    {
        return getBigDecimal("ownInventory");
    }
    public void setOwnInventory(java.math.BigDecimal item)
    {
        setBigDecimal("ownInventory", item);
    }
    /**
     * Object:���Ͼ�Ӫ�ձ�'s �������property 
     */
    public java.math.BigDecimal getProxyInventory()
    {
        return getBigDecimal("proxyInventory");
    }
    public void setProxyInventory(java.math.BigDecimal item)
    {
        setBigDecimal("proxyInventory", item);
    }
    /**
     * Object:���Ͼ�Ӫ�ձ�'s ���ɿ��property 
     */
    public java.math.BigDecimal getSoybeanInventory()
    {
        return getBigDecimal("soybeanInventory");
    }
    public void setSoybeanInventory(java.math.BigDecimal item)
    {
        setBigDecimal("soybeanInventory", item);
    }
    /**
     * Object:���Ͼ�Ӫ�ձ�'s ú��(KG)property 
     */
    public java.math.BigDecimal getCoalQty()
    {
        return getBigDecimal("coalQty");
    }
    public void setCoalQty(java.math.BigDecimal item)
    {
        setBigDecimal("coalQty", item);
    }
    /**
     * Object:���Ͼ�Ӫ�ձ�'s ���(��)property 
     */
    public java.math.BigDecimal getElecQty()
    {
        return getBigDecimal("elecQty");
    }
    public void setElecQty(java.math.BigDecimal item)
    {
        setBigDecimal("elecQty", item);
    }
    /**
     * Object:���Ͼ�Ӫ�ձ�'s ���ӳ�ʼ����property 
     */
    public int getMotorcadeInitQty()
    {
        return getInt("motorcadeInitQty");
    }
    public void setMotorcadeInitQty(int item)
    {
        setInt("motorcadeInitQty", item);
    }
    /**
     * Object:���Ͼ�Ӫ�ձ�'s ���ӳ�������property 
     */
    public int getMotorcadeAttendQty()
    {
        return getInt("motorcadeAttendQty");
    }
    public void setMotorcadeAttendQty(int item)
    {
        setInt("motorcadeAttendQty", item);
    }
    /**
     * Object:���Ͼ�Ӫ�ձ�'s ������ְ����property 
     */
    public int getMotorcadeEntryQty()
    {
        return getInt("motorcadeEntryQty");
    }
    public void setMotorcadeEntryQty(int item)
    {
        setInt("motorcadeEntryQty", item);
    }
    /**
     * Object:���Ͼ�Ӫ�ձ�'s ������ְ����property 
     */
    public int getMotorcadeLeaveQty()
    {
        return getInt("motorcadeLeaveQty");
    }
    public void setMotorcadeLeaveQty(int item)
    {
        setInt("motorcadeLeaveQty", item);
    }
    /**
     * Object:���Ͼ�Ӫ�ձ�'s ���׿��property 
     */
    public java.math.BigDecimal getCornInventory()
    {
        return getBigDecimal("cornInventory");
    }
    public void setCornInventory(java.math.BigDecimal item)
    {
        setBigDecimal("cornInventory", item);
    }
    /**
     * Object:���Ͼ�Ӫ�ձ�'s ��ʼ����property 
     */
    public java.math.BigDecimal getElecBegin()
    {
        return getBigDecimal("elecBegin");
    }
    public void setElecBegin(java.math.BigDecimal item)
    {
        setBigDecimal("elecBegin", item);
    }
    /**
     * Object:���Ͼ�Ӫ�ձ�'s ��ֹ����property 
     */
    public java.math.BigDecimal getElecEnd()
    {
        return getBigDecimal("elecEnd");
    }
    public void setElecEnd(java.math.BigDecimal item)
    {
        setBigDecimal("elecEnd", item);
    }
    /**
     * Object:���Ͼ�Ӫ�ձ�'s �������׿��property 
     */
    public java.math.BigDecimal getProxyCornInventory()
    {
        return getBigDecimal("proxyCornInventory");
    }
    public void setProxyCornInventory(java.math.BigDecimal item)
    {
        setBigDecimal("proxyCornInventory", item);
    }
    /**
     * Object:���Ͼ�Ӫ�ձ�'s �������ɿ��property 
     */
    public java.math.BigDecimal getProxySoybeanInventory()
    {
        return getBigDecimal("proxySoybeanInventory");
    }
    public void setProxySoybeanInventory(java.math.BigDecimal item)
    {
        setBigDecimal("proxySoybeanInventory", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("0489F399");
    }
}
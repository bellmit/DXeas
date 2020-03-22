package com.kingdee.eas.weighbridge;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractInStorageBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractInStorageBillInfo()
    {
        this("id");
    }
    protected AbstractInStorageBillInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.weighbridge.InStorageBillEntryCollection());
    }
    /**
     * Object: ë�ع��� 's ������¼ property 
     */
    public com.kingdee.eas.weighbridge.InStorageBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.weighbridge.InStorageBillEntryCollection)get("entrys");
    }
    /**
     * Object:ë�ع���'s �Ƿ�����ƾ֤property 
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
     * Object: ë�ع��� 's ���� property 
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
     * Object:ë�ع���'s �볧ʱ��property 
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
     * Object:ë�ع���'s ����ʱ��property 
     */
    public java.util.Date getOutTime()
    {
        return getDate("outTime");
    }
    public void setOutTime(java.util.Date item)
    {
        setDate("outTime", item);
    }
    /**
     * Object:ë�ع���'s ����Ƥ��property 
     */
    public java.math.BigDecimal getTareWeight()
    {
        return getBigDecimal("tareWeight");
    }
    public void setTareWeight(java.math.BigDecimal item)
    {
        setBigDecimal("tareWeight", item);
    }
    /**
     * Object: ë�ع��� 's ��ǰ�����֯ property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStorageOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("storageOrgUnit");
    }
    public void setStorageOrgUnit(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("storageOrgUnit", item);
    }
    /**
     * Object: ë�ع��� 's ��Դ�����֯ property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getOrderStorageOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("orderStorageOrgUnit");
    }
    public void setOrderStorageOrgUnit(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("orderStorageOrgUnit", item);
    }
    /**
     * Object: ë�ع��� 's ˾��Ա property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getWeighman()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("weighman");
    }
    public void setWeighman(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("weighman", item);
    }
    /**
     * Object:ë�ع���'s ���ʱ��property 
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
     * Object:ë�ع���'s ҵ������property 
     */
    public com.kingdee.eas.weighbridge.WeighBizType getBizType()
    {
        return com.kingdee.eas.weighbridge.WeighBizType.getEnum(getString("bizType"));
    }
    public void setBizType(com.kingdee.eas.weighbridge.WeighBizType item)
    {
		if (item != null) {
        setString("bizType", item.getValue());
		}
    }
    /**
     * Object: ë�ع��� 's ��Ӧ�� property 
     */
    public com.kingdee.eas.basedata.master.cssp.SupplierInfo getSupplier()
    {
        return (com.kingdee.eas.basedata.master.cssp.SupplierInfo)get("supplier");
    }
    public void setSupplier(com.kingdee.eas.basedata.master.cssp.SupplierInfo item)
    {
        put("supplier", item);
    }
    /**
     * Object:ë�ع���'s �Ƿ��Զ����ɳ���ⵥ��property 
     */
    public boolean isIsAutoCreateToInvBill()
    {
        return getBoolean("isAutoCreateToInvBill");
    }
    public void setIsAutoCreateToInvBill(boolean item)
    {
        setBoolean("isAutoCreateToInvBill", item);
    }
    /**
     * Object:ë�ع���'s ����״̬property 
     */
    public com.kingdee.eas.weighbridge.WeighBaseStatus getBillStatus()
    {
        return com.kingdee.eas.weighbridge.WeighBaseStatus.getEnum(getString("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.weighbridge.WeighBaseStatus item)
    {
		if (item != null) {
        setString("billStatus", item.getValue());
		}
    }
    /**
     * Object:ë�ع���'s ������ʽproperty 
     */
    public com.kingdee.eas.weighbridge.WeighBaseType getWeighType()
    {
        return com.kingdee.eas.weighbridge.WeighBaseType.getEnum(getString("weighType"));
    }
    public void setWeighType(com.kingdee.eas.weighbridge.WeighBaseType item)
    {
		if (item != null) {
        setString("weighType", item.getValue());
		}
    }
    /**
     * Object: ë�ع��� 's ��ǰ������֯ property 
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
     * Object: ë�ع��� 's Ŀ�������֯ property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getOrderCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("orderCompany");
    }
    public void setOrderCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("orderCompany", item);
    }
    /**
     * Object:ë�ع���'s ���ƺ�property 
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
     * Object:ë�ع���'s �ɹ���������property 
     */
    public String getPurOrderNumber()
    {
        return getString("purOrderNumber");
    }
    public void setPurOrderNumber(String item)
    {
        setString("purOrderNumber", item);
    }
    /**
     * Object: ë�ع��� 's �ɳ����� property 
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
     * Object:ë�ع���'s ��������property 
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
     * Object: ë�ع��� 's �ɳ��� property 
     */
    public com.kingdee.eas.custom.dx.weight.CarSendBillInfo getSendCar()
    {
        return (com.kingdee.eas.custom.dx.weight.CarSendBillInfo)get("SendCar");
    }
    public void setSendCar(com.kingdee.eas.custom.dx.weight.CarSendBillInfo item)
    {
        put("SendCar", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("52D6BAC2");
    }
}
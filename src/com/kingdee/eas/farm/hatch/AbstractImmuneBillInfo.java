package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractImmuneBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractImmuneBillInfo()
    {
        this("id");
    }
    protected AbstractImmuneBillInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:免疫派工单's 是否生成凭证property 
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
     * Object: 免疫派工单 's 客户 property 
     */
    public com.kingdee.eas.basedata.master.cssp.CustomerInfo getCustomer()
    {
        return (com.kingdee.eas.basedata.master.cssp.CustomerInfo)get("customer");
    }
    public void setCustomer(com.kingdee.eas.basedata.master.cssp.CustomerInfo item)
    {
        put("customer", item);
    }
    /**
     * Object: 免疫派工单 's 部门 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getDepartment()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("department");
    }
    public void setDepartment(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("department", item);
    }
    /**
     * Object:免疫派工单's 派工数量property 
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
     * Object: 免疫派工单 's 派单人 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getSendPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("sendPerson");
    }
    public void setSendPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("sendPerson", item);
    }
    /**
     * Object: 免疫派工单 's 接单人 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getReceivePerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("receivePerson");
    }
    public void setReceivePerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("receivePerson", item);
    }
    /**
     * Object:免疫派工单's 完成时间property 
     */
    public java.util.Date getFinishTime()
    {
        return getDate("finishTime");
    }
    public void setFinishTime(java.util.Date item)
    {
        setDate("finishTime", item);
    }
    /**
     * Object: 免疫派工单 's 销售负责人 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getSaleCharger()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("saleCharger");
    }
    public void setSaleCharger(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("saleCharger", item);
    }
    /**
     * Object: 免疫派工单 's 孵化场 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getHatchFactory()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("hatchFactory");
    }
    public void setHatchFactory(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("hatchFactory", item);
    }
    /**
     * Object:免疫派工单's 单据状态property 
     */
    public com.kingdee.eas.ncm.common.BillBaseStatusEnum getBillStatus()
    {
        return com.kingdee.eas.ncm.common.BillBaseStatusEnum.getEnum(getInt("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.ncm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("billStatus", item.getValue());
		}
    }
    /**
     * Object: 免疫派工单 's 司机 property 
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
     * Object:免疫派工单's 实际完成数量property 
     */
    public java.math.BigDecimal getActualQty()
    {
        return getBigDecimal("actualQty");
    }
    public void setActualQty(java.math.BigDecimal item)
    {
        setBigDecimal("actualQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("9B67DFB8");
    }
}
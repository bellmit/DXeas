package com.kingdee.eas.farm.pig.breedingboar;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSpermCheckBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractSpermCheckBillInfo()
    {
        this("id");
    }
    protected AbstractSpermCheckBillInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.pig.breedingboar.SpermCheckBillEntryCollection());
    }
    /**
     * Object: 精液检验记录单 's 分录 property 
     */
    public com.kingdee.eas.farm.pig.breedingboar.SpermCheckBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.pig.breedingboar.SpermCheckBillEntryCollection)get("entrys");
    }
    /**
     * Object:精液检验记录单's 是否生成凭证property 
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
     * Object:精液检验记录单's 审核时间property 
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
     * Object: 精液检验记录单 's 养殖场 property 
     */
    public com.kingdee.eas.farm.pig.PigFarmInfo getFarm()
    {
        return (com.kingdee.eas.farm.pig.PigFarmInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.pig.PigFarmInfo item)
    {
        put("farm", item);
    }
    /**
     * Object:精液检验记录单's 状态property 
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
     * Object: 精液检验记录单 's 化验员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getCheckPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("checkPerson");
    }
    public void setCheckPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("checkPerson", item);
    }
    /**
     * Object: 精液检验记录单 's 入库员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getWarehouseOperator()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("warehouseOperator");
    }
    public void setWarehouseOperator(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("warehouseOperator", item);
    }
    /**
     * Object: 精液检验记录单 's 入库仓库 property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getWarehouse()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("warehouse");
    }
    public void setWarehouse(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("warehouse", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("EFD73B48");
    }
}
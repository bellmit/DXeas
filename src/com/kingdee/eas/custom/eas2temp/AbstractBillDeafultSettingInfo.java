package com.kingdee.eas.custom.eas2temp;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBillDeafultSettingInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractBillDeafultSettingInfo()
    {
        this("id");
    }
    protected AbstractBillDeafultSettingInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: �����м��Ĭ������ 's ��� property 
     */
    public com.kingdee.eas.custom.eas2temp.BillDeafultSettingTreeInfo getTreeid()
    {
        return (com.kingdee.eas.custom.eas2temp.BillDeafultSettingTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.custom.eas2temp.BillDeafultSettingTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: �����м��Ĭ������ 's �����֯ property 
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
     * Object: �����м��Ĭ������ 's Ĭ�ϳɱ����� property 
     */
    public com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo getCostCenterUnitOrg()
    {
        return (com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo)get("costCenterUnitOrg");
    }
    public void setCostCenterUnitOrg(com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo item)
    {
        put("costCenterUnitOrg", item);
    }
    /**
     * Object: �����м��Ĭ������ 's Ĭ��ԭ�ϲֿ� property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getYLWarehouse()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("YLWarehouse");
    }
    public void setYLWarehouse(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("YLWarehouse", item);
    }
    /**
     * Object: �����м��Ĭ������ 's Ĭ�ϻػ��ϲֿ� property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getBackWarehouse()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("backWarehouse");
    }
    public void setBackWarehouse(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("backWarehouse", item);
    }
    /**
     * Object: �����м��Ĭ������ 's Ĭ�ϳ�Ʒ�ֿ� property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getCPWarehouse()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("CPWarehouse");
    }
    public void setCPWarehouse(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("CPWarehouse", item);
    }
    /**
     * Object: �����м��Ĭ������ 's Ĭ�����ϲֿ� property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getLLWarehouse()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("LLWarehouse");
    }
    public void setLLWarehouse(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("LLWarehouse", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A3EF1474");
    }
}
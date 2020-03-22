package com.kingdee.eas.farm.pig;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPigFarmInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractPigFarmInfo()
    {
        this("id");
    }
    protected AbstractPigFarmInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ���� 's ��� property 
     */
    public com.kingdee.eas.farm.pig.PigFarmTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.pig.PigFarmTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.pig.PigFarmTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:����'s �绰property 
     */
    public String getTel()
    {
        return getString("tel");
    }
    public void setTel(String item)
    {
        setString("tel", item);
    }
    /**
     * Object:����'s ��ַproperty 
     */
    public String getAddress()
    {
        return getString("address");
    }
    public void setAddress(String item)
    {
        setString("address", item);
    }
    /**
     * Object:����'s ��������property 
     */
    public java.util.Date getBuildDate()
    {
        return getDate("buildDate");
    }
    public void setBuildDate(java.util.Date item)
    {
        setDate("buildDate", item);
    }
    /**
     * Object:����'s ������property 
     */
    public com.kingdee.eas.farm.pig.PigFarmType getPigType()
    {
        return com.kingdee.eas.farm.pig.PigFarmType.getEnum(getString("pigType"));
    }
    public void setPigType(com.kingdee.eas.farm.pig.PigFarmType item)
    {
		if (item != null) {
        setString("pigType", item.getValue());
		}
    }
    /**
     * Object: ���� 's ��Ӧ�����֯ property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStoOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("stoOrgUnit");
    }
    public void setStoOrgUnit(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("stoOrgUnit", item);
    }
    /**
     * Object: ���� 's �ɱ����� property 
     */
    public com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo getCostObject()
    {
        return (com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo)get("costObject");
    }
    public void setCostObject(com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo item)
    {
        put("costObject", item);
    }
    /**
     * Object:����'s ����property 
     */
    public String getFarmHeaderName()
    {
        return getString("farmHeaderName");
    }
    public void setFarmHeaderName(String item)
    {
        setString("farmHeaderName", item);
    }
    /**
     * Object: ���� 's ������ӦְԱ property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getFarmHeader()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("farmHeader");
    }
    public void setFarmHeader(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("farmHeader", item);
    }
    /**
     * Object: ���� 's ���Ϻ�������֯ property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getFodderStoOrg()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("fodderStoOrg");
    }
    public void setFodderStoOrg(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("fodderStoOrg", item);
    }
    /**
     * Object: ���� 's ��������֯ property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getImmuneStoOrg()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("immuneStoOrg");
    }
    public void setImmuneStoOrg(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("immuneStoOrg", item);
    }
    /**
     * Object:����'s ��ʼ������property 
     */
    public int getInitBatchCount()
    {
        return getInt("initBatchCount");
    }
    public void setInitBatchCount(int item)
    {
        setInt("initBatchCount", item);
    }
    /**
     * Object: ���� 's ���ϲֿ� property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getFodderWarehouse()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("fodderWarehouse");
    }
    public void setFodderWarehouse(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("fodderWarehouse", item);
    }
    /**
     * Object: ���� 's ����ֿ� property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getImmuneWarehouse()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("immuneWarehouse");
    }
    public void setImmuneWarehouse(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("immuneWarehouse", item);
    }
    /**
     * Object: ���� 's ���������֯ property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getPigStoOrg()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("pigStoOrg");
    }
    public void setPigStoOrg(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("pigStoOrg", item);
    }
    /**
     * Object: ���� 's �����ֿ� property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getPigWarehouse()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("pigWarehouse");
    }
    public void setPigWarehouse(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("pigWarehouse", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("FFF944A4");
    }
}
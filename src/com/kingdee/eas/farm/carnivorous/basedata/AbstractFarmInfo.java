package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFarmInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractFarmInfo()
    {
        this("id");
    }
    protected AbstractFarmInfo(String pkField)
    {
        super(pkField);
        put("HouseEntry", new com.kingdee.eas.farm.carnivorous.basedata.FarmHouseEntryCollection());
    }
    /**
     * Object: ��ֳ�� 's ��� property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.carnivorous.basedata.FarmTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:��ֳ��'s ��ַproperty 
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
     * Object:��ֳ��'s ��ֳ���property 
     */
    public java.math.BigDecimal getArea()
    {
        return getBigDecimal("area");
    }
    public void setArea(java.math.BigDecimal item)
    {
        setBigDecimal("area", item);
    }
    /**
     * Object:��ֳ��'s ״̬property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum getBaseStatus()
    {
        return com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum.getEnum(getInt("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum item)
    {
		if (item != null) {
        setInt("baseStatus", item.getValue());
		}
    }
    /**
     * Object:��ֳ��'s ��������property 
     */
    public int getSuccahQty()
    {
        return getInt("succahQty");
    }
    public void setSuccahQty(int item)
    {
        setInt("succahQty", item);
    }
    /**
     * Object: ��ֳ�� 's ������֯ property 
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
     * Object: ��ֳ�� 's ������Ϣ property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmHouseEntryCollection getHouseEntry()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmHouseEntryCollection)get("HouseEntry");
    }
    /**
     * Object:��ֳ��'s �������property 
     */
    public java.math.BigDecimal getFloorArea()
    {
        return getBigDecimal("floorArea");
    }
    public void setFloorArea(java.math.BigDecimal item)
    {
        setBigDecimal("floorArea", item);
    }
    /**
     * Object: ��ֳ�� 's �ɱ����� property 
     */
    public com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo getCostCenter()
    {
        return (com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo)get("costCenter");
    }
    public void setCostCenter(com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo item)
    {
        put("costCenter", item);
    }
    /**
     * Object:��ֳ��'s �������property 
     */
    public boolean isIsHouseManager()
    {
        return getBoolean("isHouseManager");
    }
    public void setIsHouseManager(boolean item)
    {
        setBoolean("isHouseManager", item);
    }
    /**
     * Object: ��ֳ�� 's ������ property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getWarehouse()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("warehouse");
    }
    public void setWarehouse(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("warehouse", item);
    }
    /**
     * Object: ��ֳ�� 's �����֯ property 
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
     * Object:��ֳ��'s ��ֳ�����property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StockingFarmTypeEnum getFarmType()
    {
        return com.kingdee.eas.farm.stocking.basedata.StockingFarmTypeEnum.getEnum(getInt("farmType"));
    }
    public void setFarmType(com.kingdee.eas.farm.stocking.basedata.StockingFarmTypeEnum item)
    {
		if (item != null) {
        setInt("farmType", item.getValue());
		}
    }
    /**
     * Object: ��ֳ�� 's ��ֳ�� property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo getFarmer()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo)get("farmer");
    }
    public void setFarmer(com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo item)
    {
        put("farmer", item);
    }
    /**
     * Object:��ֳ��'s ���������2property 
     */
    public java.math.BigDecimal getMileStd()
    {
        return getBigDecimal("mileStd");
    }
    public void setMileStd(java.math.BigDecimal item)
    {
        setBigDecimal("mileStd", item);
    }
    /**
     * Object:��ֳ��'s ���������1property 
     */
    public java.math.BigDecimal getRecyMiles()
    {
        return getBigDecimal("recyMiles");
    }
    public void setRecyMiles(java.math.BigDecimal item)
    {
        setBigDecimal("recyMiles", item);
    }
    /**
     * Object:��ֳ��'s �����property 
     */
    public String getMnemonicCode()
    {
        return getString("mnemonicCode");
    }
    public void setMnemonicCode(String item)
    {
        setString("mnemonicCode", item);
    }
    /**
     * Object:��ֳ��'s �ѷ���property 
     */
    public boolean isIsAllot()
    {
        return getBoolean("isAllot");
    }
    public void setIsAllot(boolean item)
    {
        setBoolean("isAllot", item);
    }
    /**
     * Object:��ֳ��'s ��ֳ��ģproperty 
     */
    public String getGm()
    {
        return getString("gm");
    }
    public void setGm(String item)
    {
        setString("gm", item);
    }
    /**
     * Object:��ֳ��'s ��ֳģʽproperty 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmsType getFaemsType()
    {
        return com.kingdee.eas.farm.stocking.basedata.FarmsType.getEnum(getString("faemsType"));
    }
    public void setFaemsType(com.kingdee.eas.farm.stocking.basedata.FarmsType item)
    {
		if (item != null) {
        setString("faemsType", item.getValue());
		}
    }
    /**
     * Object:��ֳ��'s ��ʼ����������property 
     */
    public int getInitSettleBatchNum()
    {
        return getInt("initSettleBatchNum");
    }
    public void setInitSettleBatchNum(int item)
    {
        setInt("initSettleBatchNum", item);
    }
    /**
     * Object:��ֳ��'s �ۼƽ�������property 
     */
    public int getTotalSettleBatchNum()
    {
        return getInt("totalSettleBatchNum");
    }
    public void setTotalSettleBatchNum(int item)
    {
        setInt("totalSettleBatchNum", item);
    }
    /**
     * Object:��ֳ��'s �ѽ�������property 
     */
    public int getSettledBatchNum()
    {
        return getInt("settledBatchNum");
    }
    public void setSettledBatchNum(int item)
    {
        setInt("settledBatchNum", item);
    }
    /**
     * Object:��ֳ��'s �ϲ�property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.BunkerEnum getBunker()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.BunkerEnum.getEnum(getString("bunker"));
    }
    public void setBunker(com.kingdee.eas.farm.carnivorous.basedata.BunkerEnum item)
    {
		if (item != null) {
        setString("bunker", item.getValue());
		}
    }
    /**
     * Object:��ֳ��'s ���ϲ�����property 
     */
    public java.util.Date getBunkerBuildDate()
    {
        return getDate("bunkerBuildDate");
    }
    public void setBunkerBuildDate(java.util.Date item)
    {
        setDate("bunkerBuildDate", item);
    }
    /**
     * Object:��ֳ��'s ��֤���ܽ��property 
     */
    public java.math.BigDecimal getMarginAmt()
    {
        return getBigDecimal("marginAmt");
    }
    public void setMarginAmt(java.math.BigDecimal item)
    {
        setBigDecimal("marginAmt", item);
    }
    /**
     * Object:��ֳ��'s ����ܶ�property 
     */
    public java.math.BigDecimal getBorrowAmt()
    {
        return getBigDecimal("borrowAmt");
    }
    public void setBorrowAmt(java.math.BigDecimal item)
    {
        setBigDecimal("borrowAmt", item);
    }
    /**
     * Object:��ֳ��'s �˷ѵ���property 
     */
    public java.math.BigDecimal getTransPrice()
    {
        return getBigDecimal("transPrice");
    }
    public void setTransPrice(java.math.BigDecimal item)
    {
        setBigDecimal("transPrice", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E33948D8");
    }
}
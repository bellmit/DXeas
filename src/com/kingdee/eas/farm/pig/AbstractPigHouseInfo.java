package com.kingdee.eas.farm.pig;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPigHouseInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractPigHouseInfo()
    {
        this("id");
    }
    protected AbstractPigHouseInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 猪舍 's 组别 property 
     */
    public com.kingdee.eas.farm.pig.PigHouseTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.pig.PigHouseTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.pig.PigHouseTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:猪舍's 面积(m?)property 
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
     * Object: 猪舍 's 养殖场 property 
     */
    public com.kingdee.eas.farm.pig.PigFarmInfo getPigFarm()
    {
        return (com.kingdee.eas.farm.pig.PigFarmInfo)get("pigFarm");
    }
    public void setPigFarm(com.kingdee.eas.farm.pig.PigFarmInfo item)
    {
        put("pigFarm", item);
    }
    /**
     * Object:猪舍's 状态property 
     */
    public com.kingdee.eas.farm.pig.DisableState getDeletedStatus()
    {
        return com.kingdee.eas.farm.pig.DisableState.getEnum(getInt("deletedStatus"));
    }
    public void setDeletedStatus(com.kingdee.eas.farm.pig.DisableState item)
    {
		if (item != null) {
        setInt("deletedStatus", item.getValue());
		}
    }
    /**
     * Object: 猪舍 's 对应库存组织 property 
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
     * Object:猪舍's 标准饲养头数property 
     */
    public int getStandardPigQty()
    {
        return getInt("standardPigQty");
    }
    public void setStandardPigQty(int item)
    {
        setInt("standardPigQty", item);
    }
    /**
     * Object:猪舍's 猪舍类别property 
     */
    public com.kingdee.eas.farm.pig.PigHouseType getPigHouseType()
    {
        return com.kingdee.eas.farm.pig.PigHouseType.getEnum(getString("pigHouseType"));
    }
    public void setPigHouseType(com.kingdee.eas.farm.pig.PigHouseType item)
    {
		if (item != null) {
        setString("pigHouseType", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("FF51E872");
    }
}
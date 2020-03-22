package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractTtfiledInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractTtfiledInfo()
    {
        this("id");
    }
    protected AbstractTtfiledInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:技术员巡场记录单's 是否生成凭证property 
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
     * Object: 技术员巡场记录单 's 财务组织 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getBIMUDF0001()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("BIMUDF0001");
    }
    public void setBIMUDF0001(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("BIMUDF0001", item);
    }
    /**
     * Object: 技术员巡场记录单 's 养殖户 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo getBIMUDF0003()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo)get("BIMUDF0003");
    }
    public void setBIMUDF0003(com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo item)
    {
        put("BIMUDF0003", item);
    }
    /**
     * Object: 技术员巡场记录单 's 养殖场 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmInfo getBIMUDF0002()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmInfo)get("BIMUDF0002");
    }
    public void setBIMUDF0002(com.kingdee.eas.farm.carnivorous.basedata.FarmInfo item)
    {
        put("BIMUDF0002", item);
    }
    /**
     * Object: 技术员巡场记录单 's 技术员 property 
     */
    public com.kingdee.eas.custom.salepayment.TechnicianInfo getBIMUDF0004()
    {
        return (com.kingdee.eas.custom.salepayment.TechnicianInfo)get("BIMUDF0004");
    }
    public void setBIMUDF0004(com.kingdee.eas.custom.salepayment.TechnicianInfo item)
    {
        put("BIMUDF0004", item);
    }
    /**
     * Object:技术员巡场记录单's 状态property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.PurType getBIMUDF0005()
    {
        return com.kingdee.eas.farm.stocking.processbizill.PurType.getEnum(getString("BIMUDF0005"));
    }
    public void setBIMUDF0005(com.kingdee.eas.farm.stocking.processbizill.PurType item)
    {
		if (item != null) {
        setString("BIMUDF0005", item.getValue());
		}
    }
    /**
     * Object: 技术员巡场记录单 's 放养批次： property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.BatchInfo getBIMUDF0006()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.BatchInfo)get("BIMUDF0006");
    }
    public void setBIMUDF0006(com.kingdee.eas.farm.carnivorous.basedata.BatchInfo item)
    {
        put("BIMUDF0006", item);
    }
    /**
     * Object:技术员巡场记录单's 存栏量：property 
     */
    public java.math.BigDecimal getBIMUDF0008()
    {
        return getBigDecimal("BIMUDF0008");
    }
    public void setBIMUDF0008(java.math.BigDecimal item)
    {
        setBigDecimal("BIMUDF0008", item);
    }
    /**
     * Object:技术员巡场记录单's 设备情况：property 
     */
    public String getBIMUDF0013()
    {
        return getString("BIMUDF0013");
    }
    public void setBIMUDF0013(String item)
    {
        setString("BIMUDF0013", item);
    }
    /**
     * Object:技术员巡场记录单's 药品情况：property 
     */
    public String getBIMUDF0012()
    {
        return getString("BIMUDF0012");
    }
    public void setBIMUDF0012(String item)
    {
        setString("BIMUDF0012", item);
    }
    /**
     * Object:技术员巡场记录单's 死淘量：property 
     */
    public java.math.BigDecimal getBIMUDF0009()
    {
        return getBigDecimal("BIMUDF0009");
    }
    public void setBIMUDF0009(java.math.BigDecimal item)
    {
        setBigDecimal("BIMUDF0009", item);
    }
    /**
     * Object:技术员巡场记录单's 棚舍温度：property 
     */
    public String getBIMUDF0010()
    {
        return getString("BIMUDF0010");
    }
    public void setBIMUDF0010(String item)
    {
        setString("BIMUDF0010", item);
    }
    /**
     * Object:技术员巡场记录单's 棚舍湿度：property 
     */
    public String getBIMUDF0011()
    {
        return getString("BIMUDF0011");
    }
    public void setBIMUDF0011(String item)
    {
        setString("BIMUDF0011", item);
    }
    /**
     * Object:技术员巡场记录单's 日龄：property 
     */
    public java.math.BigDecimal getBIMUDF0007()
    {
        return getBigDecimal("BIMUDF0007");
    }
    public void setBIMUDF0007(java.math.BigDecimal item)
    {
        setBigDecimal("BIMUDF0007", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("44B1D4E3");
    }
}
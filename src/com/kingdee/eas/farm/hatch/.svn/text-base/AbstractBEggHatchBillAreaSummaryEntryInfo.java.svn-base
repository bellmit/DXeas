package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBEggHatchBillAreaSummaryEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBEggHatchBillAreaSummaryEntryInfo()
    {
        this("id");
    }
    protected AbstractBEggHatchBillAreaSummaryEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 片区汇总 's null property 
     */
    public com.kingdee.eas.farm.hatch.BEggHatchBillInfo getParent()
    {
        return (com.kingdee.eas.farm.hatch.BEggHatchBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.hatch.BEggHatchBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 片区汇总 's 片区 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo getOutArea()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo)get("outArea");
    }
    public void setOutArea(com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo item)
    {
        put("outArea", item);
    }
    /**
     * Object:片区汇总's 合格蛋分类property 
     */
    public com.kingdee.eas.farm.hatch.QcEggTypeEnum getQcEggType()
    {
        return com.kingdee.eas.farm.hatch.QcEggTypeEnum.getEnum(getInt("qcEggType"));
    }
    public void setQcEggType(com.kingdee.eas.farm.hatch.QcEggTypeEnum item)
    {
		if (item != null) {
        setInt("qcEggType", item.getValue());
		}
    }
    /**
     * Object:片区汇总's 上孵数量property 
     */
    public int getEggQty()
    {
        return getInt("eggQty");
    }
    public void setEggQty(int item)
    {
        setInt("eggQty", item);
    }
    /**
     * Object: 片区汇总 's 供应商 property 
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
     * Object:片区汇总's 品系property 
     */
    public com.kingdee.eas.farm.stocking.hatch.GenderType getGenderType()
    {
        return com.kingdee.eas.farm.stocking.hatch.GenderType.getEnum(getString("genderType"));
    }
    public void setGenderType(com.kingdee.eas.farm.stocking.hatch.GenderType item)
    {
		if (item != null) {
        setString("genderType", item.getValue());
		}
    }
    /**
     * Object: 片区汇总 's 养殖户 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmersInfo getFarmer()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmersInfo)get("farmer");
    }
    public void setFarmer(com.kingdee.eas.farm.stocking.basedata.FarmersInfo item)
    {
        put("farmer", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1EE6CDCF");
    }
}
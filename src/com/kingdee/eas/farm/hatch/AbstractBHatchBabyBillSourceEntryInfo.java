package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBHatchBabyBillSourceEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBHatchBabyBillSourceEntryInfo()
    {
        this("id");
    }
    protected AbstractBHatchBabyBillSourceEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: �������� 's null property 
     */
    public com.kingdee.eas.farm.hatch.BHatchBabyBillInfo getParent()
    {
        return (com.kingdee.eas.farm.hatch.BHatchBabyBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.hatch.BHatchBabyBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:��������'s ����property 
     */
    public int getDeadGermQty()
    {
        return getInt("deadGermQty");
    }
    public void setDeadGermQty(int item)
    {
        setInt("deadGermQty", item);
    }
    /**
     * Object:��������'s ��Ʒproperty 
     */
    public int getHealthQty()
    {
        return getInt("healthQty");
    }
    public void setHealthQty(int item)
    {
        setInt("healthQty", item);
    }
    /**
     * Object: �������� 's ��Ӧ�� property 
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
     * Object:��������'s ��Ʒproperty 
     */
    public int getHealthQtyB()
    {
        return getInt("healthQtyB");
    }
    public void setHealthQtyB(int item)
    {
        setInt("healthQtyB", item);
    }
    /**
     * Object:��������'s һ��property 
     */
    public int getHealthQtyA1()
    {
        return getInt("healthQtyA1");
    }
    public void setHealthQtyA1(int item)
    {
        setInt("healthQtyA1", item);
    }
    /**
     * Object:��������'s ����property 
     */
    public int getHealthQtyA2()
    {
        return getInt("healthQtyA2");
    }
    public void setHealthQtyA2(int item)
    {
        setInt("healthQtyA2", item);
    }
    /**
     * Object:��������'s ����property 
     */
    public int getHealthQtyA3()
    {
        return getInt("healthQtyA3");
    }
    public void setHealthQtyA3(int item)
    {
        setInt("healthQtyA3", item);
    }
    /**
     * Object:��������'s �ϸ�����property 
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
     * Object:��������'s �г�2property 
     */
    public int getGermQty2()
    {
        return getInt("GermQty2");
    }
    public void setGermQty2(int item)
    {
        setInt("GermQty2", item);
    }
    /**
     * Object:��������'s ������property 
     */
    public int getOutQty()
    {
        return getInt("outQty");
    }
    public void setOutQty(int item)
    {
        setInt("outQty", item);
    }
    /**
     * Object: �������� 's Ƭ�� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo getOutAreaP()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo)get("outAreaP");
    }
    public void setOutAreaP(com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo item)
    {
        put("outAreaP", item);
    }
    /**
     * Object:��������'s �Ϸ�����property 
     */
    public int getHatchQty()
    {
        return getInt("hatchQty");
    }
    public void setHatchQty(int item)
    {
        setInt("hatchQty", item);
    }
    /**
     * Object:��������'s ���̻���property 
     */
    public int getTrayingHealthEggQty()
    {
        return getInt("trayingHealthEggQty");
    }
    public void setTrayingHealthEggQty(int item)
    {
        setInt("trayingHealthEggQty", item);
    }
    /**
     * Object:��������'s �ۼƳ���property 
     */
    public int getAllOutQty()
    {
        return getInt("allOutQty");
    }
    public void setAllOutQty(int item)
    {
        setInt("allOutQty", item);
    }
    /**
     * Object:��������'s Ʒϵproperty 
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
     * Object:��������'s �ֵ���Դproperty 
     */
    public com.kingdee.eas.farm.hatch.EggSourceType getEggSource()
    {
        return com.kingdee.eas.farm.hatch.EggSourceType.getEnum(getInt("eggSource"));
    }
    public void setEggSource(com.kingdee.eas.farm.hatch.EggSourceType item)
    {
		if (item != null) {
        setInt("eggSource", item.getValue());
		}
    }
    /**
     * Object: �������� 's �ϸ����� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.QcEggTypeInfo getQcEggsType()
    {
        return (com.kingdee.eas.farm.stocking.basedata.QcEggTypeInfo)get("qcEggsType");
    }
    public void setQcEggsType(com.kingdee.eas.farm.stocking.basedata.QcEggTypeInfo item)
    {
        put("qcEggsType", item);
    }
    /**
     * Object:��������'s ë��property 
     */
    public int getMaoQty()
    {
        return getInt("maoQty");
    }
    public void setMaoQty(int item)
    {
        setInt("maoQty", item);
    }
    /**
     * Object:��������'s ����property 
     */
    public int getKuiQty()
    {
        return getInt("kuiQty");
    }
    public void setKuiQty(int item)
    {
        setInt("kuiQty", item);
    }
    /**
     * Object:��������'s С��property 
     */
    public int getLittleChickQty()
    {
        return getInt("littleChickQty");
    }
    public void setLittleChickQty(int item)
    {
        setInt("littleChickQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("CFA956AE");
    }
}
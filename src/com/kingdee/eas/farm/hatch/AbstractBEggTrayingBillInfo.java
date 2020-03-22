package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBEggTrayingBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractBEggTrayingBillInfo()
    {
        this("id");
    }
    protected AbstractBEggTrayingBillInfo(String pkField)
    {
        super(pkField);
        put("EggEntries", new com.kingdee.eas.farm.hatch.BEggTrayingBillEggEntryCollection());
        put("TransBoxEntries", new com.kingdee.eas.farm.hatch.BEggTrayingBillTransBoxEntryCollection());
    }
    /**
     * Object:���̼�¼��'s �Ƿ�����ƾ֤property 
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
     * Object:���̼�¼��'s �������property 
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
     * Object:���̼�¼��'s ״̬property 
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
     * Object: ���̼�¼�� 's ������ property 
     */
    public com.kingdee.eas.farm.hatch.HatchBaseDataInfo getHatchFactory()
    {
        return (com.kingdee.eas.farm.hatch.HatchBaseDataInfo)get("hatchFactory");
    }
    public void setHatchFactory(com.kingdee.eas.farm.hatch.HatchBaseDataInfo item)
    {
        put("hatchFactory", item);
    }
    /**
     * Object:���̼�¼��'s �Ϸ�����property 
     */
    public int getAllHatchEggQty()
    {
        return getInt("allHatchEggQty");
    }
    public void setAllHatchEggQty(int item)
    {
        setInt("allHatchEggQty", item);
    }
    /**
     * Object: ���̼�¼�� 's ����Ա property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getOperator()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("operator");
    }
    public void setOperator(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("operator", item);
    }
    /**
     * Object:���̼�¼��'s ����property 
     */
    public int getAllHealthEggQty()
    {
        return getInt("allHealthEggQty");
    }
    public void setAllHealthEggQty(int item)
    {
        setInt("allHealthEggQty", item);
    }
    /**
     * Object: ���̼�¼�� 's ������� property 
     */
    public com.kingdee.eas.farm.hatch.HatchAreaInfo getHatchArea()
    {
        return (com.kingdee.eas.farm.hatch.HatchAreaInfo)get("hatchArea");
    }
    public void setHatchArea(com.kingdee.eas.farm.hatch.HatchAreaInfo item)
    {
        put("hatchArea", item);
    }
    /**
     * Object: ���̼�¼�� 's ������ property 
     */
    public com.kingdee.eas.farm.hatch.IncubatorInfo getIncubator()
    {
        return (com.kingdee.eas.farm.hatch.IncubatorInfo)get("incubator");
    }
    public void setIncubator(com.kingdee.eas.farm.hatch.IncubatorInfo item)
    {
        put("incubator", item);
    }
    /**
     * Object:���̼�¼��'s �������property 
     */
    public int getOtherLoss()
    {
        return getInt("otherLoss");
    }
    public void setOtherLoss(int item)
    {
        setInt("otherLoss", item);
    }
    /**
     * Object: ���̼�¼�� 's ���̼�¼��ϸ property 
     */
    public com.kingdee.eas.farm.hatch.BEggTrayingBillEggEntryCollection getEggEntries()
    {
        return (com.kingdee.eas.farm.hatch.BEggTrayingBillEggEntryCollection)get("EggEntries");
    }
    /**
     * Object:���̼�¼��'s ����property 
     */
    public int getAllAddleEggQty()
    {
        return getInt("allAddleEggQty");
    }
    public void setAllAddleEggQty(int item)
    {
        setInt("allAddleEggQty", item);
    }
    /**
     * Object:���̼�¼��'s �յ���������property 
     */
    public int getAllCandlingHealthEggQty()
    {
        return getInt("allCandlingHealthEggQty");
    }
    public void setAllCandlingHealthEggQty(int item)
    {
        setInt("allCandlingHealthEggQty", item);
    }
    /**
     * Object: ���̼�¼�� 's ת���¼ property 
     */
    public com.kingdee.eas.farm.hatch.BEggTrayingBillTransBoxEntryCollection getTransBoxEntries()
    {
        return (com.kingdee.eas.farm.hatch.BEggTrayingBillTransBoxEntryCollection)get("TransBoxEntries");
    }
    /**
     * Object:���̼�¼��'s �Ϸ�����property 
     */
    public java.util.Date getHatchDate()
    {
        return getDate("hatchDate");
    }
    public void setHatchDate(java.util.Date item)
    {
        setDate("hatchDate", item);
    }
    /**
     * Object:���̼�¼��'s �յ�����property 
     */
    public java.util.Date getEggCandling()
    {
        return getDate("eggCandling");
    }
    public void setEggCandling(java.util.Date item)
    {
        setDate("eggCandling", item);
    }
    /**
     * Object:���̼�¼��'s �ֵ�����property 
     */
    public com.kingdee.eas.farm.hatch.EggType getEggType()
    {
        return com.kingdee.eas.farm.hatch.EggType.getEnum(getString("eggType"));
    }
    public void setEggType(com.kingdee.eas.farm.hatch.EggType item)
    {
		if (item != null) {
        setString("eggType", item.getValue());
		}
    }
    /**
     * Object: ���̼�¼�� 's �������ݺ� property 
     */
    public com.kingdee.eas.farm.hatch.BEggTrayingBillInfo getAdjustBill()
    {
        return (com.kingdee.eas.farm.hatch.BEggTrayingBillInfo)get("adjustBill");
    }
    public void setAdjustBill(com.kingdee.eas.farm.hatch.BEggTrayingBillInfo item)
    {
        put("adjustBill", item);
    }
    /**
     * Object:���̼�¼��'s Ʒϵ���property 
     */
    public com.kingdee.eas.farm.stocking.hatch.GenderType getGrentTy()
    {
        return com.kingdee.eas.farm.stocking.hatch.GenderType.getEnum(getString("grentTy"));
    }
    public void setGrentTy(com.kingdee.eas.farm.stocking.hatch.GenderType item)
    {
		if (item != null) {
        setString("grentTy", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("92957B02");
    }
}
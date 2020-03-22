package com.kingdee.eas.custom.dx.weight;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCarSendBillInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBaseInfo implements Serializable 
{
    public AbstractCarSendBillInfo()
    {
        this("id");
    }
    protected AbstractCarSendBillInfo(String pkField)
    {
        super(pkField);
        put("EntrysS", new com.kingdee.eas.custom.dx.weight.CarSendBillEntrysSCollection());
        put("Entrys", new com.kingdee.eas.custom.dx.weight.CarSendBillEntryCollection());
    }
    /**
     * Object:�ɳ���'s �Ƿ�����ƾ֤property 
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
     * Object:�ɳ���'s ����property 
     */
    public String getCarNum()
    {
        return getString("carNum");
    }
    public void setCarNum(String item)
    {
        setString("carNum", item);
    }
    /**
     * Object: �ɳ��� 's ˾�� property 
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
     * Object:�ɳ���'s ����property 
     */
    public java.math.BigDecimal getSuttleWgt()
    {
        return getBigDecimal("suttleWgt");
    }
    public void setSuttleWgt(java.math.BigDecimal item)
    {
        setBigDecimal("suttleWgt", item);
    }
    /**
     * Object:�ɳ���'s ֻ��property 
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
     * Object: �ɳ��� 's ��˾ property 
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
     * Object: �ɳ��� 's ������ϸ property 
     */
    public com.kingdee.eas.custom.dx.weight.CarSendBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.dx.weight.CarSendBillEntryCollection)get("Entrys");
    }
    /**
     * Object:�ɳ���'s �������property 
     */
    public java.math.BigDecimal getChickenSZWgt()
    {
        return getBigDecimal("chickenSZWgt");
    }
    public void setChickenSZWgt(java.math.BigDecimal item)
    {
        setBigDecimal("chickenSZWgt", item);
    }
    /**
     * Object: �ɳ��� 's ��ϸ��Ϣ property 
     */
    public com.kingdee.eas.custom.dx.weight.CarSendBillEntrysSCollection getEntrysS()
    {
        return (com.kingdee.eas.custom.dx.weight.CarSendBillEntrysSCollection)get("EntrysS");
    }
    /**
     * Object: �ɳ��� 's ���� property 
     */
    public com.kingdee.eas.publicdata.CarInfo getCar()
    {
        return (com.kingdee.eas.publicdata.CarInfo)get("car");
    }
    public void setCar(com.kingdee.eas.publicdata.CarInfo item)
    {
        put("car", item);
    }
    /**
     * Object:�ɳ���'s �ѹ�ë��property 
     */
    public boolean isIsGross()
    {
        return getBoolean("isGross");
    }
    public void setIsGross(boolean item)
    {
        setBoolean("isGross", item);
    }
    /**
     * Object:�ɳ���'s �ѹ�Ƥ��property 
     */
    public boolean isIsTara()
    {
        return getBoolean("isTara");
    }
    public void setIsTara(boolean item)
    {
        setBoolean("isTara", item);
    }
    /**
     * Object:�ɳ���'s ��ë��property 
     */
    public java.math.BigDecimal getSumGross()
    {
        return getBigDecimal("sumGross");
    }
    public void setSumGross(java.math.BigDecimal item)
    {
        setBigDecimal("sumGross", item);
    }
    /**
     * Object:�ɳ���'s ��Ƥ��property 
     */
    public java.math.BigDecimal getSumTara()
    {
        return getBigDecimal("sumTara");
    }
    public void setSumTara(java.math.BigDecimal item)
    {
        setBigDecimal("sumTara", item);
    }
    /**
     * Object: �ɳ��� 's ԭ�Ϲ�Ӧ�� property 
     */
    public com.kingdee.eas.custom.dx.weight.StapleSupplierInfo getStaplesupplier()
    {
        return (com.kingdee.eas.custom.dx.weight.StapleSupplierInfo)get("staplesupplier");
    }
    public void setStaplesupplier(com.kingdee.eas.custom.dx.weight.StapleSupplierInfo item)
    {
        put("staplesupplier", item);
    }
    /**
     * Object:�ɳ���'s �Ƿ�������property 
     */
    public boolean isIsweight()
    {
        return getBoolean("isweight");
    }
    public void setIsweight(boolean item)
    {
        setBoolean("isweight", item);
    }
    /**
     * Object:�ɳ���'s ��ֳ��property 
     */
    public String getFarm()
    {
        return getString("farm");
    }
    public void setFarm(String item)
    {
        setString("farm", item);
    }
    /**
     * Object:�ɳ���'s �Ƿ����property 
     */
    public boolean isIsSettle()
    {
        return getBoolean("isSettle");
    }
    public void setIsSettle(boolean item)
    {
        setBoolean("isSettle", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("9BC90962");
    }
}
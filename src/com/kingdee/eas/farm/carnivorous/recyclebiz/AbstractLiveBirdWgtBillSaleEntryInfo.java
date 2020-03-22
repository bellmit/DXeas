package com.kingdee.eas.farm.carnivorous.recyclebiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractLiveBirdWgtBillSaleEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractLiveBirdWgtBillSaleEntryInfo()
    {
        this("id");
    }
    protected AbstractLiveBirdWgtBillSaleEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: �������� 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.LiveBirdWgtBillInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.LiveBirdWgtBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.recyclebiz.LiveBirdWgtBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:��������'s ҵ������property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.SaleBizType getSalebizType()
    {
        return com.kingdee.eas.farm.carnivorous.recyclebiz.SaleBizType.getEnum(getString("salebizType"));
    }
    public void setSalebizType(com.kingdee.eas.farm.carnivorous.recyclebiz.SaleBizType item)
    {
		if (item != null) {
        setString("salebizType", item.getValue());
		}
    }
    /**
     * Object: �������� 's �ɹ���֯ property 
     */
    public com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo getPurchaseOrg()
    {
        return (com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo)get("purchaseOrg");
    }
    public void setPurchaseOrg(com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo item)
    {
        put("purchaseOrg", item);
    }
    /**
     * Object: �������� 's �ͻ� property 
     */
    public com.kingdee.eas.basedata.master.cssp.CustomerInfo getCustomer()
    {
        return (com.kingdee.eas.basedata.master.cssp.CustomerInfo)get("customer");
    }
    public void setCustomer(com.kingdee.eas.basedata.master.cssp.CustomerInfo item)
    {
        put("customer", item);
    }
    /**
     * Object:��������'s ��������property 
     */
    public java.math.BigDecimal getSaleWgt()
    {
        return getBigDecimal("saleWgt");
    }
    public void setSaleWgt(java.math.BigDecimal item)
    {
        setBigDecimal("saleWgt", item);
    }
    /**
     * Object: �������� 's ���� property 
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
     * Object: �������� 's ˾�� property 
     */
    public com.kingdee.eas.farm.feemanager.basedata.DriverInfo getDriver()
    {
        return (com.kingdee.eas.farm.feemanager.basedata.DriverInfo)get("driver");
    }
    public void setDriver(com.kingdee.eas.farm.feemanager.basedata.DriverInfo item)
    {
        put("driver", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("243D8662");
    }
}
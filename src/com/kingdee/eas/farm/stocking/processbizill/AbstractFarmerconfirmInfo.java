package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFarmerconfirmInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractFarmerconfirmInfo()
    {
        this("id");
    }
    protected AbstractFarmerconfirmInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:��ֳ��ȷ�ϵ�'s �Ƿ�����ƾ֤property 
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
     * Object: ��ֳ��ȷ�ϵ� 's ������֯�� property 
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
     * Object: ��ֳ��ȷ�ϵ� 's ��ֳ���� property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo getBIMUDF0002()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo)get("BIMUDF0002");
    }
    public void setBIMUDF0002(com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo item)
    {
        put("BIMUDF0002", item);
    }
    /**
     * Object: ��ֳ��ȷ�ϵ� 's ��ֳ���� property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmInfo getBIMUDF0003()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmInfo)get("BIMUDF0003");
    }
    public void setBIMUDF0003(com.kingdee.eas.farm.carnivorous.basedata.FarmInfo item)
    {
        put("BIMUDF0003", item);
    }
    /**
     * Object: ��ֳ��ȷ�ϵ� 's ����Ա�� property 
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
     * Object: ��ֳ��ȷ�ϵ� 's �������Σ� property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.BatchInfo getBIMUDF0005()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.BatchInfo)get("BIMUDF0005");
    }
    public void setBIMUDF0005(com.kingdee.eas.farm.carnivorous.basedata.BatchInfo item)
    {
        put("BIMUDF0005", item);
    }
    /**
     * Object:��ֳ��ȷ�ϵ�'s ��������property 
     */
    public java.math.BigDecimal getBIMUDF0006()
    {
        return getBigDecimal("BIMUDF0006");
    }
    public void setBIMUDF0006(java.math.BigDecimal item)
    {
        setBigDecimal("BIMUDF0006", item);
    }
    /**
     * Object:��ֳ��ȷ�ϵ�'s ���䣺property 
     */
    public java.math.BigDecimal getBIMUDF0007()
    {
        return getBigDecimal("BIMUDF0007");
    }
    public void setBIMUDF0007(java.math.BigDecimal item)
    {
        setBigDecimal("BIMUDF0007", item);
    }
    /**
     * Object:��ֳ��ȷ�ϵ�'s ��������property 
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
     * Object:��ֳ��ȷ�ϵ�'s �����¶ȣ�property 
     */
    public String getBIMUDF0009()
    {
        return getString("BIMUDF0009");
    }
    public void setBIMUDF0009(String item)
    {
        setString("BIMUDF0009", item);
    }
    /**
     * Object:��ֳ��ȷ�ϵ�'s ����ʪ�ȣ�property 
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
     * Object:��ֳ��ȷ�ϵ�'s ҩƷ�����property 
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
     * Object:��ֳ��ȷ�ϵ�'s �豸�����property 
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
     * Object:��ֳ��ȷ�ϵ�'s ��ע��property 
     */
    public String getBIMUDF0013()
    {
        return getString("BIMUDF0013");
    }
    public void setBIMUDF0013(String item)
    {
        setString("BIMUDF0013", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C2FFE2B8");
    }
}
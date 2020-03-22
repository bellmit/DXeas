package com.kingdee.eas.farm.carnivorous.recyclebiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractLiveBirdWgtBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractLiveBirdWgtBillInfo()
    {
        this("id");
    }
    protected AbstractLiveBirdWgtBillInfo(String pkField)
    {
        super(pkField);
        put("SaleEntrys", new com.kingdee.eas.farm.carnivorous.recyclebiz.LiveBirdWgtBillSaleEntryCollection());
    }
    /**
     * Object:���ݹ�����'s �Ƿ�����ƾ֤property 
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
     * Object: ���ݹ����� 's ������֯ property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getFICompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("FICompany");
    }
    public void setFICompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("FICompany", item);
    }
    /**
     * Object:���ݹ�����'s ���ʱ��property 
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
     * Object: ���ݹ����� 's ��ֳ�� property 
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
     * Object: ���ݹ����� 's ��ֳ�� property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmInfo getFarm()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.carnivorous.basedata.FarmInfo item)
    {
        put("farm", item);
    }
    /**
     * Object: ���ݹ����� 's ���κ�ͬ property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo getBatchContract()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo)get("batchContract");
    }
    public void setBatchContract(com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo item)
    {
        put("batchContract", item);
    }
    /**
     * Object: ���ݹ����� 's ��ֳ���� property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.BatchInfo getBatch()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.BatchInfo)get("batch");
    }
    public void setBatch(com.kingdee.eas.farm.carnivorous.basedata.BatchInfo item)
    {
        put("batch", item);
    }
    /**
     * Object:���ݹ�����'s ����״̬property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBillStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("billStatus", item.getValue());
		}
    }
    /**
     * Object: ���ݹ����� 's �������� property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo getSettlePolicy()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo)get("settlePolicy");
    }
    public void setSettlePolicy(com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo item)
    {
        put("settlePolicy", item);
    }
    /**
     * Object:���ݹ�����'s ��������property 
     */
    public java.util.Date getInDate()
    {
        return getDate("inDate");
    }
    public void setInDate(java.util.Date item)
    {
        setDate("inDate", item);
    }
    /**
     * Object:���ݹ�����'s ��������property 
     */
    public java.math.BigDecimal getBatchQty()
    {
        return getBigDecimal("batchQty");
    }
    public void setBatchQty(java.math.BigDecimal item)
    {
        setBigDecimal("batchQty", item);
    }
    /**
     * Object:���ݹ�����'s ����property 
     */
    public int getCarTimes()
    {
        return getInt("carTimes");
    }
    public void setCarTimes(int item)
    {
        setInt("carTimes", item);
    }
    /**
     * Object: ���ݹ����� 's ·�� property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.RoadLineInfo getRoadLine()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.RoadLineInfo)get("roadLine");
    }
    public void setRoadLine(com.kingdee.eas.farm.carnivorous.basedata.RoadLineInfo item)
    {
        put("roadLine", item);
    }
    /**
     * Object:���ݹ�����'s ��ǰƤ��property 
     */
    public java.math.BigDecimal getPreHouseTare()
    {
        return getBigDecimal("preHouseTare");
    }
    public void setPreHouseTare(java.math.BigDecimal item)
    {
        setBigDecimal("preHouseTare", item);
    }
    /**
     * Object:���ݹ�����'s ��ǰë��property 
     */
    public java.math.BigDecimal getPreHouseGross()
    {
        return getBigDecimal("preHouseGross");
    }
    public void setPreHouseGross(java.math.BigDecimal item)
    {
        setBigDecimal("preHouseGross", item);
    }
    /**
     * Object:���ݹ�����'s ��ǰ����property 
     */
    public java.math.BigDecimal getPreHouseSuttle()
    {
        return getBigDecimal("preHouseSuttle");
    }
    public void setPreHouseSuttle(java.math.BigDecimal item)
    {
        setBigDecimal("preHouseSuttle", item);
    }
    /**
     * Object:���ݹ�����'s ����ֻ��property 
     */
    public int getDeathQty()
    {
        return getInt("deathQty");
    }
    public void setDeathQty(int item)
    {
        setInt("deathQty", item);
    }
    /**
     * Object:���ݹ�����'s ��ǰֻ��property 
     */
    public int getPreHouseQty()
    {
        return getInt("preHouseQty");
    }
    public void setPreHouseQty(int item)
    {
        setInt("preHouseQty", item);
    }
    /**
     * Object:���ݹ�����'s ��������property 
     */
    public java.math.BigDecimal getDeathWgt()
    {
        return getBigDecimal("deathWgt");
    }
    public void setDeathWgt(java.math.BigDecimal item)
    {
        setBigDecimal("deathWgt", item);
    }
    /**
     * Object:���ݹ�����'s ��ἦֻ��property 
     */
    public int getSocialQty()
    {
        return getInt("socialQty");
    }
    public void setSocialQty(int item)
    {
        setInt("socialQty", item);
    }
    /**
     * Object:���ݹ�����'s ��ἦ����property 
     */
    public java.math.BigDecimal getSocialWgt()
    {
        return getBigDecimal("socialWgt");
    }
    public void setSocialWgt(java.math.BigDecimal item)
    {
        setBigDecimal("socialWgt", item);
    }
    /**
     * Object:���ݹ�����'s ���ؼ�ֻ��property 
     */
    public int getOverWgtQty()
    {
        return getInt("overWgtQty");
    }
    public void setOverWgtQty(int item)
    {
        setInt("overWgtQty", item);
    }
    /**
     * Object:���ݹ�����'s ���ؼ�����property 
     */
    public java.math.BigDecimal getOverWgtWgt()
    {
        return getBigDecimal("overWgtWgt");
    }
    public void setOverWgtWgt(java.math.BigDecimal item)
    {
        setBigDecimal("overWgtWgt", item);
    }
    /**
     * Object:���ݹ�����'s ����ֻ��property 
     */
    public int getSettleQty()
    {
        return getInt("settleQty");
    }
    public void setSettleQty(int item)
    {
        setInt("settleQty", item);
    }
    /**
     * Object:���ݹ�����'s ����property 
     */
    public java.math.BigDecimal getAverageWgt()
    {
        return getBigDecimal("averageWgt");
    }
    public void setAverageWgt(java.math.BigDecimal item)
    {
        setBigDecimal("averageWgt", item);
    }
    /**
     * Object: ���ݹ����� 's �������� property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.LiveBirdWgtBillSaleEntryCollection getSaleEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.LiveBirdWgtBillSaleEntryCollection)get("SaleEntrys");
    }
    /**
     * Object: ���ݹ����� 's ҵ��Ա property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("person");
    }
    public void setPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("person", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("90D40009");
    }
}
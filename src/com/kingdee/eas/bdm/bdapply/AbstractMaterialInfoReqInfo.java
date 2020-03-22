package com.kingdee.eas.bdm.bdapply;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMaterialInfoReqInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractMaterialInfoReqInfo()
    {
        this("id");
    }
    protected AbstractMaterialInfoReqInfo(String pkField)
    {
        super(pkField);
        put("MaterialStdEntry", new com.kingdee.eas.bdm.bdapply.MaterialInfoReqMaterialStdEntryCollection());
    }
    /**
     * Object:�����������뵥's �Ƿ�����ƾ֤property 
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
     * Object:�����������뵥's ���property 
     */
    public String getShortname()
    {
        return getString("shortname");
    }
    public void setShortname(String item)
    {
        setString("shortname", item);
    }
    /**
     * Object:�����������뵥's ���� property 
     */
    public String getAlias()
    {
        return getString("alias");
    }
    public void setAlias(String item)
    {
        setString("alias", item);
    }
    /**
     * Object:�����������뵥's ��������property 
     */
    public String getForeignname()
    {
        return getString("foreignname");
    }
    public void setForeignname(String item)
    {
        setString("foreignname", item);
    }
    /**
     * Object:�����������뵥's ������property 
     */
    public String getHelpCode()
    {
        return getString("helpCode");
    }
    public void setHelpCode(String item)
    {
        setString("helpCode", item);
    }
    /**
     * Object: �����������뵥 's ����������� property 
     */
    public com.kingdee.eas.basedata.master.material.AsstAttrValueInfo getAssistAtrr()
    {
        return (com.kingdee.eas.basedata.master.material.AsstAttrValueInfo)get("assistAtrr");
    }
    public void setAssistAtrr(com.kingdee.eas.basedata.master.material.AsstAttrValueInfo item)
    {
        put("assistAtrr", item);
    }
    /**
     * Object: �����������뵥 's ����������λ property 
     */
    public com.kingdee.eas.basedata.assistant.MeasureUnitInfo getBaseUnit()
    {
        return (com.kingdee.eas.basedata.assistant.MeasureUnitInfo)get("baseUnit");
    }
    public void setBaseUnit(com.kingdee.eas.basedata.assistant.MeasureUnitInfo item)
    {
        put("baseUnit", item);
    }
    /**
     * Object: �����������뵥 's ����������λ property 
     */
    public com.kingdee.eas.basedata.assistant.MeasureUnitInfo getAssistUnit()
    {
        return (com.kingdee.eas.basedata.assistant.MeasureUnitInfo)get("assistUnit");
    }
    public void setAssistUnit(com.kingdee.eas.basedata.assistant.MeasureUnitInfo item)
    {
        put("assistUnit", item);
    }
    /**
     * Object: �����������뵥 's ���кż�����λ property 
     */
    public com.kingdee.eas.basedata.assistant.MeasureUnitInfo getSeqUnit()
    {
        return (com.kingdee.eas.basedata.assistant.MeasureUnitInfo)get("seqUnit");
    }
    public void setSeqUnit(com.kingdee.eas.basedata.assistant.MeasureUnitInfo item)
    {
        put("seqUnit", item);
    }
    /**
     * Object:�����������뵥's ע���̱�property 
     */
    public String getRegisteredmark()
    {
        return getString("registeredmark");
    }
    public void setRegisteredmark(String item)
    {
        setString("registeredmark", item);
    }
    /**
     * Object:�����������뵥's ��׼�ĺ�property 
     */
    public String getWarrantnumber()
    {
        return getString("warrantnumber");
    }
    public void setWarrantnumber(String item)
    {
        setString("warrantnumber", item);
    }
    /**
     * Object:�����������뵥's ���۾���property 
     */
    public java.math.BigDecimal getPricepPrecision()
    {
        return getBigDecimal("pricepPrecision");
    }
    public void setPricepPrecision(java.math.BigDecimal item)
    {
        setBigDecimal("pricepPrecision", item);
    }
    /**
     * Object:�����������뵥's ������property 
     */
    public String getBarcode()
    {
        return getString("barcode");
    }
    public void setBarcode(String item)
    {
        setString("barcode", item);
    }
    /**
     * Object:�����������뵥's ����ͼ��property 
     */
    public String getPicturenumber()
    {
        return getString("picturenumber");
    }
    public void setPicturenumber(String item)
    {
        setString("picturenumber", item);
    }
    /**
     * Object:�����������뵥's ����״̬property 
     */
    public com.kingdee.eas.basedata.master.material.UsedStatusEnum getStatus()
    {
        return com.kingdee.eas.basedata.master.material.UsedStatusEnum.getEnum(getInt("status"));
    }
    public void setStatus(com.kingdee.eas.basedata.master.material.UsedStatusEnum item)
    {
		if (item != null) {
        setInt("status", item.getValue());
		}
    }
    /**
     * Object: �����������뵥 's ������֯ property 
     */
    public com.kingdee.eas.basedata.org.CtrlUnitInfo getAdmincu()
    {
        return (com.kingdee.eas.basedata.org.CtrlUnitInfo)get("admincu");
    }
    public void setAdmincu(com.kingdee.eas.basedata.org.CtrlUnitInfo item)
    {
        put("admincu", item);
    }
    /**
     * Object:�����������뵥's �޸İ汾property 
     */
    public int getVersion()
    {
        return getInt("version");
    }
    public void setVersion(int item)
    {
        setInt("version", item);
    }
    /**
     * Object: �����������뵥 's ���ȵ�λ property 
     */
    public com.kingdee.eas.basedata.assistant.MeasureUnitInfo getLengthUnit()
    {
        return (com.kingdee.eas.basedata.assistant.MeasureUnitInfo)get("lengthUnit");
    }
    public void setLengthUnit(com.kingdee.eas.basedata.assistant.MeasureUnitInfo item)
    {
        put("lengthUnit", item);
    }
    /**
     * Object:�����������뵥's ����property 
     */
    public java.math.BigDecimal getLength()
    {
        return getBigDecimal("length");
    }
    public void setLength(java.math.BigDecimal item)
    {
        setBigDecimal("length", item);
    }
    /**
     * Object:�����������뵥's ���property 
     */
    public java.math.BigDecimal getWidth()
    {
        return getBigDecimal("width");
    }
    public void setWidth(java.math.BigDecimal item)
    {
        setBigDecimal("width", item);
    }
    /**
     * Object:�����������뵥's �߶�property 
     */
    public java.math.BigDecimal getHeight()
    {
        return getBigDecimal("height");
    }
    public void setHeight(java.math.BigDecimal item)
    {
        setBigDecimal("height", item);
    }
    /**
     * Object: �����������뵥 's ������λ property 
     */
    public com.kingdee.eas.basedata.assistant.MeasureUnitInfo getWeightUnit()
    {
        return (com.kingdee.eas.basedata.assistant.MeasureUnitInfo)get("weightUnit");
    }
    public void setWeightUnit(com.kingdee.eas.basedata.assistant.MeasureUnitInfo item)
    {
        put("weightUnit", item);
    }
    /**
     * Object:�����������뵥's ë��property 
     */
    public java.math.BigDecimal getGrossWeight()
    {
        return getBigDecimal("grossWeight");
    }
    public void setGrossWeight(java.math.BigDecimal item)
    {
        setBigDecimal("grossWeight", item);
    }
    /**
     * Object:�����������뵥's ����property 
     */
    public java.math.BigDecimal getNetWeight()
    {
        return getBigDecimal("netWeight");
    }
    public void setNetWeight(java.math.BigDecimal item)
    {
        setBigDecimal("netWeight", item);
    }
    /**
     * Object: �����������뵥 's �����λ property 
     */
    public com.kingdee.eas.basedata.assistant.MeasureUnitInfo getVolummUnit()
    {
        return (com.kingdee.eas.basedata.assistant.MeasureUnitInfo)get("volummUnit");
    }
    public void setVolummUnit(com.kingdee.eas.basedata.assistant.MeasureUnitInfo item)
    {
        put("volummUnit", item);
    }
    /**
     * Object:�����������뵥's ���property 
     */
    public java.math.BigDecimal getVolume()
    {
        return getBigDecimal("volume");
    }
    public void setVolume(java.math.BigDecimal item)
    {
        setBigDecimal("volume", item);
    }
    /**
     * Object:�����������뵥's ����property 
     */
    public String getName()
    {
        return getString("name");
    }
    public void setName(String item)
    {
        setString("name", item);
    }
    /**
     * Object: �����������뵥 's ���Ϸ��� property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialGroupInfo getMaterialGroup()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialGroupInfo)get("materialGroup");
    }
    public void setMaterialGroup(com.kingdee.eas.basedata.master.material.MaterialGroupInfo item)
    {
        put("materialGroup", item);
    }
    /**
     * Object:�����������뵥's ����ͺ�property 
     */
    public String getModel()
    {
        return getString("model");
    }
    public void setModel(String item)
    {
        setString("model", item);
    }
    /**
     * Object:�����������뵥's ������ɫproperty 
     */
    public int getColordisplay()
    {
        return getInt("colordisplay");
    }
    public void setColordisplay(int item)
    {
        setInt("colordisplay", item);
    }
    /**
     * Object:�����������뵥's ����״̬property 
     */
    public com.kingdee.eas.bdm.bdapply.bdaApplyBillStatus getBillStatus()
    {
        return com.kingdee.eas.bdm.bdapply.bdaApplyBillStatus.getEnum(getString("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.bdm.bdapply.bdaApplyBillStatus item)
    {
		if (item != null) {
        setString("billStatus", item.getValue());
		}
    }
    /**
     * Object:�����������뵥's ����ԭ��property 
     */
    public String getErrorMsg()
    {
        return getString("errorMsg");
    }
    public void setErrorMsg(String item)
    {
        setString("errorMsg", item);
    }
    /**
     * Object: �����������뵥 's ����ü�����λ property 
     */
    public com.kingdee.eas.basedata.assistant.MeasureUnitInfo getInvUnit()
    {
        return (com.kingdee.eas.basedata.assistant.MeasureUnitInfo)get("invUnit");
    }
    public void setInvUnit(com.kingdee.eas.basedata.assistant.MeasureUnitInfo item)
    {
        put("invUnit", item);
    }
    /**
     * Object:�����������뵥's ������(��)property 
     */
    public int getExpirationDate()
    {
        return getInt("expirationDate");
    }
    public void setExpirationDate(int item)
    {
        setInt("expirationDate", item);
    }
    /**
     * Object:�����������뵥's ��׼ø����property 
     */
    public int getStandActivity()
    {
        return getInt("standActivity");
    }
    public void setStandActivity(int item)
    {
        setInt("standActivity", item);
    }
    /**
     * Object:�����������뵥's ��Э��property 
     */
    public boolean isIsOutSourcePart()
    {
        return getBoolean("isOutSourcePart");
    }
    public void setIsOutSourcePart(boolean item)
    {
        setBoolean("isOutSourcePart", item);
    }
    /**
     * Object:�����������뵥's ���ñ��������õĸ�������property 
     */
    public boolean isIsUseAsstAttrRelation()
    {
        return getBoolean("isUseAsstAttrRelation");
    }
    public void setIsUseAsstAttrRelation(boolean item)
    {
        setBoolean("isUseAsstAttrRelation", item);
    }
    /**
     * Object: �����������뵥 's ���Ϸ����׼ property 
     */
    public com.kingdee.eas.bdm.bdapply.MaterialInfoReqMaterialStdEntryCollection getMaterialStdEntry()
    {
        return (com.kingdee.eas.bdm.bdapply.MaterialInfoReqMaterialStdEntryCollection)get("MaterialStdEntry");
    }
    /**
     * Object:�����������뵥's ˰��property 
     */
    public int getTaxRate()
    {
        return getInt("taxRate");
    }
    public void setTaxRate(int item)
    {
        setInt("taxRate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("126A0892");
    }
}
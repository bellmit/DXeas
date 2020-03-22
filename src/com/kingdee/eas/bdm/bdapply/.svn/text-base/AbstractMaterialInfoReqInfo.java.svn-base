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
     * Object:物料资料申请单's 是否生成凭证property 
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
     * Object:物料资料申请单's 简称property 
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
     * Object:物料资料申请单's 别名 property 
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
     * Object:物料资料申请单's 外文名称property 
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
     * Object:物料资料申请单's 助记码property 
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
     * Object: 物料资料申请单 's 辅助属性类别 property 
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
     * Object: 物料资料申请单 's 基本计量单位 property 
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
     * Object: 物料资料申请单 's 辅助计量单位 property 
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
     * Object: 物料资料申请单 's 序列号计量单位 property 
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
     * Object:物料资料申请单's 注册商标property 
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
     * Object:物料资料申请单's 批准文号property 
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
     * Object:物料资料申请单's 单价精度property 
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
     * Object:物料资料申请单's 条形码property 
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
     * Object:物料资料申请单's 工程图号property 
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
     * Object:物料资料申请单's 物料状态property 
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
     * Object: 物料资料申请单 's 管理组织 property 
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
     * Object:物料资料申请单's 修改版本property 
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
     * Object: 物料资料申请单 's 长度单位 property 
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
     * Object:物料资料申请单's 长度property 
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
     * Object:物料资料申请单's 宽度property 
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
     * Object:物料资料申请单's 高度property 
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
     * Object: 物料资料申请单 's 重量单位 property 
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
     * Object:物料资料申请单's 毛重property 
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
     * Object:物料资料申请单's 净重property 
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
     * Object: 物料资料申请单 's 体积单位 property 
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
     * Object:物料资料申请单's 体积property 
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
     * Object:物料资料申请单's 名称property 
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
     * Object: 物料资料申请单 's 物料分类 property 
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
     * Object:物料资料申请单's 规格型号property 
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
     * Object:物料资料申请单's 单据颜色property 
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
     * Object:物料资料申请单's 单据状态property 
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
     * Object:物料资料申请单's 驳回原因property 
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
     * Object: 物料资料申请单 's 库存用计量单位 property 
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
     * Object:物料资料申请单's 保质期(日)property 
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
     * Object:物料资料申请单's 标准酶活量property 
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
     * Object:物料资料申请单's 外协件property 
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
     * Object:物料资料申请单's 启用本物料设置的辅助属性property 
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
     * Object: 物料资料申请单 's 物料分类标准 property 
     */
    public com.kingdee.eas.bdm.bdapply.MaterialInfoReqMaterialStdEntryCollection getMaterialStdEntry()
    {
        return (com.kingdee.eas.bdm.bdapply.MaterialInfoReqMaterialStdEntryCollection)get("MaterialStdEntry");
    }
    /**
     * Object:物料资料申请单's 税率property 
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
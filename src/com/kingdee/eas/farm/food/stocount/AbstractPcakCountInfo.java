package com.kingdee.eas.farm.food.stocount;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPcakCountInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractPcakCountInfo()
    {
        this("id");
    }
    protected AbstractPcakCountInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.food.stocount.PcakCountEntryCollection());
    }
    /**
     * Object: 包装计数单 's 分录 property 
     */
    public com.kingdee.eas.farm.food.stocount.PcakCountEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.food.stocount.PcakCountEntryCollection)get("entrys");
    }
    /**
     * Object:包装计数单's 是否生成凭证property 
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
     * Object:包装计数单's 单据状态property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("status"));
    }
    public void setStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("status", item.getValue());
		}
    }
    /**
     * Object: 包装计数单 's 计数员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("person");
    }
    public void setPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("person", item);
    }
    /**
     * Object: 包装计数单 's 技术岗位 property 
     */
    public com.kingdee.eas.farm.food.stocount.CountPositionSetInfo getSemcount()
    {
        return (com.kingdee.eas.farm.food.stocount.CountPositionSetInfo)get("semcount");
    }
    public void setSemcount(com.kingdee.eas.farm.food.stocount.CountPositionSetInfo item)
    {
        put("semcount", item);
    }
    /**
     * Object: 包装计数单 's 物料 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("material");
    }
    public void setMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("material", item);
    }
    /**
     * Object:包装计数单's 规格型号property 
     */
    public String getMaterialtype()
    {
        return getString("materialtype");
    }
    public void setMaterialtype(String item)
    {
        setString("materialtype", item);
    }
    /**
     * Object:包装计数单's 基本计量单位property 
     */
    public String getMbaseunit()
    {
        return getString("mbaseunit");
    }
    public void setMbaseunit(String item)
    {
        setString("mbaseunit", item);
    }
    /**
     * Object:包装计数单's 基本数量（重量）property 
     */
    public java.math.BigDecimal getMnumber()
    {
        return getBigDecimal("mnumber");
    }
    public void setMnumber(java.math.BigDecimal item)
    {
        setBigDecimal("mnumber", item);
    }
    /**
     * Object:包装计数单's 生产日期property 
     */
    public java.util.Date getProductDate()
    {
        return getDate("productDate");
    }
    public void setProductDate(java.util.Date item)
    {
        setDate("productDate", item);
    }
    /**
     * Object:包装计数单's 班次property 
     */
    public com.kingdee.eas.farm.food.stocount.Classes getClasses()
    {
        return com.kingdee.eas.farm.food.stocount.Classes.getEnum(getString("classes"));
    }
    public void setClasses(com.kingdee.eas.farm.food.stocount.Classes item)
    {
		if (item != null) {
        setString("classes", item.getValue());
		}
    }
    /**
     * Object:包装计数单's 批次property 
     */
    public String getBatch()
    {
        return getString("batch");
    }
    public void setBatch(String item)
    {
        setString("batch", item);
    }
    /**
     * Object:包装计数单's 是否生成下游单据property 
     */
    public boolean isIsPackAcceptance()
    {
        return getBoolean("IsPackAcceptance");
    }
    public void setIsPackAcceptance(boolean item)
    {
        setBoolean("IsPackAcceptance", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("0599DF95");
    }
}
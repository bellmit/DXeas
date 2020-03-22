package com.kingdee.eas.farm.feedfactory;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractQualityCheckBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractQualityCheckBillEntryInfo()
    {
        this("id");
    }
    protected AbstractQualityCheckBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.feedfactory.QualityCheckBillInfo getParent()
    {
        return (com.kingdee.eas.farm.feedfactory.QualityCheckBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.feedfactory.QualityCheckBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 检验项目 property 
     */
    public com.kingdee.eas.qm.basedata.QCItemInfo getQcItem()
    {
        return (com.kingdee.eas.qm.basedata.QCItemInfo)get("qcItem");
    }
    public void setQcItem(com.kingdee.eas.qm.basedata.QCItemInfo item)
    {
        put("qcItem", item);
    }
    /**
     * Object:分录's 结算结果property 
     */
    public String getQcresult()
    {
        return getString("qcresult");
    }
    public void setQcresult(String item)
    {
        setString("qcresult", item);
    }
    /**
     * Object: 分录 's 单位 property 
     */
    public com.kingdee.eas.basedata.assistant.MeasureUnitInfo getQcUnit()
    {
        return (com.kingdee.eas.basedata.assistant.MeasureUnitInfo)get("qcUnit");
    }
    public void setQcUnit(com.kingdee.eas.basedata.assistant.MeasureUnitInfo item)
    {
        put("qcUnit", item);
    }
    /**
     * Object:分录's 标准值property 
     */
    public String getStandardValue()
    {
        return getString("standardValue");
    }
    public void setStandardValue(String item)
    {
        setString("standardValue", item);
    }
    /**
     * Object:分录's 允许差值property 
     */
    public String getAllowDeffValue()
    {
        return getString("allowDeffValue");
    }
    public void setAllowDeffValue(String item)
    {
        setString("allowDeffValue", item);
    }
    /**
     * Object:分录's 检测结论property 
     */
    public com.kingdee.eas.farm.feedfactory.QCResult getQcConclusion()
    {
        return com.kingdee.eas.farm.feedfactory.QCResult.getEnum(getString("qcConclusion"));
    }
    public void setQcConclusion(com.kingdee.eas.farm.feedfactory.QCResult item)
    {
		if (item != null) {
        setString("qcConclusion", item.getValue());
		}
    }
    /**
     * Object: 分录 's 检测人 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getQcPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("qcPerson");
    }
    public void setQcPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("qcPerson", item);
    }
    /**
     * Object:分录's 备注property 
     */
    public String getDescription()
    {
        return getString("description");
    }
    public void setDescription(String item)
    {
        setString("description", item);
    }
    /**
     * Object:分录's 下限值property 
     */
    public java.math.BigDecimal getLower()
    {
        return getBigDecimal("lower");
    }
    public void setLower(java.math.BigDecimal item)
    {
        setBigDecimal("lower", item);
    }
    /**
     * Object:分录's 上限值property 
     */
    public java.math.BigDecimal getUpper()
    {
        return getBigDecimal("upper");
    }
    public void setUpper(java.math.BigDecimal item)
    {
        setBigDecimal("upper", item);
    }
    /**
     * Object:分录's 第一次抽样结果property 
     */
    public String getQcresult1()
    {
        return getString("qcresult1");
    }
    public void setQcresult1(String item)
    {
        setString("qcresult1", item);
    }
    /**
     * Object:分录's 第二次抽样结果property 
     */
    public String getQcresult2()
    {
        return getString("qcresult2");
    }
    public void setQcresult2(String item)
    {
        setString("qcresult2", item);
    }
    /**
     * Object:分录's 第三次抽样结果property 
     */
    public String getQcresult3()
    {
        return getString("qcresult3");
    }
    public void setQcresult3(String item)
    {
        setString("qcresult3", item);
    }
    /**
     * Object:分录's 第四次抽样结果property 
     */
    public String getQcresult4()
    {
        return getString("qcresult4");
    }
    public void setQcresult4(String item)
    {
        setString("qcresult4", item);
    }
    /**
     * Object:分录's 初检结果property 
     */
    public String getQcresult0()
    {
        return getString("qcresult0");
    }
    public void setQcresult0(String item)
    {
        setString("qcresult0", item);
    }
    /**
     * Object:分录's 公式property 
     */
    public String getGs()
    {
        return getString("gs");
    }
    public void setGs(String item)
    {
        setString("gs", item);
    }
    /**
     * Object:分录's 扣罚重量property 
     */
    public java.math.BigDecimal getDeductWgt()
    {
        return getBigDecimal("DeductWgt");
    }
    public void setDeductWgt(java.math.BigDecimal item)
    {
        setBigDecimal("DeductWgt", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1AC2DAC0");
    }
}
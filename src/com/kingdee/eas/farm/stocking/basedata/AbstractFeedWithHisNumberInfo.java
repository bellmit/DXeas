package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFeedWithHisNumberInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractFeedWithHisNumberInfo()
    {
        this("id");
    }
    protected AbstractFeedWithHisNumberInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 饲料编号 's 1#A料 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getNum1()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("num1");
    }
    public void setNum1(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("num1", item);
    }
    /**
     * Object: 饲料编号 's 1#B料 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getNum2()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("num2");
    }
    public void setNum2(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("num2", item);
    }
    /**
     * Object: 饲料编号 's 2#料 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getNum3()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("num3");
    }
    public void setNum3(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("num3", item);
    }
    /**
     * Object: 饲料编号 's 3#料 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getNum4()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("num4");
    }
    public void setNum4(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("num4", item);
    }
    /**
     * Object:饲料编号's 开始日期property 
     */
    public java.util.Date getBeginDate()
    {
        return getDate("beginDate");
    }
    public void setBeginDate(java.util.Date item)
    {
        setDate("beginDate", item);
    }
    /**
     * Object:饲料编号's 结束日期property 
     */
    public java.util.Date getEndDate()
    {
        return getDate("endDate");
    }
    public void setEndDate(java.util.Date item)
    {
        setDate("endDate", item);
    }
    /**
     * Object:饲料编号's 当前是否启用property 
     */
    public boolean isIsCancelCancel()
    {
        return getBoolean("isCancelCancel");
    }
    public void setIsCancelCancel(boolean item)
    {
        setBoolean("isCancelCancel", item);
    }
    /**
     * Object: 饲料编号 's 4#A料 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getNum5()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("num5");
    }
    public void setNum5(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("num5", item);
    }
    /**
     * Object: 饲料编号 's 4#B料 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getNum6()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("num6");
    }
    public void setNum6(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("num6", item);
    }
    /**
     * Object: 饲料编号 's 5#料 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getNum7()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("num7");
    }
    public void setNum7(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("num7", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A2239F26");
    }
}
/**
 * output package name
 */
package com.kingdee.eas.custom.lhsm;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class ForecastEnum extends StringEnum
{
    public static final String ADDNEW_VALUE = "0";//alias=新增
    public static final String SAVE_VALUE = "1";//alias=保存
    public static final String SUBMIT_VALUE = "2";//alias=提交
    public static final String AUDIT_VALUE = "3";//alias=审核
    public static final String CLOSE_VALUE = "4";//alias=关闭
    public static final String OVER_VALUE = "5";//alias=分配完毕
    public static final String SUBJECT_VALUE = "-1";//alias=驳回

    public static final ForecastEnum ADDNEW = new ForecastEnum("ADDNEW", ADDNEW_VALUE);
    public static final ForecastEnum SAVE = new ForecastEnum("SAVE", SAVE_VALUE);
    public static final ForecastEnum SUBMIT = new ForecastEnum("SUBMIT", SUBMIT_VALUE);
    public static final ForecastEnum AUDIT = new ForecastEnum("AUDIT", AUDIT_VALUE);
    public static final ForecastEnum Close = new ForecastEnum("Close", CLOSE_VALUE);
    public static final ForecastEnum OVER = new ForecastEnum("OVER", OVER_VALUE);
    public static final ForecastEnum SUBJECT = new ForecastEnum("SUBJECT", SUBJECT_VALUE);

    /**
     * construct function
     * @param String forecastEnum
     */
    private ForecastEnum(String name, String forecastEnum)
    {
        super(name, forecastEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static ForecastEnum getEnum(String forecastEnum)
    {
        return (ForecastEnum)getEnum(ForecastEnum.class, forecastEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(ForecastEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(ForecastEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(ForecastEnum.class);
    }
}
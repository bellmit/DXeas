/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.feedbiz;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class BizTypeEnum extends StringEnum
{
    public static final String COMM_VALUE = "0";//alias=∆’Õ®≥ˆ√Á
    public static final String REBACK_VALUE = "1";//alias=ªÿ≥Â…ÀÕˆ

    public static final BizTypeEnum Comm = new BizTypeEnum("Comm", COMM_VALUE);
    public static final BizTypeEnum Reback = new BizTypeEnum("Reback", REBACK_VALUE);

    /**
     * construct function
     * @param String bizTypeEnum
     */
    private BizTypeEnum(String name, String bizTypeEnum)
    {
        super(name, bizTypeEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static BizTypeEnum getEnum(String bizTypeEnum)
    {
        return (BizTypeEnum)getEnum(BizTypeEnum.class, bizTypeEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(BizTypeEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(BizTypeEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(BizTypeEnum.class);
    }
}
/**
 * output package name
 */
package com.kingdee.eas.custom.wages;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class wagesType extends StringEnum
{
    public static final String FRACTIONWAGES_VALUE = "0";//alias=分数工资
    public static final String COUNTWAGES_VALUE = "1";//alias=计件工资
    public static final String BAISCWAGES_VALUE = "2";//alias=基本工资
    public static final String OTHERWAGES_VALUE = "3";//alias=特殊分数工资

    public static final wagesType fractionWages = new wagesType("fractionWages", FRACTIONWAGES_VALUE);
    public static final wagesType countWages = new wagesType("countWages", COUNTWAGES_VALUE);
    public static final wagesType baiscWages = new wagesType("baiscWages", BAISCWAGES_VALUE);
    public static final wagesType OtherWages = new wagesType("OtherWages", OTHERWAGES_VALUE);

    /**
     * construct function
     * @param String wagesType
     */
    private wagesType(String name, String wagesType)
    {
        super(name, wagesType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static wagesType getEnum(String wagesType)
    {
        return (wagesType)getEnum(wagesType.class, wagesType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(wagesType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(wagesType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(wagesType.class);
    }
}
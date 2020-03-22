/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basedata;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class fodderInstanceEnum extends StringEnum
{
    public static final String OVER_VALUE = "1";//alias=大于
    public static final String LESS_VALUE = "2";//alias=小于
    public static final String OVERANDEQUAL_VALUE = "3";//alias=大于等于
    public static final String LESSANDEQUAL_VALUE = "4";//alias=小于等于
    public static final String NOCOMPARE_VALUE = "0";//alias=不比较

    public static final fodderInstanceEnum over = new fodderInstanceEnum("over", OVER_VALUE);
    public static final fodderInstanceEnum less = new fodderInstanceEnum("less", LESS_VALUE);
    public static final fodderInstanceEnum overAndEqual = new fodderInstanceEnum("overAndEqual", OVERANDEQUAL_VALUE);
    public static final fodderInstanceEnum lessAndEqual = new fodderInstanceEnum("lessAndEqual", LESSANDEQUAL_VALUE);
    public static final fodderInstanceEnum noCompare = new fodderInstanceEnum("noCompare", NOCOMPARE_VALUE);

    /**
     * construct function
     * @param String fodderInstanceEnum
     */
    private fodderInstanceEnum(String name, String fodderInstanceEnum)
    {
        super(name, fodderInstanceEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static fodderInstanceEnum getEnum(String fodderInstanceEnum)
    {
        return (fodderInstanceEnum)getEnum(fodderInstanceEnum.class, fodderInstanceEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(fodderInstanceEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(fodderInstanceEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(fodderInstanceEnum.class);
    }
}
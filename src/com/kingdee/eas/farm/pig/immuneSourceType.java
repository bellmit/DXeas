/**
 * output package name
 */
package com.kingdee.eas.farm.pig;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class immuneSourceType extends StringEnum
{
    public static final String DAILYIMMUNE_VALUE = "1";//alias=日常免疫计划
    public static final String BATCHIMMUNE_VALUE = "2";//alias=批次免疫规范
    public static final String TEMPIMMUNE_VALUE = "3";//alias=临时添加

    public static final immuneSourceType DailyImmune = new immuneSourceType("DailyImmune", DAILYIMMUNE_VALUE);
    public static final immuneSourceType BatchImmune = new immuneSourceType("BatchImmune", BATCHIMMUNE_VALUE);
    public static final immuneSourceType TempImmune = new immuneSourceType("TempImmune", TEMPIMMUNE_VALUE);

    /**
     * construct function
     * @param String immuneSourceType
     */
    private immuneSourceType(String name, String immuneSourceType)
    {
        super(name, immuneSourceType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static immuneSourceType getEnum(String immuneSourceType)
    {
        return (immuneSourceType)getEnum(immuneSourceType.class, immuneSourceType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(immuneSourceType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(immuneSourceType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(immuneSourceType.class);
    }
}
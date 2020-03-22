/**
 * output package name
 */
package com.kingdee.eas.custom.salediscount;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class DiscountUnitTypeEnum extends StringEnum
{
    public static final String BAO_VALUE = "2";//alias=包（单位）/吨
    public static final String YUAN_VALUE = "1";//alias=元/吨

    public static final DiscountUnitTypeEnum BAO = new DiscountUnitTypeEnum("BAO", BAO_VALUE);
    public static final DiscountUnitTypeEnum YUAN = new DiscountUnitTypeEnum("YUAN", YUAN_VALUE);

    /**
     * construct function
     * @param String discountUnitTypeEnum
     */
    private DiscountUnitTypeEnum(String name, String discountUnitTypeEnum)
    {
        super(name, discountUnitTypeEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static DiscountUnitTypeEnum getEnum(String discountUnitTypeEnum)
    {
        return (DiscountUnitTypeEnum)getEnum(DiscountUnitTypeEnum.class, discountUnitTypeEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(DiscountUnitTypeEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(DiscountUnitTypeEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(DiscountUnitTypeEnum.class);
    }
}
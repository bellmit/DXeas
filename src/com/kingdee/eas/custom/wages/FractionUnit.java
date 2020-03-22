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
public class FractionUnit extends StringEnum
{
    public static final String KILOGRAM_VALUE = "0";//alias=¹«½ï
    public static final String QUANTITY_VALUE = "1";//alias=Ö»Êý

    public static final FractionUnit kilogram = new FractionUnit("kilogram", KILOGRAM_VALUE);
    public static final FractionUnit quantity = new FractionUnit("quantity", QUANTITY_VALUE);

    /**
     * construct function
     * @param String fractionUnit
     */
    private FractionUnit(String name, String fractionUnit)
    {
        super(name, fractionUnit);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static FractionUnit getEnum(String fractionUnit)
    {
        return (FractionUnit)getEnum(FractionUnit.class, fractionUnit);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(FractionUnit.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(FractionUnit.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(FractionUnit.class);
    }
}
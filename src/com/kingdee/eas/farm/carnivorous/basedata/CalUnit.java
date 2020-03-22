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
public class CalUnit extends StringEnum
{
    public static final String QTY_VALUE = "0";//alias=Ö»
    public static final String KG_VALUE = "1";//alias=¹«½ï

    public static final CalUnit qty = new CalUnit("qty", QTY_VALUE);
    public static final CalUnit kg = new CalUnit("kg", KG_VALUE);

    /**
     * construct function
     * @param String calUnit
     */
    private CalUnit(String name, String calUnit)
    {
        super(name, calUnit);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static CalUnit getEnum(String calUnit)
    {
        return (CalUnit)getEnum(CalUnit.class, calUnit);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(CalUnit.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(CalUnit.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(CalUnit.class);
    }
}
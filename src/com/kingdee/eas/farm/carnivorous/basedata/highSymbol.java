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
public class highSymbol extends StringEnum
{
    public static final String HIGH_VALUE = ">";//alias=大于
    public static final String HIGHEQUAL_VALUE = ">=";//alias=大于等于
    public static final String EQUAL_VALUE = "=";//alias=等于
    public static final String EMPTY_VALUE = "-1";//alias=

    public static final highSymbol high = new highSymbol("high", HIGH_VALUE);
    public static final highSymbol highEqual = new highSymbol("highEqual", HIGHEQUAL_VALUE);
    public static final highSymbol equal = new highSymbol("equal", EQUAL_VALUE);
    public static final highSymbol empty = new highSymbol("empty", EMPTY_VALUE);

    /**
     * construct function
     * @param String highSymbol
     */
    private highSymbol(String name, String highSymbol)
    {
        super(name, highSymbol);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static highSymbol getEnum(String highSymbol)
    {
        return (highSymbol)getEnum(highSymbol.class, highSymbol);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(highSymbol.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(highSymbol.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(highSymbol.class);
    }
}
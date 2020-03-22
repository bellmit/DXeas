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
public class LessSymbol extends StringEnum
{
    public static final String LESS_VALUE = "<";//alias=小于
    public static final String LESSEQUAL_VALUE = "<=";//alias=小于等于
    public static final String EQUAL_VALUE = "=";//alias=等于
    public static final String EMPTY_VALUE = "-1";//alias=

    public static final LessSymbol less = new LessSymbol("less", LESS_VALUE);
    public static final LessSymbol lessEqual = new LessSymbol("lessEqual", LESSEQUAL_VALUE);
    public static final LessSymbol equal = new LessSymbol("equal", EQUAL_VALUE);
    public static final LessSymbol empty = new LessSymbol("empty", EMPTY_VALUE);

    /**
     * construct function
     * @param String lessSymbol
     */
    private LessSymbol(String name, String lessSymbol)
    {
        super(name, lessSymbol);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static LessSymbol getEnum(String lessSymbol)
    {
        return (LessSymbol)getEnum(LessSymbol.class, lessSymbol);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(LessSymbol.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(LessSymbol.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(LessSymbol.class);
    }
}
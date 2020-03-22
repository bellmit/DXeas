/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.recyclebiz;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class SaleBizType extends StringEnum
{
    public static final String INNER_VALUE = "0";//alias=内销
    public static final String OUT_VALUE = "1";//alias=外销

    public static final SaleBizType inner = new SaleBizType("inner", INNER_VALUE);
    public static final SaleBizType out = new SaleBizType("out", OUT_VALUE);

    /**
     * construct function
     * @param String saleBizType
     */
    private SaleBizType(String name, String saleBizType)
    {
        super(name, saleBizType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static SaleBizType getEnum(String saleBizType)
    {
        return (SaleBizType)getEnum(SaleBizType.class, saleBizType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(SaleBizType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(SaleBizType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(SaleBizType.class);
    }
}
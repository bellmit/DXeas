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
public class isBorrow extends StringEnum
{
    public static final String BORROW_VALUE = "1";//alias=½è¿î
    public static final String UNBORROW_VALUE = "2";//alias=»¹¿î

    public static final isBorrow borrow = new isBorrow("borrow", BORROW_VALUE);
    public static final isBorrow unBorrow = new isBorrow("unBorrow", UNBORROW_VALUE);

    /**
     * construct function
     * @param String isBorrow
     */
    private isBorrow(String name, String isBorrow)
    {
        super(name, isBorrow);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static isBorrow getEnum(String isBorrow)
    {
        return (isBorrow)getEnum(isBorrow.class, isBorrow);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(isBorrow.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(isBorrow.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(isBorrow.class);
    }
}
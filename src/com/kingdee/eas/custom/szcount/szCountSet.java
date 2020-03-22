/**
 * output package name
 */
package com.kingdee.eas.custom.szcount;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class szCountSet extends StringEnum
{
    public static final String SEMI_VALUE = "0";//alias=鲜品计数
    public static final String PRODUCT_VALUE = "1";//alias=成品计数

    public static final szCountSet semi = new szCountSet("semi", SEMI_VALUE);
    public static final szCountSet product = new szCountSet("product", PRODUCT_VALUE);

    /**
     * construct function
     * @param String szCountSet
     */
    private szCountSet(String name, String szCountSet)
    {
        super(name, szCountSet);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static szCountSet getEnum(String szCountSet)
    {
        return (szCountSet)getEnum(szCountSet.class, szCountSet);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(szCountSet.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(szCountSet.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(szCountSet.class);
    }
}
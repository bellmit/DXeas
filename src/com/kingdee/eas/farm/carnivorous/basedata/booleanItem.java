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
public class booleanItem extends StringEnum
{
    public static final String YES_VALUE = "1";//alias=ÊÇ
    public static final String NO_VALUE = "2";//alias=·ñ

    public static final booleanItem yes = new booleanItem("yes", YES_VALUE);
    public static final booleanItem no = new booleanItem("no", NO_VALUE);

    /**
     * construct function
     * @param String booleanItem
     */
    private booleanItem(String name, String booleanItem)
    {
        super(name, booleanItem);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static booleanItem getEnum(String booleanItem)
    {
        return (booleanItem)getEnum(booleanItem.class, booleanItem);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(booleanItem.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(booleanItem.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(booleanItem.class);
    }
}
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
public class recType extends StringEnum
{
    public static final String GA_VALUE = "1";//alias=Ã«¼¦
    public static final String PA_VALUE = "2";//alias=ÆÕÍ¨¼¦A¼¦
    public static final String PB_VALUE = "3";//alias=ÆÕÍ¨¼¦B¼¦

    public static final recType GA = new recType("GA", GA_VALUE);
    public static final recType PA = new recType("PA", PA_VALUE);
    public static final recType PB = new recType("PB", PB_VALUE);

    /**
     * construct function
     * @param String recType
     */
    private recType(String name, String recType)
    {
        super(name, recType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static recType getEnum(String recType)
    {
        return (recType)getEnum(recType.class, recType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(recType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(recType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(recType.class);
    }
}
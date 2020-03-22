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
public class UnitOfMetering extends StringEnum
{
    public static final String OUTPUT_VALUE = "0";//alias=按产量
    public static final String NUMBER_VALUE = "1";//alias=按只数

    public static final UnitOfMetering OutPut = new UnitOfMetering("OutPut", OUTPUT_VALUE);
    public static final UnitOfMetering Number = new UnitOfMetering("Number", NUMBER_VALUE);

    /**
     * construct function
     * @param String unitOfMetering
     */
    private UnitOfMetering(String name, String unitOfMetering)
    {
        super(name, unitOfMetering);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static UnitOfMetering getEnum(String unitOfMetering)
    {
        return (UnitOfMetering)getEnum(UnitOfMetering.class, unitOfMetering);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(UnitOfMetering.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(UnitOfMetering.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(UnitOfMetering.class);
    }
}
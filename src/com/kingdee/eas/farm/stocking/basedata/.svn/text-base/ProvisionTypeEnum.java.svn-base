/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basedata;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.IntEnum;

/**
 * output class name
 */
public class ProvisionTypeEnum extends IntEnum
{
    public static final int MONTH_VALUE = 1;//alias=整月计提

    public static final ProvisionTypeEnum month = new ProvisionTypeEnum("month", MONTH_VALUE);

    /**
     * construct function
     * @param integer provisionTypeEnum
     */
    private ProvisionTypeEnum(String name, int provisionTypeEnum)
    {
        super(name, provisionTypeEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static ProvisionTypeEnum getEnum(String provisionTypeEnum)
    {
        return (ProvisionTypeEnum)getEnum(ProvisionTypeEnum.class, provisionTypeEnum);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static ProvisionTypeEnum getEnum(int provisionTypeEnum)
    {
        return (ProvisionTypeEnum)getEnum(ProvisionTypeEnum.class, provisionTypeEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(ProvisionTypeEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(ProvisionTypeEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(ProvisionTypeEnum.class);
    }
}
/**
 * output package name
 */
package com.kingdee.eas.custom.eas2temp;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.IntEnum;

/**
 * output class name
 */
public class workShopNumEnum extends IntEnum
{
    public static final int TWO_VALUE = 2;//alias=二车间
    public static final int ONE_VALUE = 1;//alias=一车间

    public static final workShopNumEnum two = new workShopNumEnum("two", TWO_VALUE);
    public static final workShopNumEnum one = new workShopNumEnum("one", ONE_VALUE);

    /**
     * construct function
     * @param integer workShopNumEnum
     */
    private workShopNumEnum(String name, int workShopNumEnum)
    {
        super(name, workShopNumEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static workShopNumEnum getEnum(String workShopNumEnum)
    {
        return (workShopNumEnum)getEnum(workShopNumEnum.class, workShopNumEnum);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static workShopNumEnum getEnum(int workShopNumEnum)
    {
        return (workShopNumEnum)getEnum(workShopNumEnum.class, workShopNumEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(workShopNumEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(workShopNumEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(workShopNumEnum.class);
    }
}
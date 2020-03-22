/**
 * output package name
 */
package com.kingdee.eas.custom.eas2wincos;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.IntEnum;

/**
 * output class name
 */
public class EAS2WinCosSourceTypeEnum extends IntEnum
{
    public static final int SERVER_VALUE = 1;
    public static final int CLIENT_VALUE = 2;

    public static final EAS2WinCosSourceTypeEnum server = new EAS2WinCosSourceTypeEnum("server", SERVER_VALUE);
    public static final EAS2WinCosSourceTypeEnum client = new EAS2WinCosSourceTypeEnum("client", CLIENT_VALUE);

    /**
     * construct function
     * @param integer eAS2WinCosSourceTypeEnum
     */
    private EAS2WinCosSourceTypeEnum(String name, int eAS2WinCosSourceTypeEnum)
    {
        super(name, eAS2WinCosSourceTypeEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static EAS2WinCosSourceTypeEnum getEnum(String eAS2WinCosSourceTypeEnum)
    {
        return (EAS2WinCosSourceTypeEnum)getEnum(EAS2WinCosSourceTypeEnum.class, eAS2WinCosSourceTypeEnum);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static EAS2WinCosSourceTypeEnum getEnum(int eAS2WinCosSourceTypeEnum)
    {
        return (EAS2WinCosSourceTypeEnum)getEnum(EAS2WinCosSourceTypeEnum.class, eAS2WinCosSourceTypeEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(EAS2WinCosSourceTypeEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(EAS2WinCosSourceTypeEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(EAS2WinCosSourceTypeEnum.class);
    }
}
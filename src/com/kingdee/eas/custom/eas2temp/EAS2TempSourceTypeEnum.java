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
public class EAS2TempSourceTypeEnum extends IntEnum
{
    public static final int SERVER_VALUE = 1;//alias=服务器端
    public static final int CLIENT_VALUE = 2;//alias=客户端

    public static final EAS2TempSourceTypeEnum server = new EAS2TempSourceTypeEnum("server", SERVER_VALUE);
    public static final EAS2TempSourceTypeEnum client = new EAS2TempSourceTypeEnum("client", CLIENT_VALUE);

    /**
     * construct function
     * @param integer eAS2TempSourceTypeEnum
     */
    private EAS2TempSourceTypeEnum(String name, int eAS2TempSourceTypeEnum)
    {
        super(name, eAS2TempSourceTypeEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static EAS2TempSourceTypeEnum getEnum(String eAS2TempSourceTypeEnum)
    {
        return (EAS2TempSourceTypeEnum)getEnum(EAS2TempSourceTypeEnum.class, eAS2TempSourceTypeEnum);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static EAS2TempSourceTypeEnum getEnum(int eAS2TempSourceTypeEnum)
    {
        return (EAS2TempSourceTypeEnum)getEnum(EAS2TempSourceTypeEnum.class, eAS2TempSourceTypeEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(EAS2TempSourceTypeEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(EAS2TempSourceTypeEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(EAS2TempSourceTypeEnum.class);
    }
}
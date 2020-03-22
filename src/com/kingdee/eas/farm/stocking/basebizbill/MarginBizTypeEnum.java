/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basebizbill;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.IntEnum;

/**
 * output class name
 */
public class MarginBizTypeEnum extends IntEnum
{
    public static final int RECEIVEAMOUNT_VALUE = 1;//alias=保证金收取
    public static final int RETURNAMOUNT_VALUE = 2;//alias=保证金退换

    public static final MarginBizTypeEnum receiveAmount = new MarginBizTypeEnum("receiveAmount", RECEIVEAMOUNT_VALUE);
    public static final MarginBizTypeEnum returnAmount = new MarginBizTypeEnum("returnAmount", RETURNAMOUNT_VALUE);

    /**
     * construct function
     * @param integer marginBizTypeEnum
     */
    private MarginBizTypeEnum(String name, int marginBizTypeEnum)
    {
        super(name, marginBizTypeEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static MarginBizTypeEnum getEnum(String marginBizTypeEnum)
    {
        return (MarginBizTypeEnum)getEnum(MarginBizTypeEnum.class, marginBizTypeEnum);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static MarginBizTypeEnum getEnum(int marginBizTypeEnum)
    {
        return (MarginBizTypeEnum)getEnum(MarginBizTypeEnum.class, marginBizTypeEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(MarginBizTypeEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(MarginBizTypeEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(MarginBizTypeEnum.class);
    }
}
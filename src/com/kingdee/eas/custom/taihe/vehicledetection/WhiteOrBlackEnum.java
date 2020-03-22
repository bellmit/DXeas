/**
 * output package name
 */
package com.kingdee.eas.custom.taihe.vehicledetection;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.IntEnum;

/**
 * output class name
 */
public class WhiteOrBlackEnum extends IntEnum
{
    public static final int WHITE_VALUE = 1;//alias=白名单
    public static final int BLACK_VALUE = 2;//alias=黑名单

    public static final WhiteOrBlackEnum White = new WhiteOrBlackEnum("White", WHITE_VALUE);
    public static final WhiteOrBlackEnum Black = new WhiteOrBlackEnum("Black", BLACK_VALUE);

    /**
     * construct function
     * @param integer whiteOrBlackEnum
     */
    private WhiteOrBlackEnum(String name, int whiteOrBlackEnum)
    {
        super(name, whiteOrBlackEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static WhiteOrBlackEnum getEnum(String whiteOrBlackEnum)
    {
        return (WhiteOrBlackEnum)getEnum(WhiteOrBlackEnum.class, whiteOrBlackEnum);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static WhiteOrBlackEnum getEnum(int whiteOrBlackEnum)
    {
        return (WhiteOrBlackEnum)getEnum(WhiteOrBlackEnum.class, whiteOrBlackEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(WhiteOrBlackEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(WhiteOrBlackEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(WhiteOrBlackEnum.class);
    }
}
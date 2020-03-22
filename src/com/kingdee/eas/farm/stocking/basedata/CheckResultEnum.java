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
public class CheckResultEnum extends IntEnum
{
    public static final int QUALIFIED_VALUE = 1;//alias=合格
    public static final int UNQUALIFIED_VALUE = 2;//alias=不合格

    public static final CheckResultEnum qualified = new CheckResultEnum("qualified", QUALIFIED_VALUE);
    public static final CheckResultEnum unQualified = new CheckResultEnum("unQualified", UNQUALIFIED_VALUE);

    /**
     * construct function
     * @param integer checkResultEnum
     */
    private CheckResultEnum(String name, int checkResultEnum)
    {
        super(name, checkResultEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static CheckResultEnum getEnum(String checkResultEnum)
    {
        return (CheckResultEnum)getEnum(CheckResultEnum.class, checkResultEnum);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static CheckResultEnum getEnum(int checkResultEnum)
    {
        return (CheckResultEnum)getEnum(CheckResultEnum.class, checkResultEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(CheckResultEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(CheckResultEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(CheckResultEnum.class);
    }
}
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
public class SubsidyTypeEnum extends IntEnum
{
    public static final int UNITSUBSIDY_VALUE = 1;//alias=单只补贴
    public static final int ONESUBSIDY_VALUE = 2;//alias=一次性补贴

    public static final SubsidyTypeEnum unitSubsidy = new SubsidyTypeEnum("unitSubsidy", UNITSUBSIDY_VALUE);
    public static final SubsidyTypeEnum oneSubsidy = new SubsidyTypeEnum("oneSubsidy", ONESUBSIDY_VALUE);

    /**
     * construct function
     * @param integer subsidyTypeEnum
     */
    private SubsidyTypeEnum(String name, int subsidyTypeEnum)
    {
        super(name, subsidyTypeEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static SubsidyTypeEnum getEnum(String subsidyTypeEnum)
    {
        return (SubsidyTypeEnum)getEnum(SubsidyTypeEnum.class, subsidyTypeEnum);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static SubsidyTypeEnum getEnum(int subsidyTypeEnum)
    {
        return (SubsidyTypeEnum)getEnum(SubsidyTypeEnum.class, subsidyTypeEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(SubsidyTypeEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(SubsidyTypeEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(SubsidyTypeEnum.class);
    }
}
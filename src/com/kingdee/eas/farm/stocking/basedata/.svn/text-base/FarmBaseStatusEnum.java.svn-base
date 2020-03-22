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
public class FarmBaseStatusEnum extends IntEnum
{
    public static final int UNAPPROVE_VALUE = 1;//alias=未核准
    public static final int APPROVE_VALUE = 2;//alias=核准
    public static final int ENABLE_VALUE = 3;//alias=启用
    public static final int UNENABLE_VALUE = 4;//alias=未启用
    public static final int FROZEN_VALUE = 5;//alias=禁用

    public static final FarmBaseStatusEnum unApprove = new FarmBaseStatusEnum("unApprove", UNAPPROVE_VALUE);
    public static final FarmBaseStatusEnum approve = new FarmBaseStatusEnum("approve", APPROVE_VALUE);
    public static final FarmBaseStatusEnum enable = new FarmBaseStatusEnum("enable", ENABLE_VALUE);
    public static final FarmBaseStatusEnum unEnable = new FarmBaseStatusEnum("unEnable", UNENABLE_VALUE);
    public static final FarmBaseStatusEnum frozen = new FarmBaseStatusEnum("frozen", FROZEN_VALUE);

    /**
     * construct function
     * @param integer farmBaseStatusEnum
     */
    private FarmBaseStatusEnum(String name, int farmBaseStatusEnum)
    {
        super(name, farmBaseStatusEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static FarmBaseStatusEnum getEnum(String farmBaseStatusEnum)
    {
        return (FarmBaseStatusEnum)getEnum(FarmBaseStatusEnum.class, farmBaseStatusEnum);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static FarmBaseStatusEnum getEnum(int farmBaseStatusEnum)
    {
        return (FarmBaseStatusEnum)getEnum(FarmBaseStatusEnum.class, farmBaseStatusEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(FarmBaseStatusEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(FarmBaseStatusEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(FarmBaseStatusEnum.class);
    }
}
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
public class FarmerStatusEnum extends IntEnum
{
    public static final int UNAPPROVE_VALUE = 1;//alias=未核准
    public static final int APPROVE_VALUE = 2;//alias=核准
    public static final int ENABLE_VALUE = 3;//alias=启用
    public static final int UNENABLE_VALUE = 4;//alias=未启用

    public static final FarmerStatusEnum unApprove = new FarmerStatusEnum("unApprove", UNAPPROVE_VALUE);
    public static final FarmerStatusEnum approve = new FarmerStatusEnum("approve", APPROVE_VALUE);
    public static final FarmerStatusEnum enable = new FarmerStatusEnum("enable", ENABLE_VALUE);
    public static final FarmerStatusEnum unEnable = new FarmerStatusEnum("unEnable", UNENABLE_VALUE);

    /**
     * construct function
     * @param integer farmerStatusEnum
     */
    private FarmerStatusEnum(String name, int farmerStatusEnum)
    {
        super(name, farmerStatusEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static FarmerStatusEnum getEnum(String farmerStatusEnum)
    {
        return (FarmerStatusEnum)getEnum(FarmerStatusEnum.class, farmerStatusEnum);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static FarmerStatusEnum getEnum(int farmerStatusEnum)
    {
        return (FarmerStatusEnum)getEnum(FarmerStatusEnum.class, farmerStatusEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(FarmerStatusEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(FarmerStatusEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(FarmerStatusEnum.class);
    }
}
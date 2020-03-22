/**
 * output package name
 */
package com.kingdee.eas.farm.dayratecost;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.IntEnum;

/**
 * output class name
 */
public class AllocationTypeEnum extends IntEnum
{
    public static final int BYFARM_VALUE = 1;//alias=养殖场分摊
    public static final int BYFARMERGROUP_VALUE = 3;//alias=养殖户区域分摊
    public static final int BYFARMGROUP_VALUE = 4;//alias=养殖场区域
    public static final int BYFARMER_VALUE = 2;//alias=养殖户分摊

    public static final AllocationTypeEnum byFarm = new AllocationTypeEnum("byFarm", BYFARM_VALUE);
    public static final AllocationTypeEnum byFarmerGroup = new AllocationTypeEnum("byFarmerGroup", BYFARMERGROUP_VALUE);
    public static final AllocationTypeEnum byFarmGroup = new AllocationTypeEnum("byFarmGroup", BYFARMGROUP_VALUE);
    public static final AllocationTypeEnum byFarmer = new AllocationTypeEnum("byFarmer", BYFARMER_VALUE);

    /**
     * construct function
     * @param integer allocationTypeEnum
     */
    private AllocationTypeEnum(String name, int allocationTypeEnum)
    {
        super(name, allocationTypeEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static AllocationTypeEnum getEnum(String allocationTypeEnum)
    {
        return (AllocationTypeEnum)getEnum(AllocationTypeEnum.class, allocationTypeEnum);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static AllocationTypeEnum getEnum(int allocationTypeEnum)
    {
        return (AllocationTypeEnum)getEnum(AllocationTypeEnum.class, allocationTypeEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(AllocationTypeEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(AllocationTypeEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(AllocationTypeEnum.class);
    }
}
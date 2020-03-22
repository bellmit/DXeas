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
public class FarmStageEnum extends IntEnum
{
    public static final int BROOD_VALUE = 1;//alias=育雏期
    public static final int BREED_VALUE = 2;//alias=育成期
    public static final int PUREGGS_VALUE = 4;//alias=预产期
    public static final int EGGS_VALUE = 3;//alias=产蛋期

    public static final FarmStageEnum brood = new FarmStageEnum("brood", BROOD_VALUE);
    public static final FarmStageEnum breed = new FarmStageEnum("breed", BREED_VALUE);
    public static final FarmStageEnum purEggs = new FarmStageEnum("purEggs", PUREGGS_VALUE);
    public static final FarmStageEnum eggs = new FarmStageEnum("eggs", EGGS_VALUE);

    /**
     * construct function
     * @param integer farmStageEnum
     */
    private FarmStageEnum(String name, int farmStageEnum)
    {
        super(name, farmStageEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static FarmStageEnum getEnum(String farmStageEnum)
    {
        return (FarmStageEnum)getEnum(FarmStageEnum.class, farmStageEnum);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static FarmStageEnum getEnum(int farmStageEnum)
    {
        return (FarmStageEnum)getEnum(FarmStageEnum.class, farmStageEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(FarmStageEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(FarmStageEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(FarmStageEnum.class);
    }
}
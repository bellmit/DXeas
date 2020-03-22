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
public class BreedLvlEnum extends IntEnum
{
    public static final int LV1_VALUE = 1;//alias=较差
    public static final int LVL2_VALUE = 2;//alias=一般
    public static final int LVL3_VALUE = 3;//alias=良好
    public static final int LVL4_VALUE = 4;//alias=优秀

    public static final BreedLvlEnum lv1 = new BreedLvlEnum("lv1", LV1_VALUE);
    public static final BreedLvlEnum lvl2 = new BreedLvlEnum("lvl2", LVL2_VALUE);
    public static final BreedLvlEnum lvl3 = new BreedLvlEnum("lvl3", LVL3_VALUE);
    public static final BreedLvlEnum lvl4 = new BreedLvlEnum("lvl4", LVL4_VALUE);

    /**
     * construct function
     * @param integer breedLvlEnum
     */
    private BreedLvlEnum(String name, int breedLvlEnum)
    {
        super(name, breedLvlEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static BreedLvlEnum getEnum(String breedLvlEnum)
    {
        return (BreedLvlEnum)getEnum(BreedLvlEnum.class, breedLvlEnum);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static BreedLvlEnum getEnum(int breedLvlEnum)
    {
        return (BreedLvlEnum)getEnum(BreedLvlEnum.class, breedLvlEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(BreedLvlEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(BreedLvlEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(BreedLvlEnum.class);
    }
}
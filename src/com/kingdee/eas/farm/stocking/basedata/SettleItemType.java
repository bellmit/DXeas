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
public class SettleItemType extends IntEnum
{
    public static final int BREEDSEED_VALUE = 1;//alias=苗
    public static final int FODDER_VALUE = 2;//alias=料
    public static final int DRUG_VALUE = 3;//alias=药
    public static final int EGG_VALUE = 4;//alias=菜蛋
    public static final int QCEGG_VALUE = 5;//alias=合格蛋
    public static final int OTHER_VALUE = 6;//alias=其他
    public static final int CHICKEN_VALUE = 7;//alias=毛鸡
    public static final int IMMUNE_VALUE = 8;//alias=疫苗
    public static final int GOODS_VALUE = 9;//alias=物资

    public static final SettleItemType breedSeed = new SettleItemType("breedSeed", BREEDSEED_VALUE);
    public static final SettleItemType fodder = new SettleItemType("fodder", FODDER_VALUE);
    public static final SettleItemType drug = new SettleItemType("drug", DRUG_VALUE);
    public static final SettleItemType egg = new SettleItemType("egg", EGG_VALUE);
    public static final SettleItemType qcEgg = new SettleItemType("qcEgg", QCEGG_VALUE);
    public static final SettleItemType other = new SettleItemType("other", OTHER_VALUE);
    public static final SettleItemType chicken = new SettleItemType("chicken", CHICKEN_VALUE);
    public static final SettleItemType immune = new SettleItemType("immune", IMMUNE_VALUE);
    public static final SettleItemType goods = new SettleItemType("goods", GOODS_VALUE);

    /**
     * construct function
     * @param integer settleItemType
     */
    private SettleItemType(String name, int settleItemType)
    {
        super(name, settleItemType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static SettleItemType getEnum(String settleItemType)
    {
        return (SettleItemType)getEnum(SettleItemType.class, settleItemType);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static SettleItemType getEnum(int settleItemType)
    {
        return (SettleItemType)getEnum(SettleItemType.class, settleItemType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(SettleItemType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(SettleItemType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(SettleItemType.class);
    }
}
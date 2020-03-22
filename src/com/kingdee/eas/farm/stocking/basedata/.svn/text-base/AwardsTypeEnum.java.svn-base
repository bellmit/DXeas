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
public class AwardsTypeEnum extends IntEnum
{
    public static final int LAYEGGRATE_VALUE = 1;//alias=产蛋率
    public static final int AVGWEIGHT_VALUE = 2;//alias=只重
    public static final int FCR_VALUE = 3;//alias=料肉比
    public static final int FERTILITYRATE_VALUE = 4;//alias=受精率

    public static final AwardsTypeEnum layEggRate = new AwardsTypeEnum("layEggRate", LAYEGGRATE_VALUE);
    public static final AwardsTypeEnum avgWeight = new AwardsTypeEnum("avgWeight", AVGWEIGHT_VALUE);
    public static final AwardsTypeEnum FCR = new AwardsTypeEnum("FCR", FCR_VALUE);
    public static final AwardsTypeEnum fertilityRate = new AwardsTypeEnum("fertilityRate", FERTILITYRATE_VALUE);

    /**
     * construct function
     * @param integer awardsTypeEnum
     */
    private AwardsTypeEnum(String name, int awardsTypeEnum)
    {
        super(name, awardsTypeEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static AwardsTypeEnum getEnum(String awardsTypeEnum)
    {
        return (AwardsTypeEnum)getEnum(AwardsTypeEnum.class, awardsTypeEnum);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static AwardsTypeEnum getEnum(int awardsTypeEnum)
    {
        return (AwardsTypeEnum)getEnum(AwardsTypeEnum.class, awardsTypeEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(AwardsTypeEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(AwardsTypeEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(AwardsTypeEnum.class);
    }
}
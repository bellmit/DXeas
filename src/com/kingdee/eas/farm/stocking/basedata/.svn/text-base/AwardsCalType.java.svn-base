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
public class AwardsCalType extends IntEnum
{
    public static final int PROMORL_VALUE = 3;//alias=比例增减
    public static final int VALUEMORL_VALUE = 4;//alias=数值增减
    public static final int CUSTOM_VALUE = 5;//alias=自定义公式

    public static final AwardsCalType proMorL = new AwardsCalType("proMorL", PROMORL_VALUE);
    public static final AwardsCalType valueMorL = new AwardsCalType("valueMorL", VALUEMORL_VALUE);
    public static final AwardsCalType custom = new AwardsCalType("custom", CUSTOM_VALUE);

    /**
     * construct function
     * @param integer awardsCalType
     */
    private AwardsCalType(String name, int awardsCalType)
    {
        super(name, awardsCalType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static AwardsCalType getEnum(String awardsCalType)
    {
        return (AwardsCalType)getEnum(AwardsCalType.class, awardsCalType);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static AwardsCalType getEnum(int awardsCalType)
    {
        return (AwardsCalType)getEnum(AwardsCalType.class, awardsCalType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(AwardsCalType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(AwardsCalType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(AwardsCalType.class);
    }
}
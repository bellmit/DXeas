/**
 * output package name
 */
package com.kingdee.eas.farm.breed.business;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class chickenType extends StringEnum
{
    public static final String CCHEN_VALUE = "1";//alias=商品鸡
    public static final String BREDHEN_VALUE = "2";//alias=育成鸡
    public static final String LAYEGGHEN_VALUE = "3";//alias=产蛋鸡
    public static final String BREEDINGHEN_VALUE = "4";//alias=种鸡

    public static final chickenType CCHen = new chickenType("CCHen", CCHEN_VALUE);
    public static final chickenType BredHen = new chickenType("BredHen", BREDHEN_VALUE);
    public static final chickenType LayEggHen = new chickenType("LayEggHen", LAYEGGHEN_VALUE);
    public static final chickenType BreedingHen = new chickenType("BreedingHen", BREEDINGHEN_VALUE);

    /**
     * construct function
     * @param String chickenType
     */
    private chickenType(String name, String chickenType)
    {
        super(name, chickenType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static chickenType getEnum(String chickenType)
    {
        return (chickenType)getEnum(chickenType.class, chickenType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(chickenType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(chickenType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(chickenType.class);
    }
}
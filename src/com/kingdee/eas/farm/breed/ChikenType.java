/**
 * output package name
 */
package com.kingdee.eas.farm.breed;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class ChikenType extends StringEnum
{
    public static final String BROODHEN_VALUE = "1";//alias=育成母鸡
    public static final String BROODCOCK_VALUE = "2";//alias=育成公鸡
    public static final String LAYEGGHEN_VALUE = "3";//alias=产蛋母鸡
    public static final String LAYEGGCOCK_VALUE = "4";//alias=产蛋公鸡
    public static final String COMMECIALCHIKEN_VALUE = "5";//alias=商品鸡

    public static final ChikenType BroodHen = new ChikenType("BroodHen", BROODHEN_VALUE);
    public static final ChikenType BroodCock = new ChikenType("BroodCock", BROODCOCK_VALUE);
    public static final ChikenType LayeggHen = new ChikenType("LayeggHen", LAYEGGHEN_VALUE);
    public static final ChikenType LayeggCock = new ChikenType("LayeggCock", LAYEGGCOCK_VALUE);
    public static final ChikenType CommecialChiken = new ChikenType("CommecialChiken", COMMECIALCHIKEN_VALUE);

    /**
     * construct function
     * @param String chikenType
     */
    private ChikenType(String name, String chikenType)
    {
        super(name, chikenType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static ChikenType getEnum(String chikenType)
    {
        return (ChikenType)getEnum(ChikenType.class, chikenType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(ChikenType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(ChikenType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(ChikenType.class);
    }
}
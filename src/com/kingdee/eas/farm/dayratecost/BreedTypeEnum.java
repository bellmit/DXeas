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
public class BreedTypeEnum extends IntEnum
{
    public static final int OWN_VALUE = 1;//alias=自养
    public static final int OUT_VALUE = 2;//alias=放养

    public static final BreedTypeEnum own = new BreedTypeEnum("own", OWN_VALUE);
    public static final BreedTypeEnum out = new BreedTypeEnum("out", OUT_VALUE);

    /**
     * construct function
     * @param integer breedTypeEnum
     */
    private BreedTypeEnum(String name, int breedTypeEnum)
    {
        super(name, breedTypeEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static BreedTypeEnum getEnum(String breedTypeEnum)
    {
        return (BreedTypeEnum)getEnum(BreedTypeEnum.class, breedTypeEnum);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static BreedTypeEnum getEnum(int breedTypeEnum)
    {
        return (BreedTypeEnum)getEnum(BreedTypeEnum.class, breedTypeEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(BreedTypeEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(BreedTypeEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(BreedTypeEnum.class);
    }
}
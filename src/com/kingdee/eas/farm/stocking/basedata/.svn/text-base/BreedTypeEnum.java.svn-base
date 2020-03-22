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
public class BreedTypeEnum extends IntEnum
{
    public static final int PARENT_VALUE = 1;//alias=父母代
    public static final int BUSNIESS_VALUE = 2;//alias=商品代

    public static final BreedTypeEnum parent = new BreedTypeEnum("parent", PARENT_VALUE);
    public static final BreedTypeEnum busniess = new BreedTypeEnum("busniess", BUSNIESS_VALUE);

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
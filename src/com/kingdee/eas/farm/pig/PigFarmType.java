/**
 * output package name
 */
package com.kingdee.eas.farm.pig;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class PigFarmType extends StringEnum
{
    public static final String MALEPIG_VALUE = "1";//alias=种公猪
    public static final String FEMALEPIG_VALUE = "2";//alias=种母猪
    public static final String COMMPIG_VALUE = "3";//alias=商品猪

    public static final PigFarmType MalePig = new PigFarmType("MalePig", MALEPIG_VALUE);
    public static final PigFarmType FemalePig = new PigFarmType("FemalePig", FEMALEPIG_VALUE);
    public static final PigFarmType CommPig = new PigFarmType("CommPig", COMMPIG_VALUE);

    /**
     * construct function
     * @param String pigFarmType
     */
    private PigFarmType(String name, String pigFarmType)
    {
        super(name, pigFarmType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static PigFarmType getEnum(String pigFarmType)
    {
        return (PigFarmType)getEnum(PigFarmType.class, pigFarmType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(PigFarmType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(PigFarmType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(PigFarmType.class);
    }
}
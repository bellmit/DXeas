/**
 * output package name
 */
package com.kingdee.eas.farm.farmer;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class BreedMode extends StringEnum
{
    public static final String CAGE_VALUE = "1";//alias=ÁýÑø
    public static final String NET_VALUE = "2";//alias=ÍøÑø

    public static final BreedMode Cage = new BreedMode("Cage", CAGE_VALUE);
    public static final BreedMode Net = new BreedMode("Net", NET_VALUE);

    /**
     * construct function
     * @param String breedMode
     */
    private BreedMode(String name, String breedMode)
    {
        super(name, breedMode);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static BreedMode getEnum(String breedMode)
    {
        return (BreedMode)getEnum(BreedMode.class, breedMode);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(BreedMode.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(BreedMode.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(BreedMode.class);
    }
}
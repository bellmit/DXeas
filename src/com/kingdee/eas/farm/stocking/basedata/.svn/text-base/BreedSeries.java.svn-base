/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basedata;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class BreedSeries extends StringEnum
{
    public static final String A_VALUE = "1";//alias=A
    public static final String B_VALUE = "2";//alias=B
    public static final String C_VALUE = "3";//alias=C
    public static final String D_VALUE = "4";//alias=D

    public static final BreedSeries A = new BreedSeries("A", A_VALUE);
    public static final BreedSeries B = new BreedSeries("B", B_VALUE);
    public static final BreedSeries C = new BreedSeries("C", C_VALUE);
    public static final BreedSeries D = new BreedSeries("D", D_VALUE);

    /**
     * construct function
     * @param String breedSeries
     */
    private BreedSeries(String name, String breedSeries)
    {
        super(name, breedSeries);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static BreedSeries getEnum(String breedSeries)
    {
        return (BreedSeries)getEnum(BreedSeries.class, breedSeries);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(BreedSeries.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(BreedSeries.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(BreedSeries.class);
    }
}
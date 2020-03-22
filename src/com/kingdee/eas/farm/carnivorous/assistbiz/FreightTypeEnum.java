/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.assistbiz;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class FreightTypeEnum extends StringEnum
{
    public static final String SEED_VALUE = "0";//alias=³ûÃç
    public static final String FODDER_VALUE = "1";//alias=ËÇÁÏ
    public static final String RECCK_VALUE = "2";//alias=Ã«¼¦

    public static final FreightTypeEnum seed = new FreightTypeEnum("seed", SEED_VALUE);
    public static final FreightTypeEnum Fodder = new FreightTypeEnum("Fodder", FODDER_VALUE);
    public static final FreightTypeEnum recCK = new FreightTypeEnum("recCK", RECCK_VALUE);

    /**
     * construct function
     * @param String freightTypeEnum
     */
    private FreightTypeEnum(String name, String freightTypeEnum)
    {
        super(name, freightTypeEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static FreightTypeEnum getEnum(String freightTypeEnum)
    {
        return (FreightTypeEnum)getEnum(FreightTypeEnum.class, freightTypeEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(FreightTypeEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(FreightTypeEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(FreightTypeEnum.class);
    }
}
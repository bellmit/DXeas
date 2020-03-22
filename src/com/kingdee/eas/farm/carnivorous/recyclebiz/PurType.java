/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.recyclebiz;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class PurType extends StringEnum
{
    public static final String CONTRACT_VALUE = "0";//alias=合同
    public static final String OTHER_VALUE = "1";//alias=其他

    public static final PurType contract = new PurType("contract", CONTRACT_VALUE);
    public static final PurType other = new PurType("other", OTHER_VALUE);

    /**
     * construct function
     * @param String purType
     */
    private PurType(String name, String purType)
    {
        super(name, purType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static PurType getEnum(String purType)
    {
        return (PurType)getEnum(PurType.class, purType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(PurType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(PurType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(PurType.class);
    }
}
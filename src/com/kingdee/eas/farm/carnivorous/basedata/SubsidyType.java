/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basedata;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class SubsidyType extends StringEnum
{
    public static final String BYWEIGHT_VALUE = "0";//alias=按重量（元/千克）
    public static final String BYQTY_VALUE = "1";//alias=按只数（元/只）

    public static final SubsidyType byWeight = new SubsidyType("byWeight", BYWEIGHT_VALUE);
    public static final SubsidyType byQty = new SubsidyType("byQty", BYQTY_VALUE);

    /**
     * construct function
     * @param String subsidyType
     */
    private SubsidyType(String name, String subsidyType)
    {
        super(name, subsidyType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static SubsidyType getEnum(String subsidyType)
    {
        return (SubsidyType)getEnum(SubsidyType.class, subsidyType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(SubsidyType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(SubsidyType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(SubsidyType.class);
    }
}
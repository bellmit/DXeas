/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.hatch;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class GenerateType extends StringEnum
{
    public static final String GRANDPARENT_VALUE = "0";//alias=祖代
    public static final String PARENT_VALUE = "1";//alias=父母代
    public static final String COMMERCE_VALUE = "2";//alias=商品代

    public static final GenerateType GrandParent = new GenerateType("GrandParent", GRANDPARENT_VALUE);
    public static final GenerateType Parent = new GenerateType("Parent", PARENT_VALUE);
    public static final GenerateType Commerce = new GenerateType("Commerce", COMMERCE_VALUE);

    /**
     * construct function
     * @param String generateType
     */
    private GenerateType(String name, String generateType)
    {
        super(name, generateType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static GenerateType getEnum(String generateType)
    {
        return (GenerateType)getEnum(GenerateType.class, generateType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(GenerateType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(GenerateType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(GenerateType.class);
    }
}
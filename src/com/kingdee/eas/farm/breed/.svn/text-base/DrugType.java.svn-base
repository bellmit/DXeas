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
public class DrugType extends StringEnum
{
    public static final String COMMON_VALUE = "1";//alias=通用类
    public static final String CCONLY_VALUE = "2";//alias=商品鸡专用
    public static final String HENONLY_VALUE = "3";//alias=种禽专用
    public static final String DISINFECTDRUG_VALUE = "4";//alias=消毒药

    public static final DrugType Common = new DrugType("Common", COMMON_VALUE);
    public static final DrugType CCOnly = new DrugType("CCOnly", CCONLY_VALUE);
    public static final DrugType HenOnly = new DrugType("HenOnly", HENONLY_VALUE);
    public static final DrugType DisinfectDrug = new DrugType("DisinfectDrug", DISINFECTDRUG_VALUE);

    /**
     * construct function
     * @param String drugType
     */
    private DrugType(String name, String drugType)
    {
        super(name, drugType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static DrugType getEnum(String drugType)
    {
        return (DrugType)getEnum(DrugType.class, drugType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(DrugType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(DrugType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(DrugType.class);
    }
}
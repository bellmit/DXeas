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
public class settlementItem extends StringEnum
{
    public static final String CHICKEN_VALUE = "1";//alias=Ã«¼¦
    public static final String SMALLCHICKEN_VALUE = "2";//alias=Ð¡¼¦
    public static final String DISABLECHICKEN_VALUE = "3";//alias=²Ð¼¦

    public static final settlementItem chicken = new settlementItem("chicken", CHICKEN_VALUE);
    public static final settlementItem smallChicken = new settlementItem("smallChicken", SMALLCHICKEN_VALUE);
    public static final settlementItem disableChicken = new settlementItem("disableChicken", DISABLECHICKEN_VALUE);

    /**
     * construct function
     * @param String settlementItem
     */
    private settlementItem(String name, String settlementItem)
    {
        super(name, settlementItem);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static settlementItem getEnum(String settlementItem)
    {
        return (settlementItem)getEnum(settlementItem.class, settlementItem);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(settlementItem.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(settlementItem.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(settlementItem.class);
    }
}
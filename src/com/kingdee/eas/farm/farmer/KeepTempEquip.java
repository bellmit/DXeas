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
public class KeepTempEquip extends StringEnum
{
    public static final String POOR_VALUE = "1";//alias=½Ï²î
    public static final String NORMAL_VALUE = "2";//alias=Ò»°ã
    public static final String WELL_VALUE = "3";//alias=Á¼ºÃ

    public static final KeepTempEquip Poor = new KeepTempEquip("Poor", POOR_VALUE);
    public static final KeepTempEquip Normal = new KeepTempEquip("Normal", NORMAL_VALUE);
    public static final KeepTempEquip Well = new KeepTempEquip("Well", WELL_VALUE);

    /**
     * construct function
     * @param String keepTempEquip
     */
    private KeepTempEquip(String name, String keepTempEquip)
    {
        super(name, keepTempEquip);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static KeepTempEquip getEnum(String keepTempEquip)
    {
        return (KeepTempEquip)getEnum(KeepTempEquip.class, keepTempEquip);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(KeepTempEquip.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(KeepTempEquip.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(KeepTempEquip.class);
    }
}
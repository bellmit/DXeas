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
public class DownTempEquip extends StringEnum
{
    public static final String POOR_VALUE = "1";//alias=½Ï²î
    public static final String NORMAL_VALUE = "2";//alias=Ò»°ã
    public static final String WELL_VALUE = "3";//alias=Á¼ºÃ

    public static final DownTempEquip Poor = new DownTempEquip("Poor", POOR_VALUE);
    public static final DownTempEquip Normal = new DownTempEquip("Normal", NORMAL_VALUE);
    public static final DownTempEquip Well = new DownTempEquip("Well", WELL_VALUE);

    /**
     * construct function
     * @param String downTempEquip
     */
    private DownTempEquip(String name, String downTempEquip)
    {
        super(name, downTempEquip);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static DownTempEquip getEnum(String downTempEquip)
    {
        return (DownTempEquip)getEnum(DownTempEquip.class, downTempEquip);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(DownTempEquip.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(DownTempEquip.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(DownTempEquip.class);
    }
}
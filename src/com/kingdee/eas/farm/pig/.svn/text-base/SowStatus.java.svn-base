/**
 * output package name
 */
package com.kingdee.eas.farm.pig;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class SowStatus extends StringEnum
{
    public static final String RESERVE_VALUE = "1";//alias=ºó±¸
    public static final String FIRSTBORN_VALUE = "2";//alias=³õ²ú
    public static final String NURSE_VALUE = "3";//alias=²¸Èé
    public static final String NONPREGNANT_VALUE = "4";//alias=¿Õ»³
    public static final String PREGNANT_VALUE = "5";//alias=ÈÑÉï

    public static final SowStatus Reserve = new SowStatus("Reserve", RESERVE_VALUE);
    public static final SowStatus FirstBorn = new SowStatus("FirstBorn", FIRSTBORN_VALUE);
    public static final SowStatus Nurse = new SowStatus("Nurse", NURSE_VALUE);
    public static final SowStatus Nonpregnant = new SowStatus("Nonpregnant", NONPREGNANT_VALUE);
    public static final SowStatus Pregnant = new SowStatus("Pregnant", PREGNANT_VALUE);

    /**
     * construct function
     * @param String sowStatus
     */
    private SowStatus(String name, String sowStatus)
    {
        super(name, sowStatus);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static SowStatus getEnum(String sowStatus)
    {
        return (SowStatus)getEnum(SowStatus.class, sowStatus);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(SowStatus.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(SowStatus.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(SowStatus.class);
    }
}
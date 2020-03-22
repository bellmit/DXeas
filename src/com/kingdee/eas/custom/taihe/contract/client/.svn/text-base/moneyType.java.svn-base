/**
 * output package name
 */
package com.kingdee.eas.custom.taihe.contract.client;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class moneyType extends StringEnum
{
    public static final String CHARGE_VALUE = "0";//alias= ’»°
    public static final String MONEYRETURN_VALUE = "1";//alias=ÕÀªÿ
    public static final String FINE_VALUE = "2";//alias=ø€∑£

    public static final moneyType charge = new moneyType("charge", CHARGE_VALUE);
    public static final moneyType moneyreturn = new moneyType("moneyreturn", MONEYRETURN_VALUE);
    public static final moneyType fine = new moneyType("fine", FINE_VALUE);

    /**
     * construct function
     * @param String moneyType
     */
    private moneyType(String name, String moneyType)
    {
        super(name, moneyType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static moneyType getEnum(String moneyType)
    {
        return (moneyType)getEnum(moneyType.class, moneyType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(moneyType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(moneyType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(moneyType.class);
    }
}
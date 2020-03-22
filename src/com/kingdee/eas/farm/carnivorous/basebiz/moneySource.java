/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basebiz;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class moneySource extends StringEnum
{
    public static final String NULL_VALUE = "-1";//alias=
    public static final String FROMBANK_VALUE = "0";//alias=银行存款
    public static final String FROMSETTLE_VALUE = "1";//alias=结算款
    public static final String ARREARS_VALUE = "2";//alias=赊欠款
    public static final String PAYARREARS_VALUE = "3";//alias=还赊欠款

    public static final moneySource NULL = new moneySource("NULL", NULL_VALUE);
    public static final moneySource FromBank = new moneySource("FromBank", FROMBANK_VALUE);
    public static final moneySource FromSettle = new moneySource("FromSettle", FROMSETTLE_VALUE);
    public static final moneySource Arrears = new moneySource("Arrears", ARREARS_VALUE);
    public static final moneySource PayArrears = new moneySource("PayArrears", PAYARREARS_VALUE);

    /**
     * construct function
     * @param String moneySource
     */
    private moneySource(String name, String moneySource)
    {
        super(name, moneySource);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static moneySource getEnum(String moneySource)
    {
        return (moneySource)getEnum(moneySource.class, moneySource);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(moneySource.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(moneySource.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(moneySource.class);
    }
}
/**
 * output package name
 */
package com.kingdee.eas.custom.salepayment;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class ProfitExeType extends StringEnum
{
    public static final String STANDARDTYPE_VALUE = "1";//alias=标准方式
    public static final String TEMP_VALUE = "2";//alias=回款比例

    public static final ProfitExeType StandardType = new ProfitExeType("StandardType", STANDARDTYPE_VALUE);
    public static final ProfitExeType Temp = new ProfitExeType("Temp", TEMP_VALUE);

    /**
     * construct function
     * @param String profitExeType
     */
    private ProfitExeType(String name, String profitExeType)
    {
        super(name, profitExeType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static ProfitExeType getEnum(String profitExeType)
    {
        return (ProfitExeType)getEnum(ProfitExeType.class, profitExeType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(ProfitExeType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(ProfitExeType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(ProfitExeType.class);
    }
}
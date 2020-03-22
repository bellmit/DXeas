/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.feedbiz;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class DrugBizType extends StringEnum
{
    public static final String COMM_VALUE = "0";//alias=普通领用
    public static final String TRANS_VALUE = "1";//alias=调药
    public static final String RETURNBACK_VALUE = "2";//alias=退药

    public static final DrugBizType comm = new DrugBizType("comm", COMM_VALUE);
    public static final DrugBizType trans = new DrugBizType("trans", TRANS_VALUE);
    public static final DrugBizType returnBack = new DrugBizType("returnBack", RETURNBACK_VALUE);

    /**
     * construct function
     * @param String drugBizType
     */
    private DrugBizType(String name, String drugBizType)
    {
        super(name, drugBizType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static DrugBizType getEnum(String drugBizType)
    {
        return (DrugBizType)getEnum(DrugBizType.class, drugBizType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(DrugBizType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(DrugBizType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(DrugBizType.class);
    }
}
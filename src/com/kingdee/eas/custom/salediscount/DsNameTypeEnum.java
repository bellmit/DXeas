/**
 * output package name
 */
package com.kingdee.eas.custom.salediscount;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class DsNameTypeEnum extends StringEnum
{
    public static final String GENERAL_VALUE = "1";//alias=常规折扣
    public static final String AIM_VALUE = "2";//alias=目标折扣
    public static final String RISE_VALUE = "3";//alias=涨价折扣
    public static final String INTEREST_VALUE = "4";//alias=利息折扣
    public static final String MATTER_VALUE = "5";//alias=实物条件
    public static final String DISTRIBUTION_VALUE = "6";//alias=分销关系

    public static final DsNameTypeEnum General = new DsNameTypeEnum("General", GENERAL_VALUE);
    public static final DsNameTypeEnum Aim = new DsNameTypeEnum("Aim", AIM_VALUE);
    public static final DsNameTypeEnum Rise = new DsNameTypeEnum("Rise", RISE_VALUE);
    public static final DsNameTypeEnum Interest = new DsNameTypeEnum("Interest", INTEREST_VALUE);
    public static final DsNameTypeEnum Matter = new DsNameTypeEnum("Matter", MATTER_VALUE);
    public static final DsNameTypeEnum Distribution = new DsNameTypeEnum("Distribution", DISTRIBUTION_VALUE);

    /**
     * construct function
     * @param String dsNameTypeEnum
     */
    private DsNameTypeEnum(String name, String dsNameTypeEnum)
    {
        super(name, dsNameTypeEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static DsNameTypeEnum getEnum(String dsNameTypeEnum)
    {
        return (DsNameTypeEnum)getEnum(DsNameTypeEnum.class, dsNameTypeEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(DsNameTypeEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(DsNameTypeEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(DsNameTypeEnum.class);
    }
}
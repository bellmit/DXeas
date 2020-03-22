/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basedata;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.IntEnum;

/**
 * output class name
 */
public class OutOrgEnum extends IntEnum
{
    public static final int FODDER_VALUE = 1;//alias=饲料厂
    public static final int HATCH_VALUE = 2;//alias=孵化场
    public static final int BREEDORG_VALUE = 3;//alias=养殖公司

    public static final OutOrgEnum fodder = new OutOrgEnum("fodder", FODDER_VALUE);
    public static final OutOrgEnum hatch = new OutOrgEnum("hatch", HATCH_VALUE);
    public static final OutOrgEnum breedOrg = new OutOrgEnum("breedOrg", BREEDORG_VALUE);

    /**
     * construct function
     * @param integer outOrgEnum
     */
    private OutOrgEnum(String name, int outOrgEnum)
    {
        super(name, outOrgEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static OutOrgEnum getEnum(String outOrgEnum)
    {
        return (OutOrgEnum)getEnum(OutOrgEnum.class, outOrgEnum);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static OutOrgEnum getEnum(int outOrgEnum)
    {
        return (OutOrgEnum)getEnum(OutOrgEnum.class, outOrgEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(OutOrgEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(OutOrgEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(OutOrgEnum.class);
    }
}
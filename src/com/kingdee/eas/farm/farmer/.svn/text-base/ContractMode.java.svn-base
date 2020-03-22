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
public class ContractMode extends StringEnum
{
    public static final String COOPERATION_VALUE = "1";//alias=合作社垫款
    public static final String AGENCY_VALUE = "2";//alias=经销商垫款

    public static final ContractMode Cooperation = new ContractMode("Cooperation", COOPERATION_VALUE);
    public static final ContractMode Agency = new ContractMode("Agency", AGENCY_VALUE);

    /**
     * construct function
     * @param String contractMode
     */
    private ContractMode(String name, String contractMode)
    {
        super(name, contractMode);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static ContractMode getEnum(String contractMode)
    {
        return (ContractMode)getEnum(ContractMode.class, contractMode);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(ContractMode.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(ContractMode.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(ContractMode.class);
    }
}
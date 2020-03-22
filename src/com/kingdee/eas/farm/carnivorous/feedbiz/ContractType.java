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
public class ContractType extends StringEnum
{
    public static final String MARKET_VALUE = "1";//alias=市场
    public static final String CONTRACT_VALUE = "2";//alias=合同

    public static final ContractType market = new ContractType("market", MARKET_VALUE);
    public static final ContractType contract = new ContractType("contract", CONTRACT_VALUE);

    /**
     * construct function
     * @param String contractType
     */
    private ContractType(String name, String contractType)
    {
        super(name, contractType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static ContractType getEnum(String contractType)
    {
        return (ContractType)getEnum(ContractType.class, contractType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(ContractType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(ContractType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(ContractType.class);
    }
}
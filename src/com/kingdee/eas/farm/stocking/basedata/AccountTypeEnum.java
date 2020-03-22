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
public class AccountTypeEnum extends IntEnum
{
    public static final int FARMER_VALUE = 1;//alias=养殖户
    public static final int FARM_VALUE = 2;//alias=养殖场

    public static final AccountTypeEnum farmer = new AccountTypeEnum("farmer", FARMER_VALUE);
    public static final AccountTypeEnum farm = new AccountTypeEnum("farm", FARM_VALUE);

    /**
     * construct function
     * @param integer accountTypeEnum
     */
    private AccountTypeEnum(String name, int accountTypeEnum)
    {
        super(name, accountTypeEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static AccountTypeEnum getEnum(String accountTypeEnum)
    {
        return (AccountTypeEnum)getEnum(AccountTypeEnum.class, accountTypeEnum);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static AccountTypeEnum getEnum(int accountTypeEnum)
    {
        return (AccountTypeEnum)getEnum(AccountTypeEnum.class, accountTypeEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(AccountTypeEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(AccountTypeEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(AccountTypeEnum.class);
    }
}
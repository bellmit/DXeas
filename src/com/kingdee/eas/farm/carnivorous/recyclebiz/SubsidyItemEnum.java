/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.recyclebiz;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class SubsidyItemEnum extends StringEnum
{
    public static final String NODRUG_VALUE = "1";//alias=无药残
    public static final String SUCCESSIVE_VALUE = "2";//alias=连养
    public static final String ASSUREAMT_VALUE = "3";//alias=保证金
    public static final String SEASON_VALUE = "4";//alias=季节补贴
    public static final String OTHER_VALUE = "5";//alias=其他
    public static final String SUPFENCE_VALUE = "6";//alias=补栏补贴
    public static final String BUILDFENCE_VALUE = "7";//alias=新建棚补贴
    public static final String LOANINTREST_VALUE = "8";//alias=贷款利息补贴
    public static final String DEPOSIT_VALUE = "9";//alias=保证金补贴
    public static final String SIGNTABLE_VALUE = "10";//alias=签呈补贴

    public static final SubsidyItemEnum NoDrug = new SubsidyItemEnum("NoDrug", NODRUG_VALUE);
    public static final SubsidyItemEnum Successive = new SubsidyItemEnum("Successive", SUCCESSIVE_VALUE);
    public static final SubsidyItemEnum AssureAmt = new SubsidyItemEnum("AssureAmt", ASSUREAMT_VALUE);
    public static final SubsidyItemEnum Season = new SubsidyItemEnum("Season", SEASON_VALUE);
    public static final SubsidyItemEnum Other = new SubsidyItemEnum("Other", OTHER_VALUE);
    public static final SubsidyItemEnum SupFence = new SubsidyItemEnum("SupFence", SUPFENCE_VALUE);
    public static final SubsidyItemEnum BuildFence = new SubsidyItemEnum("BuildFence", BUILDFENCE_VALUE);
    public static final SubsidyItemEnum LoanIntrest = new SubsidyItemEnum("LoanIntrest", LOANINTREST_VALUE);
    public static final SubsidyItemEnum Deposit = new SubsidyItemEnum("Deposit", DEPOSIT_VALUE);
    public static final SubsidyItemEnum SignTable = new SubsidyItemEnum("SignTable", SIGNTABLE_VALUE);

    /**
     * construct function
     * @param String subsidyItemEnum
     */
    private SubsidyItemEnum(String name, String subsidyItemEnum)
    {
        super(name, subsidyItemEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static SubsidyItemEnum getEnum(String subsidyItemEnum)
    {
        return (SubsidyItemEnum)getEnum(SubsidyItemEnum.class, subsidyItemEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(SubsidyItemEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(SubsidyItemEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(SubsidyItemEnum.class);
    }
}
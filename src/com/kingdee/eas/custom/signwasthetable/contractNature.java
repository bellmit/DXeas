/**
 * output package name
 */
package com.kingdee.eas.custom.signwasthetable;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class contractNature extends StringEnum
{
    public static final String TWOPARTYCONTRACT_VALUE = "1";//alias=两方合同
    public static final String THRIPARTITECONTRACT_VALUE = "2";//alias=三方合同

    public static final contractNature TwoPartyContract = new contractNature("TwoPartyContract", TWOPARTYCONTRACT_VALUE);
    public static final contractNature ThripartiteContract = new contractNature("ThripartiteContract", THRIPARTITECONTRACT_VALUE);

    /**
     * construct function
     * @param String contractNature
     */
    private contractNature(String name, String contractNature)
    {
        super(name, contractNature);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static contractNature getEnum(String contractNature)
    {
        return (contractNature)getEnum(contractNature.class, contractNature);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(contractNature.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(contractNature.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(contractNature.class);
    }
}
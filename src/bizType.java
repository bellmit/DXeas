

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class bizType extends StringEnum
{
    public static final String SALE_VALUE = "1";//alias=销售过磅
    public static final String PUR_VALUE = "2";//alias=采购过磅
    public static final String TRANSOUT_VALUE = "3";//alias=调拨出过磅
    public static final String TRANSIN_VALUE = "4";//alias=调拨入过磅

    public static final bizType Sale = new bizType("Sale", SALE_VALUE);
    public static final bizType Pur = new bizType("Pur", PUR_VALUE);
    public static final bizType TransOut = new bizType("TransOut", TRANSOUT_VALUE);
    public static final bizType TransIn = new bizType("TransIn", TRANSIN_VALUE);

    /**
     * construct function
     * @param String bizType
     */
    private bizType(String name, String bizType)
    {
        super(name, bizType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static bizType getEnum(String bizType)
    {
        return (bizType)getEnum(bizType.class, bizType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(bizType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(bizType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(bizType.class);
    }
}
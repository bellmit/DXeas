/**
 * output package name
 */
package com.kingdee.eas.custom.eas2temp;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.IntEnum;

/**
 * output class name
 */
public class EAS2TempOPTypeEnum extends IntEnum
{
    public static final int PURINWAREHOUSE_VALUE = 1;//alias=����eas�ɹ���ⵥ
    public static final int MATERIALREQ_VALUE = 2;//alias=����eas���ϳ��ⵥ
    public static final int PRODUCTIN_VALUE = 3;//alias=����eas������ⵥ
    public static final int MANUFACTUREORDER_VALUE = 4;//alias=������������
    public static final int EXPORTSALEISSUE_VALUE = 5;//alias=�������۳��ⵥ
    public static final int EXPORTBOM_VALUE = 6;//alias=����BOM
    public static final int IMPORTSTOCKTRANSFERBILL_VALUE = 7;//alias=�����������
    public static final int EXPORTMATERIAL_VALUE = 8;//alias=��������
    public static final int MATERIALCOLLREQ_VALUE = 9;//alias=�������ڻ������ϳ��ⵥ

    public static final EAS2TempOPTypeEnum purInwarehouse = new EAS2TempOPTypeEnum("purInwarehouse", PURINWAREHOUSE_VALUE);
    public static final EAS2TempOPTypeEnum materialReq = new EAS2TempOPTypeEnum("materialReq", MATERIALREQ_VALUE);
    public static final EAS2TempOPTypeEnum productIn = new EAS2TempOPTypeEnum("productIn", PRODUCTIN_VALUE);
    public static final EAS2TempOPTypeEnum manufactureOrder = new EAS2TempOPTypeEnum("manufactureOrder", MANUFACTUREORDER_VALUE);
    public static final EAS2TempOPTypeEnum exportSaleIssue = new EAS2TempOPTypeEnum("exportSaleIssue", EXPORTSALEISSUE_VALUE);
    public static final EAS2TempOPTypeEnum exportBOM = new EAS2TempOPTypeEnum("exportBOM", EXPORTBOM_VALUE);
    public static final EAS2TempOPTypeEnum importStockTransferBill = new EAS2TempOPTypeEnum("importStockTransferBill", IMPORTSTOCKTRANSFERBILL_VALUE);
    public static final EAS2TempOPTypeEnum exportMaterial = new EAS2TempOPTypeEnum("exportMaterial", EXPORTMATERIAL_VALUE);
    public static final EAS2TempOPTypeEnum materialCollReq = new EAS2TempOPTypeEnum("materialCollReq", MATERIALCOLLREQ_VALUE);

    /**
     * construct function
     * @param integer eAS2TempOPTypeEnum
     */
    private EAS2TempOPTypeEnum(String name, int eAS2TempOPTypeEnum)
    {
        super(name, eAS2TempOPTypeEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static EAS2TempOPTypeEnum getEnum(String eAS2TempOPTypeEnum)
    {
        return (EAS2TempOPTypeEnum)getEnum(EAS2TempOPTypeEnum.class, eAS2TempOPTypeEnum);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static EAS2TempOPTypeEnum getEnum(int eAS2TempOPTypeEnum)
    {
        return (EAS2TempOPTypeEnum)getEnum(EAS2TempOPTypeEnum.class, eAS2TempOPTypeEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(EAS2TempOPTypeEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(EAS2TempOPTypeEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(EAS2TempOPTypeEnum.class);
    }
}
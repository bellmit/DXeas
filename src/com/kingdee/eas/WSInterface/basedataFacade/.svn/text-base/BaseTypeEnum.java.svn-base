package com.kingdee.eas.WSInterface.basedataFacade;

public class BaseTypeEnum //final class BaseTypeEnum extends Enum
{

    private BaseTypeEnum(String s, int i, String billTypeNumber)
    {
        //super(s, i);
        this.billTypeNumber = "";
        this.billTypeNumber = billTypeNumber;
    }

    public String getNumber()
    {
        return billTypeNumber;
    }

    public static BaseTypeEnum[] values()
    {
        BaseTypeEnum abasetypeenum[];
        int i;
        BaseTypeEnum abasetypeenum1[];
        System.arraycopy(abasetypeenum = ENUM$VALUES, 0, abasetypeenum1 = new BaseTypeEnum[i = abasetypeenum.length], 0, i);
        return abasetypeenum1;
    }

    public static BaseTypeEnum valueOf(String s)
    {
    	return null;
        //return (BaseTypeEnum)Enum.valueOf(com.kingdee.eas.custom.WSInterface.basedataFacade.BaseTypeEnum.class, s);
    }
    public static final BaseTypeEnum GeneralAsstActType;
    
    public static final BaseTypeEnum MATGROUP;
    public static final BaseTypeEnum SALEORDER;
    public static final BaseTypeEnum TRANSFERORDER;
    public static final BaseTypeEnum TRANSFERBILL;
    public static final BaseTypeEnum PURINWARE;
    public static final BaseTypeEnum SALEISSUE;
    public static final BaseTypeEnum OTHERINWARE;
    public static final BaseTypeEnum OTHERISSUE;
    public static final BaseTypeEnum ARBILL;
    public static final BaseTypeEnum APBILL;
    private String billTypeNumber;
    private static final BaseTypeEnum ENUM$VALUES[];

    static 
    {	
    	GeneralAsstActType= new BaseTypeEnum("GeneralAsstActType", 50, "051");
        MATGROUP = new BaseTypeEnum("MATGROUP", 0, "001");
        SALEORDER = new BaseTypeEnum("SALEORDER", 1, "003");
        TRANSFERORDER = new BaseTypeEnum("TRANSFERORDER", 2, "004");
        TRANSFERBILL = new BaseTypeEnum("TRANSFERBILL", 3, "005");
        PURINWARE = new BaseTypeEnum("PURINWARE", 4, "006");
        SALEISSUE = new BaseTypeEnum("SALEISSUE", 5, "007");
        OTHERINWARE = new BaseTypeEnum("OTHERINWARE", 6, "008");
        OTHERISSUE = new BaseTypeEnum("OTHERISSUE", 7, "009");
        ARBILL = new BaseTypeEnum("ARBILL", 8, "010");
        APBILL = new BaseTypeEnum("APBILL", 9, "011");
        ENUM$VALUES = (new BaseTypeEnum[] {
            MATGROUP, SALEORDER, TRANSFERORDER, TRANSFERBILL, PURINWARE, SALEISSUE, OTHERINWARE, OTHERISSUE, ARBILL, APBILL
        });
    }
}
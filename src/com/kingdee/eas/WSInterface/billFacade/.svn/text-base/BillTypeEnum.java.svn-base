package com.kingdee.eas.WSInterface.billFacade;
/**
 * 有问题
 * @author DAD
 *
 */
public class  BillTypeEnum //extends Enum
{
    public static final BillTypeEnum PURREQUEST = new BillTypeEnum("PURREQUEST", 0, "001") ;
    public static final BillTypeEnum PURORDER= new BillTypeEnum("PURREQUEST", 1, "102");
    public static final BillTypeEnum SALEORDER=new BillTypeEnum("SALEORDER", 2, "003");
    public static final BillTypeEnum TRANSFERORDER=new BillTypeEnum("TRANSFERORDER", 3, "004");
    public static final BillTypeEnum TRANSFERBILL = new BillTypeEnum("TRANSFERBILL", 4, "005");
    public static final BillTypeEnum PURINWARE= new BillTypeEnum("PURINWARE", 5, "006");
    public static final BillTypeEnum SALEISSUE= new BillTypeEnum("SALEISSUE", 6, "007");
    public static final BillTypeEnum OTHERINWARE = new BillTypeEnum("OTHERINWARE", 7, "008");
    public static final BillTypeEnum OTHERISSUE= new BillTypeEnum("OTHERISSUE", 8, "009");
    public static final BillTypeEnum ARBILL= new BillTypeEnum("ARBILL", 9, "010");
    public static final BillTypeEnum APBILL = new BillTypeEnum("APBILL", 10, "011");
    public static final BillTypeEnum Requisition = new BillTypeEnum("Requisition", 11, "Requisition");//往来通知单
    private String billTypeNumber;
    private static final BillTypeEnum ENUM$VALUES[]= (new BillTypeEnum[] {
            PURREQUEST, PURORDER, SALEORDER, TRANSFERORDER, TRANSFERBILL, PURINWARE, SALEISSUE, OTHERINWARE, OTHERISSUE, ARBILL, 
            APBILL
        });

    private BillTypeEnum(String s, int i, String billTypeNumber)
    {
        //super(s, i);
        this.billTypeNumber = "";
        this.billTypeNumber = billTypeNumber;
    }
    

    public String getNumber()
    {
        return billTypeNumber;
    }

    public static BillTypeEnum[] values()
    {
        BillTypeEnum abilltypeenum[];
        int i;
        BillTypeEnum abilltypeenum1[];
        System.arraycopy(abilltypeenum = ENUM$VALUES, 0, abilltypeenum1 = new BillTypeEnum[i = abilltypeenum.length], 0, i);
        return abilltypeenum1;
    }

    public static BillTypeEnum valueOf(String s)
    {
        //return (BillTypeEnum)Enum.valueOf(com.kingdee.eas.custom.WSInterface.billFacade.BillTypeEnum.class, s);
    	return null;
    }

}
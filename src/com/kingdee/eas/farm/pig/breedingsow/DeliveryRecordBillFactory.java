package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DeliveryRecordBillFactory
{
    private DeliveryRecordBillFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingsow.IDeliveryRecordBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IDeliveryRecordBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("12F85AED") ,com.kingdee.eas.farm.pig.breedingsow.IDeliveryRecordBill.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingsow.IDeliveryRecordBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IDeliveryRecordBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("12F85AED") ,com.kingdee.eas.farm.pig.breedingsow.IDeliveryRecordBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingsow.IDeliveryRecordBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IDeliveryRecordBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("12F85AED"));
    }
    public static com.kingdee.eas.farm.pig.breedingsow.IDeliveryRecordBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IDeliveryRecordBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("12F85AED"));
    }
}
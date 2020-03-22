package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DeliveryRecordBillEntryFactory
{
    private DeliveryRecordBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingsow.IDeliveryRecordBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IDeliveryRecordBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("349C8985") ,com.kingdee.eas.farm.pig.breedingsow.IDeliveryRecordBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingsow.IDeliveryRecordBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IDeliveryRecordBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("349C8985") ,com.kingdee.eas.farm.pig.breedingsow.IDeliveryRecordBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingsow.IDeliveryRecordBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IDeliveryRecordBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("349C8985"));
    }
    public static com.kingdee.eas.farm.pig.breedingsow.IDeliveryRecordBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IDeliveryRecordBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("349C8985"));
    }
}
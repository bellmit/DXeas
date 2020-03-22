package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CheckHeatBillEntryFactory
{
    private CheckHeatBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingsow.ICheckHeatBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ICheckHeatBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D8896854") ,com.kingdee.eas.farm.pig.breedingsow.ICheckHeatBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingsow.ICheckHeatBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ICheckHeatBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D8896854") ,com.kingdee.eas.farm.pig.breedingsow.ICheckHeatBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingsow.ICheckHeatBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ICheckHeatBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D8896854"));
    }
    public static com.kingdee.eas.farm.pig.breedingsow.ICheckHeatBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ICheckHeatBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D8896854"));
    }
}
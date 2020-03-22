package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ArrangementBreedBillEntryFactory
{
    private ArrangementBreedBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IArrangementBreedBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IArrangementBreedBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3755AF7C") ,com.kingdee.eas.farm.stocking.processbizill.IArrangementBreedBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IArrangementBreedBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IArrangementBreedBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3755AF7C") ,com.kingdee.eas.farm.stocking.processbizill.IArrangementBreedBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IArrangementBreedBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IArrangementBreedBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3755AF7C"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IArrangementBreedBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IArrangementBreedBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3755AF7C"));
    }
}
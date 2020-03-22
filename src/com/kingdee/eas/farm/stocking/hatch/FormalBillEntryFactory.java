package com.kingdee.eas.farm.stocking.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FormalBillEntryFactory
{
    private FormalBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.hatch.IFormalBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IFormalBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("52873052") ,com.kingdee.eas.farm.stocking.hatch.IFormalBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.hatch.IFormalBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IFormalBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("52873052") ,com.kingdee.eas.farm.stocking.hatch.IFormalBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.hatch.IFormalBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IFormalBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("52873052"));
    }
    public static com.kingdee.eas.farm.stocking.hatch.IFormalBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IFormalBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("52873052"));
    }
}
package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TranferBoxBillEntryFactory
{
    private TranferBoxBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.ITranferBoxBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.ITranferBoxBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("63360EFA") ,com.kingdee.eas.farm.hatch.ITranferBoxBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.hatch.ITranferBoxBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.ITranferBoxBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("63360EFA") ,com.kingdee.eas.farm.hatch.ITranferBoxBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.ITranferBoxBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.ITranferBoxBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("63360EFA"));
    }
    public static com.kingdee.eas.farm.hatch.ITranferBoxBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.ITranferBoxBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("63360EFA"));
    }
}
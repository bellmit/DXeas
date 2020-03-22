package com.kingdee.eas.farm.stocking.assistfunction;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class RunningDailyPaperEntryFactory
{
    private RunningDailyPaperEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.assistfunction.IRunningDailyPaperEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.assistfunction.IRunningDailyPaperEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0BFCB64B") ,com.kingdee.eas.farm.stocking.assistfunction.IRunningDailyPaperEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.assistfunction.IRunningDailyPaperEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.assistfunction.IRunningDailyPaperEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0BFCB64B") ,com.kingdee.eas.farm.stocking.assistfunction.IRunningDailyPaperEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.assistfunction.IRunningDailyPaperEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.assistfunction.IRunningDailyPaperEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0BFCB64B"));
    }
    public static com.kingdee.eas.farm.stocking.assistfunction.IRunningDailyPaperEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.assistfunction.IRunningDailyPaperEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0BFCB64B"));
    }
}
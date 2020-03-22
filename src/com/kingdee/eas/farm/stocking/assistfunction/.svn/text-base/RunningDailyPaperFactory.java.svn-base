package com.kingdee.eas.farm.stocking.assistfunction;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class RunningDailyPaperFactory
{
    private RunningDailyPaperFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.assistfunction.IRunningDailyPaper getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.assistfunction.IRunningDailyPaper)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3B34CA67") ,com.kingdee.eas.farm.stocking.assistfunction.IRunningDailyPaper.class);
    }
    
    public static com.kingdee.eas.farm.stocking.assistfunction.IRunningDailyPaper getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.assistfunction.IRunningDailyPaper)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3B34CA67") ,com.kingdee.eas.farm.stocking.assistfunction.IRunningDailyPaper.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.assistfunction.IRunningDailyPaper getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.assistfunction.IRunningDailyPaper)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3B34CA67"));
    }
    public static com.kingdee.eas.farm.stocking.assistfunction.IRunningDailyPaper getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.assistfunction.IRunningDailyPaper)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3B34CA67"));
    }
}
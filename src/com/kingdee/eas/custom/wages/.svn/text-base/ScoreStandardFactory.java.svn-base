package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ScoreStandardFactory
{
    private ScoreStandardFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IScoreStandard getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IScoreStandard)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C7C98067") ,com.kingdee.eas.custom.wages.IScoreStandard.class);
    }
    
    public static com.kingdee.eas.custom.wages.IScoreStandard getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IScoreStandard)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C7C98067") ,com.kingdee.eas.custom.wages.IScoreStandard.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IScoreStandard getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IScoreStandard)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C7C98067"));
    }
    public static com.kingdee.eas.custom.wages.IScoreStandard getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IScoreStandard)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C7C98067"));
    }
}
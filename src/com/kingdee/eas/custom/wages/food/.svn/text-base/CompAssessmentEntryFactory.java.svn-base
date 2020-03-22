package com.kingdee.eas.custom.wages.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CompAssessmentEntryFactory
{
    private CompAssessmentEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.food.ICompAssessmentEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.ICompAssessmentEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("49C8AB7F") ,com.kingdee.eas.custom.wages.food.ICompAssessmentEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.food.ICompAssessmentEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.ICompAssessmentEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("49C8AB7F") ,com.kingdee.eas.custom.wages.food.ICompAssessmentEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.food.ICompAssessmentEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.ICompAssessmentEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("49C8AB7F"));
    }
    public static com.kingdee.eas.custom.wages.food.ICompAssessmentEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.ICompAssessmentEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("49C8AB7F"));
    }
}
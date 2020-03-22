package com.kingdee.eas.custom.wages.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CompAssessmentFactory
{
    private CompAssessmentFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.food.ICompAssessment getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.ICompAssessment)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("59E964B3") ,com.kingdee.eas.custom.wages.food.ICompAssessment.class);
    }
    
    public static com.kingdee.eas.custom.wages.food.ICompAssessment getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.ICompAssessment)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("59E964B3") ,com.kingdee.eas.custom.wages.food.ICompAssessment.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.food.ICompAssessment getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.ICompAssessment)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("59E964B3"));
    }
    public static com.kingdee.eas.custom.wages.food.ICompAssessment getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.ICompAssessment)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("59E964B3"));
    }
}
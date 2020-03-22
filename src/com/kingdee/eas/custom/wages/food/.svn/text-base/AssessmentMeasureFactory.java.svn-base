package com.kingdee.eas.custom.wages.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AssessmentMeasureFactory
{
    private AssessmentMeasureFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.food.IAssessmentMeasure getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IAssessmentMeasure)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6816D77A") ,com.kingdee.eas.custom.wages.food.IAssessmentMeasure.class);
    }
    
    public static com.kingdee.eas.custom.wages.food.IAssessmentMeasure getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IAssessmentMeasure)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6816D77A") ,com.kingdee.eas.custom.wages.food.IAssessmentMeasure.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.food.IAssessmentMeasure getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IAssessmentMeasure)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6816D77A"));
    }
    public static com.kingdee.eas.custom.wages.food.IAssessmentMeasure getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IAssessmentMeasure)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6816D77A"));
    }
}
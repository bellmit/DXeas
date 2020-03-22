package com.kingdee.eas.custom.wages.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AssessmentMeasureEntryFactory
{
    private AssessmentMeasureEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.food.IAssessmentMeasureEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IAssessmentMeasureEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("EBC6DD18") ,com.kingdee.eas.custom.wages.food.IAssessmentMeasureEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.food.IAssessmentMeasureEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IAssessmentMeasureEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("EBC6DD18") ,com.kingdee.eas.custom.wages.food.IAssessmentMeasureEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.food.IAssessmentMeasureEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IAssessmentMeasureEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("EBC6DD18"));
    }
    public static com.kingdee.eas.custom.wages.food.IAssessmentMeasureEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IAssessmentMeasureEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("EBC6DD18"));
    }
}
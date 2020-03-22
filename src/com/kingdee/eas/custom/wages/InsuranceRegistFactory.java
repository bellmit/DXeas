package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class InsuranceRegistFactory
{
    private InsuranceRegistFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IInsuranceRegist getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IInsuranceRegist)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("45AEC1E8") ,com.kingdee.eas.custom.wages.IInsuranceRegist.class);
    }
    
    public static com.kingdee.eas.custom.wages.IInsuranceRegist getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IInsuranceRegist)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("45AEC1E8") ,com.kingdee.eas.custom.wages.IInsuranceRegist.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IInsuranceRegist getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IInsuranceRegist)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("45AEC1E8"));
    }
    public static com.kingdee.eas.custom.wages.IInsuranceRegist getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IInsuranceRegist)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("45AEC1E8"));
    }
}
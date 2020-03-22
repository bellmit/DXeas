package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MarginBreedPolicyFactory
{
    private MarginBreedPolicyFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IMarginBreedPolicy getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IMarginBreedPolicy)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C00593D6") ,com.kingdee.eas.farm.carnivorous.basedata.IMarginBreedPolicy.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IMarginBreedPolicy getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IMarginBreedPolicy)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C00593D6") ,com.kingdee.eas.farm.carnivorous.basedata.IMarginBreedPolicy.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IMarginBreedPolicy getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IMarginBreedPolicy)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C00593D6"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IMarginBreedPolicy getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IMarginBreedPolicy)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C00593D6"));
    }
}
package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MarginGetPolicyFactory
{
    private MarginGetPolicyFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IMarginGetPolicy getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IMarginGetPolicy)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("75B61C38") ,com.kingdee.eas.farm.carnivorous.basedata.IMarginGetPolicy.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IMarginGetPolicy getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IMarginGetPolicy)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("75B61C38") ,com.kingdee.eas.farm.carnivorous.basedata.IMarginGetPolicy.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IMarginGetPolicy getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IMarginGetPolicy)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("75B61C38"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IMarginGetPolicy getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IMarginGetPolicy)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("75B61C38"));
    }
}
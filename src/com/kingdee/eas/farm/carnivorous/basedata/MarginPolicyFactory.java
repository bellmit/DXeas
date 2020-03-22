package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MarginPolicyFactory
{
    private MarginPolicyFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IMarginPolicy getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IMarginPolicy)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("948B4B22") ,com.kingdee.eas.farm.carnivorous.basedata.IMarginPolicy.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IMarginPolicy getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IMarginPolicy)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("948B4B22") ,com.kingdee.eas.farm.carnivorous.basedata.IMarginPolicy.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IMarginPolicy getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IMarginPolicy)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("948B4B22"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IMarginPolicy getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IMarginPolicy)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("948B4B22"));
    }
}
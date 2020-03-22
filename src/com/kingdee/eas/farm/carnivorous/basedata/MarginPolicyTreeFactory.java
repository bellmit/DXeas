package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MarginPolicyTreeFactory
{
    private MarginPolicyTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IMarginPolicyTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IMarginPolicyTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("79F4D1E0") ,com.kingdee.eas.farm.carnivorous.basedata.IMarginPolicyTree.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IMarginPolicyTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IMarginPolicyTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("79F4D1E0") ,com.kingdee.eas.farm.carnivorous.basedata.IMarginPolicyTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IMarginPolicyTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IMarginPolicyTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("79F4D1E0"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IMarginPolicyTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IMarginPolicyTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("79F4D1E0"));
    }
}
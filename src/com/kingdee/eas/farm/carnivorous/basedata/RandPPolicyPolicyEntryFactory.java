package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class RandPPolicyPolicyEntryFactory
{
    private RandPPolicyPolicyEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IRandPPolicyPolicyEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IRandPPolicyPolicyEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8F1DB465") ,com.kingdee.eas.farm.carnivorous.basedata.IRandPPolicyPolicyEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IRandPPolicyPolicyEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IRandPPolicyPolicyEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8F1DB465") ,com.kingdee.eas.farm.carnivorous.basedata.IRandPPolicyPolicyEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IRandPPolicyPolicyEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IRandPPolicyPolicyEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8F1DB465"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IRandPPolicyPolicyEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IRandPPolicyPolicyEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8F1DB465"));
    }
}
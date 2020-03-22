package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MarginGetPolicyEntryFactory
{
    private MarginGetPolicyEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IMarginGetPolicyEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IMarginGetPolicyEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D74ADF1A") ,com.kingdee.eas.farm.carnivorous.basedata.IMarginGetPolicyEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IMarginGetPolicyEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IMarginGetPolicyEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D74ADF1A") ,com.kingdee.eas.farm.carnivorous.basedata.IMarginGetPolicyEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IMarginGetPolicyEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IMarginGetPolicyEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D74ADF1A"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IMarginGetPolicyEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IMarginGetPolicyEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D74ADF1A"));
    }
}
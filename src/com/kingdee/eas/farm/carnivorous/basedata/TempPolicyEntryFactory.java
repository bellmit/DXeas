package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TempPolicyEntryFactory
{
    private TempPolicyEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ITempPolicyEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ITempPolicyEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4697900A") ,com.kingdee.eas.farm.carnivorous.basedata.ITempPolicyEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.ITempPolicyEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ITempPolicyEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4697900A") ,com.kingdee.eas.farm.carnivorous.basedata.ITempPolicyEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ITempPolicyEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ITempPolicyEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4697900A"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ITempPolicyEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ITempPolicyEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4697900A"));
    }
}
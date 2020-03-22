package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FeeSendPersonFactory
{
    private FeeSendPersonFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IFeeSendPerson getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFeeSendPerson)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B2617972") ,com.kingdee.eas.farm.stocking.basedata.IFeeSendPerson.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IFeeSendPerson getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFeeSendPerson)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B2617972") ,com.kingdee.eas.farm.stocking.basedata.IFeeSendPerson.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IFeeSendPerson getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFeeSendPerson)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B2617972"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IFeeSendPerson getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFeeSendPerson)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B2617972"));
    }
}
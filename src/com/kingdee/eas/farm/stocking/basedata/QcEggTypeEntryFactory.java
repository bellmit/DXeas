package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class QcEggTypeEntryFactory
{
    private QcEggTypeEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IQcEggTypeEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IQcEggTypeEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("165BFB96") ,com.kingdee.eas.farm.stocking.basedata.IQcEggTypeEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IQcEggTypeEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IQcEggTypeEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("165BFB96") ,com.kingdee.eas.farm.stocking.basedata.IQcEggTypeEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IQcEggTypeEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IQcEggTypeEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("165BFB96"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IQcEggTypeEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IQcEggTypeEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("165BFB96"));
    }
}
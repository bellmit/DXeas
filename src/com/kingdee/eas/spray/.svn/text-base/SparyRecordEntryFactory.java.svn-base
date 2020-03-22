package com.kingdee.eas.spray;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SparyRecordEntryFactory
{
    private SparyRecordEntryFactory()
    {
    }
    public static com.kingdee.eas.spray.ISparyRecordEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.spray.ISparyRecordEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2CC670A9") ,com.kingdee.eas.spray.ISparyRecordEntry.class);
    }
    
    public static com.kingdee.eas.spray.ISparyRecordEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.spray.ISparyRecordEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2CC670A9") ,com.kingdee.eas.spray.ISparyRecordEntry.class, objectCtx);
    }
    public static com.kingdee.eas.spray.ISparyRecordEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.spray.ISparyRecordEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2CC670A9"));
    }
    public static com.kingdee.eas.spray.ISparyRecordEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.spray.ISparyRecordEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2CC670A9"));
    }
}
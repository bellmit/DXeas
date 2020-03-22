package com.kingdee.eas.spray;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SparyRecordFactory
{
    private SparyRecordFactory()
    {
    }
    public static com.kingdee.eas.spray.ISparyRecord getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.spray.ISparyRecord)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("33FB8D49") ,com.kingdee.eas.spray.ISparyRecord.class);
    }
    
    public static com.kingdee.eas.spray.ISparyRecord getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.spray.ISparyRecord)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("33FB8D49") ,com.kingdee.eas.spray.ISparyRecord.class, objectCtx);
    }
    public static com.kingdee.eas.spray.ISparyRecord getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.spray.ISparyRecord)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("33FB8D49"));
    }
    public static com.kingdee.eas.spray.ISparyRecord getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.spray.ISparyRecord)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("33FB8D49"));
    }
}
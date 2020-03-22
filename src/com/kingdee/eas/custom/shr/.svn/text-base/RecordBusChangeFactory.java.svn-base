package com.kingdee.eas.custom.shr;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class RecordBusChangeFactory
{
    private RecordBusChangeFactory()
    {
    }
    public static com.kingdee.eas.custom.shr.IRecordBusChange getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.shr.IRecordBusChange)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A1B04D69") ,com.kingdee.eas.custom.shr.IRecordBusChange.class);
    }
    
    public static com.kingdee.eas.custom.shr.IRecordBusChange getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.shr.IRecordBusChange)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A1B04D69") ,com.kingdee.eas.custom.shr.IRecordBusChange.class, objectCtx);
    }
    public static com.kingdee.eas.custom.shr.IRecordBusChange getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.shr.IRecordBusChange)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A1B04D69"));
    }
    public static com.kingdee.eas.custom.shr.IRecordBusChange getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.shr.IRecordBusChange)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A1B04D69"));
    }
}
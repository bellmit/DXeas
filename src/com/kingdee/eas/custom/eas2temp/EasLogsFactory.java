package com.kingdee.eas.custom.eas2temp;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EasLogsFactory
{
    private EasLogsFactory()
    {
    }
    public static com.kingdee.eas.custom.eas2temp.IEasLogs getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IEasLogs)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("45007552") ,com.kingdee.eas.custom.eas2temp.IEasLogs.class);
    }
    
    public static com.kingdee.eas.custom.eas2temp.IEasLogs getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IEasLogs)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("45007552") ,com.kingdee.eas.custom.eas2temp.IEasLogs.class, objectCtx);
    }
    public static com.kingdee.eas.custom.eas2temp.IEasLogs getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IEasLogs)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("45007552"));
    }
    public static com.kingdee.eas.custom.eas2temp.IEasLogs getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IEasLogs)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("45007552"));
    }
}
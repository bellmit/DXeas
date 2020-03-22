package com.kingdee.eas.custom.szcount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CountPosOtherFactory
{
    private CountPosOtherFactory()
    {
    }
    public static com.kingdee.eas.custom.szcount.ICountPosOther getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ICountPosOther)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("7389F7C0") ,com.kingdee.eas.custom.szcount.ICountPosOther.class);
    }
    
    public static com.kingdee.eas.custom.szcount.ICountPosOther getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ICountPosOther)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("7389F7C0") ,com.kingdee.eas.custom.szcount.ICountPosOther.class, objectCtx);
    }
    public static com.kingdee.eas.custom.szcount.ICountPosOther getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ICountPosOther)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("7389F7C0"));
    }
    public static com.kingdee.eas.custom.szcount.ICountPosOther getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ICountPosOther)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("7389F7C0"));
    }
}
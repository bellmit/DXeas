package com.kingdee.eas.custom.szcount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CountPosOtherCppEntryFactory
{
    private CountPosOtherCppEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.szcount.ICountPosOtherCppEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ICountPosOtherCppEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2CBDC06F") ,com.kingdee.eas.custom.szcount.ICountPosOtherCppEntry.class);
    }
    
    public static com.kingdee.eas.custom.szcount.ICountPosOtherCppEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ICountPosOtherCppEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2CBDC06F") ,com.kingdee.eas.custom.szcount.ICountPosOtherCppEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.szcount.ICountPosOtherCppEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ICountPosOtherCppEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2CBDC06F"));
    }
    public static com.kingdee.eas.custom.szcount.ICountPosOtherCppEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ICountPosOtherCppEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2CBDC06F"));
    }
}
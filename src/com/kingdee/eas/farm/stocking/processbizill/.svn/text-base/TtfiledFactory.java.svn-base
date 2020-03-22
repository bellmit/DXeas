package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TtfiledFactory
{
    private TtfiledFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITtfiled getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITtfiled)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("44B1D4E3") ,com.kingdee.eas.farm.stocking.processbizill.ITtfiled.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.ITtfiled getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITtfiled)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("44B1D4E3") ,com.kingdee.eas.farm.stocking.processbizill.ITtfiled.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITtfiled getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITtfiled)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("44B1D4E3"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITtfiled getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITtfiled)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("44B1D4E3"));
    }
}
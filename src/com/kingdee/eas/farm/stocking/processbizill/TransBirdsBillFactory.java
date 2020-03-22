package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TransBirdsBillFactory
{
    private TransBirdsBillFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITransBirdsBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITransBirdsBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6CA79EDE") ,com.kingdee.eas.farm.stocking.processbizill.ITransBirdsBill.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.ITransBirdsBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITransBirdsBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6CA79EDE") ,com.kingdee.eas.farm.stocking.processbizill.ITransBirdsBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITransBirdsBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITransBirdsBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6CA79EDE"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITransBirdsBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITransBirdsBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6CA79EDE"));
    }
}
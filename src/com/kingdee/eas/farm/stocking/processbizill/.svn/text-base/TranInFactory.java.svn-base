package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TranInFactory
{
    private TranInFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITranIn getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITranIn)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6D73B955") ,com.kingdee.eas.farm.stocking.processbizill.ITranIn.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.ITranIn getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITranIn)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6D73B955") ,com.kingdee.eas.farm.stocking.processbizill.ITranIn.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITranIn getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITranIn)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6D73B955"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITranIn getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITranIn)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6D73B955"));
    }
}
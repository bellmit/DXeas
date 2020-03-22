package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TheEggTableFactory
{
    private TheEggTableFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITheEggTable getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITheEggTable)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("92FD45D5") ,com.kingdee.eas.farm.stocking.processbizill.ITheEggTable.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.ITheEggTable getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITheEggTable)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("92FD45D5") ,com.kingdee.eas.farm.stocking.processbizill.ITheEggTable.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITheEggTable getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITheEggTable)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("92FD45D5"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITheEggTable getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITheEggTable)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("92FD45D5"));
    }
}
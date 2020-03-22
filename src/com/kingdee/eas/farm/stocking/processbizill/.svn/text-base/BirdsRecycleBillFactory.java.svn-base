package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BirdsRecycleBillFactory
{
    private BirdsRecycleBillFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBirdsRecycleBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBirdsRecycleBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D6772365") ,com.kingdee.eas.farm.stocking.processbizill.IBirdsRecycleBill.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IBirdsRecycleBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBirdsRecycleBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D6772365") ,com.kingdee.eas.farm.stocking.processbizill.IBirdsRecycleBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBirdsRecycleBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBirdsRecycleBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D6772365"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBirdsRecycleBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBirdsRecycleBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D6772365"));
    }
}
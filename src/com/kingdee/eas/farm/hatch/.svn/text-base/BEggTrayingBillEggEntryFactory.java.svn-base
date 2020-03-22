package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BEggTrayingBillEggEntryFactory
{
    private BEggTrayingBillEggEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IBEggTrayingBillEggEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBEggTrayingBillEggEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3389888F") ,com.kingdee.eas.farm.hatch.IBEggTrayingBillEggEntry.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IBEggTrayingBillEggEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBEggTrayingBillEggEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3389888F") ,com.kingdee.eas.farm.hatch.IBEggTrayingBillEggEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IBEggTrayingBillEggEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBEggTrayingBillEggEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3389888F"));
    }
    public static com.kingdee.eas.farm.hatch.IBEggTrayingBillEggEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBEggTrayingBillEggEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3389888F"));
    }
}
package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BEggTrayingBillTransBoxEntryFactory
{
    private BEggTrayingBillTransBoxEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IBEggTrayingBillTransBoxEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBEggTrayingBillTransBoxEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("90DAD84D") ,com.kingdee.eas.farm.hatch.IBEggTrayingBillTransBoxEntry.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IBEggTrayingBillTransBoxEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBEggTrayingBillTransBoxEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("90DAD84D") ,com.kingdee.eas.farm.hatch.IBEggTrayingBillTransBoxEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IBEggTrayingBillTransBoxEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBEggTrayingBillTransBoxEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("90DAD84D"));
    }
    public static com.kingdee.eas.farm.hatch.IBEggTrayingBillTransBoxEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBEggTrayingBillTransBoxEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("90DAD84D"));
    }
}
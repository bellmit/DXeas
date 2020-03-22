package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BEggHatchBillAreaSummaryEntryFactory
{
    private BEggHatchBillAreaSummaryEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IBEggHatchBillAreaSummaryEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBEggHatchBillAreaSummaryEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1EE6CDCF") ,com.kingdee.eas.farm.hatch.IBEggHatchBillAreaSummaryEntry.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IBEggHatchBillAreaSummaryEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBEggHatchBillAreaSummaryEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1EE6CDCF") ,com.kingdee.eas.farm.hatch.IBEggHatchBillAreaSummaryEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IBEggHatchBillAreaSummaryEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBEggHatchBillAreaSummaryEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1EE6CDCF"));
    }
    public static com.kingdee.eas.farm.hatch.IBEggHatchBillAreaSummaryEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBEggHatchBillAreaSummaryEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1EE6CDCF"));
    }
}
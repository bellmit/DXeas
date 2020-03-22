package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BEggHatchBillHatchBoxSummaryEntryFactory
{
    private BEggHatchBillHatchBoxSummaryEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IBEggHatchBillHatchBoxSummaryEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBEggHatchBillHatchBoxSummaryEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("63FBCEAD") ,com.kingdee.eas.farm.hatch.IBEggHatchBillHatchBoxSummaryEntry.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IBEggHatchBillHatchBoxSummaryEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBEggHatchBillHatchBoxSummaryEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("63FBCEAD") ,com.kingdee.eas.farm.hatch.IBEggHatchBillHatchBoxSummaryEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IBEggHatchBillHatchBoxSummaryEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBEggHatchBillHatchBoxSummaryEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("63FBCEAD"));
    }
    public static com.kingdee.eas.farm.hatch.IBEggHatchBillHatchBoxSummaryEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBEggHatchBillHatchBoxSummaryEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("63FBCEAD"));
    }
}
package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class HatchBillCoefficientEntryFactory
{
    private HatchBillCoefficientEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IHatchBillCoefficientEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBillCoefficientEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4ABAD876") ,com.kingdee.eas.farm.hatch.IHatchBillCoefficientEntry.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IHatchBillCoefficientEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBillCoefficientEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4ABAD876") ,com.kingdee.eas.farm.hatch.IHatchBillCoefficientEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IHatchBillCoefficientEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBillCoefficientEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4ABAD876"));
    }
    public static com.kingdee.eas.farm.hatch.IHatchBillCoefficientEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBillCoefficientEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4ABAD876"));
    }
}
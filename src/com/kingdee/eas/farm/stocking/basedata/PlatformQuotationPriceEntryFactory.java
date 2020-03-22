package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PlatformQuotationPriceEntryFactory
{
    private PlatformQuotationPriceEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IPlatformQuotationPriceEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IPlatformQuotationPriceEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0DADE5F1") ,com.kingdee.eas.farm.stocking.basedata.IPlatformQuotationPriceEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IPlatformQuotationPriceEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IPlatformQuotationPriceEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0DADE5F1") ,com.kingdee.eas.farm.stocking.basedata.IPlatformQuotationPriceEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IPlatformQuotationPriceEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IPlatformQuotationPriceEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0DADE5F1"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IPlatformQuotationPriceEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IPlatformQuotationPriceEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0DADE5F1"));
    }
}
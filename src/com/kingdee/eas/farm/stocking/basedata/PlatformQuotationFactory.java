package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PlatformQuotationFactory
{
    private PlatformQuotationFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IPlatformQuotation getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IPlatformQuotation)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("EECE0F28") ,com.kingdee.eas.farm.stocking.basedata.IPlatformQuotation.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IPlatformQuotation getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IPlatformQuotation)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("EECE0F28") ,com.kingdee.eas.farm.stocking.basedata.IPlatformQuotation.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IPlatformQuotation getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IPlatformQuotation)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("EECE0F28"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IPlatformQuotation getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IPlatformQuotation)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("EECE0F28"));
    }
}
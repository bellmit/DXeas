package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AreaSetSalerEntryFactory
{
    private AreaSetSalerEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.salepayment.IAreaSetSalerEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IAreaSetSalerEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B53C2828") ,com.kingdee.eas.custom.salepayment.IAreaSetSalerEntry.class);
    }
    
    public static com.kingdee.eas.custom.salepayment.IAreaSetSalerEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IAreaSetSalerEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B53C2828") ,com.kingdee.eas.custom.salepayment.IAreaSetSalerEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salepayment.IAreaSetSalerEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IAreaSetSalerEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B53C2828"));
    }
    public static com.kingdee.eas.custom.salepayment.IAreaSetSalerEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IAreaSetSalerEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B53C2828"));
    }
}
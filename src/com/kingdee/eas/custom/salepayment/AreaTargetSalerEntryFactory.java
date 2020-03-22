package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AreaTargetSalerEntryFactory
{
    private AreaTargetSalerEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.salepayment.IAreaTargetSalerEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IAreaTargetSalerEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8DAFB239") ,com.kingdee.eas.custom.salepayment.IAreaTargetSalerEntry.class);
    }
    
    public static com.kingdee.eas.custom.salepayment.IAreaTargetSalerEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IAreaTargetSalerEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8DAFB239") ,com.kingdee.eas.custom.salepayment.IAreaTargetSalerEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salepayment.IAreaTargetSalerEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IAreaTargetSalerEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8DAFB239"));
    }
    public static com.kingdee.eas.custom.salepayment.IAreaTargetSalerEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IAreaTargetSalerEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8DAFB239"));
    }
}
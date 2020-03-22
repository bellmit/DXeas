package com.kingdee.eas.custom.taihe.sale;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ComplaintTableEntryFactory
{
    private ComplaintTableEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.sale.IComplaintTableEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.sale.IComplaintTableEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("EB0AF668") ,com.kingdee.eas.custom.taihe.sale.IComplaintTableEntry.class);
    }
    
    public static com.kingdee.eas.custom.taihe.sale.IComplaintTableEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.sale.IComplaintTableEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("EB0AF668") ,com.kingdee.eas.custom.taihe.sale.IComplaintTableEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.sale.IComplaintTableEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.sale.IComplaintTableEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("EB0AF668"));
    }
    public static com.kingdee.eas.custom.taihe.sale.IComplaintTableEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.sale.IComplaintTableEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("EB0AF668"));
    }
}
package com.kingdee.eas.custom.taihe.complaintvisit;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ComplainBillComplainEntryFactory
{
    private ComplainBillComplainEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.complaintvisit.IComplainBillComplainEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.complaintvisit.IComplainBillComplainEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B48C46EB") ,com.kingdee.eas.custom.taihe.complaintvisit.IComplainBillComplainEntry.class);
    }
    
    public static com.kingdee.eas.custom.taihe.complaintvisit.IComplainBillComplainEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.complaintvisit.IComplainBillComplainEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B48C46EB") ,com.kingdee.eas.custom.taihe.complaintvisit.IComplainBillComplainEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.complaintvisit.IComplainBillComplainEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.complaintvisit.IComplainBillComplainEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B48C46EB"));
    }
    public static com.kingdee.eas.custom.taihe.complaintvisit.IComplainBillComplainEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.complaintvisit.IComplainBillComplainEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B48C46EB"));
    }
}
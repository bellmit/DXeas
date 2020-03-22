package com.kingdee.eas.custom.taihe.complaintvisit;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ComplainBillEntryFactory
{
    private ComplainBillEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.complaintvisit.IComplainBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.complaintvisit.IComplainBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("76743054") ,com.kingdee.eas.custom.taihe.complaintvisit.IComplainBillEntry.class);
    }
    
    public static com.kingdee.eas.custom.taihe.complaintvisit.IComplainBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.complaintvisit.IComplainBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("76743054") ,com.kingdee.eas.custom.taihe.complaintvisit.IComplainBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.complaintvisit.IComplainBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.complaintvisit.IComplainBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("76743054"));
    }
    public static com.kingdee.eas.custom.taihe.complaintvisit.IComplainBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.complaintvisit.IComplainBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("76743054"));
    }
}
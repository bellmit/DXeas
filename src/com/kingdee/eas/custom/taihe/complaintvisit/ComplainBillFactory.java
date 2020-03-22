package com.kingdee.eas.custom.taihe.complaintvisit;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ComplainBillFactory
{
    private ComplainBillFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.complaintvisit.IComplainBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.complaintvisit.IComplainBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2A796EBE") ,com.kingdee.eas.custom.taihe.complaintvisit.IComplainBill.class);
    }
    
    public static com.kingdee.eas.custom.taihe.complaintvisit.IComplainBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.complaintvisit.IComplainBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2A796EBE") ,com.kingdee.eas.custom.taihe.complaintvisit.IComplainBill.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.complaintvisit.IComplainBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.complaintvisit.IComplainBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2A796EBE"));
    }
    public static com.kingdee.eas.custom.taihe.complaintvisit.IComplainBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.complaintvisit.IComplainBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2A796EBE"));
    }
}
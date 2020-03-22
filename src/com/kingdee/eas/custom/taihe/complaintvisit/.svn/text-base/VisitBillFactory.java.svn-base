package com.kingdee.eas.custom.taihe.complaintvisit;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class VisitBillFactory
{
    private VisitBillFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.complaintvisit.IVisitBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.complaintvisit.IVisitBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("26F7D484") ,com.kingdee.eas.custom.taihe.complaintvisit.IVisitBill.class);
    }
    
    public static com.kingdee.eas.custom.taihe.complaintvisit.IVisitBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.complaintvisit.IVisitBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("26F7D484") ,com.kingdee.eas.custom.taihe.complaintvisit.IVisitBill.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.complaintvisit.IVisitBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.complaintvisit.IVisitBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("26F7D484"));
    }
    public static com.kingdee.eas.custom.taihe.complaintvisit.IVisitBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.complaintvisit.IVisitBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("26F7D484"));
    }
}
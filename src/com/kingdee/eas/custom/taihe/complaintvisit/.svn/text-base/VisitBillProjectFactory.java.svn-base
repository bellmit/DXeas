package com.kingdee.eas.custom.taihe.complaintvisit;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class VisitBillProjectFactory
{
    private VisitBillProjectFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.complaintvisit.IVisitBillProject getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.complaintvisit.IVisitBillProject)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("BF35B1F5") ,com.kingdee.eas.custom.taihe.complaintvisit.IVisitBillProject.class);
    }
    
    public static com.kingdee.eas.custom.taihe.complaintvisit.IVisitBillProject getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.complaintvisit.IVisitBillProject)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("BF35B1F5") ,com.kingdee.eas.custom.taihe.complaintvisit.IVisitBillProject.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.complaintvisit.IVisitBillProject getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.complaintvisit.IVisitBillProject)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("BF35B1F5"));
    }
    public static com.kingdee.eas.custom.taihe.complaintvisit.IVisitBillProject getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.complaintvisit.IVisitBillProject)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("BF35B1F5"));
    }
}
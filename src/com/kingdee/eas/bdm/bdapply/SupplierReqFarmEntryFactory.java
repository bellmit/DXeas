package com.kingdee.eas.bdm.bdapply;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SupplierReqFarmEntryFactory
{
    private SupplierReqFarmEntryFactory()
    {
    }
    public static com.kingdee.eas.bdm.bdapply.ISupplierReqFarmEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.bdm.bdapply.ISupplierReqFarmEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C5723DC1") ,com.kingdee.eas.bdm.bdapply.ISupplierReqFarmEntry.class);
    }
    
    public static com.kingdee.eas.bdm.bdapply.ISupplierReqFarmEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.bdm.bdapply.ISupplierReqFarmEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C5723DC1") ,com.kingdee.eas.bdm.bdapply.ISupplierReqFarmEntry.class, objectCtx);
    }
    public static com.kingdee.eas.bdm.bdapply.ISupplierReqFarmEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.bdm.bdapply.ISupplierReqFarmEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C5723DC1"));
    }
    public static com.kingdee.eas.bdm.bdapply.ISupplierReqFarmEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.bdm.bdapply.ISupplierReqFarmEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C5723DC1"));
    }
}
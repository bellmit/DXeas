package com.kingdee.eas.custom.lhsm;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CompanyInvTreeFactory
{
    private CompanyInvTreeFactory()
    {
    }
    public static com.kingdee.eas.custom.lhsm.ICompanyInvTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.ICompanyInvTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("7F4CC09F") ,com.kingdee.eas.custom.lhsm.ICompanyInvTree.class);
    }
    
    public static com.kingdee.eas.custom.lhsm.ICompanyInvTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.ICompanyInvTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("7F4CC09F") ,com.kingdee.eas.custom.lhsm.ICompanyInvTree.class, objectCtx);
    }
    public static com.kingdee.eas.custom.lhsm.ICompanyInvTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.ICompanyInvTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("7F4CC09F"));
    }
    public static com.kingdee.eas.custom.lhsm.ICompanyInvTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.ICompanyInvTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("7F4CC09F"));
    }
}
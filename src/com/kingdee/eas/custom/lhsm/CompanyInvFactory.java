package com.kingdee.eas.custom.lhsm;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CompanyInvFactory
{
    private CompanyInvFactory()
    {
    }
    public static com.kingdee.eas.custom.lhsm.ICompanyInv getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.ICompanyInv)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("286E7161") ,com.kingdee.eas.custom.lhsm.ICompanyInv.class);
    }
    
    public static com.kingdee.eas.custom.lhsm.ICompanyInv getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.ICompanyInv)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("286E7161") ,com.kingdee.eas.custom.lhsm.ICompanyInv.class, objectCtx);
    }
    public static com.kingdee.eas.custom.lhsm.ICompanyInv getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.ICompanyInv)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("286E7161"));
    }
    public static com.kingdee.eas.custom.lhsm.ICompanyInv getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.ICompanyInv)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("286E7161"));
    }
}
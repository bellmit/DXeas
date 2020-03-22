package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CompanyTargetTreeFactory
{
    private CompanyTargetTreeFactory()
    {
    }
    public static com.kingdee.eas.custom.salepayment.ICompanyTargetTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ICompanyTargetTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("AF4D80B8") ,com.kingdee.eas.custom.salepayment.ICompanyTargetTree.class);
    }
    
    public static com.kingdee.eas.custom.salepayment.ICompanyTargetTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ICompanyTargetTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("AF4D80B8") ,com.kingdee.eas.custom.salepayment.ICompanyTargetTree.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salepayment.ICompanyTargetTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ICompanyTargetTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("AF4D80B8"));
    }
    public static com.kingdee.eas.custom.salepayment.ICompanyTargetTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ICompanyTargetTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("AF4D80B8"));
    }
}
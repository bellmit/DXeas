package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CompanyTargetFactory
{
    private CompanyTargetFactory()
    {
    }
    public static com.kingdee.eas.custom.salepayment.ICompanyTarget getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ICompanyTarget)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1E7D25FA") ,com.kingdee.eas.custom.salepayment.ICompanyTarget.class);
    }
    
    public static com.kingdee.eas.custom.salepayment.ICompanyTarget getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ICompanyTarget)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1E7D25FA") ,com.kingdee.eas.custom.salepayment.ICompanyTarget.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salepayment.ICompanyTarget getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ICompanyTarget)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1E7D25FA"));
    }
    public static com.kingdee.eas.custom.salepayment.ICompanyTarget getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ICompanyTarget)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1E7D25FA"));
    }
}
package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CompanyTargetAreaEntryFactory
{
    private CompanyTargetAreaEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.salepayment.ICompanyTargetAreaEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ICompanyTargetAreaEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("7B36AB0B") ,com.kingdee.eas.custom.salepayment.ICompanyTargetAreaEntry.class);
    }
    
    public static com.kingdee.eas.custom.salepayment.ICompanyTargetAreaEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ICompanyTargetAreaEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("7B36AB0B") ,com.kingdee.eas.custom.salepayment.ICompanyTargetAreaEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salepayment.ICompanyTargetAreaEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ICompanyTargetAreaEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("7B36AB0B"));
    }
    public static com.kingdee.eas.custom.salepayment.ICompanyTargetAreaEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ICompanyTargetAreaEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("7B36AB0B"));
    }
}
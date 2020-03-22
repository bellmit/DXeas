package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CompanyinfoEntryFactory
{
    private CompanyinfoEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.foodtrac.ICompanyinfoEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.ICompanyinfoEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("826D774C") ,com.kingdee.eas.custom.foodtrac.ICompanyinfoEntry.class);
    }
    
    public static com.kingdee.eas.custom.foodtrac.ICompanyinfoEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.ICompanyinfoEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("826D774C") ,com.kingdee.eas.custom.foodtrac.ICompanyinfoEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.foodtrac.ICompanyinfoEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.ICompanyinfoEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("826D774C"));
    }
    public static com.kingdee.eas.custom.foodtrac.ICompanyinfoEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.ICompanyinfoEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("826D774C"));
    }
}
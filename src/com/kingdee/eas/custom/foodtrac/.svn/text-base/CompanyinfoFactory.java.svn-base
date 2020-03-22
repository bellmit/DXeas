package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CompanyinfoFactory
{
    private CompanyinfoFactory()
    {
    }
    public static com.kingdee.eas.custom.foodtrac.ICompanyinfo getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.ICompanyinfo)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3F1DACC6") ,com.kingdee.eas.custom.foodtrac.ICompanyinfo.class);
    }
    
    public static com.kingdee.eas.custom.foodtrac.ICompanyinfo getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.ICompanyinfo)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3F1DACC6") ,com.kingdee.eas.custom.foodtrac.ICompanyinfo.class, objectCtx);
    }
    public static com.kingdee.eas.custom.foodtrac.ICompanyinfo getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.ICompanyinfo)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3F1DACC6"));
    }
    public static com.kingdee.eas.custom.foodtrac.ICompanyinfo getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.ICompanyinfo)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3F1DACC6"));
    }
}
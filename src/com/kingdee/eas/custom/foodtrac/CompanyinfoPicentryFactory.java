package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CompanyinfoPicentryFactory
{
    private CompanyinfoPicentryFactory()
    {
    }
    public static com.kingdee.eas.custom.foodtrac.ICompanyinfoPicentry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.ICompanyinfoPicentry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("511EA80E") ,com.kingdee.eas.custom.foodtrac.ICompanyinfoPicentry.class);
    }
    
    public static com.kingdee.eas.custom.foodtrac.ICompanyinfoPicentry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.ICompanyinfoPicentry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("511EA80E") ,com.kingdee.eas.custom.foodtrac.ICompanyinfoPicentry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.foodtrac.ICompanyinfoPicentry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.ICompanyinfoPicentry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("511EA80E"));
    }
    public static com.kingdee.eas.custom.foodtrac.ICompanyinfoPicentry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.ICompanyinfoPicentry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("511EA80E"));
    }
}
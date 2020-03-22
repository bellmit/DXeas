package com.kingdee.eas.custom.salediscount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DiscountCompanyFactory
{
    private DiscountCompanyFactory()
    {
    }
    public static com.kingdee.eas.custom.salediscount.IDiscountCompany getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountCompany)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("AFF2E9A1") ,com.kingdee.eas.custom.salediscount.IDiscountCompany.class);
    }
    
    public static com.kingdee.eas.custom.salediscount.IDiscountCompany getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountCompany)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("AFF2E9A1") ,com.kingdee.eas.custom.salediscount.IDiscountCompany.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salediscount.IDiscountCompany getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountCompany)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("AFF2E9A1"));
    }
    public static com.kingdee.eas.custom.salediscount.IDiscountCompany getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountCompany)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("AFF2E9A1"));
    }
}
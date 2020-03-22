package com.kingdee.eas.custom.salediscount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DiscountCompanyTreeFactory
{
    private DiscountCompanyTreeFactory()
    {
    }
    public static com.kingdee.eas.custom.salediscount.IDiscountCompanyTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountCompanyTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("435B18DF") ,com.kingdee.eas.custom.salediscount.IDiscountCompanyTree.class);
    }
    
    public static com.kingdee.eas.custom.salediscount.IDiscountCompanyTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountCompanyTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("435B18DF") ,com.kingdee.eas.custom.salediscount.IDiscountCompanyTree.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salediscount.IDiscountCompanyTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountCompanyTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("435B18DF"));
    }
    public static com.kingdee.eas.custom.salediscount.IDiscountCompanyTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountCompanyTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("435B18DF"));
    }
}
package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LongTimeArAmountFactory
{
    private LongTimeArAmountFactory()
    {
    }
    public static com.kingdee.eas.custom.salepayment.ILongTimeArAmount getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ILongTimeArAmount)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4F196166") ,com.kingdee.eas.custom.salepayment.ILongTimeArAmount.class);
    }
    
    public static com.kingdee.eas.custom.salepayment.ILongTimeArAmount getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ILongTimeArAmount)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4F196166") ,com.kingdee.eas.custom.salepayment.ILongTimeArAmount.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salepayment.ILongTimeArAmount getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ILongTimeArAmount)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4F196166"));
    }
    public static com.kingdee.eas.custom.salepayment.ILongTimeArAmount getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ILongTimeArAmount)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4F196166"));
    }
}
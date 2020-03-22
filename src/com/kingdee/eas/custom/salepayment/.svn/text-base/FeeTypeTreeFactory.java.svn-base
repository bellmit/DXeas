package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FeeTypeTreeFactory
{
    private FeeTypeTreeFactory()
    {
    }
    public static com.kingdee.eas.custom.salepayment.IFeeTypeTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IFeeTypeTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A5E9E42A") ,com.kingdee.eas.custom.salepayment.IFeeTypeTree.class);
    }
    
    public static com.kingdee.eas.custom.salepayment.IFeeTypeTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IFeeTypeTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A5E9E42A") ,com.kingdee.eas.custom.salepayment.IFeeTypeTree.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salepayment.IFeeTypeTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IFeeTypeTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A5E9E42A"));
    }
    public static com.kingdee.eas.custom.salepayment.IFeeTypeTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IFeeTypeTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A5E9E42A"));
    }
}
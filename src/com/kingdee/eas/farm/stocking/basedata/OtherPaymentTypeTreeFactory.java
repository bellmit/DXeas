package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class OtherPaymentTypeTreeFactory
{
    private OtherPaymentTypeTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IOtherPaymentTypeTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IOtherPaymentTypeTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6B02D9BF") ,com.kingdee.eas.farm.stocking.basedata.IOtherPaymentTypeTree.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IOtherPaymentTypeTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IOtherPaymentTypeTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6B02D9BF") ,com.kingdee.eas.farm.stocking.basedata.IOtherPaymentTypeTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IOtherPaymentTypeTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IOtherPaymentTypeTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6B02D9BF"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IOtherPaymentTypeTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IOtherPaymentTypeTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6B02D9BF"));
    }
}
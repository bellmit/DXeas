package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class GrossProfitInfoFactory
{
    private GrossProfitInfoFactory()
    {
    }
    public static com.kingdee.eas.custom.salepayment.IGrossProfitInfo getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IGrossProfitInfo)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2D158D02") ,com.kingdee.eas.custom.salepayment.IGrossProfitInfo.class);
    }
    
    public static com.kingdee.eas.custom.salepayment.IGrossProfitInfo getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IGrossProfitInfo)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2D158D02") ,com.kingdee.eas.custom.salepayment.IGrossProfitInfo.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salepayment.IGrossProfitInfo getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IGrossProfitInfo)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2D158D02"));
    }
    public static com.kingdee.eas.custom.salepayment.IGrossProfitInfo getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IGrossProfitInfo)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2D158D02"));
    }
}
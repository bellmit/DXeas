package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class GrossProfitInfoEntryFactory
{
    private GrossProfitInfoEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.salepayment.IGrossProfitInfoEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IGrossProfitInfoEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("5AC45C90") ,com.kingdee.eas.custom.salepayment.IGrossProfitInfoEntry.class);
    }
    
    public static com.kingdee.eas.custom.salepayment.IGrossProfitInfoEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IGrossProfitInfoEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("5AC45C90") ,com.kingdee.eas.custom.salepayment.IGrossProfitInfoEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salepayment.IGrossProfitInfoEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IGrossProfitInfoEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("5AC45C90"));
    }
    public static com.kingdee.eas.custom.salepayment.IGrossProfitInfoEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IGrossProfitInfoEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("5AC45C90"));
    }
}
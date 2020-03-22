package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class GrossProfitInfoRecEntryFactory
{
    private GrossProfitInfoRecEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.salepayment.IGrossProfitInfoRecEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IGrossProfitInfoRecEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F3A708E4") ,com.kingdee.eas.custom.salepayment.IGrossProfitInfoRecEntry.class);
    }
    
    public static com.kingdee.eas.custom.salepayment.IGrossProfitInfoRecEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IGrossProfitInfoRecEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F3A708E4") ,com.kingdee.eas.custom.salepayment.IGrossProfitInfoRecEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salepayment.IGrossProfitInfoRecEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IGrossProfitInfoRecEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F3A708E4"));
    }
    public static com.kingdee.eas.custom.salepayment.IGrossProfitInfoRecEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IGrossProfitInfoRecEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F3A708E4"));
    }
}
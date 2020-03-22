package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LiveBirdWgtBillSaleEntryFactory
{
    private LiveBirdWgtBillSaleEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ILiveBirdWgtBillSaleEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ILiveBirdWgtBillSaleEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("243D8662") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ILiveBirdWgtBillSaleEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ILiveBirdWgtBillSaleEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ILiveBirdWgtBillSaleEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("243D8662") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ILiveBirdWgtBillSaleEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ILiveBirdWgtBillSaleEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ILiveBirdWgtBillSaleEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("243D8662"));
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ILiveBirdWgtBillSaleEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ILiveBirdWgtBillSaleEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("243D8662"));
    }
}
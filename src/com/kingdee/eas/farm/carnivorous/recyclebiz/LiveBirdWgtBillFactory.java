package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LiveBirdWgtBillFactory
{
    private LiveBirdWgtBillFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ILiveBirdWgtBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ILiveBirdWgtBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("90D40009") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ILiveBirdWgtBill.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ILiveBirdWgtBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ILiveBirdWgtBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("90D40009") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ILiveBirdWgtBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ILiveBirdWgtBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ILiveBirdWgtBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("90D40009"));
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ILiveBirdWgtBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ILiveBirdWgtBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("90D40009"));
    }
}
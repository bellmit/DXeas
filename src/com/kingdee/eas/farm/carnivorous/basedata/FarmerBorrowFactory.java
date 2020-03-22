package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FarmerBorrowFactory
{
    private FarmerBorrowFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFarmerBorrow getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFarmerBorrow)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F47D9DDA") ,com.kingdee.eas.farm.carnivorous.basedata.IFarmerBorrow.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IFarmerBorrow getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFarmerBorrow)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F47D9DDA") ,com.kingdee.eas.farm.carnivorous.basedata.IFarmerBorrow.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFarmerBorrow getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFarmerBorrow)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F47D9DDA"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFarmerBorrow getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFarmerBorrow)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F47D9DDA"));
    }
}
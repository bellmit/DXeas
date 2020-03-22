package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FarmerBorrowNewFactory
{
    private FarmerBorrowNewFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFarmerBorrowNew getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFarmerBorrowNew)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A6258D66") ,com.kingdee.eas.farm.carnivorous.basedata.IFarmerBorrowNew.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IFarmerBorrowNew getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFarmerBorrowNew)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A6258D66") ,com.kingdee.eas.farm.carnivorous.basedata.IFarmerBorrowNew.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFarmerBorrowNew getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFarmerBorrowNew)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A6258D66"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFarmerBorrowNew getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFarmerBorrowNew)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A6258D66"));
    }
}
package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CarviousFeedComMeatFactory
{
    private CarviousFeedComMeatFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ICarviousFeedComMeat getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ICarviousFeedComMeat)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0962A446") ,com.kingdee.eas.farm.carnivorous.basedata.ICarviousFeedComMeat.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.ICarviousFeedComMeat getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ICarviousFeedComMeat)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0962A446") ,com.kingdee.eas.farm.carnivorous.basedata.ICarviousFeedComMeat.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ICarviousFeedComMeat getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ICarviousFeedComMeat)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0962A446"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ICarviousFeedComMeat getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ICarviousFeedComMeat)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0962A446"));
    }
}
package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CarviousFeedComMeatEntryFactory
{
    private CarviousFeedComMeatEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ICarviousFeedComMeatEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ICarviousFeedComMeatEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("DA172FCC") ,com.kingdee.eas.farm.carnivorous.basedata.ICarviousFeedComMeatEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.ICarviousFeedComMeatEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ICarviousFeedComMeatEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("DA172FCC") ,com.kingdee.eas.farm.carnivorous.basedata.ICarviousFeedComMeatEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ICarviousFeedComMeatEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ICarviousFeedComMeatEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("DA172FCC"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ICarviousFeedComMeatEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ICarviousFeedComMeatEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("DA172FCC"));
    }
}
package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BrowerItemFactory
{
    private BrowerItemFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBrowerItem getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBrowerItem)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("CAE888BA") ,com.kingdee.eas.farm.carnivorous.basedata.IBrowerItem.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IBrowerItem getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBrowerItem)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("CAE888BA") ,com.kingdee.eas.farm.carnivorous.basedata.IBrowerItem.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBrowerItem getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBrowerItem)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("CAE888BA"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBrowerItem getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBrowerItem)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("CAE888BA"));
    }
}
package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BrowerItemNewFactory
{
    private BrowerItemNewFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBrowerItemNew getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBrowerItemNew)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("AA403686") ,com.kingdee.eas.farm.carnivorous.basedata.IBrowerItemNew.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IBrowerItemNew getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBrowerItemNew)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("AA403686") ,com.kingdee.eas.farm.carnivorous.basedata.IBrowerItemNew.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBrowerItemNew getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBrowerItemNew)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("AA403686"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBrowerItemNew getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBrowerItemNew)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("AA403686"));
    }
}
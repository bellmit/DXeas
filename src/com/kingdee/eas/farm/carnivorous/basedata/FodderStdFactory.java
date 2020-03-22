package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FodderStdFactory
{
    private FodderStdFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFodderStd getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFodderStd)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("460C756B") ,com.kingdee.eas.farm.carnivorous.basedata.IFodderStd.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IFodderStd getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFodderStd)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("460C756B") ,com.kingdee.eas.farm.carnivorous.basedata.IFodderStd.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFodderStd getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFodderStd)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("460C756B"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFodderStd getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFodderStd)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("460C756B"));
    }
}
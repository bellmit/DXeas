package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BrowerItemTreeFactory
{
    private BrowerItemTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBrowerItemTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBrowerItemTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("9DC98378") ,com.kingdee.eas.farm.carnivorous.basedata.IBrowerItemTree.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IBrowerItemTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBrowerItemTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("9DC98378") ,com.kingdee.eas.farm.carnivorous.basedata.IBrowerItemTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBrowerItemTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBrowerItemTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("9DC98378"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBrowerItemTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBrowerItemTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("9DC98378"));
    }
}
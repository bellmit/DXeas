package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TempPolicyFactory
{
    private TempPolicyFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ITempPolicy getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ITempPolicy)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0A9A9548") ,com.kingdee.eas.farm.carnivorous.basedata.ITempPolicy.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.ITempPolicy getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ITempPolicy)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0A9A9548") ,com.kingdee.eas.farm.carnivorous.basedata.ITempPolicy.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ITempPolicy getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ITempPolicy)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0A9A9548"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ITempPolicy getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ITempPolicy)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0A9A9548"));
    }
}
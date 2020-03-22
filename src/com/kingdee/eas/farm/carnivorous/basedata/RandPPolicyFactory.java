package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class RandPPolicyFactory
{
    private RandPPolicyFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IRandPPolicy getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IRandPPolicy)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("CEC4BAFB") ,com.kingdee.eas.farm.carnivorous.basedata.IRandPPolicy.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IRandPPolicy getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IRandPPolicy)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("CEC4BAFB") ,com.kingdee.eas.farm.carnivorous.basedata.IRandPPolicy.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IRandPPolicy getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IRandPPolicy)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("CEC4BAFB"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IRandPPolicy getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IRandPPolicy)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("CEC4BAFB"));
    }
}
package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class RandPPolicyTreeFactory
{
    private RandPPolicyTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IRandPPolicyTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IRandPPolicyTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("17D0AD39") ,com.kingdee.eas.farm.carnivorous.basedata.IRandPPolicyTree.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IRandPPolicyTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IRandPPolicyTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("17D0AD39") ,com.kingdee.eas.farm.carnivorous.basedata.IRandPPolicyTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IRandPPolicyTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IRandPPolicyTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("17D0AD39"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IRandPPolicyTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IRandPPolicyTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("17D0AD39"));
    }
}
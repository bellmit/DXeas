package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ConFeedPolicyTreeFactory
{
    private ConFeedPolicyTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IConFeedPolicyTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IConFeedPolicyTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8AEE20EE") ,com.kingdee.eas.farm.carnivorous.basedata.IConFeedPolicyTree.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IConFeedPolicyTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IConFeedPolicyTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8AEE20EE") ,com.kingdee.eas.farm.carnivorous.basedata.IConFeedPolicyTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IConFeedPolicyTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IConFeedPolicyTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8AEE20EE"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IConFeedPolicyTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IConFeedPolicyTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8AEE20EE"));
    }
}
package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SubsidyPolicyTreeFactory
{
    private SubsidyPolicyTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ISubsidyPolicyTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISubsidyPolicyTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("45C7C899") ,com.kingdee.eas.farm.carnivorous.basedata.ISubsidyPolicyTree.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.ISubsidyPolicyTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISubsidyPolicyTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("45C7C899") ,com.kingdee.eas.farm.carnivorous.basedata.ISubsidyPolicyTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ISubsidyPolicyTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISubsidyPolicyTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("45C7C899"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ISubsidyPolicyTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISubsidyPolicyTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("45C7C899"));
    }
}
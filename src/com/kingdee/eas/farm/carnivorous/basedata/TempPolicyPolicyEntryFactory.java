package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TempPolicyPolicyEntryFactory
{
    private TempPolicyPolicyEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ITempPolicyPolicyEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ITempPolicyPolicyEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A36A57F8") ,com.kingdee.eas.farm.carnivorous.basedata.ITempPolicyPolicyEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.ITempPolicyPolicyEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ITempPolicyPolicyEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A36A57F8") ,com.kingdee.eas.farm.carnivorous.basedata.ITempPolicyPolicyEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ITempPolicyPolicyEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ITempPolicyPolicyEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A36A57F8"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ITempPolicyPolicyEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ITempPolicyPolicyEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A36A57F8"));
    }
}
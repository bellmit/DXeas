package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SettlePolicyTreeFactory
{
    private SettlePolicyTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicyTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicyTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E63B3D3D") ,com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicyTree.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicyTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicyTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E63B3D3D") ,com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicyTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicyTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicyTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E63B3D3D"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicyTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicyTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E63B3D3D"));
    }
}
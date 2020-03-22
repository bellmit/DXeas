package com.kingdee.eas.custom.eas2temp;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BillDeafultSettingTreeFactory
{
    private BillDeafultSettingTreeFactory()
    {
    }
    public static com.kingdee.eas.custom.eas2temp.IBillDeafultSettingTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IBillDeafultSettingTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("34CFA232") ,com.kingdee.eas.custom.eas2temp.IBillDeafultSettingTree.class);
    }
    
    public static com.kingdee.eas.custom.eas2temp.IBillDeafultSettingTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IBillDeafultSettingTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("34CFA232") ,com.kingdee.eas.custom.eas2temp.IBillDeafultSettingTree.class, objectCtx);
    }
    public static com.kingdee.eas.custom.eas2temp.IBillDeafultSettingTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IBillDeafultSettingTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("34CFA232"));
    }
    public static com.kingdee.eas.custom.eas2temp.IBillDeafultSettingTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IBillDeafultSettingTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("34CFA232"));
    }
}
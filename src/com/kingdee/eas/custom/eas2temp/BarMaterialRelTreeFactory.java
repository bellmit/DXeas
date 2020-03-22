package com.kingdee.eas.custom.eas2temp;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BarMaterialRelTreeFactory
{
    private BarMaterialRelTreeFactory()
    {
    }
    public static com.kingdee.eas.custom.eas2temp.IBarMaterialRelTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IBarMaterialRelTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E8F4CCF1") ,com.kingdee.eas.custom.eas2temp.IBarMaterialRelTree.class);
    }
    
    public static com.kingdee.eas.custom.eas2temp.IBarMaterialRelTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IBarMaterialRelTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E8F4CCF1") ,com.kingdee.eas.custom.eas2temp.IBarMaterialRelTree.class, objectCtx);
    }
    public static com.kingdee.eas.custom.eas2temp.IBarMaterialRelTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IBarMaterialRelTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E8F4CCF1"));
    }
    public static com.kingdee.eas.custom.eas2temp.IBarMaterialRelTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IBarMaterialRelTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E8F4CCF1"));
    }
}
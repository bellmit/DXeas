package com.kingdee.eas.custom.eas2temp;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BarMaterialRelFactory
{
    private BarMaterialRelFactory()
    {
    }
    public static com.kingdee.eas.custom.eas2temp.IBarMaterialRel getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IBarMaterialRel)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F69D76B3") ,com.kingdee.eas.custom.eas2temp.IBarMaterialRel.class);
    }
    
    public static com.kingdee.eas.custom.eas2temp.IBarMaterialRel getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IBarMaterialRel)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F69D76B3") ,com.kingdee.eas.custom.eas2temp.IBarMaterialRel.class, objectCtx);
    }
    public static com.kingdee.eas.custom.eas2temp.IBarMaterialRel getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IBarMaterialRel)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F69D76B3"));
    }
    public static com.kingdee.eas.custom.eas2temp.IBarMaterialRel getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IBarMaterialRel)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F69D76B3"));
    }
}
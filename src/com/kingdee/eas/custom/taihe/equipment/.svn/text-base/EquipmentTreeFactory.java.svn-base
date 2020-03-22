package com.kingdee.eas.custom.taihe.equipment;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EquipmentTreeFactory
{
    private EquipmentTreeFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.equipment.IEquipmentTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.equipment.IEquipmentTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("CD947CF2") ,com.kingdee.eas.custom.taihe.equipment.IEquipmentTree.class);
    }
    
    public static com.kingdee.eas.custom.taihe.equipment.IEquipmentTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.equipment.IEquipmentTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("CD947CF2") ,com.kingdee.eas.custom.taihe.equipment.IEquipmentTree.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.equipment.IEquipmentTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.equipment.IEquipmentTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("CD947CF2"));
    }
    public static com.kingdee.eas.custom.taihe.equipment.IEquipmentTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.equipment.IEquipmentTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("CD947CF2"));
    }
}
package com.kingdee.eas.custom.taihe.equipment;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EquipmentFactory
{
    private EquipmentFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.equipment.IEquipment getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.equipment.IEquipment)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("70CF4F34") ,com.kingdee.eas.custom.taihe.equipment.IEquipment.class);
    }
    
    public static com.kingdee.eas.custom.taihe.equipment.IEquipment getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.equipment.IEquipment)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("70CF4F34") ,com.kingdee.eas.custom.taihe.equipment.IEquipment.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.equipment.IEquipment getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.equipment.IEquipment)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("70CF4F34"));
    }
    public static com.kingdee.eas.custom.taihe.equipment.IEquipment getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.equipment.IEquipment)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("70CF4F34"));
    }
}
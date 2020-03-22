package com.kingdee.eas.custom.taihe.workshopmanager;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WorkshopDeafultSettingFactory
{
    private WorkshopDeafultSettingFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.workshopmanager.IWorkshopDeafultSetting getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.workshopmanager.IWorkshopDeafultSetting)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F00325C2") ,com.kingdee.eas.custom.taihe.workshopmanager.IWorkshopDeafultSetting.class);
    }
    
    public static com.kingdee.eas.custom.taihe.workshopmanager.IWorkshopDeafultSetting getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.workshopmanager.IWorkshopDeafultSetting)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F00325C2") ,com.kingdee.eas.custom.taihe.workshopmanager.IWorkshopDeafultSetting.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.workshopmanager.IWorkshopDeafultSetting getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.workshopmanager.IWorkshopDeafultSetting)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F00325C2"));
    }
    public static com.kingdee.eas.custom.taihe.workshopmanager.IWorkshopDeafultSetting getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.workshopmanager.IWorkshopDeafultSetting)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F00325C2"));
    }
}
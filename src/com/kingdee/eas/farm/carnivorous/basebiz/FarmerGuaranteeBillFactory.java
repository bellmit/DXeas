package com.kingdee.eas.farm.carnivorous.basebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FarmerGuaranteeBillFactory
{
    private FarmerGuaranteeBillFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basebiz.IFarmerGuaranteeBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IFarmerGuaranteeBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("5B16D615") ,com.kingdee.eas.farm.carnivorous.basebiz.IFarmerGuaranteeBill.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basebiz.IFarmerGuaranteeBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IFarmerGuaranteeBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("5B16D615") ,com.kingdee.eas.farm.carnivorous.basebiz.IFarmerGuaranteeBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basebiz.IFarmerGuaranteeBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IFarmerGuaranteeBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("5B16D615"));
    }
    public static com.kingdee.eas.farm.carnivorous.basebiz.IFarmerGuaranteeBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IFarmerGuaranteeBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("5B16D615"));
    }
}
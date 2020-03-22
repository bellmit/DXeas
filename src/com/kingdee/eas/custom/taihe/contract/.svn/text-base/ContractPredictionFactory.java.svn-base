package com.kingdee.eas.custom.taihe.contract;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ContractPredictionFactory
{
    private ContractPredictionFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.contract.IContractPrediction getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.contract.IContractPrediction)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("47221F5D") ,com.kingdee.eas.custom.taihe.contract.IContractPrediction.class);
    }
    
    public static com.kingdee.eas.custom.taihe.contract.IContractPrediction getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.contract.IContractPrediction)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("47221F5D") ,com.kingdee.eas.custom.taihe.contract.IContractPrediction.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.contract.IContractPrediction getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.contract.IContractPrediction)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("47221F5D"));
    }
    public static com.kingdee.eas.custom.taihe.contract.IContractPrediction getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.contract.IContractPrediction)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("47221F5D"));
    }
}
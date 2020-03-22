package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IBreedSeedReceiveBill extends ICoreBillBase
{
    public BreedSeedReceiveBillCollection getBreedSeedReceiveBillCollection() throws BOSException;
    public BreedSeedReceiveBillCollection getBreedSeedReceiveBillCollection(EntityViewInfo view) throws BOSException;
    public BreedSeedReceiveBillCollection getBreedSeedReceiveBillCollection(String oql) throws BOSException;
    public BreedSeedReceiveBillInfo getBreedSeedReceiveBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BreedSeedReceiveBillInfo getBreedSeedReceiveBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BreedSeedReceiveBillInfo getBreedSeedReceiveBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(BreedSeedReceiveBillInfo model) throws BOSException, EASBizException;
    public void unAudit(BreedSeedReceiveBillInfo model) throws BOSException, EASBizException;
    public void chkVoucherFlag(BreedSeedReceiveBillInfo model) throws BOSException;
    public void chkVoucherAll(BreedSeedReceiveBillInfo model) throws BOSException;
    public void close(BreedSeedReceiveBillInfo model) throws BOSException, EASBizException;
    public void unClose(BreedSeedReceiveBillInfo model) throws BOSException, EASBizException;
}
package com.kingdee.eas.farm.stocking.processbizill;

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

public interface IBreedContract extends ICoreBillBase
{
    public BreedContractCollection getBreedContractCollection() throws BOSException;
    public BreedContractCollection getBreedContractCollection(EntityViewInfo view) throws BOSException;
    public BreedContractCollection getBreedContractCollection(String oql) throws BOSException;
    public BreedContractInfo getBreedContractInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BreedContractInfo getBreedContractInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BreedContractInfo getBreedContractInfo(String oql) throws BOSException, EASBizException;
    public void audit(BreedContractInfo model) throws BOSException;
    public void unAudit(BreedContractInfo model) throws BOSException;
}
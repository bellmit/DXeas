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

public interface IBatchContract extends ICoreBillBase
{
    public BatchContractCollection getBatchContractCollection() throws BOSException;
    public BatchContractCollection getBatchContractCollection(EntityViewInfo view) throws BOSException;
    public BatchContractCollection getBatchContractCollection(String oql) throws BOSException;
    public BatchContractInfo getBatchContractInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BatchContractInfo getBatchContractInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BatchContractInfo getBatchContractInfo(String oql) throws BOSException, EASBizException;
    public void audit(BatchContractInfo model) throws BOSException, EASBizException;
    public void unAudit(BatchContractInfo model) throws BOSException, EASBizException;
    public void isTemplate(BatchContractInfo model) throws BOSException;
    public void isInit(BatchContractInfo model) throws BOSException;
}
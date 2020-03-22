package com.kingdee.eas.custom.taihe.contract;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlBillBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IBatchContract extends IWlhlBillBase
{
    public BatchContractCollection getBatchContractCollection() throws BOSException;
    public BatchContractCollection getBatchContractCollection(EntityViewInfo view) throws BOSException;
    public BatchContractCollection getBatchContractCollection(String oql) throws BOSException;
    public BatchContractInfo getBatchContractInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BatchContractInfo getBatchContractInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BatchContractInfo getBatchContractInfo(String oql) throws BOSException, EASBizException;
    public void distribution(BatchContractInfo model) throws BOSException;
    public void close(BatchContractInfo model) throws BOSException;
    public void backClose(BatchContractInfo model) throws BOSException;
    public void allAudit(BatchContractInfo model) throws BOSException;
}
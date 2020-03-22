package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IBatchContractEntry extends ICoreBillEntryBase
{
    public BatchContractEntryInfo getBatchContractEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BatchContractEntryInfo getBatchContractEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BatchContractEntryInfo getBatchContractEntryInfo(String oql) throws BOSException, EASBizException;
    public BatchContractEntryCollection getBatchContractEntryCollection() throws BOSException;
    public BatchContractEntryCollection getBatchContractEntryCollection(EntityViewInfo view) throws BOSException;
    public BatchContractEntryCollection getBatchContractEntryCollection(String oql) throws BOSException;
}
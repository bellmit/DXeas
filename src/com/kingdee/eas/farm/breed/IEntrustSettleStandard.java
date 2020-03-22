package com.kingdee.eas.farm.breed;

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
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IEntrustSettleStandard extends IDataBase
{
    public EntrustSettleStandardInfo getEntrustSettleStandardInfo(IObjectPK pk) throws BOSException, EASBizException;
    public EntrustSettleStandardInfo getEntrustSettleStandardInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public EntrustSettleStandardInfo getEntrustSettleStandardInfo(String oql) throws BOSException, EASBizException;
    public EntrustSettleStandardCollection getEntrustSettleStandardCollection() throws BOSException;
    public EntrustSettleStandardCollection getEntrustSettleStandardCollection(EntityViewInfo view) throws BOSException;
    public EntrustSettleStandardCollection getEntrustSettleStandardCollection(String oql) throws BOSException;
}
package com.kingdee.eas.farm.stocking.basedata;

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

public interface ISettleStandard extends IDataBase
{
    public SettleStandardInfo getSettleStandardInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SettleStandardInfo getSettleStandardInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SettleStandardInfo getSettleStandardInfo(String oql) throws BOSException, EASBizException;
    public SettleStandardCollection getSettleStandardCollection() throws BOSException;
    public SettleStandardCollection getSettleStandardCollection(EntityViewInfo view) throws BOSException;
    public SettleStandardCollection getSettleStandardCollection(String oql) throws BOSException;
    public void audit(SettleStandardInfo model) throws BOSException, EASBizException;
    public void unAudit(SettleStandardInfo model) throws BOSException, EASBizException;
}
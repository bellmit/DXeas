package com.kingdee.eas.farm.carnivorous.basedata;

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

public interface IFreightCalPoint extends IDataBase
{
    public FreightCalPointInfo getFreightCalPointInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FreightCalPointInfo getFreightCalPointInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FreightCalPointInfo getFreightCalPointInfo(String oql) throws BOSException, EASBizException;
    public FreightCalPointCollection getFreightCalPointCollection() throws BOSException;
    public FreightCalPointCollection getFreightCalPointCollection(EntityViewInfo view) throws BOSException;
    public FreightCalPointCollection getFreightCalPointCollection(String oql) throws BOSException;
    public void audit(FreightCalPointInfo model) throws BOSException, EASBizException;
    public void unAudit(FreightCalPointInfo model) throws BOSException, EASBizException;
}
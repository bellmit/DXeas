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

public interface IFreightBase extends IDataBase
{
    public FreightBaseInfo getFreightBaseInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FreightBaseInfo getFreightBaseInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FreightBaseInfo getFreightBaseInfo(String oql) throws BOSException, EASBizException;
    public FreightBaseCollection getFreightBaseCollection() throws BOSException;
    public FreightBaseCollection getFreightBaseCollection(EntityViewInfo view) throws BOSException;
    public FreightBaseCollection getFreightBaseCollection(String oql) throws BOSException;
    public void audit(FreightBaseInfo model) throws BOSException, EASBizException;
    public void unAudit(FreightBaseInfo model) throws BOSException, EASBizException;
}
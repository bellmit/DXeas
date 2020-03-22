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

public interface IVet extends IDataBase
{
    public VetInfo getVetInfo(IObjectPK pk) throws BOSException, EASBizException;
    public VetInfo getVetInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public VetInfo getVetInfo(String oql) throws BOSException, EASBizException;
    public VetCollection getVetCollection() throws BOSException;
    public VetCollection getVetCollection(EntityViewInfo view) throws BOSException;
    public VetCollection getVetCollection(String oql) throws BOSException;
    public void audit(VetInfo model) throws BOSException, EASBizException;
    public void unAudit(VetInfo model) throws BOSException, EASBizException;
}
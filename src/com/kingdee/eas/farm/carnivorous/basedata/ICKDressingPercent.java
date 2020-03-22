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

public interface ICKDressingPercent extends IDataBase
{
    public CKDressingPercentInfo getCKDressingPercentInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CKDressingPercentInfo getCKDressingPercentInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CKDressingPercentInfo getCKDressingPercentInfo(String oql) throws BOSException, EASBizException;
    public CKDressingPercentCollection getCKDressingPercentCollection() throws BOSException;
    public CKDressingPercentCollection getCKDressingPercentCollection(EntityViewInfo view) throws BOSException;
    public CKDressingPercentCollection getCKDressingPercentCollection(String oql) throws BOSException;
    public void audit(CKDressingPercentInfo model) throws BOSException, EASBizException;
    public void unAudit(CKDressingPercentInfo model) throws BOSException, EASBizException;
}
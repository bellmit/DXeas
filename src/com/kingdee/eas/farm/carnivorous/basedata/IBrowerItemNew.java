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

public interface IBrowerItemNew extends IDataBase
{
    public BrowerItemNewInfo getBrowerItemNewInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BrowerItemNewInfo getBrowerItemNewInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BrowerItemNewInfo getBrowerItemNewInfo(String oql) throws BOSException, EASBizException;
    public BrowerItemNewCollection getBrowerItemNewCollection() throws BOSException;
    public BrowerItemNewCollection getBrowerItemNewCollection(EntityViewInfo view) throws BOSException;
    public BrowerItemNewCollection getBrowerItemNewCollection(String oql) throws BOSException;
    public void audit(BrowerItemNewInfo model) throws BOSException, EASBizException;
    public void unAudit(BrowerItemNewInfo model) throws BOSException, EASBizException;
}
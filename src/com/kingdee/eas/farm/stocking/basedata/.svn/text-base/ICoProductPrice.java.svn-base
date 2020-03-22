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

public interface ICoProductPrice extends IDataBase
{
    public CoProductPriceInfo getCoProductPriceInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CoProductPriceInfo getCoProductPriceInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CoProductPriceInfo getCoProductPriceInfo(String oql) throws BOSException, EASBizException;
    public CoProductPriceCollection getCoProductPriceCollection() throws BOSException;
    public CoProductPriceCollection getCoProductPriceCollection(EntityViewInfo view) throws BOSException;
    public CoProductPriceCollection getCoProductPriceCollection(String oql) throws BOSException;
    public void audit(CoProductPriceInfo model) throws BOSException, EASBizException;
    public void unAudit(CoProductPriceInfo model) throws BOSException, EASBizException;
}
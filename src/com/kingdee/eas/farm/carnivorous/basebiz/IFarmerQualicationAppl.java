package com.kingdee.eas.farm.carnivorous.basebiz;

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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IFarmerQualicationAppl extends ICoreBillBase
{
    public FarmerQualicationApplCollection getFarmerQualicationApplCollection() throws BOSException;
    public FarmerQualicationApplCollection getFarmerQualicationApplCollection(EntityViewInfo view) throws BOSException;
    public FarmerQualicationApplCollection getFarmerQualicationApplCollection(String oql) throws BOSException;
    public FarmerQualicationApplInfo getFarmerQualicationApplInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FarmerQualicationApplInfo getFarmerQualicationApplInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FarmerQualicationApplInfo getFarmerQualicationApplInfo(String oql) throws BOSException, EASBizException;
    public void audit(FarmerQualicationApplInfo model) throws BOSException, EASBizException;
    public void unAudit(FarmerQualicationApplInfo model) throws BOSException, EASBizException;
    public void isTemplate(FarmerQualicationApplInfo model) throws BOSException;
    public void isCheckItemEntry(FarmerQualicationApplInfo model) throws BOSException;
    public void viewGuaranteeBill(FarmerQualicationApplInfo model) throws BOSException, EASBizException;
}
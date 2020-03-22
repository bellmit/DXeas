package com.kingdee.eas.farm.feemanager.basebizbill;

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

public interface ITransportationrecord extends ICoreBillBase
{
    public TransportationrecordCollection getTransportationrecordCollection() throws BOSException;
    public TransportationrecordCollection getTransportationrecordCollection(EntityViewInfo view) throws BOSException;
    public TransportationrecordCollection getTransportationrecordCollection(String oql) throws BOSException;
    public TransportationrecordInfo getTransportationrecordInfo(IObjectPK pk) throws BOSException, EASBizException;
    public TransportationrecordInfo getTransportationrecordInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public TransportationrecordInfo getTransportationrecordInfo(String oql) throws BOSException, EASBizException;
    public void audit(TransportationrecordInfo model) throws BOSException, EASBizException;
    public void auditback(TransportationrecordInfo model) throws BOSException, EASBizException;
    public void sendend(TransportationrecordInfo model) throws BOSException, EASBizException;
    public void calfright(TransportationrecordInfo model) throws BOSException, EASBizException;
    public void updateMileage(TransportationrecordInfo model) throws BOSException;
    public void appointPerson(TransportationrecordInfo model) throws BOSException;
    public void viewUpdateMileage(TransportationrecordInfo model) throws BOSException;
}
package com.kingdee.eas.custom.eas2temp;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ITreeBase;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IBillDeafultSettingTree extends ITreeBase
{
    public BillDeafultSettingTreeInfo getBillDeafultSettingTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BillDeafultSettingTreeInfo getBillDeafultSettingTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BillDeafultSettingTreeInfo getBillDeafultSettingTreeInfo(String oql) throws BOSException, EASBizException;
    public BillDeafultSettingTreeCollection getBillDeafultSettingTreeCollection() throws BOSException;
    public BillDeafultSettingTreeCollection getBillDeafultSettingTreeCollection(EntityViewInfo view) throws BOSException;
    public BillDeafultSettingTreeCollection getBillDeafultSettingTreeCollection(String oql) throws BOSException;
}
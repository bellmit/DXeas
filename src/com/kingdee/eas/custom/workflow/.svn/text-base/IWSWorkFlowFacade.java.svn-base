package com.kingdee.eas.custom.workflow;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public interface IWSWorkFlowFacade extends IBizCtrl
{
    public String getMessageList(String userNumber) throws BOSException;
    public String quickApprove(String assignIds, String ifpass, String opinion, String policy, String userNumber) throws BOSException;
    public String getApproveHistory(String billId) throws BOSException;
    public String getMessageDetailList(String userNumber) throws BOSException;
    public void updateMesStatusById(String messageId) throws BOSException;
    public String getUserInfoByXtId(String xtId) throws BOSException;
    public String getFNumberByPhone(String phone) throws BOSException, EASBizException;
    public String submitApprove(String jsonStr) throws BOSException;
}
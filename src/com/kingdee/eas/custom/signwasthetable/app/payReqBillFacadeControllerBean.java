package com.kingdee.eas.custom.signwasthetable.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import com.kingdee.eas.base.permission.UserInfo;
import java.lang.String;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.kingdee.eas.common.EASBizException;

public class payReqBillFacadeControllerBean extends AbstractpayReqBillFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.signwasthetable.app.payReqBillFacadeControllerBean");

    protected Date _setPayReqBillCloseStatus(Context ctx, String payRequestBillID, boolean closeStatus, IObjectValue closeUser, Date closeDate)throws BOSException, EASBizException
    {
    	
    	UserInfo userInfo = (UserInfo) closeUser;
    	int boolValue=0;
		if(closeStatus)
			boolValue=1;
		else
			boolValue=0;
		String userID="";
		if(userInfo.getId()!=null)
			userID=userInfo.getId().toString();

		Date date=closeDate;
		if(closeDate==null)
			date=new Date();
		
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=sdf.format(date);

		StringBuffer sb=new StringBuffer();
		sb.append("/*dialect*/update T_AP_PayRequestBill set");
		sb.append(" CFisClosed=").append(boolValue).append(",");//是否关闭
		if(closeStatus){
			sb.append(" CFClosePersonID='").append(userID).append("',");//设置关闭人
			sb.append(" CFUnClosePersonID=null,");//设置反关闭人
			sb.append(" CFCloseTime=to_date('"+time+"','yyyy-MM-dd:hh24:mi:ss')");//设置关闭时间
		}else{
			sb.append(" CFClosePersonID=null,");//设置关闭人
			sb.append(" CFUnClosePersonID='").append(userID).append("',");
			sb.append(" CFCloseTime=null");
		}
		sb.append(" where fid='"+payRequestBillID+"'");
		try {
			SQLExecutorFactory.getLocalInstance(ctx, sb.toString()).executeSQL();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return date;
    }

}
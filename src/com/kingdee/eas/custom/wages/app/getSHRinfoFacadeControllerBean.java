package com.kingdee.eas.custom.wages.app;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;
import com.kingdee.eas.base.permission.UserFactory;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.person.PersonCollection;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.applicationofsocialsecurity.DataBaseConnectionFactory;
import com.kingdee.eas.custom.applicationofsocialsecurity.DataBaseConnectionInfo;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.custom.wages.IWagesPersonInfo;
import com.kingdee.eas.custom.wages.WagesPersonInfo;
import com.kingdee.eas.custom.wages.WagesPersonInfoEntryCollection;
import com.kingdee.eas.custom.wages.WagesPersonInfoEntryInfo;
import com.kingdee.eas.custom.wages.WagesPersonInfoFactory;
import com.kingdee.eas.custom.wages.WagesPersonInfoInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.jdbc.rowset.IRowSet;


public class getSHRinfoFacadeControllerBean extends AbstractgetSHRinfoFacadeControllerBean
{
	private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.wages.app.getSHRinfoFacadeControllerBean");
	/* (non-Javadoc)
	 * @see com.kingdee.eas.custom.wages.app.AbstractgetSHRinfoFacadeControllerBean#_getPersonInfo(com.kingdee.bos.Context)
	 */
	/**
	 * 关联SHR数据库获取数据
	 */
	@Override
	protected void _getPersonInfo(Context ctx) throws BOSException {
		// TODO Auto-generated method stub
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			deleteSHRinfo(ctx);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			JSONArray result = getBankCarData(ctx);
			WagesPersonInfoInfo wperson = new WagesPersonInfoInfo();
			wperson.setBizDate(new Date());
			wperson.setNumber("SHRinfo-"+new Date().toString());
			wperson.setBillStatus(BillBaseStatusEnum.getEnum(4));
			wperson.setCreator(UserFactory.getLocalInstance(ctx).getUserInfo(new ObjectUuidPK("00000000-0000-0000-0000-00000000000213B7DE7F")));
			WagesPersonInfoEntryCollection wpersonEC = wperson.getEntrys();
			for(int i=0;i<result.size();i++){
				JSONObject resultObject = result.getJSONObject(i);
				WagesPersonInfoEntryInfo wpersonE = new WagesPersonInfoEntryInfo();
				//if(resultObject.)
				wpersonE.setBankcard(resultObject.getString("Bankid"));
				Date enterdate = null;
				try {
					enterdate = format.parse(resultObject.getString("EnterDate"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				wpersonE.setEnterdate(enterdate);
				wpersonE.setPersonid(resultObject.getString("FID"));
				wpersonE.setPersonnumber(resultObject.getString("number"));
				//String personid = getPersonID(ctx, resultObject.getString("number"));
				wpersonE.setPerson(resultObject.getString("name"));
//				if(StringUtils.isEmpty(personid)){
//					System.out.println("该员工没有系统账号："+resultObject.getString("name"));
//				}else{
//					wpersonE.setPerson(PersonFactory.getLocalInstance(ctx).getPersonInfo(new ObjectUuidPK(personid)));
//				}
				wpersonEC.add(wpersonE);
			}
			IObjectPK pk = null;
			IWagesPersonInfo iwp = WagesPersonInfoFactory.getLocalInstance(ctx);
			try {
				pk = iwp.save(wperson);
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 catch (EASBizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super._getPersonInfo(ctx);
	}
	//获取银行卡信息
	private JSONArray getBankCarData(Context ctx) throws BOSException, EASBizException, SQLException{
		//数据库连接配置
		String [] result=new String[2];
		
		Connection conn=null;
		//DataBaseConnectionInfo dataBaseConnectionInfo = DataBaseConnectionFactory.getLocalInstance(ctx).getDataBaseConnectionInfo("where billStatus=3");
		CoreBaseCollection coll = DataBaseConnectionFactory.getLocalInstance(ctx).getCollection("where billStatus=3");
		if(coll==null)
			commUtils.giveUserTipsAndRetire("没有启用的sHR数据库连接配置");
		DataBaseConnectionInfo dataBaseConnectionInfo = (DataBaseConnectionInfo) coll.get(0);
		String[] connStr=new String[5];
		connStr[0]=dataBaseConnectionInfo.getIP();
		connStr[1]=dataBaseConnectionInfo.getPort();
		connStr[2]=dataBaseConnectionInfo.getDataBaseName();
		connStr[3]=dataBaseConnectionInfo.getUserName();
		connStr[4]=dataBaseConnectionInfo.getPassword();

		conn = getDataBaseConnection(connStr);
		if(conn==null){
			result[0]="更新失败";
			result[1]="数据库连接失败";
		}
		JSONArray resultArray=getCard(conn);
		System.out.println("");
		
		
		return resultArray;
	}
	/**
	 * 连接外部数据库
	 * @param str
	 * @return
	 */
	public static Connection getDataBaseConnection(String [] str){
		Connection conn=null;
		if(str.length==5){
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
				String url = "jdbc:oracle:thin:@"+str[0]+":"+str[1]+":"+str[2]; // orcl为数据库的SID
				String user = str[3];
				String password = str[4];
				conn = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				//throw new BOSException("",e);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return conn;
		}
		return null;
	}
	//用户名获取用户id
	private void deleteSHRinfo(Context ctx) throws BOSException, SQLException{
		StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("select FID from ").append(sp);
		sql.append("CT_WAG_WagesPersonInfo").append(sp);
		IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sql.toString()).executeSQL();
		WagesPersonInfoInfo wperson = new WagesPersonInfoInfo();
		IWagesPersonInfo iwp = WagesPersonInfoFactory.getLocalInstance(ctx);
		//删除info
		try {
			while(rs.next())
				//wperson = WagesPersonInfoFactory.getLocalInstance(ctx).getWagesPersonInfoInfo(new ObjectUuidPK(rs.getString("FID")));
				iwp.delete(new ObjectUuidPK(rs.getString("FID")));
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String personID = null ;
		while(rs.next()){
			personID = rs.getString("FID");
		}
	}
	private JSONArray getCard(Connection conn) {
		// TODO Auto-generated method stub
		Statement state = null;
		ResultSet rs = null ;
		JSONArray  resultArray = new JSONArray();
		JSONObject resultObject = null;
		StringBuffer sb=new StringBuffer();
		ArrayList<String> arrayList=new ArrayList<String>();
		String sp = "\n";
		sb.append("/*dialect*/").append(sp);
		sb.append("SELECT t1.FNumber FNumber,t1.FName_l2 FName_l2,t2.FEnterDate EnterDate,t1.FID FID,nvl(t1.CFBankCardBC,0) Bankid").append(sp);
		//sb.append("SELECT t1.*").append(sp);
		sb.append("FROM   T_BD_PERSON t1 ").append(sp);
		sb.append("inner join T_HR_PersonPosition t2  on t2.fpersonid=t1.fid ").append(sp);
		sb.append("inner join T_ORG_Admin   t3  on t2.fpersondep=t3.fid ").append(sp);
		//sb.append("inner join T_HR_BDEmployeeType         t15  on t15.fid=t1.FEmployeeTypeID").append(sp);
		//sb.append("where t15.FName_l2 !='离职'");
		System.out.println("SHR信息查询"+sb.toString());
		try {
			state = conn.createStatement();
			rs = state.executeQuery(sb.toString());
			while(rs.next()){
				resultObject = new JSONObject();
				//resultObject.put("number", "111111111111");
				resultObject.put("number", rs.getString("FNumber"));
				resultObject.put("name", rs.getString("FName_l2"));
				resultObject.put("EnterDate", rs.getString("EnterDate"));
				resultObject.put("Bankid", rs.getString("Bankid"));
				resultObject.put("FID", rs.getString("FID"));
				resultArray.add(resultObject);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(state!=null)
					state.close();
				//return rs;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultArray;
	}
}
package com.kingdee.eas.custom.shr.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import javax.sql.RowSet;
import java.sql.ResultSet;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.bi.model.DB.DBUtil;
import com.kingdee.bos.ctrl.common.CtrlUtil.Collection;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.util.client.MsgBox;

import com.kingdee.jdbc.rowset.IRowSet;
import java.lang.String;

public class shrBaseDataQueryFacadeControllerBean extends AbstractshrBaseDataQueryFacadeControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.shr.app.shrBaseDataQueryFacadeControllerBean");

	//数据库的连接信息的定义
	String dbIP;
	int dbPort;
	String dbName;
	String userName;
	String userPassword ;
	//jdbc执行的Connection，PraparedStatement、ResultSet定义
	Connection conn=null;
	PreparedStatement pre=null;
	java.sql.ResultSet rs=null;

	/** override
	 * @operation 更新车次和站点的操作
	 * return 没有返回值
	 * @status 0
	 */
	@Override
	protected void _excuteBusAndStop(Context ctx, String excuteStr) throws BOSException {
		// TODO Auto-generated method stub
		//初始化连接
		dataBaseOperation connectshr = new dataBaseOperation();
		connectshr.initParamToConnection();
		try {
			//执行 修改操作
			conn=connectshr.getWinCosConnection(dbIP, dbPort, dbName, userName, userPassword);
			pre=conn.prepareStatement(excuteStr);
			pre.execute();			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			connectshr.closeConnection();
		}
	}	
	public class dataBaseOperation
	{
		/**
		 *设置数据库的默认IP/端口/数据库名/用户名/密码
		 */
		protected void initParamToConnection() {

			dbIP="192.168.10.201";
			dbPort=1521;
			dbName="bqlnm";
			userName="testshr0817";
			userPassword="testshr0817";
			//			dbIP = "192.168.10.2";
			//			dbPort = 1521;
			//			dbName = "orcl";
			//			userName = "kingdeeshr";
			//			userPassword = "kingdeeshr";
		}
		/**
		 * wincos 中间库连接信息
		 * @param dbIP 数据库IP
		 * @param dbPort 数据库端口
		 * @param dbName 数据库名
		 * @param userName 用户名
		 * @param userPassword 密码
		 * @return 返回一个连接 Connection
		 * @throws Exception
		 */
		public  Connection getWinCosConnection(String dbIP,Number dbPort,String dbName,String userName,String userPassword) throws Exception 
		{
			//根据用户填写的信息获得数据库的IP/端口/数据库名称/用户名/用户密码
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:" + "thin:@"+dbIP+":"+dbPort+":"+dbName;//连接的url
			Connection conn=DriverManager.getConnection(url, userName, userPassword);//获得连接
			return conn;
		}
		/**
		 * 
		 *@operation 关闭连接connection
		 *@param
		 * @return 
		 *@return
		 *@throws Exception
		 *@status 1
		 */
		public void closeConnection()
		{
			if(conn!=null)
			{
				try {
					conn.close();
					conn=null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
		}
	}

	/** override
	 * @operation 获得车次的列表信息
	 *
	 * @status 0
	 */
	@Override
	protected ArrayList<String> _queryForBusList(Context ctx, String queryStr) throws BOSException {
		// TODO Auto-generated method stub
		//初始化连接信息
		ArrayList<String> busList=new ArrayList<String>();
		dataBaseOperation connectshr = new dataBaseOperation();
		connectshr.initParamToConnection();
		try {
			//连接
			conn=connectshr.getWinCosConnection(dbIP, dbPort, dbName, userName, userPassword);
			pre=conn.prepareStatement(queryStr);
			rs=pre.executeQuery();
			//循环取出车的名称
			while(rs.next())
				busList.add(rs.getString("fname_l2"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			connectshr.closeConnection();
		}
		return  busList;
	}
	/** override
	 * @operation 查询站点的列表
	 *
	 * @status 0
	 */
	@Override
	protected ArrayList<String> _queryForStopList(Context ctx, String sqlStopList) throws BOSException {
		// TODO Auto-generated method stub
		//定义一个List接收  结果
		ArrayList<String> stopList=new ArrayList<String>();
		//初始化连接信息
		dataBaseOperation connectshr = new dataBaseOperation();
		connectshr.initParamToConnection();
		try {
			//查询
			conn=connectshr.getWinCosConnection(dbIP, dbPort, dbName, userName, userPassword);
			pre=conn.prepareStatement(sqlStopList);
			rs=pre.executeQuery();
			//循环加入到列表
			while(rs.next())
				stopList.add(rs.getString("fname_l2"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			connectshr.closeConnection();
		}
		return  stopList;
	}
	/** override
	 * @operation 查询人员的相关信息
	 *
	 * @status 0
	 */
	@Override
	protected ArrayList<ArrayList<String>> _queryForEmpInfo(Context ctx, String sqlPerson) throws BOSException {
		// TODO Auto-generated method stub


		ArrayList<ArrayList<String>> empList=new ArrayList<ArrayList<String>>();	


		//定义了一些list，存放查询的人员的相关信息
		ArrayList<String> busList=new ArrayList<String>();//车次
		ArrayList<String> stopList=new ArrayList<String>();//站点
		ArrayList<String> nameList=new ArrayList<String>();//姓名
		ArrayList<String> numberList=new ArrayList<String>();//编码
		ArrayList<String> classList=new ArrayList<String>();//班组
		ArrayList<String> enterDateList=new ArrayList<String>();//入职日期
		ArrayList<String> IDCardNumList=new ArrayList<String>();//身份证号码

		dataBaseOperation connectshr = new dataBaseOperation();//初始化连接信息

		//加入到返回的List中
		empList.add(numberList);
		empList.add(nameList);
		empList.add(enterDateList);
		empList.add(IDCardNumList);
		empList.add(busList);
		empList.add(stopList);		
		empList.add(classList);


		connectshr.initParamToConnection();
		try {
			//连接
			conn=connectshr.getWinCosConnection(dbIP, dbPort, dbName, userName, userPassword);
			pre=conn.prepareStatement(sqlPerson);
			rs=pre.executeQuery();
			while(rs.next())
			{
				//收集信息
				nameList.add(rs.getString("fname_l2"));
				numberList.add(rs.getString("fnumber"));
				stopList.add(rs.getString("stop"));
				busList.add(rs.getString("bus"));
				enterDateList.add(rs.getString("enterDate"));
				IDCardNumList.add(rs.getString("IDCardNum"));
				classList.add(rs.getString("class"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			connectshr.closeConnection();
		}
		return  empList;
	}

	/** override
	 * @return 
	 * @operation
	 *
	 * @status 0
	 */
	@Override
	protected  String _queryForOtherPerson(Context ctx,String str) throws BOSException {
		// TODO Auto-generated method stub
		IRowSet RSet = DbUtil.executeQuery(ctx, str);
		try {
			if(RSet.next())
				return RSet.getString("fid");				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}
//package com.kingdee.eas.farm.carnivorous.recyclebiz.app;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStreamWriter;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.HashMap;
//
//import net.sf.json.JSONObject;
//
//import org.apache.commons.lang.StringUtils;
//import org.apache.log4j.Logger;
//
//import com.jcraft.jsch.ChannelSftp;
//import com.jcraft.jsch.JSchException;
//import com.jcraft.jsch.SftpException;
//import com.kingdee.bos.BOSException;
//import com.kingdee.bos.Context;
//import com.kingdee.eas.custom.commld.ExceptionUtils;
//import com.kingdee.eas.custom.commld.jdbcUntils;
//import com.kingdee.eas.custom.commld.Person.IdcardValidator;
//import com.kingdee.eas.custom.commld.fileUtils.EncryptUtil;
//import com.kingdee.eas.farm.carnivorous.basedata.BatchInfo;
//import com.kingdee.eas.util.app.DbUtil;
//import com.longyg.sftp.SFTPChannel;
//import com.longyg.sftp.SFTPConstants;
//
//public class FarmerDataExpFacadeControllerBean extends AbstractFarmerDataExpFacadeControllerBean
//{
//	private static Logger logger =
//		Logger.getLogger("com.kingdee.eas.farm.carnivorous.recyclebiz.app.FarmerDataExpFacadeControllerBean");
//
//	/**
//	 * 导出在养养殖户的数据到指定位置
//	 * 格式 ： Txt
//	 */
//	protected String _expFarmerDataToTxt(Context ctx, String param)throws BOSException
//	{
//		Connection conn = null;
//		Statement state = null;
//		File file = null ;
//		File fileOK = null ;
//		
//		
//		if(StringUtils.isEmpty(param)){
//			param = "{\"hah\":\"没参数啦\"}";
//		}
//		JSONObject resultJson = new JSONObject();
//		try{
//			//局部变量声明
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//			SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			Date newdate = new Date();
//			Calendar calendar = Calendar.getInstance();
//	        calendar.setTime(new Date());
//	        calendar.add(Calendar.DATE, -1);
//			newdate = calendar.getTime();
//			
//			/*try {
//				newdate=new SimpleDateFormat("yyyy-MM-dd").parse("2018-02-02");
//			} catch (Exception e) {
//				e.printStackTrace();
//			}*/
//			
//			String initName = "ods_out_ext_ncpt_qy_farm_dd_";
//			String fileName = initName + sdf.format(newdate);
//			//返回值
//			resultJson.put("result",true);
//			StringBuffer sb = new StringBuffer();
//
//
//
//			//获取数据前校验文件是否存在
//			//小于修改
//			if(checkFileIsExist("E:\\AntFinance\\"  + sdf.format(newdate)+"\\"+ fileName + ".txt")==2){
//			//if(checkFileIsExist("E:\\AntFinance\\" + fileName + ".txt")==2){
//				resultJson.put("result",false);
//				resultJson.put("reason","当前文件已存在");
//				return resultJson.toString();
//			//}else if (checkFileIsExist("E:\\AntFinance\\" + fileName + ".txt")==1) {
//				//小于修改
//				//创建业务日期文件夹
//			}else if (checkFileIsExist("E:\\AntFinance\\" + fileName + ".txt")==1) {
//				file = new File("E:\\AntFinance\\" + sdf.format(newdate));
//				file.mkdir();
//				file = new File(file.getPath()+"\\"+ fileName + ".txt");
//				file.createNewFile();
//
//				//file = new File("E:\\AntFinance\\" + fileName + ".txt");
//				//file.createNewFile();
//
//			}else{
//			//小于修改
//				file = new File("E:\\AntFinance\\"  + sdf.format(newdate)+"\\"+ fileName + ".txt");
//				fileOK = new File("E:\\AntFinance\\"  + sdf.format(newdate)+"\\"+ fileName + ".txt.ok");
//				//file = new File("E:\\AntFinance\\" + fileName + ".txt");
//				File parentFile = new File(file.getParent());
//				parentFile.mkdirs();
//				file.createNewFile();
//				fileOK.createNewFile();
//			}
//
//			conn = jdbcUntils.getDataBaseConnection(new String[]{"192.168.2.5","1521","orcl","qyjt","qyjt"});
//			if(conn == null){
//				resultJson.put("result",false);
//				resultJson.put("reason","数据库链接失败");
//				return resultJson.toString();
//			}
//
//			//获取数据
//			state = conn.createStatement();
//
//			//查询数据
//			queryData(ctx,sb,conn,state,sdfTime);
//			
//			//将结果输出并保存到指定位置
////			System.out.println(sb.toString());
//			exportTxtFileToFixedPosition(ctx,sb,file);
//			exportTxtFileToFixedPosition(ctx,sb,fileOK);
//			
////			if(true) {
////				return null;
////			}
//
//			//返回
//			resultJson.put("data",sb.toString());
//
//			JSONObject fromJson = JSONObject.fromObject(param);
//			String[] sftpConnInfo = new String[4];
//			if(fromJson.containsKey("conn")&&fromJson.get("conn")!=null){
//				sftpConnInfo = (String[]) fromJson.get("conn");
//			}else{
//				sftpConnInfo[0] = "dwsftp.alipay.com";
//				sftpConnInfo[1] = "SJSNSJLRQYYY0116";
//				sftpConnInfo[2] = "XHFNMMuAc3VXwsAQ";
//				sftpConnInfo[3] = "22";
//			}
//			String destPath ;
//			SimpleDateFormat sdf1 =new SimpleDateFormat("yyyyMMdd");
//			String simple = sdf1.format(new Date());
//			if(fromJson.containsKey("destPath")&&fromJson.get("destPath")!=null){
//				destPath = (String) fromJson.get("destPath");
//			}else
//				//对方文件夹地址
//				destPath = "/upload"+"/"+sdf.format(newdate);
//				String basePath = "/upload";
//				String basePath1 = sdf.format(newdate);
//				
//				//创建当日目录   每天执行一次  测试时注掉
//			transport(sftpConnInfo,basePath,"upload/"+basePath1);	
//			transportData(sftpConnInfo , file.getPath() , destPath);
//			//就绪文件 小于修改
//			transportData(sftpConnInfo , fileOK.getPath() , destPath);
//			return resultJson.toString();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			if(file != null && file.exists() && file.isFile())
//				file.delete();
//			resultJson.put("result",false);
//			resultJson.put("reason",ExceptionUtils.getExceptionStatement(e));
//			resultJson.put("location",ExceptionUtils.getExceptionLocationSimple(e));
//			return resultJson.toString();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			if(file != null && file.exists() && file.isFile())
//				file.delete();
//			resultJson.put("result",false);
//			resultJson.put("reason",ExceptionUtils.getExceptionStatement(e));
//			resultJson.put("location",ExceptionUtils.getExceptionLocationSimple(e));
//			return resultJson.toString();
//		}finally{
//			try {
//				if(state != null)
//					state.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//			try {
//				if(conn != null)
//					conn.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
//
//	/**
//	 * 用fstp导入对方指定电脑的路径下
//	 * @param sftpConnInfo
//	 * @param path
//	 * @param destPath
//	 */
//	private void transportData(String[] sftpConnInfo, String path,
//			String destPath) {
//		// TODO Auto-generated method stub
//		HashMap<String, String> sftpDetails = new HashMap<String, String>();
//		// 设置主机ip，端口，用户名，密码
//
//		sftpDetails.put(SFTPConstants.SFTP_REQ_HOST, sftpConnInfo[0]);
//		sftpDetails.put(SFTPConstants.SFTP_REQ_USERNAME, sftpConnInfo[1]);
//		sftpDetails.put(SFTPConstants.SFTP_REQ_PASSWORD, sftpConnInfo[2]);
//		sftpDetails.put(SFTPConstants.SFTP_REQ_PORT, sftpConnInfo[3]);
//
//		String src = path; // 本地文件名
//		String dst = destPath; // 目标文件名
//
//		SFTPChannel channel = new SFTPChannel();
//		try {
//			ChannelSftp chSftp = channel.getChannel(sftpDetails, 60000);
//			
//			chSftp.put(src, dst, ChannelSftp.OVERWRITE); // 代码段2
//
//			chSftp.quit();
//			channel.closeChannel();
//
//		} catch (JSchException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SftpException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//	/**
//	 * 创建每日文件夹 小于添加
//	 * @param sftpConnInfo
//	 * @param path
//	 * @param destPath
//	 */
//	private void transport(String[] sftpConnInfo, String basePath,String basePath1) {
//		// TODO Auto-generated method stub
//		HashMap<String, String> sftpDetails = new HashMap<String, String>();
//		// 设置主机ip，端口，用户名，密码
//
//		sftpDetails.put(SFTPConstants.SFTP_REQ_HOST, sftpConnInfo[0]);
//		sftpDetails.put(SFTPConstants.SFTP_REQ_USERNAME, sftpConnInfo[1]);
//		sftpDetails.put(SFTPConstants.SFTP_REQ_PASSWORD, sftpConnInfo[2]);
//		sftpDetails.put(SFTPConstants.SFTP_REQ_PORT, sftpConnInfo[3]);
//
//		
//
//		SFTPChannel channel = new SFTPChannel();
//		try {
//			ChannelSftp chSftp = channel.getChannel(sftpDetails, 60000);
//			//chSftp.cd(basePath);
//			chSftp.mkdir(basePath1);
//			//chSftp.put(src, dst, ChannelSftp.OVERWRITE); // 代码段2
//
//			chSftp.quit();
//			channel.closeChannel();
//
//		} catch (JSchException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SftpException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//
//	/**
//	 * 查询数据
//	 * @param ctx
//	 * @param sb 
//	 * @param conn
//	 * @param state
//	 * @param sdfTime 
//	 * @throws SQLException 
//	 */
//	private void queryData(Context ctx, StringBuffer sb, Connection conn, Statement state, SimpleDateFormat sdfTime) throws SQLException {
//		// TODO Auto-generated method stub
//		StringBuffer queryStr = new StringBuffer();
//		IdcardValidator idcardValidator;
//		String idCardNum = null;
//		queryStr.append("select t1.FCompanyID,t4.FName_l2 companyName,t2.FName_l2 fname,t2.FIdentity,max(t1.FInDate) FInDate,t2.FMobileTel,t5.FActualBreedDate FActualBreedDate,t2.FID farmerID").append("\n") 
////		.append("from T_FM_Batch                t1").append("\n")
//		.append(" from  (")
//		.append(" select a1.* from T_FM_Batch a1")
//		.append(" inner join (")
//		.append(" select FFarmerID,max(FInDate) FInDate from  T_FM_Batch")
//		.append(" group by FFarmerID")
//		.append(" ) tt on tt.FFarmerID=a1.FFarmerID and a1.FInDate=tt.FInDate")
//		.append(" ) t1 ")
//		.append(" inner join CT_FM_Farmer        t2 on t2.FID=t1.FFarmerID").append("\n")
//		.append(" inner join CT_FM_Farm          t3 on t3.FID=t1.FFarmID").append("\n")
//		.append(" inner join T_FM_BatchContractBill    t5 on t5.FID=t1.FBatchContractID").append("\n")
//		.append(" inner join T_ORG_Company       t4 on t4.FID=t1.FCompanyID").append("\n")
//		//增加只有存在结算单信息的过滤
////		.append(" where (t1.fid in (select FBatchID from T_FM_DkSettleBill)")
////		.append(" or upper(t2.FIdentity) in (select upper(b2.FZipCode) from T_SET_SettleBill b1 inner join T_ORG_Admin b2 on b2.FID=b1.FFarmerID)")
////		.append(" )")		
////		.append("where t1.FIsAllOut=0 and  t1.FAllOutDate is null  ").append("\n")// 测试书库and t2.FID='YSLamFVVTPiVCtITVes8M/oKf4U='
//		.append(" group by t1.FCompanyID,t2.FName_l2,t2.FIdentity,t2.FMobileTel,t2.FID,t4.FName_l2,t5.FActualBreedDate").append("\n")
//		.append(" order by t1.FCompanyID,max(t1.FInDate)").append("\n");
//		ResultSet rs = state.executeQuery(queryStr.toString());
////		StringBuffer sbRow = new StringBuffer();
//		String[] sbRow;
//		int zzz=0;
//		while(rs.next()){
////			sbRow.setLength(0);
//			//初始化数组
//			sbRow=new String[35];
//			for(int index=0;index<sbRow.length;index++) {
//				sbRow[index]="";
//			}
//
//			//			if(StringUtils.isNotBlank(rs.getString("FCompanyID"))){
//			//				sbRow.append(rs.getString("FCompanyID")).append("|");
//			//			}
//			// 加密身份证号码
//			if(StringUtils.isNotBlank(rs.getString("FIdentity"))){
//				idcardValidator = new IdcardValidator();
//				idCardNum=rs.getString("FIdentity");
//				if(idcardValidator.is15Idcard(idCardNum.trim().replace("x", "X")))
//					idCardNum=idcardValidator.convertIdcarBy15bit(idCardNum);
//				if(idcardValidator.isValidate18Idcard(idCardNum)){
//					//					sbRow.append(idCardNum).append("|");
////					sbRow.append(EncryptUtil.getSHA256StrJava(idCardNum));
//					sbRow[0]=EncryptUtil.getSHA256StrJava(idCardNum);
//				}
//			}
////			sbRow.append("|");
//
//			//			// 姓名
//			//			if(StringUtils.isNotBlank(rs.getString("fname"))){
//			//				sbRow.append(rs.getString("fname")).append("|");
//			//			}
//			// 加密姓名
//			if(StringUtils.isNotBlank(rs.getString("fname"))){
////				sbRow.append(EncryptUtil.getSHA256StrJava(rs.getString("fname")));
//				sbRow[1]=EncryptUtil.getSHA256StrJava(rs.getString("fname"));
//				//sbRow.append(rs.getString("fname"));
//			}
////			sbRow.append("|");
////小于修改
////			//			//手机号
////						if(StringUtils.isNotBlank(rs.getString("FMobileTel"))){
////							sbRow.append(rs.getString("FMobileTel").trim());
////						}
////						sbRow.append("|");
//
//			System.out.println(++zzz);
//			querySingleFarmerData(ctx,sbRow,conn,state,rs.getString("farmerID"),idCardNum,sdfTime,rs.getString("companyName"));
//			int count=sbRow.length;
//			for(int index=0;index<count;index++) {
//				sb.append(sbRow[index]).append(index<(count-1)?"|":"");
//			}
//			sb.append("\n");
//		}
//	}
//	/**
//	 * 查询单个养殖户的信息
//	 * @param ctx
//	 * @param sb
//	 * @param sbRow 
//	 * @param conn 
//	 * @param state 
//	 * @param idCardNum 
//	 * @param batchID 
//	 * @param sdfTime 
//	 * @param companyName 
//	 * @param string
//	 */
//	private void querySingleFarmerData(Context ctx,
//			String[] sbRow, Connection conn, Statement state, String farmerID, String idCardNum, SimpleDateFormat sdfTime, String companyName) {
//		// TODO Auto-generated method stub
//		Statement singleState = null;
//		ResultSet rsSingle = null;
//		try{
//			try {
//				// 首批养殖日期
//				singleState = conn.createStatement();
//				StringBuffer strb=new StringBuffer();
//				strb.append(" select min(indate) indate  from (")
//				.append(" select min(findate) indate from T_FM_Batch where FBaseStatus in (2,3) and FFarmerID='"+farmerID+"'")
//				.append(" union all")
//				.append(" select min(b1.fbizdate-b1.FDayAge+1) inDate")
//				.append(" from T_SET_SettleBill b1")
//				.append(" inner join T_ORG_Admin b2 on b2.FID=b1.FFarmerID")
//				.append(" where upper(b2.FZipCode)='"+idCardNum.toUpperCase()+"'")
//				.append(" )")
//				.append(" ");
//				rsSingle = DbUtil.executeQuery(ctx,strb.toString());
////				rsSingle = singleState.executeQuery("select min(findate) indate from T_FM_Batch where FBaseStatus in (2,3) and FFarmerID='"+farmerID+"'");
//				if (rsSingle.next()){
//					if(rsSingle.getDate("indate")!=null)
////						sbRow.append(sdfTime.format(rsSingle.getDate("indate")));
//						sbRow[2]=sdfTime.format(rsSingle.getDate("indate"));
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//			// 当前是否在养 是 1 ,养殖禽类 鸭 2
////			sbRow.append("|1|2|");
//			sbRow[3]="1";
//			sbRow[4]="2";
//
//			try {			
//				StringBuffer sql = getLastThreeBatchsInformationString(farmerID);
//				String tempStr;
//				int times=0; 
//				rsSingle = singleState.executeQuery(sql.toString());
//				int arrayFilledIndex=5; 
//				while(rsSingle.next()){
//					times++;
//					tempStr=rsSingle.getString("informatrion");
//					if (times < 3) {
//						String[] temapArray=tempStr.split("\\|");
//						for(int index=0;index<temapArray.length;index++) {
//							sbRow[arrayFilledIndex++]=temapArray[index];
//						}
//					} else if (times >= 3) {
//						break;
//					}
//				}
//
//				if(times<3){
//					queryDataFromQHC(ctx,conn,sbRow,arrayFilledIndex,idCardNum,companyName);
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//
////			int length = sbRow.toString().split("\\|").length;
//			//for (int i = length;i<31;i++)
//			//小于修改
////			for (int i = length;i<35;i++)
////				sbRow.append("|");
////			sbRow.append("\n");
////			sb.append(sbRow);
//		}
//		finally{
//			try {
//				if (singleState !=null) 
//					singleState.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//	}
//
//	/**
//	 * 数据不足者从青花瓷导入的结算单上取数
//	 * @param ctx
//	 * @param conn 
//	 * @param sb
//	 * @param times 
//	 * @param idCardNum
//	 * @param companyName 
//	 * @throws SQLException 
//	 */
//	private void queryDataFromQHC(Context ctx, Connection conn, String[] sb, int arrayFilledIndex, String idCardNum, String companyName) throws SQLException {
//		// TODO Auto-generated method stub
//		if(StringUtils.isEmpty(idCardNum))
//			return;
//
//		StringBuffer sbQHC = new StringBuffer();
//		sbQHC.append("select\n");
//		sbQHC.append("t1.FBizDate                   bizDate, \n");
//		sbQHC.append("upper(t2.FZipCode)            identity,\n");
//		sbQHC.append("substr(t3.FName_l2,0,2)       company,\n");
//		sbQHC.append("t1.FDayAge                    dayAge,\n");
//		sbQHC.append("t1.CFChickQty                 chickQty,\n");
//		sbQHC.append("sum(t4.FQuantity)             quantity,\n");
//		sbQHC.append("t1.FChickAmt                  chickAmt,\n");
//		sbQHC.append("t1.FFeedingAmt                feedingAmt,\n");
//		sbQHC.append("t1.FMedicineAmt               medicineAmt,\n");
//		sbQHC.append("t1.FOtherAmt                  otherAmt,\n");
//		sbQHC.append("t1.FFeedToMeat                feedToMeat,\n");
//		sbQHC.append("to_char(t1.FBizDate-t1.FDayAge,'yyyy-MM-dd hh24:mi:ss')   FActualBreedDate,\n");
//		sbQHC.append("t1.FOtherAmt                  profits\n");
//		sbQHC.append("from \n");
//		sbQHC.append("T_SET_SettleBill                   t1\n");
//		sbQHC.append("inner join T_ORG_Admin             t2 on t2.FID=t1.FFarmerID\n");
//		sbQHC.append("inner join T_ORG_CtrlUnit          t3 on t3.FID=t2.FControlUnitID\n");
//		sbQHC.append("inner join T_SET_SettleBillEntry   t4 on t1.FID=t4.FParentID\n");
//		sbQHC.append("where t2.FZipCode is not null\n");
//		sbQHC.append("      and  upper(t2.FZipCode)='").append(idCardNum.toUpperCase()).append("'\n");
//		sbQHC.append("      and  substr(t3.FName_l2,0,2)='").append(companyName.substring(0, 2)).append("'\n");
//		sbQHC.append("Group by t1.FDayAge,upper(t2.FZipCode),t3.FName_l2,t1.CFChickQty,t1.FChickAmt,t1.FFeedingAmt,t1.FOtherAmt,t1.FFeedToMeat,t1.FOtherAmt,t1.FMedicineAmt,t1.FBizDate\n");
//		sbQHC.append("order by t1.FBizDate desc\n");
//
//
//		Statement statess = conn.createStatement();
//		try{
//		ResultSet rs1 = statess.executeQuery(sbQHC.toString());
////		int arrayFilledIndex=5;
//		while(rs1.next()){
//			/*if(times<3){
//				sb.append(rs1.getString("FActualBreedDate")).append("|");
//				sb.append(rs1.getString("dayAge")).append("|");
//				sb.append(rs1.getString("chickQty")).append("|");
//				sb.append(rs1.getString("quantity")).append("|");
//				sb.append(rs1.getString("chickAmt")).append("|");
//				sb.append(rs1.getString("feedingAmt")).append("|");
//				sb.append(rs1.getString("medicineAmt")).append("|");
//				sb.append(rs1.getString("otherAmt")).append("|");
//				sb.append(rs1.getString("feedToMeat")).append("|");
//				sb.append(rs1.getString("profits"));
//			}
//			if(times<2)
//				sb.append("|");
//			times++;*/
//			    sb[arrayFilledIndex++]=rs1.getString("FActualBreedDate");
//			    sb[arrayFilledIndex++]=rs1.getString("dayAge");
//			    sb[arrayFilledIndex++]=rs1.getString("chickQty");
//			    sb[arrayFilledIndex++]=rs1.getString("quantity");
//			    sb[arrayFilledIndex++]=rs1.getString("chickAmt");
//			    sb[arrayFilledIndex++]=rs1.getString("feedingAmt");
//			    sb[arrayFilledIndex++]=rs1.getString("medicineAmt");
//			    sb[arrayFilledIndex++]=rs1.getString("otherAmt");
//			    sb[arrayFilledIndex++]=rs1.getString("feedToMeat");
//			    sb[arrayFilledIndex++]=rs1.getString("profits");
//			    
//			    if(arrayFilledIndex>=(sb.length-1)) {
//			    	break;
//			    }
//		}
//		}finally{
//			if(statess!=null)
//				statess.close();
//		}
//	}
//
//	/**
//	 * 获取近三批数据的sql
//	 * @param farmerID
//	 * @return
//	 */
//	private StringBuffer getLastThreeBatchsInformationString(String farmerID) {
//		// TODO Auto-generated method stub
//		StringBuffer sql = new StringBuffer();
//		sql.append("select FActualBreedDate||'|'||FDayAge||'|'||FContractQty||'|'||FGrossQty||'|'||FChickAMt||'|'||FFeedingAmt||'|'||FMedicineAmt||'|'||FOtherAmt||'|'||FFeedToMeat||'|'|| profit  informatrion").append("\n")
//		.append("from(").append("\n")
//		.append("select ").append("\n")
//		.append(" t2.FInDate,").append("\n")
//		.append(" t1.FDayAge,").append("\n")
//		.append(" t1.FContractQty,").append("\n")
//		.append(" t1.FGrossQty,").append("\n")
//		.append(" t1.FChickAMt,").append("\n")
//		.append(" t1.FFeedingAmt,").append("\n")
//		.append(" t1.FMedicineAmt,").append("\n")
//		.append(" t1.FOtherAmt FOtherAmt,").append("\n")
//		.append(" t1.FFeedToMeat,").append("\n")
//		.append(" to_char(t4.FActualBreedDate,'yyyy-MM-dd hh24:mi:ss') FActualBreedDate,").append("\n")
//		.append(" t1.FOtherAmt profit").append("\n")
//		.append(" from ").append("\n")
//		.append(" T_FM_DkSettleBill        t1").append("\n")
//		.append(" inner join T_FM_Batch    t2 on t2.FID=t1.FBatchID").append("\n")
//		.append(" inner join T_FM_BatchContractBill  t4 on t4.FID=t2.FBatchContractID").append("\n")
//		.append(" inner join CT_FM_Farmer  t3 on t3.FID=t1.FFarmerID").append("\n")
//		.append(" where t3.FID='").append(farmerID).append("'").append("\n")
//		.append(" and t1.FBillStatus=4").append("\n")
//		.append(" order by t2.FInDate desc").append("\n")
//		.append(" )").append("\n");
//
//		return sql;
//
//	}
//
//	/**
//	 * 获取数据前校验文件是否存在
//	 * @param filePath
//	 */
//	private int checkFileIsExist(String filePath) {
//		// TODO Auto-generated method stub
//		File file = new File(filePath);
//		if(file.exists()&&file.isFile()){
//			if((file.length()*0.0009766)<5)
//				return 0;
//			else
//				return 2;
//		}
//		else if(file.exists()&&!file.isFile())
//			return 1;
//		else
//			return 0;
//	}
//	/**
//	 * 将字符内容输出到指定位置
//	 * @param ctx
//	 * @param sb
//	 * @param file 
//	 * @throws IOException 
//	 */
//	private void exportTxtFileToFixedPosition(Context ctx, StringBuffer sb, File file) throws IOException {
//		// TODO Auto-generated method stub
//		OutputStreamWriter  out = null;
//		try{
//			if(StringUtils.isEmpty(sb.toString()))
//				return;
//			else{
//				out = new OutputStreamWriter(new FileOutputStream(file),"UTF-8");
//				out.write(sb.toString());
//			}
//		}finally{
//			out.close();
//		}
//	}
//	/**
//	 * 获取单批次的养殖信息
//	 * @param ctx
//	 * @param batchInfo
//	 */
//	private String getSingleBatchInformation(Context ctx, BatchInfo batchInfo) {
//		// TODO Auto-generated method stub
//		return null;
//
//	}
//}
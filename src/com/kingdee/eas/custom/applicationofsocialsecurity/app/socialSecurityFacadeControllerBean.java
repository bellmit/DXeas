package com.kingdee.eas.custom.applicationofsocialsecurity.app;

import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.kingdee.bos.*;
import com.kingdee.bos.dao.IObjectValue;

import java.lang.String;
import java.math.BigDecimal;

import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.applicationofsocialsecurity.DataBaseConnectionInfo;
import com.kingdee.eas.custom.commld.jdbcUntils;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.util.NumericExceptionSubItem;

public class socialSecurityFacadeControllerBean extends AbstractsocialSecurityFacadeControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.applicationofsocialsecurity.app.socialSecurityFacadeControllerBean");

	Connection conn=null;
	PreparedStatement state=null;
	/**
	 * ����Ա���ı����������  ��ȡ��shr���ݿ��е���Ϣ
	 */
	protected HashMap<String,String> _getInfoOfPersonBaseOnNumberOrName(Context ctx, String personNum, String personName,IObjectValue objectvalue)throws BOSException, EASBizException
	{
		DataBaseConnectionInfo info=null;
		if(objectvalue!=null)
			info=(DataBaseConnectionInfo)objectvalue;
		conn=getConnectionByDataBaseConnection(info);
		if(conn==null)
			return null;
		HashMap<String,String> map=new HashMap<String, String>();

		StringBuffer sb=StringBufferGetInfoOfPersonBaseOnNumberOrName(personNum,personName);
		if(personNum!=null&&!personNum.equals("")){
			try {
				state=conn.prepareStatement(sb.toString());
				ResultSet rs = state.executeQuery(sb.toString());
				String [] Strkey=new String[12];
				while(rs.next()){
					Strkey[0]=rs.getString("Name");
					Strkey[1]=rs.getString("enterDate");
					Strkey[2]=rs.getString("department");
					Strkey[3]=rs.getString("job");
					Strkey[4]=rs.getString("IDCardNo");
					Strkey[5]=rs.getString("gender");
					Strkey[6]=rs.getString("cellPhone");
					Strkey[7]=rs.getString("diploma");
					Strkey[8]=rs.getString("effectDate");
					Strkey[9]=rs.getString("endDate");
					if(Strkey[8]!=null&&Strkey[9]!=null&&!Strkey[8].equals("")&&!Strkey[9].equals(""))
						Strkey[10]=getContractLimitAutoByPersonAndContractEffectDateAndEndDate(ctx, personNum,conn, Strkey[8], Strkey[9]).toString();
					Strkey[11]=rs.getString("socialSecurity");

					map.put(personNum, getValue(Strkey));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		closeConnection();
		return map;
	}



	/**
	 * valueֵ��ƴװ
	 * @param strkey
	 * @return
	 */
	private String getValue(String[] strkey) {
		// TODO Auto-generated method stub
		String str="";
		for(int i=0;i<strkey.length;i++){
			if(strkey[i]!=null&&!strkey[i].equals(""))
				str+=strkey[i];
			else
				str+="0000";
			if(i!=strkey.length-1)
				str+="_";
		}
		return str;
	}

	/**
	 * 
	 * @param personNum
	 * @param personName
	 * @return
	 */
	private StringBuffer StringBufferGetInfoOfPersonBaseOnNumberOrName(
			String personNum, String personName) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();

		sb.append(" select ");
		sb.append(" t1.FNumber FNumber,");
		sb.append(" t1.FName_l2 Name,");
		sb.append(" to_char(t2.FEnterDate,'yyyy-MM-dd') enterDate,");
		sb.append(" t3.FName_l2 department,");
		sb.append(" t4.FName_l2 job,");
		sb.append(" t1.FIDCardNO IDCardNo,");
		sb.append(" case  t1.FGender when 2 then 'Ů'");
		sb.append(" when 1 then '��'");
		sb.append(" else null end  gender,");
		sb.append(" t1.fcell cellPhone,");
		sb.append(" t6.Fname_l2  diploma,");
		sb.append(" max(to_char(t7.FEffectDate,'yyyy-MM-dd')) effectDate,");
		sb.append(" max(to_char(t7.FEndDate,'yyyy-MM-dd')) endDate,");
		sb.append(" t8.FName_l2 socialSecurity");
		sb.append(" from t_bd_person t1");
		sb.append(" inner join T_HR_PersonPosition          t2 on t1.FID=t2.FPersonID");
		sb.append(" inner join T_ORG_Admin                  t3 on t3.FID=t2.FPersonDep");
		sb.append(" inner join T_ORG_Position               t4 on t4.FID=t2.FPrimaryPositionID");
		sb.append(" left join  T_HR_PersonDegree            t5 on t5.fpersonID=t1.fid  and t5.fisHighest=1");
		sb.append(" left join  T_BD_HRDiploma               t6 on t6.fid=t5.fdiploma");
		sb.append(" left join  T_HR_EmployeeContract        t7 on t7.fEmployeeID=t1.fid ");
		sb.append(" left join  CT_BD_SocialSecurityStatus   t8 on t8.FID=t1.CFSocialSecuritySt");

		sb.append(" where t1.fnumber='").append(personNum).append("'");

		sb.append(" group by t1.FNumber,t1.FName_l2,to_char(t2.FEnterDate,'yyyy-MM-dd'),t3.FName_l2,t4.FName_l2,t1.FIDCardNO,case  t1.FGender when 2 then 'Ů'");
		sb.append(" when 1 then '��'");
		sb.append(" else null end ,t1.fcell,t6.Fname_l2,t8.FName_l2");

		return sb;
	}

	/**
	 * ����Ա�����룬��ͬ����ʵ���ں���ֹ���ڻ�ú�ͬ����
	 * @param conn 
	 * @throws SQLException 
	 */
	protected BigDecimal getContractLimitAutoByPersonAndContractEffectDateAndEndDate(
			Context ctx, String personNum, Connection conn, String effectDate, String endDate)
	throws BOSException, EASBizException, SQLException {
		// TODO Auto-generated method stub


		StringBuffer sb=new StringBuffer();
		sb.append("select t1.FContractLimitAuto ContractLimitAuto");
		sb.append(" from T_HR_EmployeeContract t1");
		sb.append(" inner join t_bd_person t2    on t2.fid=t1.FEmployeeID and t2.fnumber='").append(personNum).append("'");
		sb.append(" where t1.FEffectDate={ts '").append(effectDate).append("'}");
		sb.append(" and t1.FEndDate={ts'").append(endDate).append("'}");

		state = conn.prepareStatement(sb.toString());
		ResultSet rs = state.executeQuery(sb.toString());
		if(rs.next())
			return rs.getBigDecimal("ContractLimitAuto");

		closeConnection();
		return null;
	}






	/**
	 * ��shrϵͳ�л�ȡԱ���籣״̬
	 */
	@Override
	protected ArrayList<String> _getSHRSIStatus(Context ctx,
			IObjectValue dataBaseConnectionIngfo) throws BOSException,
			EASBizException {
		// TODO Auto-generated method stub
		ArrayList<String> list=new ArrayList<String>();

		//�������ݿ�
		DataBaseConnectionInfo info=null;
		if(dataBaseConnectionIngfo!=null)
			info=(DataBaseConnectionInfo)dataBaseConnectionIngfo;
		String[] str={info.getIP(),info.getPort(),info.getDataBaseName(),info.getUserName(),info.getPassword()};
		Connection conn=jdbcUntils.getDataBaseConnection(str);

		//ȡ������
		String sql="select FName_l2 from CT_BD_SocialSecurityStatus";
		try {
			state = conn.prepareStatement(sql);
			ResultSet rs = state.executeQuery(sql);
			while(rs.next())
				list.add(rs.getString("FName_l2"));
			closeConnection();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * �����籣״̬�����ƻ��ID
	 */
	@Override
	protected String _getSIStatusIDBaseOnHisName(Context ctx,
			String SIStatusName, IObjectValue dataBaseConnectionIngfo)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		String result="";

		if(dataBaseConnectionIngfo!=null)
			conn=getConnectionByDataBaseConnection((DataBaseConnectionInfo)dataBaseConnectionIngfo);
		if(conn==null)
			return null;

		String str="select FID from CT_BD_SocialSecurityStatus where FName_l2='"+SIStatusName+"'";
		try {
			state=conn.prepareStatement(str);
			ResultSet rs = state.executeQuery(str);
			if(rs.next()){
				result= rs.getString("FID");
				closeConnection();
				return result;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ����Ա�����籣״̬
	 */
	@Override
	protected String _updateSIStatusBaseOnPersonNumAndSIStatusID(Context ctx,
			String SIStatusID, String personNum,
			IObjectValue dataBaseConnectionIngfo) throws BOSException,
			EASBizException {
		// TODO Auto-generated method stub
		if(dataBaseConnectionIngfo!=null)
			conn=getConnectionByDataBaseConnection((DataBaseConnectionInfo)dataBaseConnectionIngfo);
		if(conn==null)
			return null;

		String str="update T_BD_Person set CFSocialSecurityST='"+SIStatusID+"' where FNumber='"+personNum+"'";
		try {
			state=conn.prepareStatement(str);
			state.executeUpdate(str);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();


		return null;
	}
	/**
	 * �������ݿ��������ý�������
	 * @param info
	 * @return
	 */
	private Connection getConnectionByDataBaseConnection(
			DataBaseConnectionInfo info) {
		// TODO Auto-generated method stub
		String[] str={info.getIP(),info.getPort(),info.getDataBaseName(),info.getUserName(),info.getPassword()};
		Connection conn=jdbcUntils.getDataBaseConnection(str);
		return conn;
	}
	/**
	 * �ر�����
	 */
	private void closeConnection() {
		// TODO Auto-generated method stub

		try {
			if(conn!=null)
				conn.close();
			if(state!=null)
				state.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * ��SHRϵͳ�л�ȡ��˾
	 */
	@Override
	protected ArrayList _getCompanyNameFromSHR(Context ctx,
			IObjectValue dataBaseConnectionIngfo) throws BOSException,
			EASBizException {
		// TODO Auto-generated method stub

		ArrayList<String> list=new ArrayList<String>();

		if(dataBaseConnectionIngfo==null)
			return null;
		conn=getConnectionByDataBaseConnection((DataBaseConnectionInfo) dataBaseConnectionIngfo);
		if(conn==null)
			return null;

		String str="select t1.FName_l2 companyName,t2.FName_l2 LayerType from T_ORG_Admin t1 inner join T_Org_LayerType t2 on t2.FID=t1.FLayerTypeID where t2.FName_l2='��˾'";
		try {
			state=conn.prepareStatement(str);
			ResultSet rs = state.executeQuery(str);
			while(rs.next())
				list.add(rs.getString("companyName"));
			closeConnection();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}



	@Override
	protected ArrayList _getPersonInfoByFilterItem(Context ctx, Date dateBegin,
			Date dateEnd, IObjectValue dataBaseConnectionInfo, boolean isIn,
			String company, String SIStatus, String personName, String personNum)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		ArrayList<String> list=new ArrayList<String>();


		String companyLongtNum="";
		if(company!=null&&!company.equals("")){
			companyLongtNum=getLongNumberByCompanyName(ctx,dataBaseConnectionInfo,company);
			if(companyLongtNum.equals(""))
				throw new EASBizException(new NumericExceptionSubItem("001","���ݹ�˾���Ʋ��ҳ�����ʱʧ��"));
		}
		StringBuffer sb=getStringBufferBaseOnPersonInfomation(dateBegin,dateEnd,isIn,companyLongtNum,  SIStatus,  personName,  personNum);

		conn=getConnectionByDataBaseConnection((DataBaseConnectionInfo) dataBaseConnectionInfo);


		String str[]=new String[12];
		try {
			state=conn.prepareStatement(sb.toString());
			ResultSet rs = state.executeQuery(sb.toString());
			while(rs.next()){
				str[0]=rs.getString("FNumber");
				str[1]=rs.getString("FName");
				str[2]=rs.getString("empTypeName");
				str[3]=rs.getString("enterDate");
				str[4]=rs.getString("department");
				str[5]=rs.getString("job");
				str[6]=rs.getString("IDCardNo");
				str[7]=rs.getString("gender");
				str[8]=rs.getString("cellPhone");
				str[9]=rs.getString("diploma");
				str[10]=rs.getString("socialSecurity");
				str[11]=rs.getString("company");
				list.add(getValue(str));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}






	/**
	 * ���ݹ���������������ɸѡ�����
	 * @param dateBegin
	 * @param dateEnd
	 * @param dataBaseConnectionInfo
	 * @param isIn
	 * @param company
	 * @param status
	 * @param personName
	 * @param personNum
	 * @return
	 */
	private StringBuffer getStringBufferBaseOnPersonInfomation(Date dateBegin,
			Date dateEnd, boolean isIn,
			String companyLongtNum, String SIStatus, String personName, String personNum) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");





		sb.append(" select ");
		sb.append(" t1.FNumber FNumber,");
		sb.append(" t1.FName_l2 FName,");
		sb.append(" t9.FName_l2 empTypeName,");//�ù���ϵ״̬
		sb.append(" to_char(t2.FEnterDate,'yyyy-MM-dd') enterDate,");
		sb.append(" case when t3.FDisplayName_l2 like '%����������Ͽ��ֳ���޹�˾%' then '����������Ͽ��ֳ���޹�˾'");
		sb.append("      when t3.FDisplayName_l2 like '%����ı�Ȫ��ũ����չ���޹�˾����%' then '����ı�Ȫ��ũ����չ���޹�˾����'");
		sb.append("      when t3.FDisplayName_l2 like '%����������ϿʳƷ���޹�˾%' then '����������ϿʳƷ���޹�˾'");
		sb.append(" else null end as company,");
		sb.append(" t3.FName_l2 department,");
		sb.append(" t4.FName_l2 job,");
		sb.append(" t1.FIDCardNO IDCardNo,");
		sb.append(" case  t1.FGender when 2 then 'Ů'");
		sb.append(" when 1 then '��'");
		sb.append(" else null end  gender,");
		sb.append(" t1.fcell cellPhone,");
		sb.append(" t6.Fname_l2  diploma,");
		sb.append(" t8.FName_l2 socialSecurity");
		sb.append(" from t_bd_person t1");
		sb.append(" inner join T_HR_PersonPosition          t2 on t1.FID=t2.FPersonID");
		sb.append(" inner join T_ORG_Admin                  t3 on t3.FID=t2.FPersonDep");
		sb.append(" inner join T_ORG_Position               t4 on t4.FID=t2.FPrimaryPositionID");
		sb.append(" left  join T_HR_PersonDegree            t5 on t5.fpersonID=t1.fid  and t5.fisHighest=1");
		sb.append(" left  join T_BD_HRDiploma               t6 on t6.fid=t5.fdiploma");
		sb.append(" left  join CT_BD_SocialSecurityStatus   t8 on t8.FID=t1.CFSocialSecuritySt");
		sb.append(" left  join T_HR_BDEmployeeType          t9 on t9.FID=t1.FEmployeeTypeID ");

		if(isIn)
			sb.append(" where t9.FName_l2 in('��ʽԱ��','����Ա��','ʵϰ')");//�Ƿ���ְ
		else
			sb.append(" where t9.FName_l2 not in('��ʽԱ��','����Ա��','ʵϰ')");

		if(personName!=null&&!personName.equals(""))
			sb.append(" and t1.FName_l2 like '%").append(personName).append("%'");//Ա������ģ��ƥ��

		if(personNum!=null&&!personNum.equals(""))
			sb.append(" and t1.FNumber like '%").append(personNum).append("%'");//Ա������ģ��ƥ��

		if(companyLongtNum!=null&&!companyLongtNum.equals(""))
			sb.append(" and t3.FLongNumber like '").append(companyLongtNum).append("%'");//��˾ƥ��

		if(SIStatus!=null&&!SIStatus.equals(""))
			if(SIStatus.equals("��"))
				sb.append(" and t8.FName_l2 is null");//�籣״̬ƥ��
			else
				sb.append(" and t8.FName_l2 ='").append(SIStatus).append("'");

		if(dateBegin!=null)
			sb.append(" and to_char(t2.FEnterDate,'yyyy-MM-dd')>='").append(sdf.format(dateBegin)).append("'");//��ְ���ڴ�

		if(dateEnd!=null)
			sb.append(" and to_char(t2.FEnterDate,'yyyy-MM-dd')<='").append(sdf.format(dateEnd)).append("'");//��ְ���ڵ�


		return sb;
	}

	/**
	 * ����shr��˾�����ƻ�ȡ�䳤����
	 * @param ctx
	 * @param dataBaseConnectionInfo 
	 * @param company
	 * @return
	 */
	private String getLongNumberByCompanyName(Context ctx, IObjectValue dataBaseConnectionInfo, String company) {
		// TODO Auto-generated method stub


		String longNumber="";
		String str="select FLongNumber from T_ORG_Admin where FName_l2='"+company+"'";
		conn=getConnectionByDataBaseConnection((DataBaseConnectionInfo)dataBaseConnectionInfo);
		try {
			state=conn.prepareStatement(str);
			ResultSet rs = state.executeQuery(str);
			if(rs.next())
				longNumber=rs.getString("FLongNumber");
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return longNumber;
	}
}
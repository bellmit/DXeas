package com.kingdee.eas.farm.hatch.app;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.hatch.BEggCandlingBillCollection;
import com.kingdee.eas.farm.hatch.BEggCandlingBillFactory;
import com.kingdee.eas.farm.hatch.BEggCandlingBillInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.AppCommon;
import com.kingdee.eas.wlhlcomm.FarmException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.util.StringUtils;

public class BEggCandlingBillControllerBean extends AbstractBEggCandlingBillControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.hatch.app.BEggCandlingBillControllerBean");


	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// ״̬����Ϊ����
		BEggCandlingBillInfo info =  (BEggCandlingBillInfo)model;
		if(!BillBaseStatusEnum.TEMPORARILYSAVED.equals(info.getBaseStatus()) &&
				!BillBaseStatusEnum.ADD.equals(info.getBaseStatus())	&& 
				!info.getBaseStatus().NULL.equals(info.getBaseStatus()) && 
				info.getBaseStatus() != null ){
			throw new EASBizException(new NumericExceptionSubItem("001","ֻ�ܱ����ݴ��������״̬�ĵ���"));

		}

		//		// У��ת�䵥�Ƿ��Ѿ����������� ������
		//		if(checkTransBillExist(ctx,info)){
		//			throw new EASBizException(new NumericExceptionSubItem("001","ת�䵥�Ѿ����ڶ�Ӧ�ĳ������������ظ�����"));
		//		}

		if(info.getAdminOrg() == null){
			info.setAdminOrg(ContextUtil.getCurrentAdminUnit(ctx));

		}
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		if(info.getBizDate()!=null){
			try {
				info.setBizDate(sdf.parse((new SimpleDateFormat("yyyy-MM-dd")).format(info.getBizDate())+" 00:00:00"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		IObjectPK pk=null;
		info.setBaseStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		try{
			pk = super._save(ctx, model);
			return pk;
		}finally{
			if(pk!=null)
				setHatchEggBillCandlingDate(ctx,pk.toString(),info.getBizDate());


		}
	}

	private void setHatchEggBillCandlingDate(Context ctx,
			String pk, Date date) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		if(date==null)
			return;
		String str="select t1.FSrcObjectID from T_BOT_Relation t1  where t1.FDestObjectID=? and t1.FSrcEntityID=?";
		String [] param={pk,"D2F77416"};
		try {
			IRowSet rs = DbUtil.executeQuery(ctx, str,param);
			while(rs.next()){
				str="update CT_FM_BEggHatchBill set FBEggCandingDate={ts '"+sdf.format(date)+"'} ,FIsHasBEggCanding=1 where FID='"+rs.getString("FSrcObjectID")+"'";
				System.out.println(str);
				DbUtil.execute(ctx,str);
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
	EASBizException {
		BEggCandlingBillInfo info =  BEggCandlingBillFactory.getLocalInstance(ctx).getBEggCandlingBillInfo(pk);
		if(!BillBaseStatusEnum.TEMPORARILYSAVED.equals(info.getBaseStatus()) &&
				!BillBaseStatusEnum.ADD.equals(info.getBaseStatus())	&& 
				!BillBaseStatusEnum.SUBMITED.equals(info.getBaseStatus())  && 
				!info.getBaseStatus().NULL.equals(info.getBaseStatus()) && 
				info.getBaseStatus() != null ){
			throw new EASBizException(new NumericExceptionSubItem("001","ֻ��ɾ���ݴ��������״̬�ĵ���"));

		}

		boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), pk.toString());
		if(exist){
			throw new FarmException("�Ѿ��������ε��ݣ�����ɾ��");
		}

		String sql="select * from T_BOT_Relation where FDestObjectID='"+pk.toString()+"' and FSrcEntityID='D2F77416'";
		IRowSet rs = DbUtil.executeQuery(ctx, sql);
		String srcBillID="";
		try {
			if(rs.next()){
				srcBillID = rs.getString("FSrcObjectID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		super._delete(ctx, pk);

		if(StringUtils.isEmpty(srcBillID))
			return;
		sql="select * from T_BOT_Relation where FSrcObjectID='"+srcBillID+"' and FDestEntityID='D54999A2' order by FDate desc";
		rs = DbUtil.executeQuery(ctx, sql);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if(rs.next()){
				BEggCandlingBillCollection collBEggCanding = BEggCandlingBillFactory.getLocalInstance(ctx).getBEggCandlingBillCollection("where id='"+rs.getString("FDestObjectID")+"'");
				if(collBEggCanding.size()>0){
					String str = "update CT_FM_BEggHatchBill set FIsHasBEggCanding=1";
					if(collBEggCanding.get(0).getBizDate()!=null)
						str+=",FBEggCandingDate={ts '"+sdf.format(collBEggCanding.get(0).getBizDate())+"'}";
					str+=" where  fid ='"+srcBillID+"'";
					DbUtil.execute(ctx, str);
				}
				else
					DbUtil.execute(ctx, "update CT_FM_BEggHatchBill set FIsHasBEggCanding=0,FBEggCandingDate='' where  fid ='"+srcBillID+"'");
			}else
				DbUtil.execute(ctx, "update CT_FM_BEggHatchBill set FIsHasBEggCanding=0,FBEggCandingDate='' where  fid ='"+srcBillID+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * �ύ
	 */
	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		BEggCandlingBillInfo info = (BEggCandlingBillInfo)model;
		if(info != null  && 
				(BillBaseStatusEnum.ADD.equals(info.getBaseStatus()) ||
						BillBaseStatusEnum.TEMPORARILYSAVED.equals(info.getBaseStatus()) ||
						BillBaseStatusEnum.SUBMITED.equals(info.getBaseStatus()) || 
						BillBaseStatusEnum.NULL.equals(info.getBaseStatus()) || 
						info.getBaseStatus() == null)){
			info.setBaseStatus( BillBaseStatusEnum.SUBMITED);



			if(info.getAdminOrg() == null){
				info.setAdminOrg(ContextUtil.getCurrentAdminUnit(ctx));

			}

			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			if(info.getBizDate()!=null){
				try {
					info.setBizDate(sdf.parse((new SimpleDateFormat("yyyy-MM-dd")).format(info.getBizDate())+" 00:00:00"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			IObjectPK pk = null;
			try{
				pk=super._submit(ctx, model);
				this._audit(ctx, model);
//				return pk;
				return super._submit(ctx, model);
			}finally{
				if(pk!=null)
					setHatchEggBillCandlingDate(ctx,pk.toString(),info.getBizDate());
			}
		}else{
			throw new EASBizException(new NumericExceptionSubItem("01","ֻ���ύ�����򱣴�״̬�ĵ���"));

		}
	}

	//	/**
	//	 * У���Ϸ����Ƿ��Ѿ�����������������
	//	 * @param ctx
	//	 * @param billInfo
	//	 * @return
	//	 * @throws BOSException 
	//	 */
	//	private boolean checkTransBillExist(Context ctx, BEggCandlingBillInfo billInfo) throws BOSException{
	//		String transID = "";
	//		if(billInfo.getTransferBoxBill() != null){
	//			transID = billInfo.getTransferBoxBill().getId().toString();
	//			
	//			String id = "";
	//			if(billInfo.getId() != null){
	//				id = billInfo.getId().toString();
	//			}
	//			StringBuilder sb = new StringBuilder("select 1 from CT_FM_BEggCandlingBill where CFTransferBoxBillI ='");
	//			sb.append(transID);
	//			sb.append("' ");
	//			if(StringUtils.isNotBlank(id)){
	//				sb.append(" and fid <> '");
	//				sb.append(id);
	//				sb.append("'");
	//				
	//			}
	//			try{
	//				IRowSet rs  = DbUtil.executeQuery(ctx, sb.toString());
	//				if(rs.next()){
	//					return true;
	//				}
	//			}catch(SQLException sqle){
	//				sqle.printStackTrace();
	//				throw new BOSException(sqle);
	//			}
	//		}else{
	//			return false;
	//		}
	//		return false;
	//	}
	/**
	 * ���
	 * @throws EASBizException 
	 * @throws EASBizException 
	 */
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		BEggCandlingBillInfo billInfo = (BEggCandlingBillInfo)model;


		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new EASBizException(new NumericExceptionSubItem("01","�Ѿ��������ε��ݣ��������"));
			}

			// ���µ���״̬
//			AppCommon.updateModelStatus(ctx, "CT_FM_BEggCandlingBill", billInfo.getId().toString(), BillBaseStatusEnum.AUDITED);
			billInfo.setBaseStatus(BillBaseStatusEnum.AUDITED);

		}else{
			throw new EASBizException(new NumericExceptionSubItem("01","ֻ������ύ״̬�ĵ���"));
		}


	}

	/**
	 * �����
	 * @throws EASBizException 
	 */
	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {

		BEggCandlingBillInfo billInfo = (BEggCandlingBillInfo)model;

		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.AUDITED.equals(billInfo.getBaseStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new EASBizException(new NumericExceptionSubItem("01","�Ѿ��������ε��ݣ����ܷ����"));
			}
			// ���µ���״̬
			AppCommon.updateModelStatus(ctx, "CT_FM_BEggCandlingBill", billInfo.getId().toString(), BillBaseStatusEnum.TEMPORARILYSAVED);

		}else{
			throw new EASBizException(new NumericExceptionSubItem("01","ֻ�ܷ�������״̬�ĵ���"));
		}

	}

	@Override
	protected void _adjust(Context ctx, IObjectValue model) throws BOSException {
		// TODO Auto-generated method stub

	}
}
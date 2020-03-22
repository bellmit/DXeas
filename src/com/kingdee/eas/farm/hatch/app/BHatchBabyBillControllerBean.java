package com.kingdee.eas.farm.hatch.app;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.eas.farm.hatch.BEggCandlingBillCollection;
import com.kingdee.eas.farm.hatch.BEggCandlingBillFactory;
import com.kingdee.eas.farm.hatch.BHatchBabyBillCollection;
import com.kingdee.eas.farm.hatch.BHatchBabyBillFactory;
import com.kingdee.eas.farm.hatch.BHatchBabyBillInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.AppCommon;
import com.kingdee.eas.wlhlcomm.FarmException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.util.StringUtils;

public class BHatchBabyBillControllerBean extends AbstractBHatchBabyBillControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.hatch.app.BHatchBabyBillControllerBean");


	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// ״̬����Ϊ����
		BHatchBabyBillInfo info =  (BHatchBabyBillInfo)model;
		if(!BillBaseStatusEnum.TEMPORARILYSAVED.equals(info.getBaseStatus()) &&
				!BillBaseStatusEnum.ADD.equals(info.getBaseStatus())	&& 
				!BillBaseStatusEnum.SUBMITED.equals(info.getBaseStatus())	&& 
				!info.getBaseStatus().NULL.equals(info.getBaseStatus()) && 
				info.getBaseStatus() != null ){
			throw new EASBizException(new NumericExceptionSubItem("001","ֻ�ܱ�������,�ݴ�����ύ״̬�ĵ���"));

		}

		//		// У��ת�䵥�Ƿ��Ѿ����������� ������
		//		if(checkTransBillExist(ctx,info)){
		//			throw new EASBizException(new NumericExceptionSubItem("001","ת�䵥�Ѿ����ڶ�Ӧ�ĳ������������ظ�����"));
		//		}

		if(info.getAdminOrg() == null){
			info.setAdminOrg(ContextUtil.getCurrentAdminUnit(ctx));

		}
		info.setBizDate(DateUtilsComm.clearDateHMS(info.getBizDate()));

		info.setBaseStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		return super._save(ctx, model);
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
	EASBizException {
		BHatchBabyBillInfo info =  BHatchBabyBillFactory.getLocalInstance(ctx).getBHatchBabyBillInfo(pk);
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


		//ɾ����������ʱ����Ҫ��д�ҵ��Ǽ�¼�����Ƿ����ɳ������ؼ�Ϊfalse
		String sql="select * from T_BOT_Relation where FDestObjectID='"+pk.toString()+"' and FSrcEntityID='D54999A2'";
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
		if(srcBillID != null){
			DbUtil.execute(ctx, "update CT_FM_BEggCandlingBill set CFIsProBabyBill=0  where  fid ='"+srcBillID+"'");
		}
	}

	/**
	 * �ύ
	 */
	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		BHatchBabyBillInfo info = (BHatchBabyBillInfo)model;
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

			info.setBizDate(DateUtilsComm.clearDateHMS(info.getBizDate()));
			//			return super._submit(ctx, model);

			IObjectPK pk = null;
			try{
				pk=super._submit(ctx, model);
//				return pk;
				this._audit(ctx, model);
				return super._submit(ctx, model);
			}finally{
				if(pk!=null)
					//�������ύ��ʱ�򣬷�д�յ���¼��--�Ƿ����ɳ������ֶ�����Ϊ��
					setHatchEggBillCandlingDate(ctx,pk.toString());
			}
		}else{
			throw new EASBizException(new NumericExceptionSubItem("001","ֻ���ύ�����򱣴�״̬�ĵ���"));

		}
	}

	/**
	 * ��д�յ���¼��
	 * @param ctx
	 * @param string
	 */
	private void setHatchEggBillCandlingDate(Context ctx, String pk) {
		// TODO Auto-generated method stub

		String str="select t1.FSrcObjectID from T_BOT_Relation t1  where t1.FDestObjectID=? and t1.FSrcEntityID=?";
		String [] param={pk,"D54999A2"};
		try {
			IRowSet rs = DbUtil.executeQuery(ctx, str,param);
			while(rs.next()){
				str="update CT_FM_BEggCandlingBill set CFIsProBabyBill =1 where FID='"+rs.getString("FSrcObjectID")+"'";
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

	//	/**
	//	 * У���Ϸ����Ƿ��Ѿ�����������������
	//	 * @param ctx
	//	 * @param billInfo
	//	 * @return
	//	 * @throws BOSException 
	//	 */
	//	private boolean checkTransBillExist(Context ctx, BHatchBabyBillInfo billInfo) throws BOSException{
	//		String transID = "";
	//		if(billInfo.getTransferBoxBill() != null){
	//			transID = billInfo.getTransferBoxBill().getId().toString();
	//			
	//			String id = "";
	//			if(billInfo.getId() != null){
	//				id = billInfo.getId().toString();
	//			}
	//			StringBuilder sb = new StringBuilder("select 1 from CT_FM_BHatchBabyBill where CFTransferBoxBillI ='");
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
	 */
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		BHatchBabyBillInfo billInfo = (BHatchBabyBillInfo)model;


		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new FarmException("�Ѿ��������ε��ݣ��������");
			}

			// ���µ���״̬
//			AppCommon.updateModelStatus(ctx, "CT_FM_BHatchBabyBill", billInfo.getId().toString(), BillBaseStatusEnum.AUDITED);
			billInfo.setBaseStatus(BillBaseStatusEnum.AUDITED);

		}else{
			throw new FarmException("ֻ������ύ״̬�ĵ���");
		}


	}

	/**
	 * �����
	 */
	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
	throws BOSException {

		BHatchBabyBillInfo billInfo = (BHatchBabyBillInfo)model;

		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.AUDITED.equals(billInfo.getBaseStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new FarmException("�Ѿ��������ε��ݣ����ܷ����");
			}
			// ���µ���״̬
			AppCommon.updateModelStatus(ctx, "CT_FM_BHatchBabyBill", billInfo.getId().toString(), BillBaseStatusEnum.TEMPORARILYSAVED);

		}else{
			throw new FarmException("ֻ�ܷ�������״̬�ĵ���");
		}

	}

	@Override
	protected void _multiAudit(Context ctx, IObjectValue model)
	throws BOSException {
		BHatchBabyBillInfo billInfo = (BHatchBabyBillInfo)model;


		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new FarmException("�Ѿ��������ε��ݣ��������");
			}

			// ���µ���״̬
			AppCommon.updateModelStatus(ctx, "CT_FM_BHatchBabyBill", billInfo.getId().toString(), BillBaseStatusEnum.AUDITED);

		}else{
			throw new FarmException("ֻ������ύ״̬�ĵ���");
		}


	}

	@Override
	protected void _multiAudits(Context ctx, IObjectValue model)
	throws BOSException {
		BHatchBabyBillInfo billInfo = (BHatchBabyBillInfo)model;


		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new FarmException("�Ѿ��������ε��ݣ��������");
			}

			// ���µ���״̬
			AppCommon.updateModelStatus(ctx, "CT_FM_BHatchBabyBill", billInfo.getId().toString(), BillBaseStatusEnum.AUDITED);

		}else{
			throw new FarmException("ֻ������ύ״̬�ĵ���");
		}


	}

}
package com.kingdee.eas.custom.dep.app;

import java.math.BigDecimal;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.eas2wincos.interfaces.ExportPurInwarehouse;

import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.im.inv.PurInWarehsBillFactory;
import com.kingdee.eas.scm.im.inv.PurInWarehsBillInfo;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.util.NumericExceptionSubItem;

public class PurInWarehsBillControllerBeanDep {

	public void beforeDelete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		String fid = pk.toString();
		PurInWarehsBillInfo info = PurInWarehsBillFactory.getLocalInstance(ctx).getPurInWarehsBillInfo(pk);// by dai
		if(info.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据已经审核，禁止删除！"));
		}
		BigDecimal tempQty=new BigDecimal(0);
		String purcontractid = "";
		String purcontractbid = "";
		String purcontractaid = "";
		StringBuffer sql = new StringBuffer();
		String inWarid = "";
		if (info.get("InWarehs") != null) {
////			InWarehsDetailInfo info2 = (InWarehsDetailInfo)info.get("InWarehs");
//			tempQty=info2.getQty();
//			inWarid = info2.getId().toString();
//			sql = new StringBuffer();
//			sql.append(" delete CT_LHS_INWAREHSDETAILENTRY2 where CFPURINWAREHSID='" + fid + "' ");
//			com.kingdee.eas.util.app.DbUtil.execute(ctx, sql.toString());
//
////			PurContractJFacadeFactory.getLocalInstance(ctx).updateInWQtyA(fid, inWarid);
//			new PurContractJFacadeControllerBean().updateInWQtyA(ctx,fid, inWarid);

		} else {
			sql = new StringBuffer();
			sql.append(" delete CT_LHS_INWAREHSDETAILENTRY2 where CFPURINWAREHSID='" + fid + "' ");
			com.kingdee.eas.util.app.DbUtil.execute(ctx, sql.toString());
		}
		if (info.get("PurContract") != null) {
//			String pconinfoId = ((IPropertyContainer) info.get("PurContract")).getString("id");
//			PurContractAInfo pconinfo=PurContractAFactory.getLocalInstance(ctx).getPurContractAInfo(new ObjectUuidPK(pconinfoId));
//			purcontractid = pconinfo.getId().toString();
//			purcontractbid = pconinfo.getContractBID();
//			if (purcontractbid == null)
//				purcontractbid = "";
//			purcontractaid = pconinfo.getContractID();
//			if (purcontractaid == null)
//				purcontractaid = "";
		}
		if (!fid.equals("")) {
			tempQty=info.getEntry().get(0).getQty();
			reCompute(ctx, fid, purcontractid, purcontractbid, purcontractaid,tempQty);
		}

		if (info.get("InWarehs") != null) {
			fid = ((IPropertyContainer) info.get("InWarehs")).getString("id");// 发货明细id
			sql = new StringBuffer();
			sql.append(" update ct_lhs_inwarehsdetail set CFispurInWarehsBill=0, ");
			sql.append(" CFPurInWarehsBillID='' ");
			sql.append(" ,cfqtyb=cfqtyba,cfqtya=0");
			// sql.append(" where CFPurInWarehsBillID ='"+fid+"' ");//by dai
			sql.append(" where fid='" + fid + "'");// by dai
			com.kingdee.eas.util.app.DbUtil.execute(ctx, sql.toString());

			sql = new StringBuffer();
			sql.append(" delete ct_lhs_inwarehsdetailentry2 ");
			sql.append(" where CFPurInWarehsID ='" + fid + "' ");
			com.kingdee.eas.util.app.DbUtil.execute(ctx, sql.toString());

			sql = new StringBuffer();
			sql.append(" delete t_lhs_inventoryrpt ");
			sql.append(" where FID='" + fid + "' ");
			com.kingdee.eas.util.app.DbUtil.execute(ctx, sql.toString());
		}
	}

	public void afterUnAudit(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		PurInWarehsBillInfo info = PurInWarehsBillFactory.getLocalInstance(ctx).getPurInWarehsBillInfo(pk);
		StringBuffer sql = new StringBuffer();
		sql.append(" /*dialect*/ update T_IM_PurInWarehsBill ");
		sql.append(" set cfppersonid=''");
		sql.append(" where fid='" + info.getId().toString() + "'");
		com.kingdee.eas.util.app.DbUtil.execute(ctx, sql.toString());
	}

	public void reCompute(Context ctx, String fid, String contractid, String contractbid, String contractaid,BigDecimal qty)
			throws EASBizException, BOSException {
		
		// 删除本组织和本合同数据
		StringBuffer sql = new StringBuffer();
		sql.append(" delete t_lhs_inventoryrpt ");
		sql.append(" where FID='" + fid + "' ");
		com.kingdee.eas.util.app.DbUtil.execute(ctx, sql.toString());
		if (!contractid.equals("")) {

			// 插入本组织和本合同数据
			sql = new StringBuffer();
			sql.append(" insert into t_lhs_inventoryrpt( ");
			sql.append(" fid,fnumber,fdate,fcontrolunitid, ");
			sql.append(" fpurcontractid,fpurcontractbid,fpurcontractaid,");
			sql.append(" fsupplierid,FCarNumber,fmaterialid,");
			sql.append(" fqty,fqtya,fqtyb,fqtyin,fCarnumberA, ");
			sql.append(" fqtyc,fprice,famount, ");
			sql.append(" famounta,famountb ");
			sql.append(" ) ");
			sql.append(" select  ");
			sql.append(" t1.fid,t1.fnumber,t1.fbizdate,t1.fcontrolunitid,");
			sql.append(" t3.fid,t3.fcontractbid,t3.fcontractid,");
			sql.append(" t1.fsupplierid,upper(t1.CFCarNumber),t2.fmaterialid, ");
			sql.append(" 0,t2.fbaseqty,isnull(t1.cfqtyb,0),isnull(t1.cfqtyin,0),isnull(t1.CFCarNumberA,''), ");//
			sql.append(" 0,t2.fprice,t2.ftaxamount, ");
			sql.append(" 0,t2.ftaxamount ");
			sql.append(" from t_im_purinwarehsbill t1 ");
			sql.append(" inner join t_im_purinwarehsentry t2 on t2.fparentid=t1.fid ");
			sql.append(" inner join t_sm_purcontract t3 on t3.fid=t1.cfpurcontractid");
			sql.append(" where t1.FID='" + fid + "' ");
//			com.kingdee.eas.util.app.DbUtil.execute(ctx, sql.toString());

			sql = new StringBuffer();
			sql.append(" update t_lhs_inventoryrpt set fqtyin=fqtya ");
			sql.append(" where isnull(fqtyin,0)=0");
			com.kingdee.eas.util.app.DbUtil.execute(ctx, sql.toString());

			sql = new StringBuffer();
			sql.append(" update  ct_lhs_purcontractapurqty  set cfqtya=cfqtya-"+qty);
			sql.append(" ,cfqtyb=0 ");
			//sql.append(" update  ct_lhs_purcontractapurqty  set cfqtya=0,cfqtyb=0 ");
			sql.append(" where fparentid='" + contractid + "'");
			com.kingdee.eas.util.app.DbUtil.execute(ctx, sql.toString());

			// 更新公司合同
			sql = new StringBuffer();
			sql.append("update  ct_lhs_purcontractapurqty  t1 set (cfqtya,cfqtyb)=( ");
			sql.append(" select  t2.fqtya,t2.fqtyb from (  ");
			sql.append(" select fpurcontractid,fmaterialid ,sum(fqtya) fqtya,sum(fqtyb) fqtyb ");
			sql.append(" from t_lhs_inventoryrpt ");
			sql.append(" where fpurcontractid='" + contractid + "'");
			sql.append(" group by fpurcontractid,fmaterialid ");
			sql.append(" )as t2 where t2.fpurcontractid=t1.fparentid ");
			sql.append(" and t2.fmaterialid=t1.cfmaterialid");
			sql.append(" ) ");
			sql.append(" where t1.fparentid='" + contractid + "' ");
			com.kingdee.eas.util.app.DbUtil.execute(ctx, sql.toString());

			sql = new StringBuffer();
			sql.append(" update  ct_lhs_purcontractapurqty  set cfqtyc=cfqty-cfqtya-cfqtyb ");
			sql.append(" where fparentid='" + contractid + "'");
			com.kingdee.eas.util.app.DbUtil.execute(ctx, sql.toString());
		}
		if (!contractaid.equals("")) {
			sql = new StringBuffer();
			sql.append(" update  ct_lhs_purcontractapurqty  set cfqtya=cfqtya-"+qty);
			sql.append(" ,cfqtyb=0 ");
			//sql.append(" update  ct_lhs_purcontractapurqty  set cfqtya=0,cfqtyb=0 ");
			sql.append(" where fparentid='" + contractaid + "'");
			com.kingdee.eas.util.app.DbUtil.execute(ctx, sql.toString());

			// 更新商贸合同
			sql = new StringBuffer();
			sql.append(" update  ct_lhs_purcontractapurqty  t1 set (cfqtya,cfqtyb)=( ");
			sql.append(" select  t2.fqtya,t2.fqtyb from (  ");
			sql.append(" select fpurcontractaid,fmaterialid ,sum(fqtya) fqtya,sum(fqtyb) fqtyb ");
			sql.append(" from t_lhs_inventoryrpt ");
			sql.append(" where fpurcontractaid='" + contractaid + "'");
			sql.append(" group by fpurcontractaid,fmaterialid ");
			sql.append(" )as t2 where t2.fpurcontractaid=t1.fparentid ");
			sql.append(" and t2.fmaterialid=t1.cfmaterialid");
			sql.append(" ) ");
			sql.append(" where t1.fparentid='" + contractaid + "' ");
			com.kingdee.eas.util.app.DbUtil.execute(ctx, sql.toString());

			sql = new StringBuffer();
			sql.append(" update  ct_lhs_purcontractapurqty  set cfqtyc=cfqty-(cfqtya+cfqtyb)");
			sql.append(" where fparentid='" + contractaid + "'");
			com.kingdee.eas.util.app.DbUtil.execute(ctx, sql.toString());

		}

	}
	/**
	 * add by dai 20150709
	 */
	public void afterAudit(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		try {
			PurInWarehsBillInfo info = PurInWarehsBillFactory.getLocalInstance(ctx).getPurInWarehsBillInfo(pk);
			ExportPurInwarehouse ep = new ExportPurInwarehouse();
			ep.export2WinCosByID(ctx, info.getStorageOrgUnit().getString("id"), pk.toString());;
		}catch(Exception ee) {
			ee.printStackTrace();
		}
	}


	public void afterPassAudit(Context ctx, IObjectPK pk, IObjectValue model) throws EASBizException, BOSException {
		// TODO Auto-generated method stub
//		try {
//			PurInWarehsBillInfo info = PurInWarehsBillFactory.getLocalInstance(ctx).getPurInWarehsBillInfo(pk);
//			ExportPurInwarehouse ep = new ExportPurInwarehouse();
//			ep.export2WinCosByID(ctx, info.getStorageOrgUnit().getString("id"), pk.toString());;
//		}catch(Exception ee) {
//			ee.printStackTrace();
//		}
	}


}

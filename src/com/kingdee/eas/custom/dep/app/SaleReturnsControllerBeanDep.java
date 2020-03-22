package com.kingdee.eas.custom.dep.app;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.assistant.PeriodFactory;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.scm.sd.sale.SaleReturnsFactory;
import com.kingdee.eas.scm.sd.sale.SaleReturnsInfo;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class SaleReturnsControllerBeanDep  {

	public void afterAudit(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
//		try {
//			String ficompanyid = ContextUtil.getCurrentFIUnit(ctx).getId().toString();
//			SaleReturnsInfo so = SaleReturnsFactory.getLocalInstance(ctx).getSaleReturnsInfo(pk);
//			if (so.getBigDecimal("disamount") == null)
//				so.setBigDecimal("disamount", BigDecimal.ZERO);
//			SaleReturnsFactory.getLocalInstance(ctx).update(new ObjectUuidPK(so.getId().toString()), so);
//
//			// 得到订单业务日期的会计期间
//			PeriodInfo po = null;
//			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//			java.util.Date FBizDate = so.getBizDate();
//			String date = format.format(FBizDate);
//			int year = Integer.parseInt(date.substring(0, 4));
//			int month = Integer.parseInt(date.substring(5, 7));
//			String customid = so.getReturnsCustomer().getId().toString();
//			IRowSet rr = com.kingdee.eas.custom.xszr.CalUtilFacadeFactory.getLocalInstance(ctx).getSqlData(
//					"select fid from t_bd_period where fperiodyear=" + year + " and fPeriodnumber=" + month);
//			if (rr.next()) {
//				ObjectUuidPK pp = new ObjectUuidPK(rr.getString("fid"));
//				po = PeriodFactory.getLocalInstance(ctx).getPeriodInfo(pp);
//			} else {
//				// MsgBox.info("提示", "没有会计期间", this);
//				SysUtil.abort();
//			}
//
//			// 更新即时折让资料
//			StringBuffer b = new StringBuffer();
//			b.append("select fid from CT_XSZ_Jszr where CFcustomerID='");
//			b.append(customid + "' and cfficompanyid='");
//			b.append(ficompanyid + "'");
//			BigDecimal bqzf = new BigDecimal(0);
//			BigDecimal bqqc = new BigDecimal(0);
//			IRowSet rb = com.kingdee.eas.custom.xszr.CalUtilFacadeFactory.getLocalInstance(ctx).getSqlData(b.toString());
//			if (rb.next()) {
//				bqzf=so.getBigDecimal("disamount");
//				b=new StringBuffer();
//				b.append(" /*dialect*/ update CT_XSZ_Jszr set cfbqzf=cfbqzf-"+bqzf);
//				b.append(" where fid='"+rb.getString("fid")+"'");
//				com.kingdee.eas.util.app.DbUtil.execute(ctx, b.toString());
//				
//				b=new StringBuffer();
//				b.append(" /*dialect*/ update CT_XSZ_Jszr set cfzrye=cfbqqc-cfbqzf ");
//				b.append(" where fid='"+rb.getString("fid")+"'");
//				com.kingdee.eas.util.app.DbUtil.execute(ctx, b.toString());
//				
//				
//			}
//		} catch (EASBizException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public void afterUnAudit(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
//		try {
//			String ficompanyid = ContextUtil.getCurrentFIUnit(ctx).getId().toString();
//			SaleReturnsInfo so = SaleReturnsFactory.getLocalInstance(ctx).getSaleReturnsInfo(pk);
//			String customid = so.getReturnsCustomer().getId().toString();
//			if (so.getBigDecimal("disamount") == null)
//				so.setBigDecimal("disamount", BigDecimal.ZERO);
//
//			// 更新即时折让资料
//			
//			StringBuffer b = new StringBuffer();
//			BigDecimal bqzf = new BigDecimal(0);
//			b.append("select fid from CT_xsz_jszr where CFcustomerID='");
//			b.append(customid + "' and cfficompanyid='");
//			b.append(ficompanyid + "'");
//			IRowSet rb = com.kingdee.eas.custom.xszr.CalUtilFacadeFactory.getLocalInstance(ctx).getSqlData(b.toString());
//			if (rb.next()) {
//				bqzf=so.getBigDecimal("disamount");
//				b=new StringBuffer();
//				b.append(" /*dialect*/ update CT_XSZ_Jszr set cfbqzf=cfbqzf+"+bqzf);
//				b.append(" where fid='"+rb.getString("fid")+"'");
//				com.kingdee.eas.util.app.DbUtil.execute(ctx, b.toString());
//				
//				b=new StringBuffer();
//				b.append(" /*dialect*/ update CT_XSZ_Jszr set cfzrye=cfbqqc-cfbqzf ");
//				b.append(" where fid='"+rb.getString("fid")+"'");
//				com.kingdee.eas.util.app.DbUtil.execute(ctx, b.toString());
//				
////				ObjectUuidPK pc = new ObjectUuidPK(rb.getString("fid"));
////				JszrInfo jszr = JszrFactory.getLocalInstance(ctx).getJszrInfo(pc);
////				if (jszr.getBqzf() == null)
////					jszr.setBqzf(new BigDecimal(0));
////				if (jszr.getZrye() == null)
////					jszr.setZrye(new BigDecimal(0));
////				if (jszr.getBqqc() == null)
////					jszr.setBqqc(new BigDecimal(0));
////				bqzf = so.getDisamount();
////				jszr.setBqzf(jszr.getBqzf().add(bqzf));
////				jszr.setZrye(jszr.getBqqc().subtract(jszr.getBqzf()));
////				JszrFactory.getLocalInstance(ctx).update(pc, jszr);
//			}
//		} catch (EASBizException e) {
//			// TODO Auto-generated catch block
//			throw new BOSException("",e);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			throw new BOSException("",e);
//		}
	}
}

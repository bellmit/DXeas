package com.kingdee.eas.scm.sd.sale.app;


public class SaleReturnsControllerBeanEx extends com.kingdee.eas.scm.sd.sale.app.SaleReturnsControllerBean {

	
	private static final long serialVersionUID = -391062358700105546L;
//
//	
//	protected IObjectPK _submit(Context arg0, IObjectValue arg1) throws BOSException, EASBizException {
//		// TODO Auto-generated method stub
//		return super._submit(arg0, arg1);
//	}
//
//	protected void _audit(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
//		super._audit(ctx, pk);
//		try {
//			String ficompanyid = ContextUtil.getCurrentFIUnit(ctx).getId().toString();
//			SaleReturnsInfo so = SaleReturnsFactory.getLocalInstance(ctx).getSaleReturnsInfo(pk);
//			if (so.getDisamount() == null)
//				so.setDisamount(new BigDecimal(0));
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
//				bqzf=so.getDisamount();
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
////				ObjectUuidPK pc = new ObjectUuidPK(rb.getString("fid"));
////				JszrInfo jszr = JszrFactory.getLocalInstance(ctx).getJszrInfo(pc);
////				bqzf = so.getDisamount();
////				if (jszr.getBqzf() == null)
////					jszr.setBqzf(new BigDecimal(0));
////				if (jszr.getBqqc() != null)
////					bqqc = jszr.getBqqc();
////				jszr.setBqzf(jszr.getBqzf().subtract(bqzf));// 本次支付
////				jszr.setZrye(bqqc.subtract(jszr.getBqzf()));// 本期结余、即时余额
////				JszrFactory.getLocalInstance(ctx).update(pc, jszr);
//			}
//		} catch (EASBizException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	protected void _unAudit(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
//		// TODO Auto-generated method stub
//		super._unAudit(ctx, pk);
//		try {
//			String ficompanyid = ContextUtil.getCurrentFIUnit(ctx).getId().toString();
//			SaleReturnsInfo so = SaleReturnsFactory.getLocalInstance(ctx).getSaleReturnsInfo(pk);
//			String customid = so.getReturnsCustomer().getId().toString();
//			if (so.getDisamount() == null)
//				so.setDisamount(new BigDecimal(0));
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
//				bqzf=so.getDisamount();
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
//	}
}

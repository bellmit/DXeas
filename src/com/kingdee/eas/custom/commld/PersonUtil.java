package com.kingdee.eas.custom.commld;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.org.PositionFactory;
import com.kingdee.eas.basedata.org.PositionHierarchy;
import com.kingdee.eas.basedata.org.PositionHierarchyCollection;
import com.kingdee.eas.basedata.org.PositionHierarchyFactory;
import com.kingdee.eas.basedata.org.PositionHierarchyInfo;
import com.kingdee.eas.basedata.org.PositionInfo;
import com.kingdee.eas.basedata.org.PositionMember;
import com.kingdee.eas.basedata.org.PositionMemberFactory;
import com.kingdee.eas.basedata.org.PositionMemberInfo;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.hr.emp.PersonPositionFactory;
import com.kingdee.eas.hr.emp.PersonPositionInfo;

public class PersonUtil {

	/**
	 * ����Ա����info����id��ȡֻҪְλ
	 * @param obj
	 * @return
	 */
	public static PositionInfo getPersonPositionByPerson(Context ctx,Object obj){
		String PersonId="";
		if(obj==null){
			System.out.println("����Ϊ��");
			return null;
		}
		if(obj instanceof String)
			PersonId=(String)obj;
		if(obj instanceof PersonInfo)
			PersonId=((PersonInfo)obj).getId().toString();

		try {
			CoreBaseCollection coll;
			if(ctx==null)
				coll = PositionMemberFactory.getRemoteInstance().getCollection("where person='"+PersonId+"' and IsPrimary=1");
			else
				coll = PositionMemberFactory.getLocalInstance(ctx).getCollection("where person='"+PersonId+"' and IsPrimary=1");
			if(coll.size()>1){
				System.out.println("������ʷ��¼\\(�R���Q)/");
				return null;
			}

			if(coll.size()==1){
				PositionMemberInfo info=(PositionMemberInfo) coll.get(0);
				if(info.getPosition().getId()!=null){
					if(ctx==null)
						return PositionFactory.getRemoteInstance().getPositionInfo(new ObjectUuidPK(info.getPosition().getId().toString()));
					else
						return PositionFactory.getLocalInstance(ctx).getPositionInfo(new ObjectUuidPK(info.getPosition().getId().toString()));
				}
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ���ĳ��Ա��ֱ���ϼ���֯
	 */
	public static PositionInfo getDirectUpperPositionByPerson(Context ctx,Object obj){
		PositionInfo childPosition = getPersonPositionByPerson(ctx, obj);
		if(childPosition==null)
			return null;
		PositionHierarchyCollection coll;
		try {
			if(ctx==null)
				coll=PositionHierarchyFactory.getRemoteInstance().getPositionHierarchyCollection("where child='"+childPosition.getId().toString()+"'");
			else
				coll=PositionHierarchyFactory.getLocalInstance(ctx).getPositionHierarchyCollection("where child='"+childPosition.getId().toString()+"'");
			if(coll.size()>0){
				String positionID = ((PositionHierarchyInfo)coll.get(0)).getParent().getId().toString();
				if(ctx==null)
					return PositionFactory.getRemoteInstance().getPositionInfo(new ObjectUuidPK(positionID));
				else
					PositionFactory.getLocalInstance(ctx).getPositionInfo(new ObjectUuidPK(positionID));
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

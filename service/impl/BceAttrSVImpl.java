package huangwf5.service.impl;

import huangwf5.dao.interfaces.IBceAttrDAO;
import huangwf5.service.interfaces.IBceAttrSV;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.crm.so.order.dsmp.pcestudio.bo.BOUpItemRelatBean;
import com.asiainfo.crm.so.order.dsmp.pcestudio.bo.BOUpPlanProdRelBean;
import com.asiainfo.crm.so.order.dsmp.pcestudio.bo.BOUpProductItemBean;

public class BceAttrSVImpl implements IBceAttrSV {

	@Override
	public BOUpProductItemBean[] getProductItemByCreaterAndItemType(
			String creater, String itemType) {
		IBceAttrDAO bceAttrDao=(IBceAttrDAO)ServiceFactory.getService(IBceAttrDAO.class);
		BOUpProductItemBean[] b=null;
		try {
			b=bceAttrDao.getProductItemByCreaterAndItemType(creater, itemType);
		} catch (Exception e) {
	 		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return b;
   }

	@Override
	public BOUpItemRelatBean[] getUpItemRelatByKindAndRelatProductItemIdAndDelFlag(
			String prodItemRelatKindId, String relatProductItemId, String delFlag)
			throws Exception {
		IBceAttrDAO bceAttrDao=(IBceAttrDAO)ServiceFactory.getService(IBceAttrDAO.class);
		BOUpItemRelatBean[] b=null;
		b=bceAttrDao.getUpItemRelatByKindAndRelatProductItemIdAndDelFlag(prodItemRelatKindId, relatProductItemId, delFlag);
		return b;
	}

	@Override
	public BOUpItemRelatBean[] getUpItemRelatByKind$ProductItemId$DelFlag(
			String prodItemRelatKindId, String productItemId, String delFlag) {
		IBceAttrDAO bceAttrDao=(IBceAttrDAO)ServiceFactory.getService(IBceAttrDAO.class);
		BOUpItemRelatBean[] b=null;
		try {
			b=bceAttrDao.getUpItemRelatByKind$ProductItemId$DelFlag(prodItemRelatKindId, productItemId, delFlag);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public BOUpProductItemBean[] getAllAttr(String offerId) {
		List<BOUpProductItemBean> attrList=new ArrayList<BOUpProductItemBean>();
		IBceAttrDAO bceAttrDao=(IBceAttrDAO)ServiceFactory.getService(IBceAttrDAO.class);
		//根据OfferId获取角色
		BOUpItemRelatBean[] roleRels=getUpItemRelatByKind$ProductItemId$DelFlag("OFFER_PLAN_GENERAL_SPEC_ROLE",offerId,null);
		//此处打印输出角色
		for(int i=0;i<roleRels.length;i++){
			System.out.println(roleRels[i]);
		}
		try {
			for(int i=0;i<roleRels.length;i++){//获取角色下的产品
				BOUpPlanProdRelBean[] planProdRelBeans=bceAttrDao.getUpPlanProdBeanByProductItemId$attrF$delFlag(offerId, roleRels[i].getRelatProductItemId()+"", null);
			    for(int j=0;j<planProdRelBeans.length;j++){//获取产品下的服务
			    	BOUpItemRelatBean[] services= getUpItemRelatByKind$ProductItemId$DelFlag("SRVC_SINGLE_PRICE_SERVICE", planProdRelBeans[j].getRelatProductItemId()+"", "1");
			    	for(int z=0;z<services.length;z++){//获取服务下的属性
			    		BOUpItemRelatBean[] attrs=getUpItemRelatByKind$ProductItemId$DelFlag(null,services[z].getRelatProductItemId()+"","1");
			    		for(int k=0;k<attrs.length;k++){
			    			BOUpProductItemBean[] b=bceAttrDao.getProductItemByProductItemId(attrs[k].getRelatProductItemId()+"");
			    			if(null!=b&&b.length>0){
			    				for(int m =0;m<b.length;m++){
			    					System.out.println(b[m].getName());
			    					attrList.add(b[m]);
			    				}
			    			}
			    		}
			    		
			    	}
			    }
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BOUpProductItemBean[] beans=new BOUpProductItemBean[attrList.size()];
		beans=attrList.toArray(new BOUpProductItemBean[attrList.size()]);
		//IBOSsmQuestionValue[] delValues = (IBOSsmQuestionValue[]) li.toArray(new IBOSsmQuestionValue[li.size()]);
		System.out.println("attrList.size()="+attrList.size());
		Set set=new HashSet();
		for(int t=0;t<attrList.size();t++){
			set.add(attrList.get(t).getProductItemId());
		}
		System.out.println("set.size():"+set.size());
		
		
		return beans;
	}
	
	public static void main(String[] args) {
		IBceAttrSV sv=(IBceAttrSV)ServiceFactory.getService(IBceAttrSV.class);
		sv.getAllAttr(211206019561L+"");
	}
	

}

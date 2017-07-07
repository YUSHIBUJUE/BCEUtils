package huangwf5.action;

import huangwf5.service.interfaces.IBceAttrSV;
import huangwf5.utils.IBceStatic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.pce.service.interfaces.IProductFSV;
import com.asiainfo.appframe.ext.flyingserver.org.apache.commons.lang.StringUtils;
import com.asiainfo.crm.so.order.dsmp.pcestudio.bo.BOUpItemRelatBean;
import com.asiainfo.crm.so.order.dsmp.pcestudio.bo.BOUpProductItemBean;

public class BceAttrAction {

	public BOUpProductItemBean[] getProductItemByCreaterAndItemType(
			String creater, String itemType){
		IBceAttrSV sv=(IBceAttrSV)ServiceFactory.getService(IBceAttrSV.class);
		BOUpProductItemBean[] b=sv.getProductItemByCreaterAndItemType(creater, itemType);	
		return  b;	
	}
	/*
	insert into base.bce_attr (ATTR_ID, MODULE_ID, OBJ_NAME, ATTR_CODE, ATTR_NAME, I18N_RES, FIELD_TYPE, FIELD_WIDTH, COL_SPAN, IS_NULLABLE, FIELD_HEIGHT, IS_MULTIVALUEABLE, EDIT_TYPE, MAX_LENGTH, RES_SRC, RES_PARAM, DEFAULT_VALUE, MUTI_FLAG, VALUE_CLASS, RULE_ID, REMARKS, STATE, REGION_ID, EFF_TYPE)
	values (152120021001, 1, 'frmProductAttr', '200011800', '���Ź���Ա����', '', 'VARCHAR2(100)', '', null, 1, '', null, 2, null, '', '', '', null, '', '', '���Ź���Ա����', 1, '', null);
 */
	public void getBceAttr(String creater, String itemType){//"20140325003", "ATTRIBUTE"
		List<String> list=new ArrayList<String>();
		BOUpProductItemBean[] b=getProductItemByCreaterAndItemType(creater, itemType);	
		String sqlSingle="";
		for(int i=0;i<=b.length-1;i++){
			sqlSingle="";
			sqlSingle=IBceStatic.BCE_ATTR_INSERT;
			sqlSingle+=b[i].getProductItemId()+","+1+",'frmProductAttr'"+",'"+b[i].getCode()+"','"+b[i].getName()+"','','VARCHAR2(100)','',null,1,'',null,2,null,'','','',null,'','','"+b[i].getName()+"',1,'',null);\n";
			System.out.println(sqlSingle);
		}
	}
	
	//version2.1
	public List getBceAttrV2_1(String offerId){
    	List<String> list=new ArrayList<String>();
    	IBceAttrSV bceSV=(IBceAttrSV)ServiceFactory.getService(IBceAttrSV.class);
    	BOUpProductItemBean[] b=bceSV.getAllAttr(offerId);
    	String sqlSingle="";
		for(int i=0;i<=b.length-1;i++){
			sqlSingle="";
			sqlSingle=IBceStatic.BCE_ATTR_INSERT;
			sqlSingle+=b[i].getProductItemId()+","+1+",'frmProductAttr'"+",'"+b[i].getCode()+"','"+b[i].getName()+"','','VARCHAR2(100)','',null,1,'',null,2,null,'','','',null,'','','"+b[i].getName()+"',1,'',null);\n";
			//System.out.println(sqlSingle);
			list.add(sqlSingle);
		}
		return list;
	}
	/*
	 insert into base.bce_frame_attr (ATTR_ID, BCE_FRAME_ID, FORM_ID, MODULE_ID, GROUP_ID, IS_VISIBLE, IS_EDITABLE, FIELD_HEIGHT, FIELD_WIDTH, COL_SPAN, IS_NULLABLE, EDIT_TYPE, MAX_LENGTH, RES_SRC, RES_PARAM, DEFAULT_VALUE, VALUE_CLASS, IS_VALIDATE, SEQ_NO, IS_LOG, EXT_1, EXT_2, EXT_3, STATE, IS_MULTIVALUEABLE, ATTR_NAME, I18N_RES, MUTI_FLAG, REGION_ID, EFF_TYPE)
	 values (152120021001, 888888901995, 'frmProductAttr', 1, null, 1, 1, '', '', null, 1, 2, null, '', '', '', '', null, null, null, '', '', null, 1, null, '���Ź���Ա����', '', null, '', null);

	 */
    public void getBceFrameAttr(String creater,String itemType,String bceFrameId){
    	List<String> list=new ArrayList<String>();
    	BOUpProductItemBean[] b=getProductItemByCreaterAndItemType(creater, itemType);	
    	String sqlSingle="";
    	for(int j=0;j<=b.length-1;j++){
    		sqlSingle=""; 
    		sqlSingle=IBceStatic.BCE_FRAME_ATTR_INSERT;
    		sqlSingle+=b[j].getProductItemId()+","+bceFrameId+",'frmProductAttr',1,null,1,1,'','',null,1,2,null,'','','','',null,null,null,'','',null,1,null,'"+b[j].getName()+"','',null,'',null);\n";
    		System.out.println(sqlSingle);
    	}
    	
    }
    //version2.1
    public List getBceFrameAttrV2_1(String offerId,String bceFrameId){
    	List list =new ArrayList();
    	IBceAttrSV bceSV=(IBceAttrSV)ServiceFactory.getService(IBceAttrSV.class);
    	BOUpProductItemBean[] b=bceSV.getAllAttr(offerId);
    	String sqlSingle="";
    	for(int j=0;j<=b.length-1;j++){
    		sqlSingle=""; 
    		sqlSingle=IBceStatic.BCE_FRAME_ATTR_INSERT;
    		sqlSingle+=b[j].getProductItemId()+","+bceFrameId+",'frmProductAttr',1,null,1,1,'','',null,1,2,null,'','','','',null,null,null,'','',null,1,null,'"+b[j].getName()+"','',null,'',null);\n";
    		//System.out.println(sqlSingle);
    		list.add(sqlSingle);
    	}
    	return list;
    }
    /*
     * creater:�ֶ�����
     * itemType:�ֶ����룬���ݲ�Ʒ���ø���Ʒ��Ԫ�������������
     * beginSerialId:s max(beginSerialId)+1 f product.up_all_net_conf ;
     * serviceId:����id������������ԣ�������"null",v2.0�汾�������null���ɣ����ԵĻ���ȥ����Ӧ�ķ���id����
     * allnetType:�ֶ�����
     * planId:�ֶ�����߻�id
     * notes:�ֶ�����˵��
     * 
     */
    public List getUpAllNetConf(String creater,String itemType,long beginSerialId,String serviceId,String allNetType,String planId,String notes){
    	List resultList=new ArrayList();
    	IProductFSV psv=(IProductFSV)ServiceFactory.getService(IProductFSV.class);
    	IBceAttrSV bceSV=(IBceAttrSV)ServiceFactory.getService(IBceAttrSV.class);
    	BOUpItemRelatBean[]  upItemRelat=null;
    	//IItemRelatValue[] itemRelatServic=e=psv.getItemRelatByRelatItemIdAndRelatKind(relatItemId, "SERVICE_GENERAL_ATTRIBUTE_SINGLE");//attr_id,kind  �õ�����id
    	BOUpProductItemBean[] b=getProductItemByCreaterAndItemType(creater, allNetType);	
    	String sqlSingle="";
    	for(int i=0;i<b.length;i++){
    		sqlSingle="";
    		sqlSingle=IBceStatic.UP_ALL_NET_CONF_INSERT;
    		if(itemType.equals("ATTRIBUTE_SINGLE")){//�ж��Ƿ������ԣ���������ѯ�������Զ�Ӧ�ķ���id serviceId
    			try {
    				upItemRelat=bceSV.getUpItemRelatByKindAndRelatProductItemIdAndDelFlag("SERVICE_GENERAL_ATTRIBUTE_SINGLE", b[i].getProductItemId()+"", "1");
    				if(null!=upItemRelat&&upItemRelat.length>0){
    					serviceId=upItemRelat[0].getProductItemId()+"";
    				}
				} catch (Exception e) {
					e.printStackTrace();
				}
    		}
    		sqlSingle+=beginSerialId+","+serviceId+","+b[i].getProductItemId()+",'"+b[i].getName()+"','"+itemType+"','"+allNetType+"','"+b[i].getCode()+"',"+planId+",'"+notes+"','1'"+",'','','','');\n";
    		resultList.add(sqlSingle);
    		//System.out.println(sqlSingle);
    		beginSerialId++;
    		
    		
    	}
    	return resultList;
    }

    //version2.1
	public List getUpAllNetConfV2_1(String offerId,String creater,String itemType,long beginSerialId,String serviceId,String allNetType,String planId,String notes){
		List resultList=new ArrayList();
    	IProductFSV psv=(IProductFSV)ServiceFactory.getService(IProductFSV.class);
    	IBceAttrSV bceSV=(IBceAttrSV)ServiceFactory.getService(IBceAttrSV.class);
    	BOUpItemRelatBean[]  upItemRelat=null;
    	//IItemRelatValue[] itemRelatServic=e=psv.getItemRelatByRelatItemIdAndRelatKind(relatItemId, "SERVICE_GENERAL_ATTRIBUTE_SINGLE");//attr_id,kind  �õ�����id
    	BOUpProductItemBean[] b=bceSV.getAllAttr(offerId);
    	String sqlSingle="";
    	for(int i=0;i<b.length;i++){
    		sqlSingle="";
    		sqlSingle=IBceStatic.UP_ALL_NET_CONF_INSERT;
    		if(itemType.equals("ATTRIBUTE_SINGLE")){//�ж��Ƿ������ԣ���������ѯ�������Զ�Ӧ�ķ���id serviceId
    			try {
    				upItemRelat=bceSV.getUpItemRelatByKindAndRelatProductItemIdAndDelFlag("SERVICE_GENERAL_ATTRIBUTE_SINGLE", b[i].getProductItemId()+"", "1");
    				if(null!=upItemRelat&&upItemRelat.length>0){
    					serviceId=upItemRelat[0].getProductItemId()+"";
    				}
				} catch (Exception e) {
					e.printStackTrace();
				}
    		}
    		sqlSingle+=beginSerialId+","+serviceId+","+b[i].getProductItemId()+",'"+b[i].getName()+"','"+itemType+"','"+allNetType+"','"+b[i].getCode()+"',"+planId+",'"+notes+"','1'"+",'','','','');\n";
    		resultList.add(sqlSingle);
    		//System.out.println(sqlSingle);
    		beginSerialId++;
    		
    		
    	}
    	return resultList;
	}
	
	public static void main(String[] args) {
		List list=new ArrayList();
		BceAttrAction a=new BceAttrAction();
		BOUpProductItemBean[] b=null;
		//a.getBceAttr("201610120119", "ATTRIBUTE");
		//a.getBceFrameAttr("201610120119", "ATTRIBUTE","888888895599");//creater,item_type,bce_frame_Id
		list=a.getUpAllNetConf("2016122201", "ATTRIBUTE_SINGLE", 170000000132l, null, "ATTRIBUTE", "211206020022", "VoLTE����ͨ��[ƽ̨��Ʒ����]");
		for(int i=0;i<=list.size()-1;i++){
			System.out.println(list.get(i));
		}
		//System.out.println("list.size()="+list.size());
		
		//version2.1�����汾  1����ȡbce_attr
		//list=a.getBceAttrV2_1(211206020022L+"");
		// for(int k=0;k<list.size();k++){
		//	 System.out.println(list.get(k));
		// }
		 
		 //version2.1�����汾  2����ȡbce_frame_attr 
		//list=a.getBceFrameAttrV2_1(211206020022L+"","888888895790");
		//for(int k=0;k<list.size();k++){
		//	 System.out.println(list.get(k));
		// }
		 
		 
		
	}
	
}
/*
 * �������ͨ������base.bce_attr_hwf��ͨ��oracle����Ȼ��д��between���Ļ������
 * base.bce_attr
 * base.bce_frame_attr��������
 */










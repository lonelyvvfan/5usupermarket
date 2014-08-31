package cs.action.admin;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.struts2.ServletActionContext;


import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.NEW;

import cs.entity.GoodsCount;
import cs.entity.Order;
import cs.entity.Order_detail;
import cs.entity.Turnover;
import cs.service.AdminService;
import cs.service.OrderService;
import cs.service.PagingService;
import cs.vo.PageModel;

public class OrdermanageAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private int id;
	private Integer orderNo;// 订单序列号
	private String arrivedday;// 到达日期
	private String arrivedtime;// 送达时间
	private double totalamount;// 最终金额
	private String username;// 用户名
	private String truename;// 真实姓名
	private String telephone;// 联系电话
	private String school;// 学校
	private String doorplate;// 寝室楼号
	private String room;// 寝室号
	private String remark;// 备注
	private String payway;// 支付方式
	private Integer isclosed;// 订单状态
	private String orderday;  //开始日期
	private String orderday1;  //截止日期
	private String startdate;  //截止日期
	private String enddate;		//截止日期
	private String goodsname;//商品名
	
	/* 订单详情 */
	private Integer id_detail;
	private Integer orderid;	//订单id	
	private Integer goodsid; 	//商品id
	private double price;		//商品单价
	private Integer number; 	//商品数量
	
	private PageModel orderpage = new PageModel();
	private List<GoodsCount> goodscountpage;
	private List<Turnover> turnoverpage;
	private PagingService pagingService;
	private Integer pagesize = 20;
	private Order order;
	private List<Order> list = new ArrayList<Order>();
	private List<Order_detail> list_detail = new ArrayList<Order_detail>();
	private List<Order_detail> list_detail1 = new ArrayList<Order_detail>();
	private List<Order_detail> goodscountlist = new ArrayList<Order_detail>();
	private AdminService adminService;
	private OrderService orderService;
	private int[] checkbox;
	private HttpServletResponse response;
	
	public String showorder() throws Exception {
		System.out.print("order");
		// 分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
		String phql = "from Order order by id desc";
		// this.pageBean = pagingService.queryForPage(phql,2, page);
		System.out.println(phql);
		if ((Object) orderpage.getCurrentPage() == null)
			orderpage.setCurrentPage(1);
		username = null;
		orderpage = pagingService.queryforpage(phql, pagesize,
				orderpage.getCurrentPage(), username);
		List<Integer> list1 = new ArrayList<Integer>();
		for (Integer i = orderpage.getCurrentPage() - 5; i <= orderpage
				.getCurrentPage() + 5; i++) {
			if (i <= 0 || i > orderpage.getTotalPage())
				continue;
			list1.add(i);
		}
		orderpage.setPageList(list1);
		return "order";

	}
	
	public String deletecheckbox() throws Exception{
		String[] arr =(String [])ActionContext.getContext().getParameters().get("checkbox");
		System.out.println("checkbox  = " + arr);
		 if(arr!=null)
		 {
		     int[] arrId = new int[arr.length];
		     for (int i = 0; i < arr.length; i++) {
		         arrId[i] = Integer.parseInt(arr[i]);
		         }       
		boolean reslut = false;
		reslut = adminService.deletecheckboxorder(checkbox);
		if(reslut)
		{
			System.out.println("return success");
		return "success";
		}
		else {
			System.out.println("return success");
			return "failure";
		}
		 }
		 else
			 return "failure";
	}	
	
	public String upjia() throws Exception{
		String[] arr =(String [])ActionContext.getContext().getParameters().get("checkbox");
		System.out.println("checkbox  = " + arr);
		 if(arr!=null)
		 {
		     int[] arrId = new int[arr.length];
		     for (int i = 0; i < arr.length; i++) {
		         arrId[i] = Integer.parseInt(arr[i]);
		         }       
		boolean reslut = false;
		reslut = adminService.orderupjia(checkbox);
		if(reslut)
		{
			System.out.println("return success");
		return "success";
		}
		else {
			System.out.println("return success");
			return "failure";
		}
		 }
		 else
			 return "failure";
	}
	
	
	public String downjia() throws Exception{
		String[] arr =(String [])ActionContext.getContext().getParameters().get("checkbox");
		System.out.println("checkbox  = " + arr);
		 if(arr!=null)
		 {
		     int[] arrId = new int[arr.length];
		     for (int i = 0; i < arr.length; i++) {
		         arrId[i] = Integer.parseInt(arr[i]);
		         }       
		boolean reslut = false;
		reslut = adminService.orderdownjia(checkbox);
		if(reslut)
		{
			System.out.println("return success");
		return "success";
		}
		else {
			System.out.println("return success");
			return "failure";
		}
		 }
		 else
			 return "failure";
	}

	public String toexcel() throws Exception{
		String[] arr =(String [])ActionContext.getContext().getParameters().get("checkbox");
		System.out.println("checkbox  = " + arr);
		 if(arr!=null)
		 {
		     int[] arrId = new int[arr.length];
		     for (int i = 0; i < arr.length; i++) {
		         arrId[i] = Integer.parseInt(arr[i]);
		         }       
		boolean reslut = false;
		
		
		String []tableHeader={"订单号","商品名称","商品单价","数量(件)","最终金额(元)","支付方式","送货时间","地址","备注","用户名","真实姓名","联系电话"};
		short cellNumber=(short)tableHeader.length;//表的列数 
		HSSFWorkbook workbook = new HSSFWorkbook();	//创建一个excel 
		HSSFCell cell = null;	//Excel的列 
		HSSFRow row = null;	//Excel的行 
		HSSFCellStyle style = workbook.createCellStyle();	//设置表头的类型 
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); 
		HSSFCellStyle style1 = workbook.createCellStyle();	//设置数据类型 
		style1.setAlignment(HSSFCellStyle.ALIGN_CENTER); 
		HSSFFont font = workbook.createFont();	//设置字体 
		HSSFSheet sheet = workbook.createSheet("sheet1");	//创建一个sheet 
		HSSFHeader header = sheet.getHeader();//设置sheet的头 
		style.setWrapText(true);
		row = sheet.createRow((short)0);
		cell = row.createCell(0);
		cell.setCellStyle(style);
		try {              /** 
             *根据是否取出数据，设置header信息 
             * 
             */ 
			if(checkbox.length < 1 ){ 
				header.setCenter("查无资料"); 
			}else{ 
				header.setCenter("订单"); 
				row = sheet.createRow(0); 
				row.setHeight((short)400); 
				for(int k = 0;k < cellNumber;k++){	
					cell = row.createCell(k);//创建第0行第k列 
					cell.setCellValue(tableHeader[k]);//设置第0行第k列的值 
					if(k!=1&&k!=7){
						sheet.setColumnWidth(k,8000);//设置列的宽度 
					}else{
						sheet.setColumnWidth(k, 15000);
					}
					font.setColor(HSSFFont.COLOR_NORMAL); // 设置单元格字体的颜色. 
					font.setFontHeight((short)350); //设置单元字体高度 
					style1.setFont(font);//设置字体风格 
					cell.setCellStyle(style1); 
				}
			for(int i=0;i<checkbox.length;i++){
				String s1 = "";
				String s2 = "";
				String s3 = "";
				order = adminService.findorderbyid(checkbox[i]);
				System.out.println(order.getOrderNo());
				System.out.println(order.getArrivedday());
				int orderno = order.getOrderNo();
				list_detail = adminService.findorderdetailbyid(checkbox[i]);
				for(int j=0;j<list_detail.size();j++){
					int k = j+1;
					s1 = s1 + k + "、" + list_detail.get(j).getGoodsname() + "\n";
					s2 = s2 + k + "、" + list_detail.get(j).getPrice() + "元每件\n";
					s3 = s3 + list_detail.get(j).getNumber() + "\n";
				}
				row = sheet.createRow((short) (i + 1));//创建第i+1行 
				short n = (short)list_detail.size();
				row.setHeight((short) ((short)300*n));//设置行高 
				style.setAlignment(CellStyle.ALIGN_CENTER);
				style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
				
				
				cell = row.createCell(0);//创建第i+1行第0列 
			    cell.setCellValue(order.getOrderNo());//设置第i+1行第0列的值 
			    cell.setCellStyle(style);//设置风格 
				
				
				
					cell = row.createCell(1);//创建第i+1行第0列 
				    cell.setCellValue(s1);//设置第i+1行第0列的值 
				    cell.setCellStyle(style);//设置风格 
				
				
				
					cell = row.createCell(2);//创建第i+1行第0列 
				    cell.setCellValue(s2);//设置第i+1行第0列的值 
				    cell.setCellStyle(style);//设置风格 
				
				
				
					cell = row.createCell(3);//创建第i+1行第0列 
				    cell.setCellValue(s3);//设置第i+1行第0列的值 
				    cell.setCellStyle(style);//设置风格 
					
				
				
					cell = row.createCell(4);//创建第i+1行第0列 
				    cell.setCellValue(order.getTotalamount());//设置第i+1行第0列的值 
				    cell.setCellStyle(style);//设置风格 
				
				    
				    String payway = order.getPayway().toString();
				    if(payway=="0"){
				    	cell = row.createCell(5);//创建第i+1行第0列 
					    cell.setCellValue("支付宝");//设置第i+1行第0列的值 
					    cell.setCellStyle(style);//设置风格 
				    }else {
				    	cell = row.createCell(5);//创建第i+1行第0列 
					    cell.setCellValue("当面付");//设置第i+1行第0列的值 
					    cell.setCellStyle(style);//设置风格 
					}
				
				
					cell = row.createCell(6);//创建第i+1行第0列 
				    cell.setCellValue(order.getArrivedday());//设置第i+1行第0列的值 
				    cell.setCellStyle(style);//设置风格 
				
				    
				
				    String school = order.getSchool();
				    String living = order.getLiving();
				    String doorplate = order.getDoorplate();
				    String room = order.getRoom();
				    //set school
				    if(school.equals("0")){
				    	school = "浙江工商大学";
				    }else if(school.equals("1")){
				    	school = "浙江财经大学";
				    }else if(school.equals("2")){
				    	school = "中国计量学院现代科技学院";
				    }else if(school.equals("3")){
				    	school = "杭州师范大学";
				    }else if(school.equals("4")){
				    	school = "浙江经贸职业技术学院";
				    }else if(school.equals("5")){
				    	school = "浙江金融职业技术学院";
				    }else if(school.equals("6")){
				    	school = "浙江水利水电学院";
				    }else if(school.equals("7")){
				    	school = "浙江经济职业技术学院";
				    }else{
				    	school = "";
				    }
				    //set living
				    if(living.equals("0")){
				    	living = "钱江湾";
				    }else if(living.equals("1")){
				    	living = "金沙港";
				    }else if(living.equals("2")){
				    	living = "成蹊苑";
				    }else if(living.equals("3")){
				    	living = "桃李苑";
				    }else if(living.equals("4")){
				    	living = "计量（东）生活区";
				    }else if(living.equals("5")){
				    	living = "仁和社区";
				    }else if(living.equals("6")){
				    	living = "成蹊苑";
				    }else if(living.equals("7")){
				    	living = "桃李苑";
				    }else if(living.equals("8")){
				    	living = "水利水电生活区";
				    }else if(living.equals("9")){
				    	living = "玉屏洲";
				    }else{
				    	living = "";
				    }
				    cell = row.createCell(7);//创建第i+1行第0列 
				    cell.setCellValue(school+"  "+living+"  "+doorplate+"幢"+"  "+room+"室");//设置第i+1行第0列的值 
				    cell.setCellStyle(style);//设置风格 
					
				    
				
					cell = row.createCell(8);//创建第i+1行第0列 
				    cell.setCellValue(order.getRemark());//设置第i+1行第0列的值 
				    cell.setCellStyle(style);//设置风格 
				
				
					cell = row.createCell(9);//创建第i+1行第0列 
				    cell.setCellValue(order.getUsername());//设置第i+1行第0列的值 
				    cell.setCellStyle(style);//设置风格 
					
				
					cell = row.createCell(10);//创建第i+1行第0列 
				    cell.setCellValue(order.getTruename());//设置第i+1行第0列的值 
				    cell.setCellStyle(style);//设置风格 
					
				
					cell = row.createCell(11);//创建第i+1行第0列 
				    cell.setCellValue( order.getTelephone());//设置第i+1行第0列的值 
				    cell.setCellStyle(style);//设置风格 
				
			}
			}
		}
			catch (Exception e) { 
				e.printStackTrace(); 
				} 
		HttpServletResponse response = null;//创建一个HttpServletResponse对象 
		OutputStream out = null;//创建一个输出流对象 
		try { 
		response = ServletActionContext.getResponse();//初始化HttpServletResponse对象 
		out = response.getOutputStream();// 
		        response.setHeader("Content-disposition","attachment; filename="+"order.xls");//filename是下载的xls的名，建议最好用英文 
		        response.setContentType("application/msexcel;charset=UTF-8");//设置类型 
		        response.setHeader("Pragma","No-cache");//设置头 
		        response.setHeader("Cache-Control","no-cache");//设置头 
		        response.setDateHeader("Expires", 0);//设置日期头 
		        workbook.write(out); 
		        out.flush(); 
		workbook.write(out); 
		} catch (IOException e) { 
		e.printStackTrace(); 
		}finally{ 
		try{ 

		if(out!=null){ 
		out.close(); 
		} 

		}catch(IOException e){ 
		e.printStackTrace(); 
		} 

		} 
		return null; 
		}
		 return "success";
	}
	
	
	
	public String toprint() throws Exception{
		String[] arr =(String [])ActionContext.getContext().getParameters().get("checkbox");
		System.out.println("checkbox  = " + arr);
		 if(arr!=null)
		 {
		     int[] arrId = new int[arr.length];
		     for (int i = 0; i < arr.length; i++) {
		         arrId[i] = Integer.parseInt(arr[i]);
		         }       
		boolean reslut = false;
		
		
		String []tableHeader={"商品名称","商品单价","购买数量"};
		short cellNumber=(short)tableHeader.length;//表的列数 
		HSSFWorkbook workbook = new HSSFWorkbook();	//创建一个excel 
		HSSFCell cell = null;	//Excel的列 
		HSSFRow row = null;	//Excel的行 
		HSSFCellStyle style = workbook.createCellStyle();	//设置表头的类型 
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); 
		HSSFCellStyle style1 = workbook.createCellStyle();	//设置数据类型 
		style1.setAlignment(HSSFCellStyle.ALIGN_CENTER); 
		HSSFFont font = workbook.createFont();	//设置字体 
		HSSFSheet sheet = workbook.createSheet("sheet1");	//创建一个sheet 
		HSSFHeader header = sheet.getHeader();//设置sheet的头 
		style.setWrapText(true);
		
		
		try {              /** 
             *根据是否取出数据，设置header信息 
             * 
             */ 
			if(checkbox.length < 1 ){ 
				header.setCenter("查无资料"); 
			}else{ 
				header.setCenter("要批量打印的订单"); 
				for(int i=0,l=0;l<checkbox.length;i=7+adminService.findorderdetailbyid(checkbox[l]).size()+i,l++){
				row = sheet.createRow((short)i);
				cell = row.createCell(i);
				cell.setCellStyle(style);
				order = adminService.findorderbyid(checkbox[l]);
				int orderno = order.getOrderNo();
				list_detail = adminService.findorderdetailbyid(checkbox[l]);
				row = sheet.createRow(i); 
				row.setHeight((short)400); 
				cell = row.createCell(0);//创建第0行第k列 
				cell.setCellValue("订单号");//设置第0行第k列的值 
				sheet.setColumnWidth(0, 8000);
				font.setColor(HSSFFont.COLOR_NORMAL); // 设置单元格字体的颜色. 
				style1.setFont(font);//设置字体风格 
				cell.setCellStyle(style1); 
				
				cell = row.createCell(1);//创建第0行第k列 
				cell.setCellValue(order.getOrderNo());//设置第0行第k列的值 
				sheet.setColumnWidth(1, 15000);
				font.setColor(HSSFFont.COLOR_NORMAL); // 设置单元格字体的颜色. 
				style1.setFont(font);//设置字体风格 
				cell.setCellStyle(style1); 
				
				row = sheet.createRow(i+1); 
				for(int k = 0;k < cellNumber;k++){	
					cell = row.createCell(k);//创建第1行第k列 
					cell.setCellValue(tableHeader[k]);//设置第1行第k列的值 
					font.setColor(HSSFFont.COLOR_NORMAL); // 设置单元格字体的颜色. 
					style1.setFont(font);//设置字体风格 
					cell.setCellStyle(style1); 
				}
				
				for(int j=i+2,m=0;m<list_detail.size();j++,m++){
					System.out.println("当前的货物总数是："+ list_detail.size());
					row = sheet.createRow((short) (j));//创建第i+1行 
					short n = (short)list_detail.size();
					row.setHeight((short) ((short)300*n));//设置行高 
					style.setAlignment(CellStyle.ALIGN_CENTER);
					style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
					
					cell = row.createCell(0);//创建第i+1行第0列 
				    cell.setCellValue(list_detail.get(m).getGoodsname());//设置第i+1行第0列的值 
				    cell.setCellStyle(style);//设置风格 
					
					
					
					cell = row.createCell(1);//创建第i+1行第0列 
					cell.setCellValue(list_detail.get(m).getPrice());//设置第i+1行第0列的值 
					cell.setCellStyle(style);//设置风格 
					
					
					
					cell = row.createCell(2);//创建第i+1行第0列 
					cell.setCellValue(list_detail.get(m).getNumber());//设置第i+1行第0列的值 
					cell.setCellStyle(style);//设置风格 
				}
				
				row = sheet.createRow(i+2+list_detail.size()); 
				row.setHeight((short)400); 
				cell = row.createCell(0);//创建第i+1行第0列 
			    cell.setCellValue("用户名");//设置第i+1行第0列的值 
			    cell.setCellStyle(style);//设置风格 
				
				
				
				cell = row.createCell(1);//创建第i+1行第0列 
				cell.setCellValue(order.getUsername());//设置第i+1行第0列的值 
				sheet.setColumnWidth(1, 15000);
				cell.setCellStyle(style);//设置风格 
				
				
				
				cell = row.createCell(2);//创建第i+1行第0列 
				cell.setCellValue("真实姓名");//设置第i+1行第0列的值 
				cell.setCellStyle(style);//设置风格 
				
				cell = row.createCell(3);//创建第i+1行第0列 
				cell.setCellValue(order.getTruename());//设置第i+1行第0列的值 
				sheet.setColumnWidth(3, 15000);
				cell.setCellStyle(style);//设置风格 
				
				
				
				row = sheet.createRow(i+3+list_detail.size()); 
				row.setHeight((short)400); 
				cell = row.createCell(0);//创建第i+1行第0列 
			    cell.setCellValue("送货时间");//设置第i+1行第0列的值 
			    cell.setCellStyle(style);//设置风格 
				
				
				
				cell = row.createCell(1);//创建第i+1行第0列 
				cell.setCellValue(order.getArrivedday()+""+order.getArrivedtime());//设置第i+1行第0列的值 
				sheet.setColumnWidth(1, 15000);
				cell.setCellStyle(style);//设置风格 
				
				
				
				cell = row.createCell(2);//创建第i+1行第0列 
				cell.setCellValue("地址");//设置第i+1行第0列的值 
				cell.setCellStyle(style);//设置风格 
				
				
				
				String school = order.getSchool();
			    String living = order.getLiving();
			    String doorplate = order.getDoorplate();
			    String room = order.getRoom();
			    //set school
			    if(school.equals("0")){
			    	school = "浙江工商大学";
			    }else if(school.equals("1")){
			    	school = "浙江财经大学";
			    }else if(school.equals("2")){
			    	school = "中国计量学院现代科技学院";
			    }else if(school.equals("3")){
			    	school = "杭州师范大学";
			    }else if(school.equals("4")){
			    	school = "浙江经贸职业技术学院";
			    }else if(school.equals("5")){
			    	school = "浙江金融职业技术学院";
			    }else if(school.equals("6")){
			    	school = "浙江水利水电学院";
			    }else if(school.equals("7")){
			    	school = "浙江经济职业技术学院";
			    }else{
			    	school = "";
			    }
			    //set living
			    if(living.equals("0")){
			    	living = "钱江湾";
			    }else if(living.equals("1")){
			    	living = "金沙港";
			    }else if(living.equals("2")){
			    	living = "成蹊苑";
			    }else if(living.equals("3")){
			    	living = "桃李苑";
			    }else if(living.equals("4")){
			    	living = "计量（东）生活区";
			    }else if(living.equals("5")){
			    	living = "仁和社区";
			    }else if(living.equals("6")){
			    	living = "成蹊苑";
			    }else if(living.equals("7")){
			    	living = "桃李苑";
			    }else if(living.equals("8")){
			    	living = "水利水电生活区";
			    }else if(living.equals("9")){
			    	living = "玉屏洲";
			    }else{
			    	living = "";
			    }
			    cell = row.createCell(3);//创建第i+1行第0列 
			    cell.setCellValue(school+"  "+living+"  "+doorplate+"幢"+"  "+room+"室");//设置第i+1行第0列的值 
				sheet.setColumnWidth(3, 15000);
				cell.setCellStyle(style);//设置风格 
				
				
				row = sheet.createRow(i+4+list_detail.size()); 
				row.setHeight((short)400); 
				cell = row.createCell(0);//创建第i+1行第0列 
			    cell.setCellValue("支付方式");//设置第i+1行第0列的值 
			    cell.setCellStyle(style);//设置风格 
			    
			    
			    
			    String payway = order.getPayway().toString();
			    if(payway=="0"){
			    	cell = row.createCell(1);//创建第i+1行第0列 
				    cell.setCellValue("支付宝");//设置第i+1行第0列的值 
				    sheet.setColumnWidth(1, 15000);
				    cell.setCellStyle(style);//设置风格 
			    }else {
			    	cell = row.createCell(1);//创建第i+1行第0列 
				    cell.setCellValue("当面付");//设置第i+1行第0列的值 
				    sheet.setColumnWidth(1, 15000);
				    cell.setCellStyle(style);//设置风格 
				}
				
				
				
				cell = row.createCell(2);//创建第i+1行第0列 
				cell.setCellValue("最终金额");//设置第i+1行第0列的值 
				cell.setCellStyle(style);//设置风格 
				
				
				cell = row.createCell(3);//创建第i+1行第0列 
				cell.setCellValue(order.getTotalamount());//设置第i+1行第0列的值 
				sheet.setColumnWidth(3, 15000);
				cell.setCellStyle(style);//设置风格 
				
				row = sheet.createRow(i+5+list_detail.size()); 
				row.setHeight((short)400); 
				cell = row.createCell(0);//创建第i+1行第0列 
			    cell.setCellValue("联系电话");//设置第i+1行第0列的值 
			    cell.setCellStyle(style);//设置风格 
				
				
				
				cell = row.createCell(1);//创建第i+1行第0列 
				cell.setCellValue(order.getTelephone());//设置第i+1行第0列的值 
				sheet.setColumnWidth(1, 15000);
				cell.setCellStyle(style);//设置风格 
				
				
				
				cell = row.createCell(2);//创建第i+1行第0列 
				cell.setCellValue("备注");//设置第i+1行第0列的值 
				cell.setCellStyle(style);//设置风格 
				
				cell = row.createCell(3);//创建第i+1行第0列 
				cell.setCellValue(order.getRemark());//设置第i+1行第0列的值 
				sheet.setColumnWidth(3, 15000);
				cell.setCellStyle(style);//设置风格 
				
				
				row = sheet.createRow(i+6+list_detail.size()); 
				
				cell = row.createCell(2);//创建第i+1行第0列 
				cell.setCellValue("配送人员");//设置第i+1行第0列的值 
				cell.setCellStyle(style);//设置风格 
				
				cell = row.createCell(3);//创建第i+1行第0列 
				cell.setCellValue("");//设置第i+1行第0列的值 
				sheet.setColumnWidth(3, 15000);
				row.setHeight((short)400); 
				cell.setCellStyle(style);//设置风格 
				
				
		}
			}
		}catch (Exception e) { 
					e.printStackTrace(); 
					} 
			HttpServletResponse response = null;//创建一个HttpServletResponse对象 
			OutputStream out = null;//创建一个输出流对象 
			try { 
			response = ServletActionContext.getResponse();//初始化HttpServletResponse对象 
			out = response.getOutputStream();// 
			        response.setHeader("Content-disposition","attachment; filename="+"toprint.xls");//filename是下载的xls的名，建议最好用英文 
			        response.setContentType("application/msexcel;charset=UTF-8");//设置类型 
			        response.setHeader("Pragma","No-cache");//设置头 
			        response.setHeader("Cache-Control","no-cache");//设置头 
			        response.setDateHeader("Expires", 0);//设置日期头 
			        workbook.write(out); 
			        out.flush(); 
			workbook.write(out); 
			} catch (IOException e) { 
			e.printStackTrace(); 
			}finally{ 
			try{ 

			if(out!=null){ 
			out.close(); 
			} 

			}catch(IOException e){ 
			e.printStackTrace(); 
			} 

			} 
			return null; 
			}
			 return "success";
		
	}
	
	
	public String deleteorderbyid() throws Exception {
		boolean reslut = false;
		reslut = adminService.deleteorderbyid(id);
		System.out.println(reslut);
		if (reslut==true){
			reslut = adminService.deleteorderdetailbyid(id);
		}
		if (reslut) {
			System.out.println("return success");
			return "success";
		} else {
			System.out.println("return failure");
			return "failure";
		}
	}
	
	public String addorder1() throws Exception {
		list = adminService.addorder1(arrivedday, arrivedtime, totalamount,
				username, truename, telephone, school, doorplate, room, remark,
				payway, isclosed);
		return "addSuccess";
	}

	public String addorder() throws Exception {
		Order order = adminService.addorder(arrivedday, arrivedtime, totalamount,
				username, truename, telephone, school, doorplate, room, remark,
				payway, isclosed);
		list  = adminService.addorderdetail(list_detail1,order.getId());
		return "addSuccess";
	}
	
	public String alterorder() throws Exception{   
		System.out.println("asdaasdsa");
		list  = adminService.alterorder(id,orderNo, arrivedday, arrivedtime, totalamount,
				username, truename, telephone, school, doorplate, room, remark,
				payway, isclosed);
		System.out.println(telephone);
		return "alterSuccess";
	}
	
	public String alterorderdetail() throws Exception{   
		System.out.println("alterorderdetail");
		System.out.println(list_detail1);
		list  = adminService.alterorderdetail(list_detail1);
		System.out.println(telephone);
		return "alterSuccess";
	}
	
	public String altershow() throws Exception{
		order = adminService.findorderbyid(id);
		list_detail=adminService.findorderdetailbyid(id);
		return "alterShow";
	}
	
	public String view() throws Exception{
		order = adminService.findorderbyid(id);
		System.out.println("id is "+id);
		list_detail=adminService.findorderdetailbyid(id);
		System.out.println(list_detail.size()+" is the size of the list_detail");
		return "view";
	}
	
	/**
	 * 根据username,orderNo,startdate,enddate,iscloded找到指定订单返回list
	 * 
	 * @return String
	 */
	public String findorderspecial()throws Exception{
		System.out.println(username);
		//goods_supertypes = adminService.showsuptype();
		//goods_subtypes = adminService.showsubtype();
		System.out.println("username="+username);
	   	System.out.println("orderNo = "+ orderNo);
		System.out.println("isclosed="+isclosed);
	   	System.out.println("orderday="+orderday);
	   	System.out.println("orderday1="+orderday1);
    	//分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
   	    String phql="from Order as u where 1=1 ";
        //this.pageBean = pagingService.queryForPage(phql,2, page); 
   	    orderNo = (Integer)(orderNo);
   	    System.out.println(phql);
   	    if ((Object)orderpage.getCurrentPage()==null)
   	    	orderpage.setCurrentPage(1);
   	    orderpage = pagingService.queryorderforpage(phql,pagesize, orderpage.getCurrentPage(),username,orderNo,startdate,enddate,isclosed);
        List<Integer> list1=new ArrayList<Integer>();
        for (Integer i=orderpage.getCurrentPage()-5;i<=orderpage.getCurrentPage()+5;i++)
        {
        	if (i<=0||i>orderpage.getTotalPage())
        		continue;
        	list1.add(i);
        }
        System.out.println(list1);
        orderpage.setPageList(list1);
        return "findsuccess";
	}
	
	/**
	 * 根据username,startdate,enddate,iscloded找到指定订单返回list
	 * 
	 * @return String
	 */
	public String goodscount()throws Exception{
		System.out.println("enter goodscount action");
		System.out.println("goodsname="+goodsname);
		System.out.println("isclosed="+isclosed);
	   	System.out.println("startdate="+startdate);
	   	System.out.println("enddate="+enddate);
    	//分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
   	    String phql="from Order_detail as u where 1=1 ";
 	    
   	    System.out.println(phql);
   	 setGoodscountpage(pagingService.querygoodscountforpage(goodsname,startdate,enddate,isclosed));

        return "goodscount";
	}
	
	/**
	 * 根据startdate,enddate,iscloded找到指定订单返回list 统计一个时间段内的营业额
	 * 
	 * @return String
	 */
	public String turnover()throws Exception{
		System.out.println("enter goodscount action");
		System.out.println("isclosed="+isclosed);
	   	System.out.println("startdate="+startdate);
	   	System.out.println("enddate="+enddate);
    	//分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
   	    String phql="from Order_detail as u where 1=1 ";
 	    
   	    System.out.println(phql);
   	    
   	 //setGoodscountpage(pagingService.querygoodscountforpage(goodsname,startdate,enddate,isclosed));
   	 setTurnoverpage(pagingService.queryturnoverforpage(startdate, enddate, isclosed));
        return "turnover";
	}
	
	/**
	 * 根据goodsname,startdate,enddate找到指定订单返回list
	 * 
	 * @return String
	 */
	public String findorderspecial1()throws Exception{
		System.out.println(username);
		//goods_supertypes = adminService.showsuptype();
		//goods_subtypes = adminService.showsubtype();
		System.out.println("username="+username);
	   	System.out.println("orderNo = "+ orderNo);
		System.out.println("isclosed="+isclosed);
	   	System.out.println("orderday="+orderday);
	   	System.out.println("orderday1="+orderday1);
    	//分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
   	    String phql="from Order as u where username like ? and orderday >= ? and orderday <= ?";
        //this.pageBean = pagingService.queryForPage(phql,2, page); 
   	    
   	    System.out.println(phql);
   	    if ((Object)orderpage.getCurrentPage()==null)
   	    	orderpage.setCurrentPage(1);
   	    orderpage = pagingService.queryorderforpage(phql,pagesize, orderpage.getCurrentPage(),username,orderNo,orderday,orderday1,isclosed);
        List<Integer> list1=new ArrayList<Integer>();
        for (Integer i=orderpage.getCurrentPage()-5;i<=orderpage.getCurrentPage()+5;i++)
        {
        	if (i<=0||i>orderpage.getTotalPage())
        		continue;
        	list1.add(i);
        }
        System.out.println(list1);
        orderpage.setPageList(list1);
        return "findsuccess";
	}

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public String getArrivedday() {
		return arrivedday;
	}

	public void setArrivedday(String arrivedday) {
		this.arrivedday = arrivedday;
	}

	public String getArrivedtime() {
		return arrivedtime;
	}

	public void setArrivedtime(String arrivedtime) {
		this.arrivedtime = arrivedtime;
	}

	public double getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getDoorplate() {
		return doorplate;
	}

	public void setDoorplate(String doorplate) {
		this.doorplate = doorplate;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPayway() {
		return payway;
	}

	public void setPayway(String payway) {
		this.payway = payway;
	}



	public Integer getIsclosed() {
		return isclosed;
	}

	public void setIsclosed(Integer isclosed) {
		this.isclosed = isclosed;
	}

	public PageModel getOrderpage() {
		return orderpage;
	}

	public void setOrderpage(PageModel orderpage) {
		this.orderpage = orderpage;
	}

	public PagingService getPagingService() {
		return pagingService;
	}

	public void setPagingService(PagingService pagingService) {
		this.pagingService = pagingService;
	}

	public Integer getPagesize() {
		return pagesize;
	}

	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<Order> getList() {
		return list;
	}

	public void setList(List<Order> list) {
		this.list = list;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public Integer getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(Integer goodsid) {
		this.goodsid = goodsid;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public List<Order_detail> getList_detail() {
		return list_detail;
	}

	public void setList_detail(List<Order_detail> list_detail) {
		this.list_detail = list_detail;
	}

	public Integer getId_detail() {
		return id_detail;
	}

	public void setId_detail(Integer id_detail) {
		this.id_detail = id_detail;
	}

	public List<Order_detail> getList_detail1() {
		return list_detail1;
	}

	public void setList_detail1(List<Order_detail> list_detail1) {
		this.list_detail1 = list_detail1;
	}

	public int[] getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(int[] checkbox) {
		this.checkbox = checkbox;
	}

	public String getOrderday() {
		return orderday;
	}

	public void setOrderday(String orderday) {
		this.orderday = orderday;
	}

	public String getOrderday1() {
		return orderday1;
	}

	public void setOrderday1(String orderday1) {
		this.orderday1 = orderday1;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}



	public List<Order_detail> getGoodscountlist() {
		return goodscountlist;
	}

	public void setGoodscountlist(List<Order_detail> goodscountlist) {
		this.goodscountlist = goodscountlist;
	}

	public List<GoodsCount> getGoodscountpage() {
		return goodscountpage;
	}

	public void setGoodscountpage(List<GoodsCount> goodscountpage) {
		this.goodscountpage = goodscountpage;
	}

	public List<Turnover> getTurnoverpage() {
		return turnoverpage;
	}

	public void setTurnoverpage(List<Turnover> turnoverpage) {
		this.turnoverpage = turnoverpage;
	}

	
}

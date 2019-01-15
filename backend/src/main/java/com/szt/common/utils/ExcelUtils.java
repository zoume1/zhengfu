//package com.szt.common.utils;
//
//import java.io.IOException;
//import java.lang.reflect.Field;
//import java.math.BigDecimal;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFCellStyle;
//import org.apache.poi.hssf.usermodel.HSSFDataFormat;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.formula.functions.T;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.springframework.stereotype.Component;
//import org.springframework.web.multipart.MultipartFile;
//
//
///**
// * 使用该类需要配合使用@ExportExcel和@ImportExcel自定义注解
// * 在实体字段中加入@Excel(name="名字") '名字'指代导出时excel时第一列的名字,导入时会反射读取有@Excel的字段
// * 该实体类支持单表导入导出,多关系的暂不兼容,除非新建VO在每个字段中加入注解
// * @author Administrator
// *
// * @param <T>
// */
//public class ExcelUtils {
//	/**
//	 * 通用导出excel模板
//	 * @throws IOException
//	 */
//	public void exportTemplate(HttpServletResponse response) throws Exception {
//		 		//设置编码规则
//				response.setContentType("application/binary;charset=UTF-8");
//				//获取输出流
//				ServletOutputStream out=response.getOutputStream();
//				//设置文件名
//		        String fileName=new String(("template "+ new SimpleDateFormat("yyyy-MM-dd").format(new Date())).getBytes(),"UTF-8");
//		        //设置请求头
//		       response.setHeader("Content-disposition", "attachment; filename=" + fileName + ".xls");
//	            // 第一步，创建一个workbook，对应一个Excel文件
//	            HSSFWorkbook workbook = new HSSFWorkbook();
//	            // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
//	            HSSFSheet hssfSheet = workbook.createSheet("sheet1");
//	            // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
//	            HSSFRow hssfRow = hssfSheet.createRow(0);
//	            // 创建样式
//	            HSSFCellStyle hssfCellStyle = workbook.createCellStyle();
//	            //设置居中样式
//	            hssfCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//	            //设置单元格格式为文本格式样式
//	            HSSFDataFormat format = workbook.createDataFormat();
//	            hssfCellStyle.setDataFormat(format.getFormat("@"));
//	    		//获得该实体所有字段,遍历,同时生成列名
//				HSSFCell  hssfCell = hssfRow.createCell(j);//列索引从0开始
//				hssfSheet.setColumnWidth(j++, 7000);
//				hssfCell.setCellValue(a.name());//列名1
//				hssfCell.setCellStyle(hssfCellStyle);//列居中显示
//				hssfCell.setCellStyle(hssfCellStyle);
//				arr.add(item);
//	    		List<Field> list = getImportExcelAnnotation(classType,hssfRow,hssfSheet,hssfCellStyle);
//	            // 第七步，将文件输出到客户端浏览器
//                workbook.write(out);
//                out.flush();
//                out.close();
//
//	}
//	public void exportData(HttpServletResponse response, List<T> tableObjList, Class<T> type, Template<T> template) throws Exception {
//		ServletOutputStream out = response.getOutputStream();
//		String fileName = new String(("excel " + (new SimpleDateFormat("yyyy-MM-dd")).format(new Date())).getBytes(), "UTF-8");
//		response.setHeader("Content-disposition", "attachment; filename=" + fileName + ".xls");
//		HSSFWorkbook workbook = new HSSFWorkbook();
//		HSSFSheet hssfSheet = workbook.createSheet("sheet1");
//		HSSFRow hssfRow = hssfSheet.createRow(0);
//		HSSFCellStyle hssfCellStyle = workbook.createCellStyle();
//		hssfCellStyle.setAlignment((short)2);
//		List<Field> fieldList = this.getExportExcelAnnotation(type.newInstance().getClass(), hssfRow, hssfSheet, hssfCellStyle);
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		if (tableObjList != null && !tableObjList.isEmpty()) {
//			for(int i = 0; i < tableObjList.size(); ++i) {
//				hssfRow = hssfSheet.createRow(i + 1);
//				T item = tableObjList.get(i);
//
//				for(int j = 0; j < fieldList.size(); ++j) {
//					hssfSheet.setColumnWidth(j, 7000);
//					Field filed = (Field)fieldList.get(j);
//					HSSFCell cell = hssfRow.createCell(j);
//					cell.setCellStyle(hssfCellStyle);
//					Class<T> classType = (Class<T>) item.getClass();
//					String fieldName = filed.getName();
//					Object value = classType.getMethod("get" + getMethodName(fieldName)).invoke(item);
//					if (template == null) {
//						if (value instanceof Date) {
//							cell.setCellValue(sdf.format((Date)value));
//						} else if (value instanceof String) {
//							cell.setCellValue((String)value);
//						} else if (value instanceof Integer) {
//							cell.setCellValue((double)(Integer)value);
//						} else if (value instanceof Double) {
//							cell.setCellValue((Double)value);
//						} else if (value instanceof BigDecimal) {
//							cell.setCellValue(((BigDecimal)value).doubleValue());
//						} else {
//							cell.setCellValue("");
//						}
//					} else {
//						template.format(cell, fieldName, value);
//					}
//				}
//			}
//		}
//
//		workbook.write(out);
//		out.flush();
//		out.close();
//	}
//	/**
//	 * 通用导出excel模板和数据
//	 * @param orderTime
//	 * @throws IOException
//	 */
//	public void exportData(HttpServletResponse response,List<T> tableObjList,Class<T> type,Template<T> template, String orderTime) throws Exception {
//				//判断tableObjList是否有数据
//		        /*if(tableObjList.size()==0){
//					throw new RuntimeException("不能导出空数据!");
//				}*/
//				//获取输出流
//				ServletOutputStream out=response.getOutputStream();
//				//设置文件名
//		        String fileName=new String(("excel "+ new SimpleDateFormat("yyyy-MM-dd").format(new Date())).getBytes(),"UTF-8");
//		        //设置请求头
//		        response.setHeader("Content-disposition", "attachment; filename=" + fileName + ".xls");
//	            // 第一步，创建一个workbook，对应一个Excel文件
//	            HSSFWorkbook workbook = new HSSFWorkbook();
//	            // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
//	            HSSFSheet hssfSheet = workbook.createSheet("sheet1");
//	            // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
//	            HSSFRow hssfRow = hssfSheet.createRow(0);
//	            // 第四步，创建单元格，并设置值表头 设置表头居中
//	            HSSFCellStyle hssfCellStyle = workbook.createCellStyle();
//	            //居中样式
//	            hssfCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//	    		//存储需要读取的字段列名
//	    		List<Field> fieldList = getExportExcelAnnotation(type.newInstance().getClass(), hssfRow, hssfSheet, hssfCellStyle);
//	            // 第五步，写入实体数据
//	            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//	            if(tableObjList != null && !tableObjList.isEmpty()){
//	            	//遍历数据
//	                for (int i = 0; i < tableObjList.size(); i++) {
//	                    hssfRow = hssfSheet.createRow(i+1);
//	                    T item = tableObjList.get(i);
//	                    //遍历带有@importExcel注解的字段
//	                    for(int j=0;j<fieldList.size();j++){
//	                    	//设置宽度
//	                    	hssfSheet.setColumnWidth(j, 7000);
//	                    	//获取字段
//	                    	Field filed = fieldList.get(j);
//	                    	//创建列
//	                    	HSSFCell cell = hssfRow.createCell(j);
//	                    	//设置居中样式
//	                    	cell.setCellStyle(hssfCellStyle);
//	                    	//获取class对象
//	                    	Class<T> classType =  (Class<T>) item.getClass();
//	                    	String fieldName = filed.getName();
//	                    	//反射调用get方法
//	                    	Object value = classType.getMethod("get"+getMethodName(fieldName)).invoke(item);
//	                    	//默认数据格式转换
//	                    	if(template==null){
//	                    		if(value instanceof Date){
//		                    		cell.setCellValue(sdf.format((Date)value));
//		                    	}else if(value instanceof String){
//		                    		cell.setCellValue((String)value);
//		                    	}else if(value instanceof Integer){
//		                    		cell.setCellValue((Integer)value);
//		                    	}else if(value instanceof Double){
//		                    		cell.setCellValue((Double)value);
//		                    	}else if(value instanceof BigDecimal){
//		                    		cell.setCellValue(((BigDecimal)value).doubleValue());
//		                    	}else{
//		                    		cell.setCellValue("");
//		                    	}
//	                    	}
//	                    	//如果有接口实现类传入,走新的格式转换
//	                    	else{
//	                    		template.format(cell,fieldName,value);
//	                    	}
//
//	                    }
//	                }
//	            }
//	            // 第七步，将文件输出到客户端浏览器
//                workbook.write(out);
//                out.flush();
//                out.close();
//	}
//
//	/**
//	 * 读取导入的excel表格信息
//	 * @param file
//	 * @param tableObj
//	 * @throws Exception
//	 */
//	public  List<T> importExcel(MultipartFile file,Class<T> classType) throws Exception{
//		 String fileType = "";
//	 	        String fileName = file.getOriginalFilename();
//	 	        fileType = fileName.substring(fileName.lastIndexOf(".") + 1,  fileName.lastIndexOf(".") + 4);
//	 	    if (!(fileType.toLowerCase().equals("xls") || fileType.toLowerCase().equals("xlsx"))) {
//	 	         throw new RuntimeException("导入的文件格式不是excel文件");
//	 	    }
//	 	    HSSFWorkbook workbook = null;
//	 	   List<T> list = new ArrayList<T>();
//	 	   try{
//	 		//存储需要读取的字段列名
//	   		List<Field> arr = new ArrayList<Field>();
//	   		//通过反射读取带有@Excel的字段,获得列名
//			Field[] fields =classType.newInstance().getClass().getDeclaredFields();
//	   		for(int i=0,j=0;i<fields.length;i++){
//	   			//获取带有该注解的字段
//	   			Field item =fields[i];
//	   			ImportExcel a   = null;
//	   			if((a=item.getAnnotation(ImportExcel.class))!=null){
//	   				arr.add(item);
//	   			}
//	   		}
//	   			workbook = new HSSFWorkbook(file.getInputStream());
//	 	       if(workbook != null){
//	 	            for(int sheetNum = 0;sheetNum < workbook.getNumberOfSheets();sheetNum++){
//	 	                //获得当前sheet工作表
//	 	                Sheet sheet = workbook.getSheetAt(sheetNum);
//	 	                if(sheet == null){
//	 	                    continue;
//	 	                }
//	 	                //获得当前sheet的开始行
//	 	                int firstRowNum  = sheet.getFirstRowNum();
//	 	                //获得当前sheet的结束行
//	 	                int lastRowNum = sheet.getLastRowNum();
//	 	                //循环除了第一行的所有行
//	 	                for(int rowNum = firstRowNum+1;rowNum <= lastRowNum;rowNum++){
//	 	                    //获得当前行
//	 	                    Row row = sheet.getRow(rowNum);
//	 	                    if(row == null){
//	 	                        continue;
//	 	                    }
//	 	                    //获得当前行的开始列
//	 	                    int firstCellNum = row.getFirstCellNum();
//	 	                    //获得当前行的列数
//	 	                    int lastCellNum = row.getPhysicalNumberOfCells();
//	 	                    //循环当前行
//	 	                    T table = classType.newInstance();
//	 	                    for(int cellNum = firstCellNum; cellNum < arr.size();cellNum++){
//	 	                        Cell cell = row.getCell(cellNum);
//	 	                        Field field = arr.get(cellNum);
//	 	                        String  typeName = field.getType().toString();
// 	                         	if (typeName.equals("class java.lang.String")) {
// 	                         		classType.getMethod("set"+getMethodName(field.getName()),String.class).invoke(table,getCellValue(cell));
//	 	                        }else if (typeName.equals( "class java.lang.Integer")) {
//	 	                        	classType.getMethod("set"+getMethodName(field.getName()),Integer.class).invoke(table,Integer.parseInt(getCellValue(cell)));
//	 	                        }else if (typeName.equals("class java.lang.Double")) {
//	 	                        	classType.getMethod("set"+getMethodName(field.getName()),Double.class).invoke(table,Double.parseDouble(getCellValue(cell)));
//	 	                        }else if(typeName.equals("class java.math.BigDecimal")){
//	 	                        	classType.getMethod("set"+getMethodName(field.getName()),BigDecimal.class).invoke(table,new BigDecimal(getCellValue(cell)));
//	 	                        }else if(typeName.equals("class java.util.Date")){
//	 	                        	classType.getMethod("set"+getMethodName(field.getName()),Date.class).invoke(table,getCellValue(cell));
//	 	                        }
//	 	                    }
//	 	                    list.add(table);
//	 	                }
//	 	            }
//	 	        }
//			}catch (Exception e){
//				e.printStackTrace();
//				throw new RuntimeException("excel模板数据错误!");
//			}
//			return list;
//	 	 }
//
//	public  String getCellValue(Cell cell){
//         String cellValue = "";
//         if(cell == null){
//             return cellValue;
//         }
//         //把数字当成String来读，避免出现1读成1.0的情况
//         if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
//             cell.setCellType(Cell.CELL_TYPE_STRING);
//         }
//         //判断数据的类型
//         switch (cell.getCellType()){
//             case Cell.CELL_TYPE_NUMERIC: //数字
//                 cellValue = String.valueOf(cell.getNumericCellValue());
//                 break;
//             case Cell.CELL_TYPE_STRING: //字符串
//                 cellValue = String.valueOf(cell.getStringCellValue());
//                 break;
//             case Cell.CELL_TYPE_BOOLEAN: //Boolean
//                 cellValue = String.valueOf(cell.getBooleanCellValue());
//                 break;
//             case Cell.CELL_TYPE_FORMULA: //公式
//                 cellValue = String.valueOf(cell.getCellFormula());
//                 break;
//             case Cell.CELL_TYPE_BLANK: //空值
//                 cellValue = "";
//                 break;
//             case Cell.CELL_TYPE_ERROR: //故障
//                 cellValue = "非法字符";
//                 break;
//             default:
//                 cellValue = "未知类型";
//                 break;
//         }
//         return cellValue;
//	 }
//	/**
//	 * 创建excel列
//	 * @param class1
//	 * @param hssfRow
//	 * @param hssfCellStyle
//	 * @param hssfSheet,
//	 * @return
//	 * @throws SecurityException
//	 * @throws InstantiationException
//	 * @throws IllegalAccessException
//	 */
//	private List<Field> getImportExcelAnnotation(Class<? extends Object> class1, HSSFRow hssfRow, HSSFSheet hssfSheet, HSSFCellStyle hssfCellStyle) throws SecurityException, InstantiationException, IllegalAccessException{
//		//存储需要读取的字段列名
//   		List<Field> arr = new ArrayList<Field>();
////   		//通过反射读取带有@Excel的字段,获得列名
////		Field[] fields =class1.newInstance().getClass().getDeclaredFields();
////   		for(int i=0,j=0;i<fields.length;i++){
////   			//获取带有该注解的字段
////   			Field item =fields[i];
////   			ImportExcel a   = null;
////   			if((a=item.getAnnotation(ImportExcel.class))!=null){
////   			//创建一列
////
////   			}
////   		}
//   		return arr;
//	}
//	/**
//	 * 创建excel列
//	 * @param class1
//	 * @param hssfRow
//	 * @param hssfCellStyle
//	 * @param hssfSheet,
//	 * @return
//	 * @throws SecurityException
//	 * @throws InstantiationException
//	 * @throws IllegalAccessException
//	 */
//	private List<Field> getExportExcelAnnotation(Class<? extends Object> class1, HSSFRow hssfRow, HSSFSheet hssfSheet, HSSFCellStyle hssfCellStyle) throws SecurityException, InstantiationException, IllegalAccessException{
//		//存储需要读取的字段列名
//   		List<Field> arr = new ArrayList<Field>();
//   		//通过反射读取带有@Excel的字段,获得列名
//		Field[] fields =class1.newInstance().getClass().getDeclaredFields();
//   		for(int i=0,j=0;i<fields.length;i++){
//   			//获取带有该注解的字段
//   			Field item =fields[i];
//   			ExportExcel a   = null;
//   			if((a=item.getAnnotation(ExportExcel.class))!=null){
//   			//创建一列
//   				HSSFCell  hssfCell = hssfRow.createCell(j);//列索引从0开始
//				hssfSheet.setColumnWidth(j++, 7000);
//                hssfCell.setCellValue(a.name());//列名1
//                hssfCell.setCellStyle(hssfCellStyle);//列居中显示
//                hssfCell.setCellStyle(hssfCellStyle);
//   				arr.add(item);
//   			}
//   		}
//   		return arr;
//	}
//	 // 把一个字符串的第一个字母大写、效率是最高的、
//    public static String getMethodName(String fildeName) throws Exception{
//        byte[] items = fildeName.getBytes();
//        items[0] = (byte) ((char) items[0] - 'a' + 'A');
//        return new String(items);
//    }
//
//
//}

package cs.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class UploadPicture {

	
	
	@SuppressWarnings("resource")
	public String uploadFile(File upload, String uploadFileName,String path)
			throws Exception {
		@SuppressWarnings("deprecation")
		String rootpath = ServletActionContext.getRequest().getRealPath(
				path);
		if (!new File(rootpath).exists()) {
			new File(rootpath).mkdirs();
		}
		String filepath = "/"
				+ new SimpleDateFormat("yyMMddHHmmss").format(new Date()) +(int)(Math.random()*10000)+ "."
				+ uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1);

		String savepath = rootpath + filepath;
		FileOutputStream fos = new FileOutputStream(savepath);
		FileInputStream fis = new FileInputStream(upload);
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = fis.read(buffer)) > 0) {
			fos.write(buffer, 0, len);
		}
		return filepath;
	}

	public void deleteFile(String savePath,String path) {
		@SuppressWarnings("deprecation")
		String rootpath = ServletActionContext.getRequest().getRealPath(
				path);
		File file = new File(rootpath + savePath);
		
		if (file.exists()) {
			file.delete();
		}
	}
	
	
	
	
	/**
	 * 
	 	
	private File upload;
	private String uploadFileName;
	
	private File upload1;
	private String uploadFileName1;
	
	private File upload2;
	private String uploadFileName2;
	
	 * 
	 * 
	 * 
	 * 
	 * 上传图片
	 * @throws IOException
	 * @return void
	
	private void upload() throws IOException{
		String realPath = ServletActionContext.getServletContext().getRealPath("/images/goods");
		System.out.println(realPath);
		uploadFileName = new SimpleDateFormat("yyMMddHHmmss").format(new Date()) +(int)(Math.random()*10000)+ "."
				+ uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1);
		if(upload != null){
			File saveFile = new File(new File(realPath), uploadFileName);
			if(!saveFile.getParentFile().exists()){
				saveFile.getParentFile().mkdirs();
			}
			FileUtils.copyFile(upload, saveFile);
		}
	}
	 */
	/**
	 * 上传图片
	 * @throws IOException
	 * @return void
	 
	private void upload1() throws IOException{
		String realPath = ServletActionContext.getServletContext().getRealPath("/images/goods");
		System.out.println(realPath);
		uploadFileName = new SimpleDateFormat("yyMMddHHmmss").format(new Date()) +(int)(Math.random()*10000)+ "."
				+ uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1);
		if(upload1 != null){
			File saveFile = new File(new File(realPath), uploadFileName);
			if(!saveFile.getParentFile().exists()){
				saveFile.getParentFile().mkdirs();
			}
			FileUtils.copyFile(upload1, saveFile);
		}
	}
	*/
	/**
	 * 上传图片
	 * @throws IOException
	 * @return void
	
	private void upload2() throws IOException{
		String realPath = ServletActionContext.getServletContext().getRealPath("/images/goods");
		System.out.println(realPath);
		uploadFileName = new SimpleDateFormat("yyMMddHHmmss").format(new Date()) +(int)(Math.random()*10000)+ "."
				+ uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1);
		if(upload2 != null){
			File saveFile = new File(new File(realPath), uploadFileName);
			if(!saveFile.getParentFile().exists()){
				saveFile.getParentFile().mkdirs();
			}
			FileUtils.copyFile(upload2, saveFile);
		}
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public File getUpload1() {
		return upload1;
	}

	public void setUpload1(File upload1) {
		this.upload1 = upload1;
	}

	public String getUploadFileName1() {
		return uploadFileName1;
	}

	public void setUploadFileName1(String uploadFileName1) {
		this.uploadFileName1 = uploadFileName1;
	}

	public File getUpload2() {
		return upload2;
	}

	public void setUpload2(File upload2) {
		this.upload2 = upload2;
	}

	public String getUploadFileName2() {
		return uploadFileName2;
	}

	public void setUploadFileName2(String uploadFileName2) {
		this.uploadFileName2 = uploadFileName2;
	}
	 */
	
}

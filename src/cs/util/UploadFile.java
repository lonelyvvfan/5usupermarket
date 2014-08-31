package cs.util;

import java.io.File;

import org.apache.commons.io.FileUtils;

public class UploadFile {

	public static File Upload(File uploadFile, String uploadFileFileName,String targetDirectory)throws Exception {
		File target = new File(targetDirectory, uploadFileFileName);
		// ����ļ��Ѿ����ڣ���ɾ��ԭ���ļ�
		if (target.exists()) {
			target.delete();
		}
		// ����file����ʵ���ϴ�
		FileUtils.copyFile(uploadFile, target);
		return target;
	}
}
package cs.action;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import java.io.File;
import java.io.FileOutputStream;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class Narrowimage {
	
	/** * @param im 
	 * 原始图像
	 * @param resizeTimes
	 * 倍数,比如0.5就是缩小一半,0.98等等double类型
	 * @return 返回处理后的图像 */
	
	public BufferedImage zoomImage(String src) {
		BufferedImage result = null; 
		try {
			File srcfile = new File(src);
		if (!srcfile.exists()) 
		{ System.out.println("文件不存在");
		}
		BufferedImage im = ImageIO.read(srcfile);
		/* 原始图像的宽度和高度 */
		int width = im.getWidth();
		int height = im.getHeight();
		//压缩计算 
		float resizeTimes = 0.3f; /*这个参数是要转化成的倍数,如果是1就是转化成1倍*/ 
		
		/* 调整后的图片的宽度和高度 */ 
		int toWidth = (int) (width * resizeTimes); 
		int toHeight = (int) (height * resizeTimes);
		
		/* 新生成结果图片 */ 
		result = new BufferedImage(toWidth, toHeight, BufferedImage.TYPE_INT_RGB);
		
		result.getGraphics().drawImage(
				im.getScaledInstance(toWidth, toHeight, java.awt.Image.SCALE_SMOOTH), 0, 0, null);
		
		} catch (Exception e)
		{ System.out.println("创建缩略图发生异常" + e.getMessage()); } 
		return result;
	}
	
	
	public boolean writeHighQuality(BufferedImage im, String fileFullPath) {
		try {
			/*输出到文件流*/
			FileOutputStream newimage = new FileOutputStream(fileFullPath);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(newimage);
			JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(im);
			System.out.println("在压缩了");
			/* 压缩质量 */ 
			jep.setQuality(0.9f, true); 
			encoder.encode(im, jep); 
			/*近JPEG编码*/ 
			newimage.close(); 
			return true;
			} catch (Exception e){ 
				return false; 
			} 
		}

}

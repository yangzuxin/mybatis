package lianliankan;

import java.awt.image.BufferedImage;
import java.util.LinkedList;

/**
 * 图片工具类
 * 
 * @author Vincent
 * 
 */
public class ImageUtil {
	/**
	 * 保存所有的图片
	 */
	public LinkedList<BufferedImage> images = new LinkedList<>();
	/*
	 * 记录每种图片的数量
	 */
	public int[] count = new int[GameInfo.PICHEIGHT * GameInfo.PICWIDTH];

	/**
	 * 比较两张图片
	 * 
	 * @param image1
	 * @param image2
	 * @return
	 */
	public boolean equal(BufferedImage image1, BufferedImage image2) {
		int width = image1.getWidth();
		int height = image1.getHeight();

		int wrong = 0;

		for (int i = 0; i < width; i++)
			for (int j = 0; j < height; j++) {
				if (image1.getRGB(i, j) != image2.getRGB(i, j))
					wrong++;
				// 不匹配的像素不超过250个即认为相同
				/**
				 * 这个数值的设定很重要
				 */
				if (wrong > 250)
					return false;

			}

		return true;
	}

	/**
	 * 获取图片对应的数值
	 * 
	 * @param image
	 * @return
	 */
	public int getImageValue(BufferedImage image) {
		int index = -1;

		for (int i = 0; i < images.size(); i++)
			if (equal(images.get(i), image)) {
				count[i]++;
				return i;
			}

		if (index == -1) {
			images.add(image);
			index = images.size() - 1;
			count[index]++;

		}

		return index;

	}

	/**
	 * 获取空白图片的对应的数值 <strong>这里是以图片数量最多的为空白图片</strong>
	 * 
	 * @return
	 */
	public int getBlankImageValue() {
		int max = Integer.MIN_VALUE;
		int index = -1;
		for (int i = 0; i < count.length; i++)
			if (max < count[i]) {
				index = i;
				max = count[i];
			}
		return index;
	}

	/**
	 * 获取空白图片的数量
	 * 
	 * @return
	 */
	public int getBlankImageCount() {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < count.length; i++)
			if (max < count[i]) {
				max = count[i];
			}
		return max;
	}

}

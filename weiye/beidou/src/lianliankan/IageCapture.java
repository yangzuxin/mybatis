package lianliankan;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;

/**
 * 图片捕捉类
 * 
 * @author Vincent
 * 
 */
public class IageCapture {

	/**
	 * 每个小图片的长和宽
	 */
	int picWidth = 30, picHeight = 34;

	/**
	 * map的宽度和高度
	 */
	int MAPWIDTH = 19, MAPHEIGHT = 11;

	/**
	 * 小图片之间的距离
	 */
	int gap = 1;

	/**
	 * 截取的整张图片的起点终点坐标
	 */
	int startX, startY, endX, endY;

	/**
	 * 截下的整张图片
	 */
	private BufferedImage image;

	public IageCapture(int startX, int startY) {
		// TODO 自动生成的构造函数存根
		this.startX = startX;
		this.startY = startY;

		gap = GameInfo.GAP;
		MAPWIDTH = GameInfo.MAPWIDTH;
		MAPHEIGHT = GameInfo.MAPHEIGHT;
		picHeight = GameInfo.PICHEIGHT;
		picWidth = GameInfo.PICWIDTH;

		endX = startX + picWidth * MAPWIDTH + gap * (MAPWIDTH - 1);
		endY = startY + picHeight * MAPHEIGHT + gap * (MAPWIDTH - 1);

	}

	/**
	 * 截取图片
	 * 
	 * @throws Exception
	 */
	public void capture() throws Exception {
		Robot robot = new Robot();
		image = robot.createScreenCapture(new Rectangle(startX, startY, endX
				- startX, endY - startY));

	}

	/**
	 * 获取i行j列图片的坐标
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	private Point getLocation(int i, int j) {
		int x, y;
		y = (picHeight + 4) * i;
		x = (picWidth + 4) * j;
		return new Point(x, y);
	}

	/**
	 * 获取i行j列图片
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	public BufferedImage getImage(int i, int j) {
		Point point = getLocation(i, j);
		BufferedImage bufferedImage = image.getSubimage(point.x, point.y,
				picWidth, picHeight);
		return bufferedImage;
	}

}

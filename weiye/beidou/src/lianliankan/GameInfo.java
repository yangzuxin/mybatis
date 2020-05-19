package lianliankan;

/**
 * 游戏信息类
 * 
 * @author Vincent
 * 
 */
public class GameInfo {
	/**
	 * 图片的宽度和高度
	 */
	public static final int PICWIDTH = 30;
	public static final int PICHEIGHT = 34;

	/**
	 * 图片之间的间距
	 */
	public static final int GAP = 1;

	/**
	 * 截取的图片起始位置
	 */
	public static int PICX = 8;
	public static int PICY = 185;

	/**
	 * 地图的宽度和高度
	 */
	public static final int MAPWIDTH = 19;
	public static final int MAPHEIGHT = 11;

	/**
	 * 每次点击的时间间隔
	 */
	public static int SLEEPTIME = 800;

	public static void setPICX(int pICX) {
		PICX = pICX;
	}

	public static void setPICY(int pICY) {
		PICY = pICY;
	}

	public static void setSLEEPTIME(int sLEEPTIME) {
		SLEEPTIME = sLEEPTIME;
	}

}

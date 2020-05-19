package lianliankan;

import java.awt.Point;
import java.util.Stack;

/**
 * 
 * @author Vicnent
 * 
 */
public class MapDetector {
	private int EMPTY = 0;
	private int PATH = -1;

	private int startX, startY, endX, endY;
	private boolean ok = false;
	private int width, height;

	private int RIGHT = 0, DOWN = 1, LEFT = 2, UP = 3, NONE = -1;
	private int direction[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	private int[][] map;

	// 记录走过的路径
	private Stack<Point> pathStack = new Stack<>();

	public MapDetector(int[][] map, int startX, int startY, int endX, int endY,
			int emptyValue) {
		// TODO 自动生成的构造函数存根

		EMPTY = emptyValue;

		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
		this.map = map;
		width = map[0].length;
		height = map.length;

	}

	/**
	 * 深度优先搜索
	 * 
	 * @param x
	 * @param y
	 * @param coner
	 * @param oldDirection
	 */

	public void dfs(int x, int y, int coner, int oldDirection) {
		// 判断拐角数是否大于2
		if (coner > 2)
			return;

		// 判断是否越界
		if (x >= height || y >= width || x < 0 || y < 0)
			return;

		// 判断该位置是否可行
		if (map[x][y] != EMPTY)
			return;

		// 判断是否到达终点
		if (x == endX && y == endY) {
			pathStack.add(new Point(x, y));
			map[endX][endY] = PATH;
			map[startX][startY] = PATH;
			// printResult();
			clearPath(); // 把之前记录下的-1变回0
			ok = true;
			return;
		}

		// 把该位置标记为已走过
		map[x][y] = PATH;
		pathStack.add(new Point(x, y));

		// 分别往四个方向前进
		for (int newDirection = 0; newDirection < 4; newDirection++) {
			int xx = x + direction[newDirection][0];
			int yy = y + direction[newDirection][1];

			int c = coner;
			if (oldDirection != newDirection)
				c++;

			dfs(xx, yy, c, newDirection);

			if (ok == true)
				return;

		}
		// 若四个方向都走不通 放弃走该位置
		map[x][y] = EMPTY;
		pathStack.pop();
	}

	/**
	 * 把标记过的路径恢复为原样
	 */
	private void clearPath() {
		for (int i = 0; i < height; i++)
			for (int j = 0; j < width; j++)
				if (map[i][j] == PATH)
					map[i][j] = EMPTY;
	}

	/**
	 * 获取路径
	 * 
	 * @return
	 */
	public Stack<Point> getPathStack() {
		return pathStack;
	}

	/**
	 * 判断两个点是否可以联通
	 * 
	 * @return
	 */
	public boolean isValid() {
		// 先判断起点与终点元素是否相同
		if (map[startX][startY] != map[endX][endY]) {
			// System.out.println("元素不相同");
			return false;
		}
		if (startX == endX && startY == endY) {
			// System.out.println("坐标一样");
			return false;
		}

		if (map[startX][startY] == EMPTY)
			return false;

		// 先把起点和终点位置设置为可行
		int primaryValue = map[startX][startY];
		map[startX][startY] = map[endX][endY] = EMPTY;

		// 深度优先搜索
		dfs(startX, startY, -1, NONE);

		// 若寻路失败则恢复原来的值
		if (ok != true)
			map[startX][startY] = map[endX][endY] = primaryValue;

		return ok;
	}

}

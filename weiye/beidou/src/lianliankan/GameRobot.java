package lianliankan;

import java.awt.Robot;
import java.awt.event.InputEvent;

/**
 * 
 * @author Vincent
 *
 */
public class GameRobot {

	public static void clickButton(int i, int j, int m, int n) throws Exception {
		Robot robot = new Robot();

		int startX = GameInfo.PICX;
		int startY = GameInfo.PICY;
		int gap = GameInfo.GAP;
		int picHeight = GameInfo.PICHEIGHT;
		int picWidth = GameInfo.PICWIDTH;

		int x = startX + (picWidth + gap) * j + (picWidth + gap) / 2;
		int y = startY + (picHeight + gap) * i + (picHeight + gap) / 2;

		robot.mouseMove(x, y);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);

		x = startX + (picWidth + gap) * n + (picWidth + gap) / 2;
		y = startY + (picHeight + gap) * m + (picHeight + gap) / 2;

		robot.mouseMove(x, y);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
	}

}

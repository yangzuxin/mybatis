package om.xiaoan.tljqr;

import java.util.Random;
import java.util.Scanner;

public class 猜数字 {
	static Scanner stx;
	static Object a;
	static Random r;

	public static void main(String[] args) {
		stx = new Scanner(System.in);
		r = new Random();
		
		
		int x = r.nextInt(100) + 1;
		int i = x;
		System.out.println(x);
		System.out.println(i);
		
		
		
		gameProcess();

	}

	public static void gameProcess() {
		
		int count = 0;
		int count1 = 0;// 赢的局数计数
		a: while (true) {
			int y = r.nextInt(101);
			System.out.println("本次随机数为：" + y);// 打印本次随机生成的数字
			b: while (true) {
				System.out.println("请输入你要猜的数字");
				int x = stx.nextInt();
				if (x < y) {
					System.out.println("很遗憾,猜小了");
					// System.out.println("本次随机数字为:"+y);
					count++;
//					break;
				} else if (x > y) {
					System.out.println("很遗憾,猜大了");
					// System.out.println("本次随机数字为:"+y);
					count++;
//					break;
				} else if (x == y) {
					System.out.println("恭喜你,猜对了");
					count1++;
					System.out.println("当前胜利" + count1 + "局");
					if (count1 >= 0 && count1 <= 3) {
						if (count1 >= 3) {
							count1 = 3;
							System.out.println("恭喜你三局全部猜中，快去领取奖励吧！");
							break a;
						} else {
							System.out.println("你已胜利" + count1 + "局，是否继续？胜利三局奖励丰厚，继续按：1，退出输入其他数字:");
							int f = stx.nextInt();
							if (f != 1) {
								break a;
							} else {
								System.out.println("你选择了继续");
								break b;
							}
						}
					}
				}
			}
		}
		System.out.println("总共猜了" + count + "次");
		if(count >3){
			count1 = 4;
			jl(count1);
		}else{
			jl(count1);
		}
	}
	private static void jl(int count1) {
		switch (count1) {
		case 1:
			System.out.println("奖励一个亲亲");
			break;
		case 2:
			System.out.println("奖励一个亲亲抱抱");
			break;
		case 3:
			System.out.println("奖励一个亲亲抱抱举高高");
			break;
		default:
			System.out.println("奖励一个空气");
			break;
		   }
	}
	
}

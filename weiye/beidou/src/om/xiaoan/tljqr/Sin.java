package om.xiaoan.tljqr;

public class Sin {
	
	public static void main(String[] args) {
		int a = 12;
		int b = 6;
		int c = 4;
		int d = a/c;
		System.out.println(d);
	}
	public static void cos1(double a,double b,double c){
        double out=0;
        if(a>0&&b>0&&c>0){
            if (a+b>c){
                out=(a*a+b*b-c*c)/(2*a*b);
            }else if (a+c>b){
                out=(a*a+c*c-b*b)/(2*a*c);
            }else if (c+b>a){
                out=(c*c+a*a-b*b)/(2*b*c);
            }else {
                System.out.println("边长错误");
            }
        }else {
            System.out.println("范围超出边界");
        }
        System.out.println(out);
    }
    public static void cos2(double A,double a,double b) {
        //a^2 = b^2 + c^2 - 2·b·c·cosA
        //b^2 = a^2 + c^2 - 2·a·c·cosB
        //c^2 = a^2 + b^2 - 2·a·b·cosC
        System.out.println(Math.sqrt((a*a+b*b)-(2*a*b*Math.cos(Math.PI*(A/180)))));
    }
    public static void cos3(int a){
        System.out.println(Math.cos(Math.PI*(a/180)));
    }
}

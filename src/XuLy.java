import java.util.Scanner;

public class XuLy {
	final static int MIN = -100;
	final static int MAX = 100;

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = nhapN(scan);
		int a[] = taoMang(n);
		int b[] = a;
		xuatMang(a);
		a = shuffle(a);
		xuatMang(a);
		b = shuffle(a);
		int count = countShuffle(a, b);
		System.out.println("Cần " + count + " lần để mảng hoàn đổi về mảng ban đầu");
	}

	public static int[] nhapMang(Scanner scan, int n) {
		int a[] = new int[n];
		for(int i = 0; i < n; i++) {
			System.out.println("a[" + i + "] = ");
			a[i] = Integer.parseInt(scan.nextLine());
		}
		return a;
	}	
	
	public static int nhapN(Scanner scan) {
		int n;
		do {
			System.out.print("Nhập a > 0 và n phải là chẵn ");
			n = Integer.parseInt(scan.nextLine());
		} while (n <  2 || n % 2 != 0);
		return n;
	}

	public static int[] taoMang(int n) {
		int a[] = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = MIN + (int)(Math.random()*((MAX - MIN) + 1)); 
		}
		return a;
	}
	
	public static void xuatMang(int a[]) {
		for (int pt : a) {
			System.out.print(pt + "\t");
		}
		System.out.println("\n");
	}
	
	public static int[] shuffle(int a[]) {
		int tam[] = new int[a.length];
		for(int i = 0; i < a.length/2; i++) {
			tam[2*i] = a[i];
			tam[2*i + 1] = a[a.length/2 + i];
		}
		a = tam;
		return a;
	}  
	
	public static boolean isEqual(int a[], int b[]) {
		for(int i = 0; i < a.length; i++) {
			if(a[i] != b[i]) {
				return false; // không bằng nhau
			}
		}
		return true;
	}
	
	public static int countShuffle(int a[], int b[]) {
		int count = 0;
		do {
			b = shuffle(b);
			xuatMang(b);
			count++;
		} while(!isEqual(a,b));
	 return count;
	}
}

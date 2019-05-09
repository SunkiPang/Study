class Main {
  public static void main(String[] args) {
    methodB(3);
  }
  public static void methodB(int n){
	if (n < 1)
	  	System.out.println('B');
	else{
		methodB(n - 1);
		System.out.println('R');
	}
  }
}

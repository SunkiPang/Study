class Main {
  public static void main(String[] args) {
    methodB(3);
  }
  public static int Fibonacci(int n){
    if (n == 1)
      return 1;
  }
   else
      return (n + Fibonacci(n-1));
}

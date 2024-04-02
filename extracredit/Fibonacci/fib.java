package extracredit.Fibonacci;

public class fib {
    public static int fibonacci(int n){
        if(n == 1 || n == 0){
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
        
    public static void main(String[] args) {
        int x = fibonacci(12);
        System.out.println(x);
        
    }
}
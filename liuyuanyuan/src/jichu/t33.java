package jichu;

public class t33 {
    public static void main(String[] args) {
        for(int n=2;n<=100;n++){
            if(isPrime(n)){
                System.out.print(n+" ");
            }
        }
    }

    public static boolean isPrime(int num){
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}

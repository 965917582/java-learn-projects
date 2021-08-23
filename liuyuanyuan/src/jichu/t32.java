package jichu;

public class t32 {
    public static void main(String[] args) {
        double total = 100;
        double bounce = 100;//掉下去反弹的高度
        for(int i=2;i<=10;i++){
            total+=bounce;
            bounce/=2;
            System.out.println("第"+i+"次弹："+bounce);
        }
        System.out.println("共经过："+total+"米");

    }
}

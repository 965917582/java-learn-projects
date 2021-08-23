package com;

public class TraditionalThreadCommunication {

    public static void main(String[] args) {

        final Business business = new Business();
        new Thread(new Runnable() {
            public void run() {
                for (int i=0;i<=50;i++){
                    business.sub(i);
                }
            }
        }).start();


        for (int i=0;i<=50;i++){
            business.main(i);
        }
    }


    static class Business{
        boolean bShouldSub=true;

        public synchronized  void sub(int i){
            while(!bShouldSub){
                try{
                    this.wait();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
            for (int j=0;j<=10;j++){
                System.out.println("sub thread "+i+"-"+j);
            }
            bShouldSub=false;
            this.notify();
        }

        public synchronized void main(int i)  {
            while(bShouldSub){
                try{
                    this.wait();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            for (int j = 0; j <= 10; j++) {
                System.out.println("main thread " + i + "-" + j);
            }
            bShouldSub=true;
            this.notify();
        }
    }
}

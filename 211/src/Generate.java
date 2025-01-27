public class Generate {
    public void Generation(String abc,int a){
        System.out.print(abc);
        for(int i=0;i<3;i++){
            try {
                Thread.sleep(a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(".");
        }
        try {
            Thread.sleep(a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}

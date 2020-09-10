public class ThreadTest extends Thread{

    static final int size = 10000000;
    static final int h = size / 2;

    public ThreadTest(Runnable runnable1, String s) {
        super(runnable1, s);
    }

    public static void main(String[] args) {
       oneThread();
       twoThreads();
    }



    public static void oneThread(){
        long a = System.currentTimeMillis();
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Итог: " + (System.currentTimeMillis() - a));
    }


    public static void twoThreads(){
        long a = System.currentTimeMillis();
        float[] arr = new float[size];
        float[] tempArr1 = new float[h];
        float[] tempArr2 = new float[h];

        System.arraycopy(arr, 0, tempArr1, 0, h);
        System.arraycopy(arr, h, tempArr2, 0, h);

        System.out.println("Создание и разбивка массивов закончены: " + (System.currentTimeMillis() - a));

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
           iternalMethod(tempArr1, 1);
            }
        };
        ThreadTest threadTest1 = new ThreadTest(runnable1, "Thread-1");

       Runnable runnable2 = new Runnable() {
           @Override
           public void run() {
            iternalMethod(tempArr2, 2);
           }
       };
       ThreadTest threadTest2 = new ThreadTest(runnable2, "Thread-2");

       
       threadTest1.start();
       threadTest2.start();

        try {
            threadTest1.join();
            threadTest2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(tempArr1, 0, arr, 0, h);
        System.arraycopy(tempArr2, 0, arr, h, h);

        System.out.println("Итог: " + (System.currentTimeMillis() - a));

    }

    static void iternalMethod(float[] arr, int part) {
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("просчёт части "+ part + ", завершен за: " + (System.currentTimeMillis() - a));
    }
}

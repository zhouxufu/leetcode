package multithread;

/**
 * @author zhouxufu
 */
public class InterruptDemo implements Runnable{

    @Override
    public void run(){
        while(!Thread.currentThread().isInterrupted()) {
            try {
                System.out.println("in run() - about to sleep for 20 seconds");
                Thread.sleep(1000);
                System.out.println("in run() - woke up");
            } catch (InterruptedException e) {
                System.out.println("in run() - interrupted while sleeping");
                //处理完中断异常后，返回到run（）方法人口，
                //如果没有return，线程不会实际被中断，它会继续打印下面的信息
                if(!Thread.currentThread().isInterrupted()){
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("in run() - leaving normally");
        }
    }

    public static void main(String[] args) {
        InterruptDemo si = new InterruptDemo();
        Thread t = new Thread(si);
        t.start();
        //主线程休眠2秒，从而确保刚才启动的线程有机会执行一段时间
        try {
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("in main() - interrupting other thread");
        //中断线程t
        t.interrupt();
        System.out.println("in main() - leaving");
    }
}

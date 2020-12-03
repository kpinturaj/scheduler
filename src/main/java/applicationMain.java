import com.uber.api.Scheduler;
import com.uber.api.impl.SchedulerImpl;

public class applicationMain {

    public static void main(String[] args) throws InterruptedException {
        Scheduler scheduler = new SchedulerImpl();

        TestCommand command = new TestCommand();

        scheduler.schedulerTask(command, System.currentTimeMillis()+5000);

        scheduler.schedulerTask(command, System.currentTimeMillis()+10000);

        scheduler.schedulerTask(command, System.currentTimeMillis()+15000);


        Thread.sleep(150000);
    }
}

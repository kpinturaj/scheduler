import com.uber.command.Command;

public class TestCommand implements Command {
    @Override
    public void task() {

        System.out.println("Executing task at " + System.currentTimeMillis() );
    }
}

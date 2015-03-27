/**
 * Created by cprasenj on 3/27/2015.
 */
public class WIN_PL1 implements Executable {
    @Override
    public void execute(String grid) {
        System.out.println(grid);
        System.out.println("Player1 won!!!!");
        System.exit(0);
    }
}

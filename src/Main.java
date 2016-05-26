import com.epam.state_pattern.Fisher;
import com.epam.state_pattern.Human;

/**
 * Created by Asus on 26.05.2016.
 */
public class Main {

    public static void main(String[] args) {
        Human me = new Human("Maria", Human.Gender.FEMALE, 19, new Fisher());
        System.out.println(me.toString());

        me.doSomething();
        me.chooseHobby(Human.State.STAND_ON_MUSHROOM_GLADE);
        me.doSomething();
        me.chooseHobby(Human.State.SEE_BEAST);
        me.doSomething();
    }
}
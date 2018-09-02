/*
 * this class is the AI medium in task 3
 *
 * */


public class AIMedium extends AIEasy {
    public static String[] comGuessArray = new String[7];  //create a array for storaging all the guess
    public static String AIMediumWay() {
        for (; ; ) {
            for (int i = 0; i < 7; i++) {    //go through the array, if the new guess is equal with the old one, then guess again, until without repetition
                if (!Computer.getRandom().equals(comGuessArray[i]))
                    return Computer.getRandom();
            }
        }
    }
}

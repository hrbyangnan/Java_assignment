/*
 *
 *This class is the main class that we can execute and test the whole program.
 *by Nan Yang  nyan779
 *
 */



import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class testSolution {
    public static void main(String[] args) throws readAILevelException, readManuOrAutoException, IOException {
        Collection<String> output = new ArrayList<>();  //create a collection for storage all text of output to file in task 7
        output.add("Bulls & Cows game result.");        //add text into collection in task 7
        Solution s = new Solution();
//        Computer c = new Computer();
        System.out.println("Please enter Input Mode(1:From File; 2:Manually)");
        int aiMode = Keyboard.readManuOrAuto();         //storage the way of input guesses of user in task 6
        String url = null;
        if (aiMode == 1) {                              //if aiMode==1 then read user's guesses from a file, else enter guesses manually
            url = Keyboard.readUrl();
        }
        System.out.println("Please enter AI level(1:easy; 2:medium; 3:hard):");
        int aiLevel = Keyboard.readAILevel();            //storage the AI level of user in task 6
        int round;                                       //define a var for turns in bonus task-1
        System.out.println("Please input the number of turns:");
        round = Keyboard.readRound();
        System.out.println("Please enter your secret code:");
        String userGuess;
        String userNumber = Keyboard.readInput();
        output.add("Your code: " + userNumber);             //add text into collection in task 7
        String aiNumber = Computer.getRandom();
        String comGuess = Computer.getRandom();
        output.add("Computer's code: " + comGuess);         //add text into collection in task 7
        output.add("---");                                  //add text into collection in task 7

        assert url != null;
        BufferedReader br = new BufferedReader(new FileReader(url));

        for (int i = 0; i < round; i++) {           //allow user and computer guess the times of round that user enter just before in bonus task-1
            userGuess = br.readLine();
            {
                System.out.print("You guess: ");
                System.out.println(userGuess);
                int temp = i + 1;                 //because var "i" is from 0 to round, so if we use it as the number of turn, we have to add 1 as the result.
                output.add("Turn " + temp + ":");  //add text into collection in task 7
            }

            String userResult = s.getHint(aiNumber, userGuess);
            output.add("Your guessed " + userGuess + ", scoring " + userResult);    //add text into collection in task 7
            System.out.println("Result: " + userResult);
            System.out.println();

            switch (aiLevel) {      ////find different way of the AI level of user in task 6
                case 1:
                    comGuess = AIEasy.AIEasyWay();
                    break;
                case 2:
                    comGuess = AIMedium.AIMediumWay();
                    AIMedium.comGuessArray[i] = comGuess;
                    break;
                case 3:
                    comGuess = AIHard.AIHardWay();
                    AIHard.comGuessArray[i] = s.getHint(comGuess, userNumber);
                    break;
            }

            String comResult = s.getHint(comGuess, userNumber);
            System.out.println("Computer guess: " + comGuess);
            System.out.println("Result: " + comResult);
            output.add("Computer guessed " + comGuess + ", scoring " + comResult);
            if (userResult.equals("4A0B")) {      //if user's guess is correct, then end the loop by using break.
                System.out.println("You win! :)");
                output.add("You win! :)");              //add text into collection in task 7
                break;
            }
            if (comResult.equals("4A0B")) {         //if computer's guess is correct, then end the loop by using break.
                System.out.println("Computer win! :)");
                output.add("Computer win! :)");             //add text into collection in task 7
                break;
            }

            System.out.println("---");
            output.add("---");              //add text into collection in task 7

        }
        br.close();
        System.out.println("Output result to File? 1:Yes; 2:No.)");
        int outPutOrNot = Keyboard.readManuOrAuto();
        if (outPutOrNot == 1) {  //if user choose to output the result to file
            String outUrl = Keyboard.readOutUrl();
            FileOutputStream fos = new FileOutputStream(outUrl);
            Iterator<String> it;             //using iterator of collection to go through all collection and output it into file
            for (it = output.iterator(); it.hasNext(); ) {
                String str = it.next();
                fos.write(str.getBytes());
                fos.write("\r\n".getBytes());
            }
            fos.close();
        }
    }
}


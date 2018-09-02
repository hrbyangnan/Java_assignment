import java.util.*;
import java.io.*;

class Keyboard {

    private static Scanner in = new Scanner(System.in);
    private static boolean redirected = false;

    static String readInput() {

        try {
            if (!redirected) {
                redirected = System.in.available() != 0;
            }
        } catch (IOException e) {
            System.err.println("An error has occurred in the Keyboard constructor.");
            e.printStackTrace();
            System.exit(-1);
        }

        try {
            String input = in.nextLine();
            if (redirected) {
                System.out.println(input);
            }
            return input;
        } catch (NoSuchElementException e) {
            return null; // End of file
        } catch (IllegalStateException e) {
            System.err.println("An error has occurred in the Keyboard.readInput() method.");
            e.printStackTrace();
            System.exit(-1);
        }
        return null;
    }


    static int readAILevel() throws readAILevelException {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        if (i != 1 && i != 2 && i != 3) {
            throw new readAILevelException("please input 1-3 number");
        }

        return i;
    }

    static int readManuOrAuto() throws readManuOrAutoException {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        if (i != 1 && i != 2) {
            throw new readManuOrAutoException("please input 1-2 number");
        }

        return i;
    }

    static int readRound() throws readManuOrAutoException {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        if (i < 1) {
            throw new readManuOrAutoException("please input a valid number for round");
        }

        return i;
    }

    static String readUrl() {
        String url;
        for (; ; ) {
            Scanner sc = new Scanner(System.in);
            System.out.println("please input URL of file:");
            url = sc.nextLine();
            File file = new File(url);
            if (!file.canRead()) {
                System.out.print(("invalid URL! "));
            } else if (file.canRead()) break;
        }
        return url;
    }

    static String readOutUrl() throws IOException {
        String url;
//        loop1:
//        for (; ; ) {
        Scanner sc = new Scanner(System.in);
        System.out.println("please input URL of file:");
        url = sc.nextLine();
        File file = new File(url);
        if (!file.exists()) {
            file.createNewFile();
        }

//            if (!file.canWrite()) {
//                System.out.print(("invalid URL! "));
//            } else if (file.canWrite()) {
//                break loop1;
//            }
//        }
        return url;
    }

}
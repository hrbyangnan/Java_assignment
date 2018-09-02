import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public String getHint(String secret, String guess) {
        char[] secrets = secret.toCharArray();
        char[] guesses = guess.toCharArray();

        HashMap<Character, Integer> maps = new HashMap<>();
        List<Character> postDealList = new LinkedList<>();

        int As = 0, Bs = 0;

        for (int i = 0; i < secrets.length; i++) {
            if (secrets[i] == guesses[i])
                As++;
            else {
                if (!maps.containsKey(secrets[i]))
                    maps.put(secrets[i], 0);

                maps.replace(secrets[i], maps.get(secrets[i]) + 1);
                postDealList.add(guesses[i]);
            }
        }
        int size = postDealList.size();
        for (int i = 0; i < size; i++) {
            char guessChar = postDealList.get(i);
            if (maps.containsKey(guessChar)) {
                int val = maps.get(guessChar);
                Bs++;
                if (val - 1 == 0)
                    maps.remove(guessChar);
                else
                    maps.replace(guessChar, val - 1);
            }
        }
        return ""+String.valueOf(As) + " bulls and " + String.valueOf(Bs) + " cows";
    }
}
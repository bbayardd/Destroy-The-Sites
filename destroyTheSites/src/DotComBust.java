import java.util.ArrayList;

public class DotComBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom>dotComList = new ArrayList<>();
    int NumOfGuesses = 0;
    public void setUpGame() {
        DotCom first = new DotCom();
        DotCom second = new DotCom();
        DotCom third = new DotCom();
        first.SetName("Pets.com");
        second.SetName("People.com");
        third.SetName("Trees.com");
        dotComList.add(first);
        dotComList.add(second);
        dotComList.add(third);
        System.out.println("Your goal remove 3 website");
        System.out.println("Also you need to do it use minimum steps");

        for (DotCom dotComToSet : dotComList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.SetLocationCells(newLocation);
        }
    }
    public void startPlaying() {
        while (!dotComList.isEmpty()){
            String userGuess = helper.getUserInput("Make your move");
            checkUserGuess(userGuess);
        }
        finishGame();
    }
    public void checkUserGuess(String userGuess) {
        NumOfGuesses++;
        String result = "Miss";

        for (DotCom dotComTest : dotComList) {
            result = dotComTest.checkYourself(userGuess);
            if (result.equals("Yep")) {
                break;
            }
            if (result.equals("Done")) {
                dotComList.remove(dotComTest);
                break;
            }
        }
        System.out.println(result);
    }
    private void finishGame() {
        System.out.println("Your done with all sites. You have nothing.");
        if (NumOfGuesses < 18)
            System.out.println("You make " + NumOfGuesses + " move. Well done!");
        else
            System.out.println("You make " + NumOfGuesses +"next time try harder!!!");
    }
    public static void main(String [] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
}

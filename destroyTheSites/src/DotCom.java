import java.util.ArrayList;

public class DotCom {
    private ArrayList<String> locationCells;
    int numOfHits = 0;
    private String name;

    public void SetLocationCells(ArrayList<String> loc) {
        locationCells = loc;
    }
    public void SetName(String UserInput) {
        name = UserInput;
    }
    public String checkYourself(String userInput) {
        String result = "Miss";
        if (locationCells.contains(userInput)) {
            locationCells.remove(locationCells.indexOf(userInput));
            if (locationCells.isEmpty()) {
                return ("Done");
            } else {
                result = "Yep";
            }
        }
        return (result);
    }
}

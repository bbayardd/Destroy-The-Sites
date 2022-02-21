import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameHelper {
    private static ArrayList<String> locations = new ArrayList<>();
    private static int count;
    public ArrayList<String> placeDotCom(int numberOfSites) {
        ArrayList<String> singleLocations = new ArrayList<>();
        boolean tester;
            tester = false;
            while (!tester) {
                int cellX = (int) (Math.random() * 7);
                int cellY = (int) (Math.random() * 7);
                ArrayList<Integer> coordinates = new ArrayList<>();
                if (cellX - 2 >= 0)
                    if (checkCoordinates(locations, cellX, cellY, 1))
                        coordinates.add(1);
                if (cellX + 2 <= 6)
                    if (checkCoordinates(locations, cellX, cellY, 3))
                        coordinates.add(3);
                if (cellY + 2 <= 6)
                    if (checkCoordinates(locations, cellX, cellY, 2))
                        coordinates.add(2);
                if (cellY - 2 >= 0)
                    if (checkCoordinates(locations, cellX, cellY, 4))
                        coordinates.add(4);
                int count = coordinates.size();
                if (count != 0) {
                    int godOfRandom = (int) (Math.random() * count);
                    count = coordinates.get(godOfRandom);
                    setValue(locations, cellX,cellY,count);
                    setValue(singleLocations, cellX, cellY,count);
                    tester = true;
                }
            }
        return singleLocations;
    }
    public void setValue(ArrayList<String> locations, int x, int y, int way) {
        if (way == 1) {
            locations.add(Integer.toString(x--).concat(Integer.toString(y)));
            locations.add(Integer.toString(x--).concat(Integer.toString(y)));
            locations.add(Integer.toString(x).concat(Integer.toString(y)));
        } else if (way == 2) {
            locations.add(Integer.toString(x).concat(Integer.toString(y++)));
            locations.add(Integer.toString(x).concat(Integer.toString(y++)));
            locations.add(Integer.toString(x).concat(Integer.toString(y)));
        } else if (way == 3) {
            locations.add(Integer.toString(x++).concat(Integer.toString(y)));
            locations.add(Integer.toString(x++).concat(Integer.toString(y)));
            locations.add(Integer.toString(x).concat(Integer.toString(y)));
        } else if (way == 4) {
            locations.add(Integer.toString(x).concat(Integer.toString(y--)));
            locations.add(Integer.toString(x).concat(Integer.toString(y--)));
            locations.add(Integer.toString(x).concat(Integer.toString(y--)));
        }
    }

    public boolean checkCoordinates (ArrayList<String> Coordinates ,int x, int y, int way) {
        String test3;
        if (Coordinates.size() == 0)
            return true;
        if (way == 1) {
                for (int i = 0; i < 3; i++) {
                    test3 = Integer.toString(x).concat(Integer.toString(y));
                    if (Coordinates.contains(test3))
                        return false;
                    x--;
                }
            } else if (way == 2) {
                for (int i = 0; i < 3; i++) {
                    test3 = Integer.toString(x).concat(Integer.toString(y));
                    if (Coordinates.contains(test3))
                        return false;
                    y++;
                }
            } else if (way == 3) {
            for (int i = 0; i < 3; i++) {
                test3 = Integer.toString(x).concat(Integer.toString(y));
                if (Coordinates.contains(test3))
                    return false;
                x++;
            }
        }  else if (way == 4) {
            for (int i = 0; i < 3; i++) {
                test3 = Integer.toString(x).concat(Integer.toString(y));
                if (Coordinates.contains(test3))
                    return false;
                x++;
            }
        }
        return true;
    }


    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.println(prompt + " ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) {
                return null;
            }
        } catch (IOException e) {
            System.out.println("IOExeption: " + e);
        }System.out.println(inputLine);
        return inputLine;
    }
}

package panels.GameResultsPanel.InternalStorageManagement;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ResultsManagement {
    private static final String SCORES = "scores.txt";

    public void setScores(long score){
Scanner in = new Scanner(System.in);
        List<Long> loadedScores = loadScores();

        if(!loadedScores.isEmpty())
            if (loadedScores.get(loadedScores.size()-1)< score){
//                String name = in.next();
//                System.out.println(name);
                List<Long> newListScores = new ArrayList<>();
                int i;
                for (i = 0; i < 10; i++) {
                    if(loadedScores.size()==i){
                        break;
                    }
                    if(loadedScores.get(i)< score){
                        newListScores.add(score);
                        break;
                    }
                    newListScores.add(loadedScores.get(i));
                }
                for (; i < 9; i++) {
                    if(loadedScores.size()==i){
                        break;
                    }
                    newListScores.add(loadedScores.get(i));
                }
                loadedScores = newListScores;
                saveScores(loadedScores);
            }

        loadedScores = loadScores();

int num =0;
        for (long scores : loadedScores) {
            num++;
            System.out.println(num+ ". Score: " + scores);
        }
    }
    public void saveScores(List<Long> scores) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(SCORES))) {
            for (long score : scores) {
                writer.println(score);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Long> loadScores() {
        List<Long> scores = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(SCORES))) {
            while (scanner.hasNextLong()) {
                scores.add(scanner.nextLong());
            }
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
        return scores;
    }

    public List<Long> getLoadScores() {
        return loadScores();
    }
}

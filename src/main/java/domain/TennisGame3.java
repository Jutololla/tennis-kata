package domain;

import java.util.HashMap;

public class TennisGame3 implements TennisGame {

    private int p2;
    private int p1;
    private final String p1N;
    private final String p2N;

    public TennisGame3(String p1N, String p2N) {
        this.p1N = p1N;
        this.p2N = p2N;
    }

    public String getScore() {
        HashMap<Integer, String> pointNomenclature = new HashMap<>();
        pointNomenclature.put(0,"Love");
        pointNomenclature.put(1,"Fifteen");
        pointNomenclature.put(2,"Thirty");
        pointNomenclature.put(3,"Forty");
        if (isInMiddleGame()) {
            return evaluateScore(pointNomenclature);
        } else if (p1 == p2)
        {
            return "Deuce";
        }
        return advantageAndWin();

    }

    private String advantageAndWin() {
        String score;
        if (p1 > p2) score = p1N;
        else score = p2N;
        if ((p1 - p2) * (p1 - p2) == 1) return "Advantage " + score;
        return "Win for " + score;
    }

    private String evaluateScore(HashMap<Integer, String> pointNomenclature) {
        String score;
        score = pointNomenclature.get(p1);
        if (p1 == p2) return score + "-All";
        return score + "-" + pointNomenclature.get(p2);
    }

    private boolean isInMiddleGame() {
        return p1 < 4 && p2 < 4 && (p1 + p2 != 6);
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.p1 += 1;
        else
            this.p2 += 1;

    }

}

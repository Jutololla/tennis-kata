package domain;

import java.util.HashMap;

public class TennisGame1 implements TennisGame {
    
    private int mScore1 = 0;
    private int mScore2 = 0;

    public TennisGame1(String player1Name, String player2Name) {
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            mScore1 += 1;
        else
            mScore2 += 1;
    }

    public String getScore() {
        String score = "";
        if (mScore1 == mScore2)
        {
            score = checkEvenScoreCase();
        }
        else if (mScore1 >3 || mScore2 >3)


        {
            score = checkFourOrMorePointsCase();
        }
        else
        {
            score = checkInGameCase(score);
        }
        return score;
    }

    private String checkInGameCase(String stringScore) {
        StringBuilder score = new StringBuilder(stringScore);
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0,"Love");
        map.put(1,"Fifteen");
        map.put(2,"Thirty");
        map.put(3,"Forty");
        score.append(map.get(mScore1));
        score.append("-");
        score.append(map.get(mScore2));
        return score.toString();
    }

    private String checkFourOrMorePointsCase() {
        int minusResult = mScore1 - mScore2;
        String leadingPlayer = (minusResult>0)?"player1":"player2";
        return Math.abs(minusResult) == 1 ? "Advantage " + leadingPlayer : "Win for " + leadingPlayer;
    }

    private String checkEvenScoreCase() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0,"Love-All");
        map.put(1,"Fifteen-All");
        map.put(2,"Thirty-All");
        String score=map.get(mScore1);
        return (score==null)?"Deuce":score;
    }
}

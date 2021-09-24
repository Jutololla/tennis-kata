package domain;

import java.util.HashMap;

public class TennisGame2 implements TennisGame {
    public int P1point = 0;
    public int P2point = 0;


    public String P1res = "";
    public String P2res = "";

    public TennisGame2(String player1Name, String player2Name) {
    }

    public String getScore() {
        int pointsDifference=P1point-P2point;
        HashMap<Integer, String> pointAccount = new HashMap<>();
        pointAccount.put(0,"Love");
        pointAccount.put(1,"Fifteen");
        pointAccount.put(2,"Thirty");
        pointAccount.put(3,"Forty");
        String score = "";

        score = checkEvenScore(pointsDifference, pointAccount, score);

        score = checkLoveScore(pointAccount, score);

        score = checkScore(pointAccount, score);

        String leadingPlayer = (pointsDifference>0)?"player1":"player2";

        score = checkAdvantage(score, leadingPlayer);

        score = checkVictory(score);
        return score;
    }

    private String checkLoveScore(HashMap<Integer, String> pointAccount, String score) {
        if (isCheckLoveScore(P1point, P2point)) {
            P1res= pointAccount.get(P1point);
            P2res = "Love";
            score = P1res + "-" + P2res;
        }
        if (isCheckLoveScore(P2point, P1point)) {
            P2res= pointAccount.get(P2point);
            P1res = "Love";
            score = P1res + "-" + P2res;
        }
        return score;
    }

    private boolean isCheckLoveScore(int p1point, int p2point) {
        return p1point > 0 && p2point == 0;
    }

    private String checkEvenScore(int pointsDifference, HashMap<Integer, String> pointAccount, String score) {
        if (pointsDifference ==0) {
            score = pointAccount.get(P1point);
                score += "-All";
            if (P1point >= 3) {
                score = "Deuce";
            }
        }
        return score;
    }

    private String checkScore(HashMap<Integer, String> pointAccount, String score) {
        if (isCheckScore()) {
            P1res= pointAccount.get(P1point);
            P2res= pointAccount.get(P2point);
            score = P1res + "-" + P2res;
        }
        return score;
    }

    private boolean isCheckScore() {
        return P1point > P2point && P1point < 4 || P2point > P1point && P2point < 4;
    }

    private String checkAdvantage(String score, String leadingPlayer) {
        if(isCheckAdvantage(P1point, 3, P2point, 3, P2point != P1point)){
            score="Advantage "+leadingPlayer;
        }
        return score;
    }

    private boolean isCheckAdvantage(int p1point, int i, int p2point, int i2, boolean b) {
        return p1point >= i && p2point >= i2 && b;
    }

    private String checkVictory(String score) {
        if (isCheckAdvantage(P1point, 4, P2point, 0, (P1point - P2point) >= 2)) {
            score = "Win for player1";
        }
        if (isCheckAdvantage(P2point, 4, P1point, 0, (P2point - P1point) >= 2)) {
            score = "Win for player2";
        }
        return score;
    }


    public void p1Score() {
        P1point++;
    }

    public void p2Score() {
        P2point++;
    }

    public void wonPoint(String player) {
        if (player.equals("player1"))
            p1Score();
        else
            p2Score();
    }
}
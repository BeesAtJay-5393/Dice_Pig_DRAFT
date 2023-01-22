public class Player {
    private String name;
    private int points;

    public Player(){
        name = "Player";
        points = 0;
    }

    public Player(String name){
        this.name = name;
        points = 0;
    }

    //Developer Notes:
    //  Here, we need to find a way to get the CLASS Player to have access
    //  to the CLASS Die.

    //The above statement is incorrect.

    public String getName(){
        return this.name;
    }

    public int getPoints(){
        return this.points;
    }

    public void addPoints(int roundPoints){
        this.points += roundPoints;
    }
}

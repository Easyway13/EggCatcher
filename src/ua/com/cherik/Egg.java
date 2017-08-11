package ua.com.cherik;


public class Egg {

    private int x;
    private int y;
    private boolean isAlive;


    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }


    public Egg(int x) {
        this.x = x;
        this.y = 0;
        isAlive = true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void checkBorders(){
        if(y == Room.game.getHeight()-1 && x!= Room.game.getBasket().getX() )
        {
            isAlive = false;
        }
        System.out.println(Room.game.getEggCount()+ " " + isAlive());


    }

    public void move() {

        if(x == Room.game.getBasket().getX() && y == Room.game.getBasket().getY())
        {
            Room.game.addEggCount(1);
            Room.game.eatEgg();
        }

        checkBorders();

        if(isAlive == false)
            return;

        y++;

    }
}

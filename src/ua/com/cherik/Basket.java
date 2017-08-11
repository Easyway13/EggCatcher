package ua.com.cherik;

public class Basket {

    private int x;
    private int y;
    private int outOfBorders=0;
    private Direction direction;

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }


    public Basket(int widthOfRoom, int heightOfRoom) {
        x = widthOfRoom/2;
        y = heightOfRoom-1;


    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public void move() {

        if(Room.game.getEgg().isAlive() == false)
            return;

        if(direction == Direction.RIGHT){
            move(1);
        } else if(direction == Direction.LEFT){
            move(-1);
        }

    }



    public void checkBorders(){
        if(x>= Room.game.getWidth()-1)
            outOfBorders = 2;
        else if(x<0)
            outOfBorders =1;


    }

    public void move(int x) {

        checkBorders();

        if(outOfBorders == 0)
            this.x += x;
        else
            return;



    }

}

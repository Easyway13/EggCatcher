package ua.com.cherik;

import java.awt.event.KeyEvent;


public class Room {
    private int width;
    private int height;
    private Basket basket;
    private Egg egg;
    private int eggCount;

    public int getEggCount() {
        return eggCount;
    }
    public void addEggCount(int eggCount) {
        this.eggCount += eggCount;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public Basket getBasket() {
        return basket;
    }
    public void setBasket(Basket basket) {
        this.basket = basket;
    }
    public Egg getEgg() {
        return egg;
    }
    public void setEgg(Egg egg) {
        this.egg = egg;
    }

    public Room (int width, int height){
        this.width = width;
        this.height = height;
        this.basket = new Basket(width, height);
    }


    public static Room game;

    public void run() {

        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();


        while (egg.isAlive()) {

            if (keyboardObserver.hasKeyEvents()) {
                KeyEvent event = keyboardObserver.getEventFromTop();

                if (event.getKeyChar() == 'q') return;


                if (event.getKeyCode() == KeyEvent.VK_LEFT)
                    basket.move(-1);



                else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                    basket.move(1);


            }


            egg.move();
            print();
            sleep();
        }


        System.out.println("Game Over!");
    }

    public void print() {

        int[][] matrix = new int[height][width];


        matrix[basket.getY()][basket.getX()] = 1;



        matrix[egg.getY()][egg.getX()] = egg.isAlive() ? 3 : 2;


        String[] symbols = {" . ", "|_|", "RIP", "(@)"};
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(symbols[matrix[y][x]]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

    }

    public void eatEgg() {
        createEgg();
    }

    public void createEgg() {

        int x = (int) (Math.random() * width);
        int y = 0;

        System.out.print(x + " " + y + "; ");

        egg = new Egg(x);


    }



    public static void main(String[] args) {
        game = new Room(20, 20);
        game.createEgg();
        game.run();

    }

    private int initialDelay = 520;
    private int delayStep = 20;


    public void sleep() {
        try {
            int level = game.getEggCount();
            int delay = level < 15 ? (initialDelay - delayStep * level) : 200;
            Thread.sleep(delay);
        } catch (InterruptedException e) {
        }
    }
}



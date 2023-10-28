import stanford.karel.SuperKarel;

public class Task1 extends SuperKarel
{
    private void putBeeperAndMove(){
        putBeeper();
        move();
    }
    public void run() {
        setBeepersInBag(69);
        turnLeft();
        putBeeper();
        for(int i=0;i<4;i++){
            move();
            putBeeper();
        }
        turnRight();
        for(int i=0;i<2;i++){
            move();
            putBeeper();
        }
        move();
        turnRight();
        move();
        putBeeper();
        move();
        move();
        putBeeper();
        move();
        turnRight();
        for(int i=0;i<2;i++){
            move();
            putBeeper();
        }
        turnRight();
        move();
        move();
        turnRight();
        putBeeper();
        move();
        putBeeper();
        for(int i=0;i<3;i++){
            move();
        }
    }

}

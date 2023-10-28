import stanford.karel.SuperKarel;

public class Task2 extends SuperKarel
{
    public void run() {
        goToTowardsBeeper();
        pickBeeper();
        returnToStart();
    }
    private void goToTowardsBeeper(){
        move();
        move();
        turnRight();
        move();
        turnLeft();
        move();
    }
    private void returnToStart(){
        turnAround();
        move();
        turnRight();
        move();
        turnLeft();
        move();
        move();
        turnAround();
    }

}

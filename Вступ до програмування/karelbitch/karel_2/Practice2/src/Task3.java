import stanford.karel.SuperKarel;

public class Task3 extends SuperKarel {
    public void run() {
        setBeepersInBag(228);
        for(int i = 0; i < 7; i++) { //i = number of pillars to rebuild
            rebuildPillar();
            if(frontIsClear()){
                for(int j = 0; j < 3; j++){ //j = number of moves to do after rebuilding
                    move();
                }
            }
        }
    }
    private void putBeeperIfAbsent(){
        if(noBeepersPresent()){
            putBeeper();
        }
    }
    private void rebuildPillar(){
        putBeeperIfAbsent();
        turnLeft();
        while(frontIsClear()){
            move();
            putBeeperIfAbsent();
        }
        turnAround();
        while(frontIsClear()){
            move();
        }
        turnLeft();
    }
}
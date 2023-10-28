/*
    Реалізувати програму з лекції Ханойські вежі. З клавіатури вводиться число дисків на першій голці
     і голка на яку необхідно перенести диски. Ваша програма має вивести в консоль послідовність
      дій для перенесення дисків. Та кількість кроків.

      File: Hanoi.java
      Author: Федорич Володимир
 */

import acm.program.ConsoleProgram;

public class Hanoi extends ConsoleProgram {
    long steps = 0;

    public void run(){

        tower(5,'A','C', 'B');
        println("Completed in " + steps + " steps");
    }

    /*
        Move the top n-1 disks to the auxiliary tower.
        Move 1 disk from source rod to destination rod.
        Take the n-1 disks from auxiliary disk to the destination rod.
     */
    private void tower(int n, char from_rod, char to_rod, char helper_rod){
        if(n == 0){
            return;
        }
        if (n == 1)
        {
            println("Take disk 1 from rod " +  from_rod + " to rod " + to_rod);
            steps++;
            return;
        }
        tower(n-1, from_rod, helper_rod, to_rod);
        println("Take disk " + n + " from rod " +  from_rod + " to rod " + to_rod);
        tower(n-1, helper_rod, to_rod, from_rod);
        steps += 1;
    }
}

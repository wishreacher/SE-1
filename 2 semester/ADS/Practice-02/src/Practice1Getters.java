public class Practice1Getters {
    public static int getMaxGrade(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static int getMinGrade(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static double getAverage(int[] grades) {
        double sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];
        }
        return sum / grades.length;
    }

    public static int amountOfNerds(int[] grades) {
        double average = getAverage(grades);
        int nerds = 0;
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] > average) {
                nerds++;
            }
        }
        return nerds;
    }

    public static int amountOfSuckers(int[] grades) {
        double average = getAverage(grades);
        int nerds = 0;
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] < average) {
                nerds++;
            }
        }
        return nerds;
    }

    public static int getVidminno(int[] grades) {
        int n = 0;
        for (int i = 0; i < grades.length; i++) {
            if (91 <= grades[i] && grades[i] <= 100) {
                n++;
            }
        }
        return n;
    }

    public static int getZadovilno(int[] grades) {
        int n = 0;
        for (int i = 0; i < grades.length; i++) {
            if (60 <= grades[i] && grades[i] <= 70) {
                n++;
            }
        }
        return n;
    }

    public static int getDobre(int[] grades) {
        int n = 0;
        for (int i = 0; i < grades.length; i++) {
            if (71 <= grades[i] && grades[i] <= 90) {
                n++;
            }
        }
        return n;
    }

    public static int getNezadovilno(int[] grades) {
        int n = 0;
        for (int i = 0; i < grades.length; i++) {
            if (0 <= grades[i] && grades[i] <= 59) {
                n++;
            }
        }
        return n;
    }
}

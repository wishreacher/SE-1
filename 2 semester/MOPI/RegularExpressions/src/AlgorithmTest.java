public class AlgorithmTest {
    public static void main(String[] args){
        Algorithm test = new Algorithm(" ->. abc");
        System.out.print("Algorithm 0" + test);
        System.out.print(" -> " +  test.eval("ai",100));

        Algorithm test1 = new Algorithm("a -> bc");
        System.out.print("\nAlgorithm 1: " + test1);
        System.out.print(" -> " +  test1.eval("ai",100));

        Algorithm test2 = new Algorithm("b -> a");
        System.out.print("\nAlgorithm 2: " + test2);
        System.out.print(" -> " +  test2.eval("bb",50));

        Algorithm test3 = new Algorithm("c -> ab");
        System.out.print("\nAlgorithm 3: " + test3);
        System.out.print(" -> " +  test3.eval("cc",75));

        Algorithm test4 = new Algorithm("d -> cba");
        System.out.print("\nAlgorithm 4: " + test4);
        System.out.print(" -> " +  test4.eval("dd",25));
    }
}
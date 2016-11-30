/**
 * Created by Samson on 07-11-2016.
 */
public class RunProgram {
    public static void main(String[] args){

        SearchTree<Integer> numbers = new SearchTree<>();

        numbers.add(2);
        numbers.add(8);
        numbers.add(1);
        numbers.add(0);
        numbers.add(7);
        numbers.add(6);
        numbers.add(4);
        numbers.add(9);



        numbers.printSideways();
        System.out.println("Count left nodes: ");
        System.out.print(numbers.countLeftNodes());
        System.out.println();
        System.out.println("Even");
        System.out.println(numbers.countEvenBranches());
        System.out.println();
        System.out.println(numbers.printLevel(2));
        //System.out.println(numbers.countEmpty());
        // System.out.println(numbers.getLeft());

    }
}

/**
 * Created by Samson on 06-11-2016.
 */
public class RunProgram {
    public static void main(String[] args){

        SearchTree<Integer> numbers = new SearchTree<>();

        numbers.add(3);
        numbers.add(5);
        numbers.add(2);
        numbers.add(1);
        numbers.add(4);
        numbers.add(6);



        numbers.printSideways();


        System.out.println(numbers.countLeaves());

        System.out.println(numbers.countLeftNodes());

    }
}

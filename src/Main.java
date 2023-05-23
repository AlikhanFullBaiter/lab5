package src;

public class Main {
    public static void main(String[] args) {
        BST<Integer, String> myBST = new BST<>();
        myBST.put(6 , "Gavi");
        myBST.put(2, "Bellerin");
        myBST.put(3, "Pique");
        myBST.put(5,"Busquets");
        myBST.put(1, "Ter Stegen");
        myBST.put(4 , "Araujo");

        System.out.println(myBST.get(2));
        myBST.delete(2);
        System.out.println(myBST.get(2));

        System.out.println(myBST.iterator());
        System.out.println(myBST.findHeight());
    }
}

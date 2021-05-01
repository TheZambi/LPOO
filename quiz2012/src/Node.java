public class Node {
    static int number=0;
    int thisNumber = 0;

    public Node()
    {
        number++;
        thisNumber = number;
    }

    static void resetNumbering(int i){number = i;}
    int getNumber(){return 0;}
    Folder getParent(){return null;}
    String getName(){return null;}
    int getSize(){return 0;};

    protected void setSeparator(char separator) {
    }
}

class Pen{
    String colour;
    String type;

    public void printColour(){
        System.out.println(this.colour);
    }

    public void printType(){
        System.out.println(this.type);
    }

}


public class Oops {
    public static void main(String args[]){
        Pen p1 = new Pen();
        Pen p2 = new Pen();

        p1.colour = "black";
        p1.type = "m1";

        p2.colour = "blue";
        p2.type = "m2";

        p1.printColour();
        p2.printColour();
    }
}

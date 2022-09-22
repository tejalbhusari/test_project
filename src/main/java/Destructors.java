public class Destructors {

        public void finalize() throws Throwable{
            System.out.println("Object is destroyed by the Garbage Collector");
        }
        public static void main(String[] args) {

            Destructors test = new Destructors();
            test = null;
            System.gc();
        }

}

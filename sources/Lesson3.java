public class Lesson3 {
    public static void main(String[] args) {
        int cond = (int)Math.signum(-377);
        System.out.println((int)Math.signum(-377));
        
        int a = 3;
        int b = 4;
        double alpha = Math.PI / 2;
        System.out.println(0.5 * a * b * Math.sin(alpha));
        System.out.println(Math.pow(Math.PI, 2.0)); 

        switch (cond) {
            case -1:
                System.out.println("Negative");
                break;
            case 0:
                System.out.println("Zero");
                break;
            case 1:
                System.out.println("Positive");
            default:
                break;
        }
    }    
}

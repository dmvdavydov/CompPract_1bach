public class Lesson2 {
    public static void main(String[] args) {
        int a = -7;//Integer.MIN_VALUE;
        int aa = a >>> 1;
        byte b = Byte.SIZE;
        short s = Short.MAX_VALUE;
        int integ = Integer.MAX_VALUE;
        long lo = Long.MAX_VALUE;
        float fl = Float.MAX_VALUE;
        double doub = Double.MAX_VALUE;
        char ch = Character.MAX_VALUE;

        System.out.println("Var a equal " + a);
        System.out.println("Var a in binary equal " + Integer.toBinaryString(a));
        System.out.println("Var b equal " + b);
        System.out.println("Var a >>> 1 equal " + aa);
        System.out.println("Var a >>> 1 in binary equal " + Integer.toBinaryString(aa));

        System.out.println("Var s equal " + s);
        System.out.println("Var integ equal " + integ);

        System.out.println("Var lo equal " + lo);
        System.out.println("Var fl equal " + fl);

        System.out.println("Var doub equal " + doub);
        System.out.println("Var ch equal " + Integer.toHexString(ch));

        System.out.println("b + 1 equal " + (integ + 1));
        System.out.println("b + 3 equal " + (integ + 3));

        System.out.println("Размер (в байтах) Integer: " + Integer.BYTES);
        System.out.println("Размер (в байтах) Long: " + Long.BYTES);
        System.out.println("Размер (в байтах) Float: " + Float.BYTES);
        System.out.println("Размер (в байтах) Double: " + Double.BYTES);

        System.out.println("НЕ (3 РАВНО 7) ? " + !(3==7));
    }

}

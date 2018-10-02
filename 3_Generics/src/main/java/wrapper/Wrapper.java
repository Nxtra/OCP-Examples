package wrapper;

public class Wrapper {

    public static void main(String[] args) {
        int integer = new Integer(1);
        byte abyte = (byte) integer;
        byte bbyte = (byte) 1;
        byte cbyte = new Byte((byte) integer);
        short ashort = abyte;
        short bshort = (short) integer;
        float afloat = new Float(1.0);
        double adouble = afloat;
        Float aFloat = new Float(1.0);
        Double aDouble = (double) aFloat;
        float bfloat = 1.0f;
        double bdouble = 1.0d;
    }
}

public class Main {
    public static void main(String[] args) throws Exception{
        String str = "abbccda";
        HuffManCoder hf = new HuffManCoder(str);
        String cs = hf.encode(str);
        System.out.println(cs);
        String dc = hf.decode(cs);
        System.out.println(dc);
    }

    // Bitset can be used: like an array but with bit at each index;
}

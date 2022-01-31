public class Debug {
    // 16進数表示
    static void printHex(int hex) {
        System.out.println(Integer.toHexString(hex));
    }
    
    // 2進数表示
    static void printBinary(int hex) {
        System.out.println(Integer.toBinaryString(hex));
    }

    // 参照渡しテスト
    void retArr(byte[] oldArr) {
        oldArr[0] = 1;
        oldArr[1] = 2;
    }
}

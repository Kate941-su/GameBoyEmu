public class TestMain {
    public static void main(String[] args) {
        Cpu cpu = new Cpu();
        Mmu mem = new Mmu();
        Debug debug = new Debug();
        System.out.println(Cpu.FlagName.Z);
        byte[] newArr = new byte[3];
        debug.retArr(newArr);
        System.out.println(newArr[1]);
    }
}

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/* 
レジスタ
A   F
B   C
D   E
H   L
フラグレジスタ(F)
|Z|N|H|C|0|0|0|0|
Z->0フラグ
N->加算フラグ
H->ハーフキャリーフラグ
C->キャリーフラグ
SP (stack pointer)
PC (program counter)
*/
public class Cpu {
    // レジスタ
    protected byte a = 0;    // アキュームレーターレジスタ
    protected byte f = 0;    // フラグレジスタ
    protected byte b = 0;
    protected byte c = 0;
    protected byte d = 0;
    protected byte e = 0;
    protected byte h = 0;
    protected byte l = 0;
    protected short sp = 0;    // スタックポインタ
    protected short pc = 0;    // プログラムカウンタ
    // メモリ
    Mmu mmu;
public static enum FlagName {
    Z(8),
    N(7),
    H(6),
    C(5);
    private int id;
    private FlagName(int id) {
        this.id = id;
    }        
}
    // コンストラクタ
    public Cpu() {
        // 最初にロードするメモリ
        pc = 0x100;// ブートローダーが0x100なので
        mmu = new Mmu();
        // テストコード
        Path path = Paths.get("./", "black.gb");
        try {
            // テスト
            byte[] data = Files.readAllBytes(path);
            // output BinaryDate
            for (int i = 0; i < data.length; i++) {
                if (data[i] != 0x00) {
                    System.out.printf("%02x ", data[i]);                    
                }
            }
            System.out.println("\nSuccessed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // メモリから読み取る
    byte read(short address) {
        byte[] memory = mmu.getMemory();
        return memory[(int)address];
    }
    // メモリに書き込む
    void write(short address, byte data) {
        byte[] memory = mmu.getMemory();
        memory[(int)address] = data;
    }
    // プログラムカウンタを進める
    int aheadPc(byte opecode) {
        return ConstVal.OPECODE_BYTE_SIZE[opecode];
    }
    // 16ビット演算で足し算する
    short convert16bitFromRegisters(byte registerTop, byte registerBottom) {
        int temp = (int)registerTop << 8;
        temp += (int)registerBottom;
        return (short) temp;
    }
    // 8ビット演算でインクリメント
    byte inc8bit(byte register) {
        return (byte)(register + 1);
    }
    // 8ビット演算でデクリメント
    byte dec8bit(byte register) {
        return (byte)(register - 1);
    }
    // 16ビット演算でインクリメント
    byte inc16bit(byte registerTop, byte registerBottom, boolean isTop) {
        int temp = registerTop;
        temp = temp << 8 + registerBottom;
        temp += 1;
        if (isTop) {
            return (byte)(temp >> 8);
        } else {
            return (byte)(temp & 0xFF);
        }
    }
    // 命令を実行する
    void execute(byte opecode) {
        switch (opecode) {
            case 0x00:
            case 0x01:
                b = read((short)(pc + 2));
                c = read((short)(pc + 1));
            case 0x02:
                b = (byte)0;
                c = a;
            case 0x03:
                b = inc16bit(b, c, true);
                c = inc16bit(b, c, false);
            case 0x04:
                b = inc8bit(b);
            // まだ(1/22)
            case 0x05:
                b = dec8bit(b);
            case 0x06:
                b = read((short)(pc + 2));
                c = read((short)(pc + 1));
            case 0x07:
                b = (byte)0;
                c = a;
            case 0x08:
                b = inc16bit(b, c, true);
                c = inc16bit(b, c, false);
            case 0x09:
                b = inc8bit(b);
            case 0x0A:

            case 0x0B:
                b = read((short)(pc + 2));
                c = read((short)(pc + 1));
            case 0x0C:
                b = (byte)0;
                c = a;
            case 0x0D:
                b = inc16bit(b, c, true);
                c = inc16bit(b, c, false);
            case 0x0E:
                b = inc8bit(b);
        }
        aheadPc(opecode);
    }
}

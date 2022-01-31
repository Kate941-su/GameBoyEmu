/*
    Memory map layout
    http://gameboy.mongenel.com/dmg/asmmemmap.html
    0000-00FF   Interrupt routines
                VBlank: 0x40
                LCDC:   0x48
                Timer:  0x50
                Serial: 0x58
                Joypad: 0x60
    0100-014F   Cartridge header
    0150-3FFF   ROM bank 0 (fixed)
    4000-7FFF   Switchable ROM banks
    VRAM
    8000-87FF   Tileset #1: tiles 0 to 127, 16 bytes per tile
    8800-8FFF   Tileset #1: tiles 128 to 255
                Tileset #0: tiles -1 to -128
    9000-97FF   Tileset #0: tiles 0 to 127
    9800-9BFF   Tilemap #0: 32x32=1024 tiles (bytes)
    9C00-9FFF   Tilemap #1: 32x32=1024 tiles (bytes)
    C000-CFFF   Internal RAM bank 0 (fixed)
    D000-DFFF   Switchable RAM banks
    FE00-FE9F   Object Attribute Memory
    FF00-FF7F   Hardware registers
    FF80-FFFE   High RAM
*/
public class Mmu{
    protected byte[] memory = new byte[ConstVal.MEMORY_SIZE];
    public Mmu() {
        Debug.printHex(ConstVal.MEMORY_SIZE);
        // メモリの初期化
        for (int i = 0; i < memory.length; i++) {
            memory[i] = 0;
        }
    }
    public byte[] getMemory() {
        return memory;
    }
}
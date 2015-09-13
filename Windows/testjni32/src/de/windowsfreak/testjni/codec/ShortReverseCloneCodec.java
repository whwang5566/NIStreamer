package de.windowsfreak.testjni.codec;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * This copies a source ByteBuffer which is not backed by a Short[] array to a target ByteBuffer which is a Short[] array.
 */
public class ShortReverseCloneCodec implements Codec {
    @Override
    public int encode(ByteBuffer compressedData, ByteBuffer uncompressedData, int uncompressedLength) throws IOException {
        synchronized(compressedData) {
            synchronized (uncompressedData) {
                uncompressedData.rewind();
                compressedData.clear();
                uncompressedData.asShortBuffer().get(compressedData.asShortBuffer().array(), 0, uncompressedLength);
                compressedData.limit(uncompressedLength);
                return compressedData.limit();
            }
        }
    }

    @Override
    public void decode(ByteBuffer uncompressedData, int uncompressedLength, ByteBuffer compressedData, int compressedLength) throws IOException {
        new Exception("Warning! This method is not implemented.").printStackTrace();
    }
}

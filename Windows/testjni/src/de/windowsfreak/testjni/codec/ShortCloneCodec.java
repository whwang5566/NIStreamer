package de.windowsfreak.testjni.codec;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * This copies a source ByteBuffer which is a Short[] array to a target ByteBuffer which is not backed by a Byte[] array.
 */
public class ShortCloneCodec implements Codec {
    @Override
    public int encode(final ByteBuffer compressedData, final ByteBuffer uncompressedData, final int uncompressedLength) throws IOException {
        synchronized(compressedData) {
            synchronized (uncompressedData) {
                uncompressedData.rewind();
                compressedData.clear();
                compressedData.asShortBuffer().put(uncompressedData.asShortBuffer());
                compressedData.limit(uncompressedLength);
                return compressedData.limit();
            }
        }
    }

    @Override
    public void decode(final ByteBuffer uncompressedData, final int uncompressedLength, final ByteBuffer compressedData, final int compressedLength) throws IOException {
        new Exception("Warning! This method is not implemented.").printStackTrace();
    }
}
package com.avozdedeus.avozdedeusjpc.audio.analysis;

/**
 * In-memory PCM 16-bit signed little-endian mono stream for TarsosDSP [AudioDispatcher].
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000fH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/avozdedeus/avozdedeusjpc/audio/analysis/PcmAudioInputStream;", "Lbe/tarsos/dsp/io/TarsosDSPAudioInputStream;", "pcmBytes", "", "sampleRateHz", "", "([BF)V", "format", "Lbe/tarsos/dsp/io/TarsosDSPAudioFormat;", "position", "", "close", "", "getFormat", "getFrameLength", "", "read", "buffer", "offset", "length", "skip", "bytesToSkip", "audio_release"})
public final class PcmAudioInputStream implements be.tarsos.dsp.io.TarsosDSPAudioInputStream {
    @org.jetbrains.annotations.NotNull()
    private final byte[] pcmBytes = null;
    @org.jetbrains.annotations.NotNull()
    private final be.tarsos.dsp.io.TarsosDSPAudioFormat format = null;
    private int position = 0;
    
    public PcmAudioInputStream(@org.jetbrains.annotations.NotNull()
    byte[] pcmBytes, float sampleRateHz) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public be.tarsos.dsp.io.TarsosDSPAudioFormat getFormat() {
        return null;
    }
    
    @java.lang.Override()
    public long getFrameLength() {
        return 0L;
    }
    
    @java.lang.Override()
    @kotlin.jvm.Throws(exceptionClasses = {java.io.IOException.class})
    public int read(@org.jetbrains.annotations.NotNull()
    byte[] buffer, int offset, int length) throws java.io.IOException {
        return 0;
    }
    
    @java.lang.Override()
    @kotlin.jvm.Throws(exceptionClasses = {java.io.IOException.class})
    public long skip(long bytesToSkip) throws java.io.IOException {
        return 0L;
    }
    
    @java.lang.Override()
    @kotlin.jvm.Throws(exceptionClasses = {java.io.IOException.class})
    public void close() throws java.io.IOException {
    }
}
package com.avozdedeus.avozdedeusjpc.tuner;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B;\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\rH\u0002J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\rH\u0002J\b\u0010\u0016\u001a\u00020\u0005H\u0007J\u0006\u0010\u0017\u001a\u00020\u0005R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/avozdedeus/avozdedeusjpc/tuner/AudioRecordTunerPitchAnalyzer;", "", "onPitchDetected", "Lkotlin/Function1;", "", "", "onPitchLost", "Lkotlin/Function0;", "sampleRate", "", "bufferSize", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;II)V", "audioRecord", "Landroid/media/AudioRecord;", "isRunning", "", "lock", "workerThread", "Ljava/lang/Thread;", "analyzePitch", "record", "releaseRecord", "start", "stop", "Companion", "tuner_debug"})
public final class AudioRecordTunerPitchAnalyzer {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<java.lang.Float, kotlin.Unit> onPitchDetected = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function0<kotlin.Unit> onPitchLost = null;
    private final int sampleRate = 0;
    private final int bufferSize = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Object lock = null;
    @kotlin.jvm.Volatile()
    private volatile boolean isRunning = false;
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private volatile android.media.AudioRecord audioRecord;
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private volatile java.lang.Thread workerThread;
    @java.lang.Deprecated()
    public static final int DEFAULT_SAMPLE_RATE = 44100;
    @java.lang.Deprecated()
    public static final int DEFAULT_BUFFER_SIZE = 2048;
    @java.lang.Deprecated()
    public static final int BITS_PER_SAMPLE = 16;
    @java.lang.Deprecated()
    public static final int BYTES_PER_SAMPLE = 2;
    @java.lang.Deprecated()
    public static final int CHANNEL_COUNT = 1;
    @java.lang.Deprecated()
    public static final float SHORT_MAX_VALUE = 32768.0F;
    @java.lang.Deprecated()
    public static final float MIN_DETECTED_PITCH_HZ = 55.0F;
    @java.lang.Deprecated()
    public static final float MAX_DETECTED_PITCH_HZ = 880.0F;
    @java.lang.Deprecated()
    public static final long STOP_JOIN_TIMEOUT_MS = 300L;
    @java.lang.Deprecated()
    public static final long PITCH_LOST_TIMEOUT_NANOS = 250000000L;
    @org.jetbrains.annotations.NotNull()
    private static final com.avozdedeus.avozdedeusjpc.tuner.AudioRecordTunerPitchAnalyzer.Companion Companion = null;
    
    public AudioRecordTunerPitchAnalyzer(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> onPitchDetected, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onPitchLost, int sampleRate, int bufferSize) {
        super();
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    public final void start() {
    }
    
    public final void stop() {
    }
    
    private final void analyzePitch(android.media.AudioRecord record) {
    }
    
    private final void releaseRecord(android.media.AudioRecord record) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/avozdedeus/avozdedeusjpc/tuner/AudioRecordTunerPitchAnalyzer$Companion;", "", "()V", "BITS_PER_SAMPLE", "", "BYTES_PER_SAMPLE", "CHANNEL_COUNT", "DEFAULT_BUFFER_SIZE", "DEFAULT_SAMPLE_RATE", "MAX_DETECTED_PITCH_HZ", "", "MIN_DETECTED_PITCH_HZ", "PITCH_LOST_TIMEOUT_NANOS", "", "SHORT_MAX_VALUE", "STOP_JOIN_TIMEOUT_MS", "tuner_debug"})
    static final class Companion {
        
        private Companion() {
            super();
        }
    }
}
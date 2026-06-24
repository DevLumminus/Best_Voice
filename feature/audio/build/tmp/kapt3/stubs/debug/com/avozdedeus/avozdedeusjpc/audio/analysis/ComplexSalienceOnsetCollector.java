package com.avozdedeus.avozdedeusjpc.audio.analysis;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\b0\u0005\u00a2\u0006\u0002\u0010\tJ \u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u0014H\u0002J\u0006\u0010\u001f\u001a\u00020\bJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/avozdedeus/avozdedeusjpc/audio/analysis/ComplexSalienceOnsetCollector;", "Lbe/tarsos/dsp/AudioProcessor;", "bufferSize", "", "onCandidates", "Lkotlin/Function1;", "", "Lcom/avozdedeus/avozdedeusjpc/audio/analysis/OnsetCandidate;", "", "(ILkotlin/jvm/functions/Function1;)V", "fft", "Lbe/tarsos/dsp/util/fft/FFT;", "fftBuffer", "", "lastOnsetTime", "", "magnitude", "oldMagnitude", "peakWindow", "Lkotlin/collections/ArrayDeque;", "Lcom/avozdedeus/avozdedeusjpc/audio/analysis/SalienceFrame;", "pendingCandidates", "", "phase", "phaseBeforePrevious", "predictedPhaseDeviation", "previousPhase", "considerPeakCandidate", "previous", "current", "next", "flushPending", "process", "", "audioEvent", "Lbe/tarsos/dsp/AudioEvent;", "processingFinished", "audio_debug"})
final class ComplexSalienceOnsetCollector implements be.tarsos.dsp.AudioProcessor {
    private final int bufferSize = 0;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<java.util.List<com.avozdedeus.avozdedeusjpc.audio.analysis.OnsetCandidate>, kotlin.Unit> onCandidates = null;
    @org.jetbrains.annotations.NotNull()
    private final be.tarsos.dsp.util.fft.FFT fft = null;
    @org.jetbrains.annotations.NotNull()
    private final float[] fftBuffer = null;
    @org.jetbrains.annotations.NotNull()
    private final float[] magnitude = null;
    @org.jetbrains.annotations.NotNull()
    private final float[] phase = null;
    @org.jetbrains.annotations.NotNull()
    private final float[] oldMagnitude = null;
    @org.jetbrains.annotations.NotNull()
    private final float[] previousPhase = null;
    @org.jetbrains.annotations.NotNull()
    private final float[] phaseBeforePrevious = null;
    @org.jetbrains.annotations.NotNull()
    private final float[] predictedPhaseDeviation = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.collections.ArrayDeque<com.avozdedeus.avozdedeusjpc.audio.analysis.SalienceFrame> peakWindow = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.avozdedeus.avozdedeusjpc.audio.analysis.OnsetCandidate> pendingCandidates = null;
    private double lastOnsetTime = -1.0 / 0.0;
    
    public ComplexSalienceOnsetCollector(int bufferSize, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<com.avozdedeus.avozdedeusjpc.audio.analysis.OnsetCandidate>, kotlin.Unit> onCandidates) {
        super();
    }
    
    @java.lang.Override()
    public boolean process(@org.jetbrains.annotations.NotNull()
    be.tarsos.dsp.AudioEvent audioEvent) {
        return false;
    }
    
    @java.lang.Override()
    public void processingFinished() {
    }
    
    public final void flushPending() {
    }
    
    private final void considerPeakCandidate(com.avozdedeus.avozdedeusjpc.audio.analysis.SalienceFrame previous, com.avozdedeus.avozdedeusjpc.audio.analysis.SalienceFrame current, com.avozdedeus.avozdedeusjpc.audio.analysis.SalienceFrame next) {
    }
}
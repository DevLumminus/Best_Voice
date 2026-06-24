package com.avozdedeus.avozdedeusjpc.tuner;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0004J\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u001aJ\u000e\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0004J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0010\u001a\u00020\u0004J\u0014\u0010\u001e\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000e\u00a8\u0006 "}, d2 = {"Lcom/avozdedeus/avozdedeusjpc/tuner/TunerPitch;", "", "()V", "A4_FREQUENCY_HZ", "", "A4_MIDI_NOTE", "", "MAX_GUITAR_PITCH_HZ", "METER_IN_TUNE_CENTS", "METER_MAX_CENTS", "MIN_GUITAR_PITCH_HZ", "noteLabels", "", "", "[Ljava/lang/String;", "centsBetween", "frequencyHz", "targetFrequencyHz", "log2", "value", "meterIndicatorAngleDegrees", "", "fraction", "meterIndicatorFraction", "cents", "meterIndicatorSegmentIndex", "(D)Ljava/lang/Integer;", "noteLabelFor", "readingFor", "Lcom/avozdedeus/avozdedeusjpc/tuner/TunerPitchReading;", "floorMod", "modulus", "tuner_debug"})
public final class TunerPitch {
    private static final double A4_FREQUENCY_HZ = 440.0;
    private static final int A4_MIDI_NOTE = 69;
    private static final double MIN_GUITAR_PITCH_HZ = 55.0;
    private static final double MAX_GUITAR_PITCH_HZ = 880.0;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String[] noteLabels = {"C", "C#", "D", "Eb", "E", "F", "F#", "G", "G#", "A", "Bb", "B"};
    public static final double METER_MAX_CENTS = 50.0;
    public static final double METER_IN_TUNE_CENTS = 5.0;
    @org.jetbrains.annotations.NotNull()
    public static final com.avozdedeus.avozdedeusjpc.tuner.TunerPitch INSTANCE = null;
    
    private TunerPitch() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.avozdedeus.avozdedeusjpc.tuner.TunerPitchReading readingFor(double frequencyHz) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String noteLabelFor(double frequencyHz) {
        return null;
    }
    
    public final double centsBetween(double frequencyHz, double targetFrequencyHz) {
        return 0.0;
    }
    
    public final float meterIndicatorFraction(double cents) {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer meterIndicatorSegmentIndex(double cents) {
        return null;
    }
    
    public final float meterIndicatorAngleDegrees(float fraction) {
        return 0.0F;
    }
    
    private final double log2(double value) {
        return 0.0;
    }
    
    private final int floorMod(int $this$floorMod, int modulus) {
        return 0;
    }
}
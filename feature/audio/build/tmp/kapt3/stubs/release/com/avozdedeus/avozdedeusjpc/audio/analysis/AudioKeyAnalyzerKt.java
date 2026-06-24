package com.avozdedeus.avozdedeusjpc.audio.analysis;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0013\n\u0002\b\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"FREQUENCY_A4_HZ", "", "KEY_ANALYSIS_MAX_DURATION_SEC", "KEY_BUFFER_SIZE", "", "KEY_CLASS_COUNT", "KEY_CONFIDENCE_MARGIN_FOR_FULL_SCALE", "KEY_HOP_SIZE", "KEY_MAX_FREQUENCY_HZ", "KEY_MIN_CONFIDENCE", "", "KEY_MIN_CORRELATION", "KEY_MIN_FREQUENCY_HZ", "KEY_MIN_RMS", "KEY_MIN_VOICED_FRAMES", "MIDI_A4", "MajorKeyProfile", "", "MinorKeyProfile", "audio_release"})
public final class AudioKeyAnalyzerKt {
    private static final double KEY_ANALYSIS_MAX_DURATION_SEC = 90.0;
    private static final int KEY_BUFFER_SIZE = 4096;
    private static final int KEY_HOP_SIZE = 2048;
    private static final int KEY_CLASS_COUNT = 12;
    private static final double KEY_MIN_FREQUENCY_HZ = 55.0;
    private static final double KEY_MAX_FREQUENCY_HZ = 5000.0;
    private static final double KEY_MIN_RMS = 0.003;
    private static final int KEY_MIN_VOICED_FRAMES = 4;
    private static final double KEY_MIN_CORRELATION = 0.1;
    private static final float KEY_MIN_CONFIDENCE = 0.05F;
    private static final double KEY_CONFIDENCE_MARGIN_FOR_FULL_SCALE = 0.25;
    private static final double MIDI_A4 = 69.0;
    private static final double FREQUENCY_A4_HZ = 440.0;
    @org.jetbrains.annotations.NotNull()
    private static final double[] MajorKeyProfile = {6.35, 2.23, 3.48, 2.33, 4.38, 4.09, 2.52, 5.19, 2.39, 3.66, 2.29, 2.88};
    @org.jetbrains.annotations.NotNull()
    private static final double[] MinorKeyProfile = {6.33, 2.68, 3.52, 5.38, 2.6, 3.53, 2.54, 4.75, 3.98, 2.69, 3.34, 3.17};
}
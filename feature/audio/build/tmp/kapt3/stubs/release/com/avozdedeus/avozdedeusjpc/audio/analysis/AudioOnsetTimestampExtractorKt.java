package com.avozdedeus.avozdedeusjpc.audio.analysis;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"BUFFER_OVERLAP", "", "BUFFER_SIZE", "CANDIDATE_BATCH_SIZE", "MINIMUM_INTER_ONSET_INTERVAL_SEC", "", "SILENCE_THRESHOLD_DB", "TIMESTAMP_OVERLAP_OFFSET_FACTOR", "audio_release"})
public final class AudioOnsetTimestampExtractorKt {
    private static final int BUFFER_SIZE = 2048;
    private static final int BUFFER_OVERLAP = 1024;
    private static final double MINIMUM_INTER_ONSET_INTERVAL_SEC = 0.03;
    private static final double SILENCE_THRESHOLD_DB = -70.0;
    private static final double TIMESTAMP_OVERLAP_OFFSET_FACTOR = 4.3;
    private static final int CANDIDATE_BATCH_SIZE = 256;
}
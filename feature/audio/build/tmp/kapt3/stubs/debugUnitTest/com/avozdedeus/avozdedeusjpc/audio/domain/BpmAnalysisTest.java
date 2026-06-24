package com.avozdedeus.avozdedeusjpc.audio.domain;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007J\b\u0010\b\u001a\u00020\u0004H\u0007J\b\u0010\t\u001a\u00020\u0004H\u0007J\b\u0010\n\u001a\u00020\u0004H\u0007J\b\u0010\u000b\u001a\u00020\u0004H\u0007\u00a8\u0006\f"}, d2 = {"Lcom/avozdedeus/avozdedeusjpc/audio/domain/BpmAnalysisTest;", "", "()V", "comb filter prefers periodic pulse over non periodic ghost intervals", "", "empty or single timestamp returns no bpm", "harmonic reinforcement finds the beat when adjacent onsets are subdivisions", "histogram and periodic validation pick repeated 500ms interval over fewer false intervals", "intervals outside valid bpm range are ignored", "moving average is no longer populated by bpm analysis", "regular half second timestamps return 120 bpm", "weak periodicity still returns best candidate with low confidence", "audio_debugUnitTest"})
public final class BpmAnalysisTest {
    
    public BpmAnalysisTest() {
        super();
    }
}
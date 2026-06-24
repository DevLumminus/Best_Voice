package com.avozdedeus.avozdedeusjpc.audio.analysis;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/avozdedeus/avozdedeusjpc/audio/analysis/AudioKeyAnalyzer;", "", "analyze", "Lcom/avozdedeus/avozdedeusjpc/audio/analysis/AudioKeyAnalysisResult;", "uri", "Landroid/net/Uri;", "audio_debug"})
public abstract interface AudioKeyAnalyzer {
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.avozdedeus.avozdedeusjpc.audio.analysis.AudioKeyAnalysisResult analyze(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri);
}
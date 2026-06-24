package com.avozdedeus.avozdedeusjpc.audio.analysis;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\nH\u0016J \u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/avozdedeus/avozdedeusjpc/audio/analysis/OnsetCandidateDatabase;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "databaseFile", "Ljava/io/File;", "(Landroid/content/Context;Ljava/io/File;)V", "ensureParentDirectory", "", "getReadableDatabase", "Landroid/database/sqlite/SQLiteDatabase;", "getWritableDatabase", "onCreate", "db", "onUpgrade", "oldVersion", "", "newVersion", "audio_debug"})
final class OnsetCandidateDatabase extends android.database.sqlite.SQLiteOpenHelper {
    @org.jetbrains.annotations.NotNull()
    private final java.io.File databaseFile = null;
    
    public OnsetCandidateDatabase(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.io.File databaseFile) {
        super(null, null, null, 0);
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.NotNull()
    android.database.sqlite.SQLiteDatabase db) {
    }
    
    @java.lang.Override()
    public void onUpgrade(@org.jetbrains.annotations.NotNull()
    android.database.sqlite.SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.database.sqlite.SQLiteDatabase getWritableDatabase() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.database.sqlite.SQLiteDatabase getReadableDatabase() {
        return null;
    }
    
    private final void ensureParentDirectory() {
    }
}
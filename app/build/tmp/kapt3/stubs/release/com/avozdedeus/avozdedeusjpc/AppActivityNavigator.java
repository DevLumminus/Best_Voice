package com.avozdedeus.avozdedeusjpc;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J$\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0014\u0010\u0011\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0011\u001a\u00020\u0004*\u00020\u00062\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0015H\u0002\u00a8\u0006\u0016"}, d2 = {"Lcom/avozdedeus/avozdedeusjpc/AppActivityNavigator;", "Lcom/avozdedeus/avozdedeusjpc/core/navigation/AppNavigator;", "()V", "openAbout", "", "context", "Landroid/content/Context;", "openAcordes", "openAudio", "audioUri", "Landroid/net/Uri;", "fileName", "", "openHelp", "openHome", "openSettings", "openTuner", "launch", "intent", "Landroid/content/Intent;", "destination", "Ljava/lang/Class;", "app_release"})
public final class AppActivityNavigator implements com.avozdedeus.avozdedeusjpc.core.navigation.AppNavigator {
    
    @javax.inject.Inject()
    public AppActivityNavigator() {
        super();
    }
    
    @java.lang.Override()
    public void openHome(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @java.lang.Override()
    public void openAudio(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.net.Uri audioUri, @org.jetbrains.annotations.Nullable()
    java.lang.String fileName) {
    }
    
    @java.lang.Override()
    public void openTuner(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @java.lang.Override()
    public void openAbout(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @java.lang.Override()
    public void openHelp(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @java.lang.Override()
    public void openSettings(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @java.lang.Override()
    public void openAcordes(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    private final void launch(android.content.Context $this$launch, java.lang.Class<?> destination) {
    }
    
    private final void launch(android.content.Context $this$launch, android.content.Intent intent) {
    }
}
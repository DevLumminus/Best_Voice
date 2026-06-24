package com.avozdedeus.avozdedeusjpc;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.avozdedeus.avozdedeusjpc.about.SobreActivity;
import com.avozdedeus.avozdedeusjpc.about.SobreActivity_MembersInjector;
import com.avozdedeus.avozdedeusjpc.about.SobreViewModel;
import com.avozdedeus.avozdedeusjpc.about.SobreViewModel_HiltModules;
import com.avozdedeus.avozdedeusjpc.about.SobreViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.avozdedeus.avozdedeusjpc.about.SobreViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.avozdedeus.avozdedeusjpc.acorde.AcordesActivity;
import com.avozdedeus.avozdedeusjpc.acorde.AcordesActivity_MembersInjector;
import com.avozdedeus.avozdedeusjpc.acorde.AcordesViewModel;
import com.avozdedeus.avozdedeusjpc.acorde.AcordesViewModel_HiltModules;
import com.avozdedeus.avozdedeusjpc.acorde.AcordesViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.avozdedeus.avozdedeusjpc.acorde.AcordesViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.avozdedeus.avozdedeusjpc.audio.AudioActivity;
import com.avozdedeus.avozdedeusjpc.audio.AudioActivity_MembersInjector;
import com.avozdedeus.avozdedeusjpc.audio.AudioPlaybackService;
import com.avozdedeus.avozdedeusjpc.audio.AudioPlaybackService_MembersInjector;
import com.avozdedeus.avozdedeusjpc.audio.analysis.DefaultAudioKeyAnalyzer;
import com.avozdedeus.avozdedeusjpc.audio.analysis.DefaultOnsetAnalyzer;
import com.avozdedeus.avozdedeusjpc.audio.analysis.OnsetAnalysisSessionCache;
import com.avozdedeus.avozdedeusjpc.audio.data.AudioMediaControllerCoordinator;
import com.avozdedeus.avozdedeusjpc.audio.data.AudioSessionRepository;
import com.avozdedeus.avozdedeusjpc.audio.data.SharedPreferencesBpmAnalysisCache;
import com.avozdedeus.avozdedeusjpc.audio.presentation.AudioViewModel;
import com.avozdedeus.avozdedeusjpc.audio.presentation.AudioViewModel_HiltModules;
import com.avozdedeus.avozdedeusjpc.audio.presentation.AudioViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.avozdedeus.avozdedeusjpc.audio.presentation.AudioViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.avozdedeus.avozdedeusjpc.core.common.prefs.SharedPreferencesUserUiPreferences;
import com.avozdedeus.avozdedeusjpc.help.HelpActivity;
import com.avozdedeus.avozdedeusjpc.help.HelpActivity_MembersInjector;
import com.avozdedeus.avozdedeusjpc.help.HelpViewModel;
import com.avozdedeus.avozdedeusjpc.help.HelpViewModel_HiltModules;
import com.avozdedeus.avozdedeusjpc.help.HelpViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.avozdedeus.avozdedeusjpc.help.HelpViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.avozdedeus.avozdedeusjpc.home.MainActivity;
import com.avozdedeus.avozdedeusjpc.home.MainActivity_MembersInjector;
import com.avozdedeus.avozdedeusjpc.home.MainViewModel;
import com.avozdedeus.avozdedeusjpc.home.MainViewModel_HiltModules;
import com.avozdedeus.avozdedeusjpc.home.MainViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.avozdedeus.avozdedeusjpc.home.MainViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.avozdedeus.avozdedeusjpc.settings.ConfigActivity;
import com.avozdedeus.avozdedeusjpc.settings.ConfigActivity_MembersInjector;
import com.avozdedeus.avozdedeusjpc.settings.ConfigViewModel;
import com.avozdedeus.avozdedeusjpc.settings.ConfigViewModel_HiltModules;
import com.avozdedeus.avozdedeusjpc.settings.ConfigViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.avozdedeus.avozdedeusjpc.settings.ConfigViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.avozdedeus.avozdedeusjpc.tuner.AfinadorActivity;
import com.avozdedeus.avozdedeusjpc.tuner.AfinadorActivity_MembersInjector;
import com.avozdedeus.avozdedeusjpc.tuner.AfinadorViewModel;
import com.avozdedeus.avozdedeusjpc.tuner.AfinadorViewModel_HiltModules;
import com.avozdedeus.avozdedeusjpc.tuner.AfinadorViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.avozdedeus.avozdedeusjpc.tuner.AfinadorViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.LazyClassKeyMap;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class DaggerMainApplication_HiltComponents_SingletonC {
  private DaggerMainApplication_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public MainApplication_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new SingletonCImpl(applicationContextModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements MainApplication_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private SavedStateHandleHolder savedStateHandleHolder;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ActivityRetainedCBuilder savedStateHandleHolder(
        SavedStateHandleHolder savedStateHandleHolder) {
      this.savedStateHandleHolder = Preconditions.checkNotNull(savedStateHandleHolder);
      return this;
    }

    @Override
    public MainApplication_HiltComponents.ActivityRetainedC build() {
      Preconditions.checkBuilderRequirement(savedStateHandleHolder, SavedStateHandleHolder.class);
      return new ActivityRetainedCImpl(singletonCImpl, savedStateHandleHolder);
    }
  }

  private static final class ActivityCBuilder implements MainApplication_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public MainApplication_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements MainApplication_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public MainApplication_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements MainApplication_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public MainApplication_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements MainApplication_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public MainApplication_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements MainApplication_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public MainApplication_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements MainApplication_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public MainApplication_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends MainApplication_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends MainApplication_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    FragmentCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }
  }

  private static final class ViewCImpl extends MainApplication_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends MainApplication_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    ActivityCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    AudioMediaControllerCoordinator audioMediaControllerCoordinator() {
      return new AudioMediaControllerCoordinator(singletonCImpl.audioSessionRepositoryProvider.get());
    }

    @Override
    public void injectSobreActivity(SobreActivity arg0) {
      injectSobreActivity2(arg0);
    }

    @Override
    public void injectAcordesActivity(AcordesActivity arg0) {
      injectAcordesActivity2(arg0);
    }

    @Override
    public void injectAudioActivity(AudioActivity arg0) {
      injectAudioActivity2(arg0);
    }

    @Override
    public void injectHelpActivity(HelpActivity arg0) {
      injectHelpActivity2(arg0);
    }

    @Override
    public void injectMainActivity(MainActivity arg0) {
      injectMainActivity2(arg0);
    }

    @Override
    public void injectConfigActivity(ConfigActivity arg0) {
      injectConfigActivity2(arg0);
    }

    @Override
    public void injectAfinadorActivity(AfinadorActivity arg0) {
      injectAfinadorActivity2(arg0);
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Map<Class<?>, Boolean> getViewModelKeys() {
      return LazyClassKeyMap.<Boolean>of(ImmutableMap.<String, Boolean>builderWithExpectedSize(7).put(AcordesViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, AcordesViewModel_HiltModules.KeyModule.provide()).put(AfinadorViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, AfinadorViewModel_HiltModules.KeyModule.provide()).put(AudioViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, AudioViewModel_HiltModules.KeyModule.provide()).put(ConfigViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, ConfigViewModel_HiltModules.KeyModule.provide()).put(HelpViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, HelpViewModel_HiltModules.KeyModule.provide()).put(MainViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, MainViewModel_HiltModules.KeyModule.provide()).put(SobreViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, SobreViewModel_HiltModules.KeyModule.provide()).build());
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    private SobreActivity injectSobreActivity2(SobreActivity instance) {
      SobreActivity_MembersInjector.injectAppNavigator(instance, singletonCImpl.appActivityNavigatorProvider.get());
      return instance;
    }

    private AcordesActivity injectAcordesActivity2(AcordesActivity instance2) {
      AcordesActivity_MembersInjector.injectAppNavigator(instance2, singletonCImpl.appActivityNavigatorProvider.get());
      return instance2;
    }

    private AudioActivity injectAudioActivity2(AudioActivity instance3) {
      AudioActivity_MembersInjector.injectAppNavigator(instance3, singletonCImpl.appActivityNavigatorProvider.get());
      AudioActivity_MembersInjector.injectAudioMediaControllerCoordinator(instance3, audioMediaControllerCoordinator());
      return instance3;
    }

    private HelpActivity injectHelpActivity2(HelpActivity instance4) {
      HelpActivity_MembersInjector.injectAppNavigator(instance4, singletonCImpl.appActivityNavigatorProvider.get());
      return instance4;
    }

    private MainActivity injectMainActivity2(MainActivity instance5) {
      MainActivity_MembersInjector.injectAppNavigator(instance5, singletonCImpl.appActivityNavigatorProvider.get());
      return instance5;
    }

    private ConfigActivity injectConfigActivity2(ConfigActivity instance6) {
      ConfigActivity_MembersInjector.injectAppNavigator(instance6, singletonCImpl.appActivityNavigatorProvider.get());
      return instance6;
    }

    private AfinadorActivity injectAfinadorActivity2(AfinadorActivity instance7) {
      AfinadorActivity_MembersInjector.injectAppNavigator(instance7, singletonCImpl.appActivityNavigatorProvider.get());
      return instance7;
    }
  }

  private static final class ViewModelCImpl extends MainApplication_HiltComponents.ViewModelC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    Provider<AcordesViewModel> acordesViewModelProvider;

    Provider<AfinadorViewModel> afinadorViewModelProvider;

    Provider<AudioViewModel> audioViewModelProvider;

    Provider<ConfigViewModel> configViewModelProvider;

    Provider<HelpViewModel> helpViewModelProvider;

    Provider<MainViewModel> mainViewModelProvider;

    Provider<SobreViewModel> sobreViewModelProvider;

    ViewModelCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        SavedStateHandle savedStateHandleParam, ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;

      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.acordesViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.afinadorViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.audioViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2);
      this.configViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 3);
      this.helpViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 4);
      this.mainViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 5);
      this.sobreViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 6);
    }

    @Override
    public Map<Class<?>, javax.inject.Provider<ViewModel>> getHiltViewModelMap() {
      return LazyClassKeyMap.<javax.inject.Provider<ViewModel>>of(ImmutableMap.<String, javax.inject.Provider<ViewModel>>builderWithExpectedSize(7).put(AcordesViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) (acordesViewModelProvider))).put(AfinadorViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) (afinadorViewModelProvider))).put(AudioViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) (audioViewModelProvider))).put(ConfigViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) (configViewModelProvider))).put(HelpViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) (helpViewModelProvider))).put(MainViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) (mainViewModelProvider))).put(SobreViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) (sobreViewModelProvider))).build());
    }

    @Override
    public Map<Class<?>, Object> getHiltViewModelAssistedMap() {
      return ImmutableMap.<Class<?>, Object>of();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.avozdedeus.avozdedeusjpc.acorde.AcordesViewModel
          return (T) new AcordesViewModel();

          case 1: // com.avozdedeus.avozdedeusjpc.tuner.AfinadorViewModel
          return (T) new AfinadorViewModel();

          case 2: // com.avozdedeus.avozdedeusjpc.audio.presentation.AudioViewModel
          return (T) new AudioViewModel(singletonCImpl.audioSessionRepositoryProvider.get(), singletonCImpl.defaultOnsetAnalyzerProvider.get(), singletonCImpl.sharedPreferencesBpmAnalysisCacheProvider.get(), singletonCImpl.defaultAudioKeyAnalyzerProvider.get(), singletonCImpl.sharedPreferencesUserUiPreferencesProvider.get());

          case 3: // com.avozdedeus.avozdedeusjpc.settings.ConfigViewModel
          return (T) new ConfigViewModel(singletonCImpl.sharedPreferencesUserUiPreferencesProvider.get());

          case 4: // com.avozdedeus.avozdedeusjpc.help.HelpViewModel
          return (T) new HelpViewModel();

          case 5: // com.avozdedeus.avozdedeusjpc.home.MainViewModel
          return (T) new MainViewModel();

          case 6: // com.avozdedeus.avozdedeusjpc.about.SobreViewModel
          return (T) new SobreViewModel();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends MainApplication_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    ActivityRetainedCImpl(SingletonCImpl singletonCImpl,
        SavedStateHandleHolder savedStateHandleHolderParam) {
      this.singletonCImpl = singletonCImpl;

      initialize(savedStateHandleHolderParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandleHolder savedStateHandleHolderParam) {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends MainApplication_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }

    @Override
    public void injectAudioPlaybackService(AudioPlaybackService arg0) {
      injectAudioPlaybackService2(arg0);
    }

    private AudioPlaybackService injectAudioPlaybackService2(AudioPlaybackService instance) {
      AudioPlaybackService_MembersInjector.injectAudioSessionRepository(instance, singletonCImpl.audioSessionRepositoryProvider.get());
      return instance;
    }
  }

  private static final class SingletonCImpl extends MainApplication_HiltComponents.SingletonC {
    private final ApplicationContextModule applicationContextModule;

    private final SingletonCImpl singletonCImpl = this;

    Provider<AppActivityNavigator> appActivityNavigatorProvider;

    Provider<AudioSessionRepository> audioSessionRepositoryProvider;

    Provider<OnsetAnalysisSessionCache> onsetAnalysisSessionCacheProvider;

    Provider<DefaultOnsetAnalyzer> defaultOnsetAnalyzerProvider;

    Provider<SharedPreferencesBpmAnalysisCache> sharedPreferencesBpmAnalysisCacheProvider;

    Provider<DefaultAudioKeyAnalyzer> defaultAudioKeyAnalyzerProvider;

    Provider<SharedPreferencesUserUiPreferences> sharedPreferencesUserUiPreferencesProvider;

    SingletonCImpl(ApplicationContextModule applicationContextModuleParam) {
      this.applicationContextModule = applicationContextModuleParam;
      initialize(applicationContextModuleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final ApplicationContextModule applicationContextModuleParam) {
      this.appActivityNavigatorProvider = DoubleCheck.provider(new SwitchingProvider<AppActivityNavigator>(singletonCImpl, 0));
      this.audioSessionRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<AudioSessionRepository>(singletonCImpl, 1));
      this.onsetAnalysisSessionCacheProvider = DoubleCheck.provider(new SwitchingProvider<OnsetAnalysisSessionCache>(singletonCImpl, 3));
      this.defaultOnsetAnalyzerProvider = DoubleCheck.provider(new SwitchingProvider<DefaultOnsetAnalyzer>(singletonCImpl, 2));
      this.sharedPreferencesBpmAnalysisCacheProvider = DoubleCheck.provider(new SwitchingProvider<SharedPreferencesBpmAnalysisCache>(singletonCImpl, 4));
      this.defaultAudioKeyAnalyzerProvider = DoubleCheck.provider(new SwitchingProvider<DefaultAudioKeyAnalyzer>(singletonCImpl, 5));
      this.sharedPreferencesUserUiPreferencesProvider = DoubleCheck.provider(new SwitchingProvider<SharedPreferencesUserUiPreferences>(singletonCImpl, 6));
    }

    @Override
    public void injectMainApplication(MainApplication mainApplication) {
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return ImmutableSet.<Boolean>of();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.avozdedeus.avozdedeusjpc.AppActivityNavigator
          return (T) new AppActivityNavigator();

          case 1: // com.avozdedeus.avozdedeusjpc.audio.data.AudioSessionRepository
          return (T) new AudioSessionRepository(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 2: // com.avozdedeus.avozdedeusjpc.audio.analysis.DefaultOnsetAnalyzer
          return (T) new DefaultOnsetAnalyzer(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule), singletonCImpl.onsetAnalysisSessionCacheProvider.get());

          case 3: // com.avozdedeus.avozdedeusjpc.audio.analysis.OnsetAnalysisSessionCache
          return (T) new OnsetAnalysisSessionCache(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 4: // com.avozdedeus.avozdedeusjpc.audio.data.SharedPreferencesBpmAnalysisCache
          return (T) new SharedPreferencesBpmAnalysisCache(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 5: // com.avozdedeus.avozdedeusjpc.audio.analysis.DefaultAudioKeyAnalyzer
          return (T) new DefaultAudioKeyAnalyzer(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 6: // com.avozdedeus.avozdedeusjpc.core.common.prefs.SharedPreferencesUserUiPreferences
          return (T) new SharedPreferencesUserUiPreferences(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          default: throw new AssertionError(id);
        }
      }
    }
  }
}

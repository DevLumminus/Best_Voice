if(NOT TARGET oboe::oboe)
add_library(oboe::oboe SHARED IMPORTED)
set_target_properties(oboe::oboe PROPERTIES
    IMPORTED_LOCATION "C:/Users/Andre/.gradle/caches/8.13/transforms/a9f0672f5fa28f1031ed2c9f18a99045/transformed/oboe-1.10.0/prefab/modules/oboe/libs/android.x86/liboboe.so"
    INTERFACE_INCLUDE_DIRECTORIES "C:/Users/Andre/.gradle/caches/8.13/transforms/a9f0672f5fa28f1031ed2c9f18a99045/transformed/oboe-1.10.0/prefab/modules/oboe/include"
    INTERFACE_LINK_LIBRARIES ""
)
endif()


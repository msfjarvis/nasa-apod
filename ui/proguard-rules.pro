-keepattributes *Annotation*, InnerClasses, EnclosingMethod
-dontnote kotlinx.serialization.AnnotationsKt # core serialization annotations

-keep,includedescriptorclasses class dev.msfjarvis.lobsters.model.**$$serializer { *; }
-keepclassmembers class dev.msfjarvis.lobsters.model.** {
    *** Companion;
}
-keepclasseswithmembers class dev.msfjarvis.lobsters.model.** {
    kotlinx.serialization.KSerializer serializer(...);
}

-if public class ** implements java.io.Serializable
-keep public class <1> { *; }

# Inline-based optimizations cause reflection to fail within Ktor (from what I can tell), so we turn
# this off for now.
-dontoptimize

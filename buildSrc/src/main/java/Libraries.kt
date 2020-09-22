@file:Suppress("HardcodedStringLiteral")

object Libraries {
    object Jetpack {
        private const val coreVersion = "1.3.1"
        const val core = "androidx.core:core-ktx:$coreVersion"

        private const val appCompatVersion = "1.2.0"
        const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"

        object Compose {
            const val version = "1.0.0-alpha02"

            const val ui = "androidx.compose.ui:ui:$version"
            const val material = "androidx.compose.material:material:$version"
            const val uiTooling = "androidx.ui:ui-tooling:$version"
        }

        object Lifecycle {
            private const val version = "2.3.0-alpha07"

            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        }

        object Test {
            object Ext {
                private const val junitVersion = "1.1.2"
                const val junit = "androidx.test.ext:junit:$junitVersion"
            }

            object Espresso {
                private const val version = "3.3.0"

                const val core = "androidx.test.espresso:espresso-core:$version"
            }
        }
    }

    private const val materialVersion = "1.2.1"
    const val material = "com.google.android.material:material:$materialVersion"

    private const val junitVersion = "4.+"
    const val junit = "unit:junit:$junitVersion"
}

# Network-Aware LazyColumn

A Jetpack Compose library for creating a `LazyColumn` that reacts dynamically to network connectivity changes, enabling or disabling item interactions based on the network state.

---

## Features
- Automatically updates UI based on network connectivity.
- Seamless integration with Jetpack Compose.
- Lightweight and easy to use. (Hopefully)

---

## Installation

Add the JitPack repository to your `settings.gradle.kts` file:

```kotlin
pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}
```

Then add the dependency to your `build.gradle.kts` file:

```kotlin
dependencies {
    implementation("com.github.dontkeep:network-aware-lc:Tag")
}
```
Replace `Tag` with the latest version tag from the [releases](https://github.com/dontkeep/network-aware-lc/releases).

## Usage

Here's how to use the `NetworkAwareLazyColumn`:

1. Initialize the `NetworkMonitor` in your `MainActivity` or any other `ComponentActivity`.

```kotlin
val networkMonitor = NetworkMonitor(applicationContext)
```

2. Use the `NetworkAwareLazyColumn` composable:

```kotlin
NetworkAwareLazyColumn(
    items = listOf("Item 1", "Item 2", "Item 3"),
    networkMonitor = networkMonitor,
    modifier = Modifier.padding(innerPadding),
    itemContent = { item, isClickable, paddingModifier ->
        ItemCard(
            item = item,
            isClickable = isClickable,
            onClick = {
              Toast.makeText(this@MainActivity, "Clicked: $item", Toast.LENGTH_SHORT).show()
            }
        )
    }
)
```

### Example

An example project is available in the repository to demonstrate the usage of the library.

## Demo

https://github.com/user-attachments/assets/ff915715-954b-468b-b789-ce50a6f8de7e

## License

MIT License

Copyright (c) 2024 dontkeep

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.



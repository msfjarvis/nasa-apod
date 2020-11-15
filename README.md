# nasa-apod

[NASA APOD](https://apod.nasa.gov/apod/) app that uses a hard-coded list of old previous entries. This was built as the take home exercise for my interview with [Obvious](https://obvious.in/).

## Tech stack

The app went through multiple iterations, starting with [Ktor](https://github.com/ktorio/ktor) + [kotlinx.serialization](https://github.com/kotlin/kotlinx.serialization) to fetch and parse a remotely hosted copy of the JSON data. Ktor ended up causing multiple problems with R8 compatibility, so I switched to [Retrofit](https://github.com/square/retrofit) + [Moshi](https://github.com/square/moshi), finally dropping the fetching of the JSON from a remote server and instead loading and parsing it locally.

The libraries that this app is using as of now:

- [AppCompat](https://developer.android.com/jetpack/androidx/releases/appcompat) + [Fragments](https://developer.android.com/jetpack/androidx/releases/fragment) + [Material Components](https://material.io/develop/android) + [ViewPager2](https://developer.android.com/jetpack/androidx/releases/viewpager2) for UI
- [AndroidX Navigation](https://developer.android.com/guide/navigation) for handling navigation events
- [Moshi](https://github.com/square/moshi) for parsing JSON
- [Dagger Hilt](https://dagger.dev/hilt) for dependency injection
- [Coil](https://github.com/coil-kt/coil) for image loading
- [JUnit4](https://junit.org/junit4/) for unit tests

The test coverage is _decent_, but not ideal. The app does not have a lot of moving parts, and the business logic end of things is tested properly.

In order, this is what happens in the app:

1. Load raw resources and parse as JSON
2. Expose as a sorted list through a ViewModel
3. Render as grid in MainFragment and as ViewPager in DetailFragment

The first step is tested by ensuring that our Moshi adapter is able to correctly parse the JSON file.

The second step is tested by asserting that our comparator is correctly sorting instances of the `PictureDetail` class.

The third step is wholly untested as a result of my lack of experience with testing complex UI interactions, doubly worsened by build errors with Dagger Hilt. Maybe one day we'll remedy both of these problems :)

# License

```
Copyright (c) 2020 Harsh Shandilya

Permission is hereby granted, free of charge, to any
person obtaining a copy of this software and associated
documentation files (the "Software"), to deal in the
Software without restriction, including without
limitation the rights to use, copy, modify, merge,
publish, distribute, sublicense, and/or sell copies of
the Software, and to permit persons to whom the Software
is furnished to do so, subject to the following
conditions:

The above copyright notice and this permission notice
shall be included in all copies or substantial portions
of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF
ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT
SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR
IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
DEALINGS IN THE SOFTWARE.
```

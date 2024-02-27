## What I have done and why

Include a summary of what your pull request contains, and why you have made these changes.

Fixes #<issue_number_goes_here>

## Do tests pass?

- [ ] Check formatting: `./gradlew spotlessApply`
- [ ] Run local tests on `DemoDebug` variant: `./gradlew testDemoDebug`
  - [ ] Check build-logic: `./gradlew gradlew check -p build-logic`
  - [ ] Lint: `./gradlew lint`
  - [ ] Unit tests: `./gradlew test`
- [ ] Build: `./build -x check -x test -x lint`


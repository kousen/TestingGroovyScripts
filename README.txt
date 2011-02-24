Code to support blog post on testing Groovy scripts. A Gradle build
file is included, along with a Gradle wrapper.

In other words, if you already have Gradle installed, type:
> gradle build

and if you don't, type
> gradlew build

The latter will download and install Gradle version 0.9.2 and then run
the build, which includes the tests.

The source consists of three trivial scripts:
1. the standard "Hello, World!" in Groovy,
2. a script with a local variable and an assert, and
3. a script with an undeclared variable that can
be set by an external binding.

The test class runs all three scripts and shows that they work. See the
blog post at http://kousenit.wordpress.com/2011/02/24/testing-groovy-scripts/
for details.
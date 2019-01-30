# Three Scala Problems

Apologies I shall only cover **Mac** .

Install [Homebrew](https://brew.sh) for easy package management on Mac:

```bash
ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
```

```bash
$ brew cask install java
$ brew install jenv
$ brew install scala
$ brew install sbt
```

These install the necessary Java and Scala environment, where [jenv](http://www.jenv.be) manages said environment.

To configure our JVM environment:

```bash
$ jenv versions
    system
  * 11.0.2 (set by /Users/davidainslie/workspace/three-scala-problems/.java-version)
```

From the available versions, let's set the latest:

```bash
$ jenv local 11.0.2
```

Finally:

```bash
$ sbt test
```
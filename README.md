Project Euler Problems
======================
Implementations of [Project Euler] problems in Kotlin, Literate Coffeescript,
Python, Rust, and Scala.


Kotlin
------
Requires a JVM and [Kotlin] installation on your system.

To run a problem use:

    kotlinc -script 001.kts

### Kotlin Installation (macOS)
Create a Kotlin development environment using [SDKMAN].

    $ curl -s "https://get.sdkman.io" | bash

Follow the caveats printed to enable SDKMAN in the current shell.

    $ source "$HOME/.sdkman/bin/sdkman-init.sh"

Then install Java and Kotlin:

    $ sdk install java
    $ sdk install kotlin

Commands:

* `sdk help` to show commands.
* `sdk current` to show current SDK versions.
* `sdk list` to list available SDK.
* `sdk install <sdk>` to install a new SDK version.
* `sdk use <sdk>` to select a given SDK version for use.
* `sdk uninstall <sdk>` to uninstall a given SDK version.


Literate Coffeescript
---------------------
Requires a [NodeJS] installation with [Coffee] on your system.

To run a problem use:

    coffee 001.litcoffee


Python
------
Requires a [Python] installation on your system.

To run a problem use:

    python 001.py

### Python Installation (macOS)
Create a Python development environment using [pyenv].

    $ brew install pyenv

[pyenv]: https://github.com/pyenv/pyenv

Follow the caveats printed and add the following to your `.zprofile`.

    # Homebrew Pyenv initialisation.
    if which pyenv > /dev/null; then eval "$(pyenv init -)"; fi

Commands:

* `pyenv version` to show current Python version.
* `pyenv versions` to list available local Python versions.
* `pyenv install --list` to show Python versions available to install.
* `pyenv install <version>` to install a new Python version.
* `pyenv global <version>` to select a given Python version for use.
* `pyenv uninstall <version>` to delete a given Python version.


Rust
----
Requires a [Rust] installation on your system.

To run a problem use:

    rustc 001.rs
    ./001


Scala
-----
Requires a Java installation on your system.

To run a problem use the bootstrap [Ammonite] script in the `scala` directory:

    cd scala
    ./amm 001.scala

### Java Installation (macOS)
Create a Java development environment using [SDKMAN].

    $ curl -s "https://get.sdkman.io" | bash

Follow the caveats printed to enable SDKMAN in the current shell.

    $ source "$HOME/.sdkman/bin/sdkman-init.sh"

Then install Java:

    $ sdk install java

Commands:

* `sdk help` to show commands.
* `sdk current` to show current SDK versions.
* `sdk list` to list available SDK.
* `sdk install <sdk>` to install a new SDK version.
* `sdk use <sdk>` to select a given SDK version for use.
* `sdk uninstall <sdk>` to uninstall a given SDK version.


[Project Euler]: https://projecteuler.net
[SDKMAN]: https://sdkman.io/
[Kotlin]: https://kotlinlang.org/
[NodeJS]: https://nodejs.org
[Coffee]: https://coffeescript.org
[Python]: https://python.org
[Rust]: https://www.rust-lang.org
[Ammonite]: https://ammonite.io

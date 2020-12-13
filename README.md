Project Euler Problems
======================
Implementations of [Project Euler] problems in Literate Coffeescript, Python,
Rust, and Scala.


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
Requires a JVM installation on your system.

To run a problem use the bootstrap [Ammonite] script in the `scala` directory:

    cd scala
    ./amm 001.scala


[Project Euler]: https://projecteuler.net
[NodeJS]: https://nodejs.org
[Coffee]: https://coffeescript.org
[Python]: https://python.org
[Ammonite]: https://ammonite.io
[Rust]: https://www.rust-lang.org

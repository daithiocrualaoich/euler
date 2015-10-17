Project Euler Problems
======================
Implementation of [ProjectEuler] problems.

Literate Coffeescript
---------------------
Create the Docker as described below, or otherwise get a [NodeJS] installation
on your system. Install Coffeescript using `npm`:

    npm install -g coffee-script

To run a problem use:

    coffee 001.litcoffee

Rust
----
Create the Docker as described below, or otherwise get a [Rust] installation
on your system.

To run a problem use:

    rustc 001.rs
    ./001

Scala
-----
Create the Docker as described below, or otherwise get a [Scala] installation
on your system.

To run a problem use:

    scala 001.scala

Development: Docker
-------------------
A `Dockerfile` container definition is provided at the top level of the source
tree with installations of the development tools needed to build and run the
Project Euler examples.

To build the container, first install [Docker] if necessary and start a Docker
terminal. Then create the container image using:

    docker build --rm=true -t euler .

Run a shell in the development container with:

    docker run -it -v $(pwd):/docker euler /bin/bash

The current working directory from the host machine is available at `/docker`
inside the container. Change to that directory before running the problems as
described above.

    cd /docker

From time to time, it is necessary to clean up old containers and images to
reclaim space. To do this, run:

    docker ps -a | grep Exited | awk '{ print $1 }' | xargs -- docker rm
    docker images | grep none | awk '{ print $3 }' | xargs -- docker rmi

Deleting all the containers and images will also remove the cached steps in
the `euler` image build. The next subsequent build will be cache busted in
`apt-get upgrade` and will fetch the latest versions. This is sometimes
required for images that have been cached for a long time.


[ProjectEuler]: http://projecteuler.net
[NodeJS]: http://nodejs.org
[Scala]: http://www.scala-lang.org/
[Rust]: https://www.rust-lang.org/
[Docker]: http://docker.io

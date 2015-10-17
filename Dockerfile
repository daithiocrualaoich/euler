FROM        debian:latest
MAINTAINER  Daithi O Crualaoich



################################################################################
# Basic Development Tools
################################################################################

RUN     apt-get update -qq
RUN     apt-get upgrade -qq

RUN     apt-get install -qq wget
RUN     apt-get install -qq build-essential gcc



################################################################################
# Coffee
################################################################################

RUN     apt-get -qq install git
RUN     wget -q https://nodejs.org/dist/v4.2.1/node-v4.2.1-linux-x64.tar.gz
RUN     tar xzf node-v4.2.1-linux-x64.tar.gz --strip-components=1 -C /usr
RUN     rm node-v4.2.1-linux-x64.tar.gz

RUN     npm install -g coffee-script



################################################################################
# Rust
################################################################################

RUN     wget -q https://static.rust-lang.org/dist/rust-1.3.0-x86_64-unknown-linux-gnu.tar.gz
RUN     tar xzf rust-1.3.0-x86_64-unknown-linux-gnu.tar.gz
RUN     rust-1.3.0-x86_64-unknown-linux-gnu/install.sh --without=rust-docs
RUN     rm -fr rust-1.3.0-x86_64-unknown-linux-gnu.tar.gz rust-1.3.0-x86_64-unknown-linux-gnu



################################################################################
# Scala
################################################################################

RUN     apt-get install -qq openjdk-7-jdk

RUN     wget -q http://downloads.typesafe.com/scala/2.11.7/scala-2.11.7.tgz
RUN     tar xzf scala-2.11.7.tgz --strip-components=1 -C /usr
RUN     rm scala-2.11.7.tgz

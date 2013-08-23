Project Euler Problems
======================
Literate Coffeescript implementation of [ProjectEuler] problems.

Running
-------
Create the VM as described below, or otherwise get a [NodeJS] installation on
your system. Install Coffeescript using `npm`:

    npm install -g coffee-script

To run a problem use:

    coffee 001.litcoffee


Development: Vagrant/Virtualbox VM
----------------------------------
[VirtualBox] and [Vagrant] are tools to "create and configure lightweight,
reproducible, and portable development environments." Vagrant itself is a
virtual instance creation and startup tool on top of Oracle VirtualBox which
takes care of the virtualisation.

Download and install the Open Source Edition of [VirtualBox].

Then download and install [Vagrant]. The Linux packages install the `vagrant`
executable at `/opt/vagrant/bin` and you will want to add this to your path.

To build the VM, change to the `dev/vagrant` directory and run the provide
`Rakefile` target:

    rake

Building the VM may take some time, particularly on the first occasion when
Ubuntu base images are downloaded. The completed VM will be output at
`dev/vagrant/euler'.box`.

To use this VM, change back to the root of the repository and use the
`Vagrantfile` provided there to create an instance of the VM:

    vagrant up

When this is complete, you can ssh onto the instance using:

    vagrant ssh

The directory where the `Vagrantfile` was sourced is mounted at `/vagrant` on
the VM so change there for development.

    cd /vagrant

When finished developing, you can destroy the VM using:

    vagrant destroy -f

To see more verbose output on any vagrant command, add a VAGRANT_LOG environment
variable setting, e.g.:

    VAGRANT_LOG=INFO /opt/vagrant/bin/vagrant up

Further help troubleshooting can be obtained by editing your `Vagrantfile` and
enabling the `virtualbox.gui = true` setting. This will pop up a VirtualBox
GUI window on boot.

Note that VT-x/AMD-V hardware acceleration may need to be enabled in your BIOS
to use VirtualBox virtualisation


[ProjectEuler]: http://projecteuler.net
[NodeJS]: http://nodejs.org
[VirtualBox]: https://www.virtualbox.org/wiki/Downloads
[Vagrant]: http://vagrantup.com

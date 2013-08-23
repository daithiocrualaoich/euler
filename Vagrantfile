Vagrant.configure("2") do |config|

  config.vm.box = "euler"
  config.vm.box_url = "dev/vagrant/euler.box"

  config.ssh.forward_x11 = true

  config.vm.hostname = "euler"
  config.vm.provider :virtualbox do |virtualbox|
    virtualbox.name = "noted"
    # virtualbox.gui = true
  end
end

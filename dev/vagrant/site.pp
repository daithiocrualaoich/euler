node default {


  ##############################################################################
  #
  # Apt preliminaries and basic packages
  #
  ##############################################################################

  exec {
    'apt-update': command => '/usr/bin/apt-get update';
  }

  package {
    [
      'bash-completion',
      'vim',
      'curl',
      'unzip',
      'bzip2'
    ]: ensure => latest;
  }

  Exec['apt-update'] -> Package <| |>



  ##############################################################################
  #
  # NodeJS
  #
  ##############################################################################

  package {
    [
      'git',
      'build-essential'
    ]: ensure => latest;
  }

  include nodejs

  exec {
    'install-coffeescript':
      command => '/usr/local/bin/npm install -g coffee-script',
      creates => '/usr/local/bin/coffee',
      timeout => 0
  }

  Package['build-essential'] -> Class['nodejs'] -> Exec['install-coffeescript']


  ##############################################################################
  #
  # Literate Programming
  #
  ##############################################################################

  package {
    [
      'markdown',
      'pandoc',
      'texlive'
    ]: ensure => latest;
  }

}

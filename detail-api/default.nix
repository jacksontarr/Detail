{ mkShell, maven, jdk11 }:
{
  shell = mkShell {
    packages = [ 
      maven
      jdk11
    ];
  };
}
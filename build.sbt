
name := "scalculator"

scalaVersion := "2.11.5"

/** Shell */
shellPrompt := { state => System.getProperty("user.name") + "> " }

/** Dependencies */
resolvers ++= 
    Seq(Resolver.sonatypeRepo("releases"), 
        Resolver.sonatypeRepo("snapshots"),
        Resolver.typesafeRepo("releases"),
        "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases")
  

libraryDependencies <++= version { version =>
  Seq(
    "org.specs2"      %% "specs2-core"         ,
    "org.specs2"      %% "specs2-matcher-extra",
    "org.specs2"      %% "specs2-gwt"          ,
    "org.specs2"      %% "specs2-html"         ,
    "org.specs2"      %% "specs2-form"         ,
    "org.specs2"      %% "specs2-scalacheck"   ,
    "org.specs2"      %% "specs2-mock"         ,
    "org.specs2"      %% "specs2-junit"        
  ).map(_ % version)
}

scalacOptions ++= Seq("-Yrangepos", "-deprecation", "-unchecked", "-feature", "-language:_")

logBuffered := false

mainClass in Compile := Some("fr.scalculator.Main")


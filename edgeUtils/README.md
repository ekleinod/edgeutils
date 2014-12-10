# edgeUtils - Java Classes

These are the java classes, delivered as eclipse project.

You can use the classes directly, or you can use the jar file as library.

## Jar File Versions

I keep a history of all jar files in the `export` folder.
The most recent version is contained twice: once as `edgeutils.jar`, once with its version number.

Example for two versions, `0.3` being the most recent version:

	export
		edgeutils-0.2.jar
		edgeutils-0.3.jar
		edgeutils.jar <-- same as edgeutils-0.3.jar

## Java Files vs. Jar

I have to use the jar file because I otherwise would have to use the eclipse project which I can only import once in eclipse.
As long as there is a workspace for every single project you are fine.
You are fine as well, if you do not rely on unified paths for every developer of your project.

An example: I want to use `edgeUtils` in two projects: `A` and `B`.
Both projects create a jar file, this creation is done with an ant build file.
In this build file I have to give the path to `edgeUtils`.
This path is different for my different development computers (one using Windows, one using Linux).

To unify this path, I include `edgeUtils` as submodule in both projects.
Thus I have unified paths but two instances of `edgeUtils`, which I cannot use sinmultaneously in eclipse.
Therefore I use the jar file.


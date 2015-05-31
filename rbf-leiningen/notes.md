# Install `lein`

Web: http://leiningen.org

Use following commands on Mac OS X terminal:

``` bash
LEIN_SCRIPT='/usr/local/bin/lein' # Make sure it's on $PATH
LEIN_SCRIPT_URL='https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein'
curl -fsSL --create-dirs -o $LEIN_SCRIPT $LEIN_SCRIPT_URL && chmod +x $LEIN_SCRIPT && lein
```

Alternative if the previous command doesn't work (requires you to `sudo` to modify `/usr/*`):

``` bash
LEIN_PATH=/usr/local/bin/
curl -fsSLO https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein && \
  chmod +x lein && \
  sudo mkdir -p $LEIN_PATH && \
  sudo mv lein $LEIN_PATH && \
  lein
```
A the first launch, the script auto-installs everything required for `lein` and `clojure` to work. You should see something like the following:

```
Downloading Leiningen to /Users/rob/.lein/self-installs/leiningen-2.5.1-standalone.jar now...
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100   406    0   406    0     0    529      0 --:--:-- --:--:-- --:--:--   529
100 14.5M  100 14.5M    0     0  1093k      0  0:00:13  0:00:13 --:--:-- 1637k

Leiningen is a tool for working with Clojure projects.

Several tasks are available:
change              Rewrite project.clj by applying a function.
check               Check syntax and warn on reflection.
classpath           Print the classpath of the current project.
clean               Remove all files from project's target-path.
compile             Compile Clojure source into .class files.
deploy              Build and deploy jar to remote repository.
deps                Download all dependencies.
do                  Higher-order task to perform other tasks in succession.
help                Display a list of tasks or help for a given task.
install             Install the current project to the local repository.
jar                 Package up all the project's files into a jar file.
javac               Compile Java source files.
new                 Generate project scaffolding based on a template.
plugin              DEPRECATED. Please use the :user profile instead.
pom                 Write a pom.xml file to disk for Maven interoperability.
release             Perform :release-tasks.
repl                Start a repl session either with the current project or standalone.
retest              Run only the test namespaces which failed last time around.
run                 Run a -main function with optional command-line arguments.
search              Search remote maven repositories for matching jars.
show-profiles       List all available profiles or display one if given an argument.
test                Run the project's tests.
trampoline          Run a task without nesting the project's JVM inside Leiningen's.
uberjar             Package up the project files and dependencies into a jar file.
update-in           Perform arbitrary transformations on your project map.
upgrade             Upgrade Leiningen to specified version or latest stable.
vcs                 Interact with the version control system.
version             Print version for Leiningen and the current JVM.
with-profile        Apply the given task with the profile(s) specified.

Run `lein help $TASK` for details.

Global Options:
  -o             Run a task offline.
  -U             Run a task after forcing update of snapshots.
  -h, --help     Print this help or help for a specific task.
  -v, --version  Print Leiningen's version.

See also: readme, faq, tutorial, news, sample, profiles, deploying, gpg,
mixed-source, templates, and copying.
```

> **Java missing**: If you do not have the `java` command-line tool you will see following error message instead:
> ``` bash
> No Java runtime present, requesting install.
> ```
> At the same time a dialog will ask you to install the Java Developer Kit to proceed:
> ![Install JDK dialog](images/dialog_install_jdk_mac.png)
> Click on `More Info...` and follow the instructions to install the JDK (you will be redirected to the Oracle website).
> After installing the JDK verify that `java` command-line tool was properly installed, e.g.:
> ```
> $ java -version
> java version "1.8.0_45"
> Java(TM) SE Runtime Environment (build 1.8.0_45-b14)
> Java HotSpot(TM) 64-Bit Server VM (build 25.45-b02, mixed mode)
> ```
> If so, you can now relaunch `lein` to proceed.



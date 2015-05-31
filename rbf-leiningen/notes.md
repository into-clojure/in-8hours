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
  sudo mkdir -p  $LEIN_PATH && \
  sudo mv lein $LEIN_PATH && \
  lein
```

You should see something like the following:

``` bash
Downloading Leiningen to /Users/rob/.lein/self-installs/leiningen-2.5.1-standalone.jar now...
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100   406    0   406    0     0    529      0 --:--:-- --:--:-- --:--:--   529
100 14.5M  100 14.5M    0     0  1093k      0  0:00:13  0:00:13 --:--:-- 1637k
```

> **Java missing**: If you do not have the `java` command-line tool you will see following error message:
> ``` bash
> No Java runtime present, requesting install.
> ```
> At the same time a dialog will ask you to install the Java Developer Kit to proceed:
> ![Install JDK dialog](images/dialog_install_jdk_mac.png)

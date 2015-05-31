# Install `lein`

Web: http://leiningen.org

Use following commands on Mac OS X terminal:

``` bash
LEIN_SCRIPT='/usr/local/bin/lein' # Make sure it's on $PATH
LEIN_SCRIPT_URL='https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein'
curl -fsSL -o $LEIN_SCRIPT $LEIN_SCRIPT_URL && chmod +x $LEIN_SCRIPT && lein
```

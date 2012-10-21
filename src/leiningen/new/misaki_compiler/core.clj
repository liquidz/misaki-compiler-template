(ns misaki.compiler.{{name}}.core
  (:require
    [misaki.server  :as srv]))

(defn -extension
  "Set watch target extension as keyword. (REQUIRED)"
  []
  (list :txt))


(defn -config
  "Set custom configuration. (OPTIONAL)"
  [config]
  (assoc config :message "hello {{name}}"))


(defn -compile
  "Compile specified java.io.File. (REQUIRED)

  * Return value:
   * string? : Write string to file named as same as template file.
   * true/false : Do nothing.
   * map? : Write file with detailed setting.
     * `:status`   : Compile result (true/false).
     * `:filename` : Filename to write
     * `:body`     : Compiled body text. If body is nil, only status is checked.
     * `:stop-compile?` : Flag(true/false) to stop compilation.
     * `:all-compile?`  : Flag(true/false) to force compiling all templates.
  "
  [config file]

  (str (:message config) " " (slurp file)))


(defn -main [& args]
  (apply srv/-main args))

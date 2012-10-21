(ns misaki.compiler.{{name}}.core-test
  (:use clojure.test
        misaki.compiler.{{name}}.core
        misaki.tester)
  (:require [clojure.string :as str]))

; set base directory which include _config.clj
; default testing base directory is "test"
(set-base-dir! "test/")


; define test wrapping config data as *config*
;
; This code is same as following:
;   (deftest foo-test
;     (binding [*base-dir* "test"
;               *config* (get-config)]
;       (is (= "hello") (:template-dir *config*))))
(deftest* -config-test
  ; get compiler's config which is customized by `-config`
  (is (= "hello {{name}}" (:message (get-config)))))

(deftest* -compile-test
  (let [in  (template-file "foo.txt")
        out (public-file   "foo.txt")]
    ; call `-compile` to test your compling
    (is (test-compile in))
    (is (= "hello {{name}} world" (str/trim (slurp out))))
    (.delete out)))

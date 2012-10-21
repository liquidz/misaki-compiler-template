(ns misaki.compiler.{{name}}.core-test
  (:use clojure.test
        misaki.compiler.{{name}}.core
        ;[misaki.util file]
        misaki.tester)
  (:require [clojure.string :as str]
            [clojure.java.io :as io]))

(set-base-dir! "test/")

(deftest* -config-test
  (is (= "hello {{name}}" (:message (get-config)))))

(deftest* -compile-test
  (let [in  (template-file "foo.txt")
        out (public-file "foo.txt")]
    (is (test-compile in))
    (is (= "hello {{name}} world" (str/trim (slurp out))))

    (.delete out)))





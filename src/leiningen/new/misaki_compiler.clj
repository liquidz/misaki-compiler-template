(ns leiningen.new.misaki-compiler
  (:use [leiningen.new.templates
         :only [renderer year project-name
                ->files sanitize-ns name-to-path]]))

(def render (renderer "misaki-compiler"))

(defn misaki-compiler
  "FIXME: write documentation"
  [name]
  (let [data {:name      name
              :sanitized (name-to-path name)
              :year      "{{year}}"
              :month     "{{month}}"
              :filename  "{{filename}}"}]
    (->files
      data
      ["project.clj"  (render "project.clj" data)]
      ["README.md"    (render "README.md" data)]
      ["doc/intro.md" (render "intro.md" data)]
      [".gitignore"   (render ".gitignore" data)]
      ["sample/_config.clj" (render "_config.clj" data)]
      ["sample/template/foo.txt" (render "foo.txt" data)]
      ["src/misaki/compiler/{{sanitized}}/core.clj"  (render "core.clj" data)]
      ["test/misaki/compiler/{{name}}/core_test.clj" (render "core_test.clj" data)])))


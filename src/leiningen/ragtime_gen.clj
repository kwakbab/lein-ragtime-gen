(ns leiningen.ragtime-gen
  (:require [clojure.java.io :as io]
            [clj-time.core :refer [now]]
            [clj-time.format :refer [unparse formatter]]))

(declare give-a-name)
(declare check-basic-settings)

(defn ragtime-gen
  [project & [migration-name]]
  (when (check-basic-settings project migration-name)
    (let [file-dir (:migration-path project)
          dir? (.isDirectory (io/file file-dir))]
      (if dir?
        (let [file-name (give-a-name migration-name)
              file-name-with-path (format "%s/%s" file-dir file-name)]
          (with-open [w (io/writer file-name-with-path)]
            (do
              (.write w "{:up [\"\"] :down [\"\"]}")
              (println (str "generated ./" file-name-with-path)))))
        (println (format "Hi. -> $ mkdir %s" (:migration-path project)))))))

(defn- give-a-name [name]
  (format "%s-%s.edn" (unparse (formatter "yyyyMMddhhmmss") (now)) name))

(defn- check-basic-settings [project migration-name]
  (cond
    (nil? migration-name) (do
                            (println "require 'migration-name'")
                            false)
    (nil? (:migration-path project)) (do
                                       (println "require :migration-path")
                                       false)
    :else true))

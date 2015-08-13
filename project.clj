(defproject lein-ragtime-gen "0.0.2"
  :description "generating ragtime migration files"
  :url "https://github.com/kwakbab/lein-ragtime-gen"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [clj-time "0.10.0"]]
  :jvm-opts ["-Duser.timezone=UTC"]
  :eval-in-leiningen true)

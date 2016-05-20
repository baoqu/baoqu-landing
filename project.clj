(defproject baoqu-landing "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [funcool/catacumba "0.15.0"]
                 [hiccup "1.0.5"]
                 [org.clojure/clojurescript "1.8.51"]
                 [rum "0.8.3"]
                 [funcool/httpurr "0.6.0"]]
  :main baoqu-landing.core
  :plugins [[lein-cljsbuild "1.1.3"]]
  :cljsbuild {:builds
              [{:id "dev"
                :source-paths ["src-cljs"]
                :compiler {:main baoqu-landing.core
                           :output-to "resources/public/assets/js/app.js"
                           :output-dir "resources/public/assets/js/out"
                           :asset-path "assets/js/out"
                           :source-map-timestamp true}}]})

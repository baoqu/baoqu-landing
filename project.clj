(defproject baoqu-landing "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [;; Clojure
                 [org.clojure/clojure "1.8.0"]
                 [ring "1.4.0"]
                 [ring/ring-json "0.4.0"]
                 [compojure "1.5.0"]
                 [hiccup "1.0.5"]
                 [com.layerware/hugsql "0.4.7"]
                 [sqlitejdbc "0.5.6"]
                 ;; ClojureScript
                 [org.clojure/clojurescript "1.8.51"]
                 [rum "0.8.3"]
                 [funcool/httpurr "0.6.0"]]
  :main baoqu-landing.core
  :plugins [[lein-cljsbuild "1.1.3"]
            [lein-ring "0.9.7"]]
  :ring {:handler baoqu-landing.core/app
         :port 3030
         :init baoqu-landing.core/bootstrap}
  :cljsbuild {:builds
              [{:id "dev"
                :source-paths ["src-cljs"]
                :compiler {:main baoqu-landing.core
                           :output-to "resources/public/assets/js/app.js"
                           :output-dir "resources/public/assets/js/out"
                           :asset-path "assets/js/out"
                           :source-map-timestamp true}}]})

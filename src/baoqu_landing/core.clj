(ns baoqu-landing.core
  (require [catacumba.core :as ct]
           [baoqu-landing.templates :as t]
           [catacumba.handlers.misc :as misc])
  (:gen-class))

(defn main-handler
  [ctx]
  {:status 200
   :headers {:content-type "text/html"}
   :body (t/landing)})

(def app
  (ct/routes [[:any (misc/autoreloader)]
              [:all "" #'main-handler]
              [:assets "assets" {:dir "public/assets"}]]))

(defn -main
  [& args]
  (ct/run-server app {:port 3030
                      :marker-file "basedir-marker"}))

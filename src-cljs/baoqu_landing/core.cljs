(ns baoqu-landing.core
  (:require [rum.core :as rum]
            [httpurr.client.xhr :as http]
            [promesa.core :as p]))

(enable-console-print!)

(defn say-hi [e]
  (let [mail-el (js/document.getElementById "mail-input")
        mail (.-value mail-el)]
    (js/alert (str "Se ha registrado el siguiente correo: " mail))
;;    (-> (http/send! {:method :get
;;                     :url "https://seequestor-dev.docker.kaleidos.net/api/"})
;;        #(p/then (println %) ))
    ))

(rum/defc mail-form []
  [:div.form-box
   [:input#mail-input {:placeholder "Leave us your email here"} ]
   [:button.btn {:on-click say-hi} "Join"]])

(rum/mount (mail-form) (js/document.getElementById "form"))

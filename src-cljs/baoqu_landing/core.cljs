(ns baoqu-landing.core
  (:require [rum.core :as rum]))

(enable-console-print!)

(defn say-hi [e]
  (let [mail-el (js/document.getElementById "email")
        mail (.-value mail-el)]
    (js/alert (str "Se ha registrado el siguiente correo: " mail))))

(rum/defc mail-form []
  [:div
   [:input#email]
   [:button {:on-click say-hi} "Enviar"]])

(rum/mount (mail-form) (js/document.getElementById "mail-form"))

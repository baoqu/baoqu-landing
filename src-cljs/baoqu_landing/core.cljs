(ns baoqu-landing.core
  (:require [rum.core :as rum]
            [httpurr.client.xhr :as http]
            [promesa.core :as p]))

(enable-console-print!)

(defn say-hi [e]
  (let [mail-el (js/document.getElementById "mail-input")
        mail (.-value mail-el)]
    (-> (http/send! {:method :post
                     :url "http://localhost:3030/newmail"
                     :headers {:content-type "application/json"}
                     :body {:mail mail}})
        (p/then #(println %)))))

(rum/defc mail-form []
  [:div
   [:form.form-box {:on-submit say-hi}
    [:input#mail-input {:placeholder "Leave us your email"}]
    [:button.btn "Join"]]
   [:p.success "Mail correctly registered!"]
   [:p.failuer "An error has occurred!"]])

(rum/mount (mail-form) (js/document.getElementById "form"))

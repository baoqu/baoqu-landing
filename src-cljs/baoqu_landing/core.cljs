(ns baoqu-landing.core
  (:require [rum.core :as rum]
            [httpurr.client.xhr :as http]
            [promesa.core :as p]))

(enable-console-print!)

(def state (atom {}))

(defn validate-mail
  [mail]
  (re-matches #"[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?" mail))

(defn map->json
  [map]
  (js/JSON.stringify (clj->js map)))

(defn say-hi [e]
  (.preventDefault e)
  (let [mail-el (js/document.getElementById "mail-input")
        mail (.-value mail-el)
        valid? (validate-mail mail)]
    (if valid?
      (-> (http/send! {:method :post
                       :url "http://localhost:3030/newmail"
                       :headers {:content-type "application/json"}
                       :body (map->json {:mail mail})})
          (p/then (fn [r]
                    (if (= 201 (:status r))
                      (swap! state assoc :result :success)
                      (do
                        (swap! state assoc :result :error)
                        (println r))))))
      (swap! state assoc :result :invalid))))

(rum/defc mail-form < rum/reactive
  []
  (let [s (rum/react state)]
    [:div
     [:form.form-box {:on-submit say-hi}
      [:input#mail-input {:placeholder "Leave us your email"}]
      [:button.btn "Join"]]
     (if (= :success (:result @state)) [:p.success "Mail correctly registered, we'll keep you posted ;)"])
     (if (= :error (:result @state)) [:p.failuer "Ouch, an error has occurred :("])
     (if (= :invalid (:result @state)) [:p.advice "Enter an email address if you wanna have all the fun"])]))

(rum/mount (mail-form) (js/document.getElementById "form"))

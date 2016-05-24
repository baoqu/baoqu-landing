(ns baoqu-landing.core
  (:require [rum.core :as rum]
            [httpurr.client.xhr :as http]
            [promesa.core :as p]))

(enable-console-print!)

(def state (atom {}))

(defn say-hi [e]
  (.preventDefault e)
  (let [mail-el (js/document.getElementById "mail-input")
        mail (.-value mail-el)]
    (-> (http/send! {:method :post
                     :url "http://localhost:3030/newmail"
                     :headers {:content-type "application/json"}
                     :body {:mail mail}})
        (p/then (fn [r]
                  (if (= 201 (:status r))
                    (swap! state assoc :result :success)
                    (do
                      (swap! state assoc :result :error)
                      (println r))))))))

(rum/defc mail-form < rum/reactive
  []
  (let [s (rum/react state)]
    [:div
     [:form.form-box {:on-submit say-hi}
      [:input#mail-input {:placeholder "Leave us your email"}]
      [:button.btn "Join"]]
     (if (= :success (:result @state)) [:p.success "Mail correctly registered!"])
     (if (= :error (:result @state)) [:p.failuer "An error has occurred!"])]))

(rum/mount (mail-form) (js/document.getElementById "form"))

(ns baoqu-landing.templates
  (require [hiccup.core :refer [html]]))

(def google-analytics-string
  "(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
    (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
    m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
    })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');
    ga('create', 'UA-7259258-6', 'auto');
    ga('send', 'pageview');")

(defn landing
  []
  (html
   [:html
    [:head
     [:title "Baoqu"]
     [:meta {:name "viewport" :content "width=device-width, initial-scale=1"}]
     [:link {:rel "icon" :type "image/png" :href "/assets/img/favicon.png"}]
     [:link {:rel "stylesheet" :href "/assets/css/main.css"}]
     [:link {:rel "stylesheet" :href "https://fonts.googleapis.com/css?family=Open+Sans"}]]
    [:body
      [:div.mod-principal
        [:div.item.hero-unit
          [:div.header
            [:span.logo]
            [:h1 "Baoqu"]
          ]
          [:h2 "Online deliberation for massive groups"]
          [:div#form]
          [:div.hint "We are willing to enrole anyone who want to participate in the first test (coming soon), but also people who want to join us developing this."]
          [:div.links
            [:a.twitter {:href "https://twitter.com/_BaoQu_"} "Twitter"]
            [:a.github {:href "https://github.com/baoqu"} "Github"]
          ]]
        [:div.item.device
          [:ul.mobile
            [:li.screen.ideas]
            [:li.screen.map]
            [:li.screen.comments]
          ]]]
      [:div.mod-secondary
        [:p.description "Horizontal deliberation for massive groups in a whole new way"]
        [:ul.benefits
          [:li.mapping
            [:img.map {:src "/assets/img/benefit-map.png"}]
            [:h3 "Mapping the conversation"]
            [:p "We map visually the deliberation in a fractal way"]]
          [:li.trolling
            [:img.troll {:src "/assets/img/benefit-troll.png"}]
            [:h3 "Trolling resilient"]
            [:p "System rules for crosspollination and troll resilience"]]
          [:li.open
            [:img.open {:src "/assets/img/benefit-open.png"}]
            [:h3 "Open Source"]
            [:p "Baoqu is an open initiative being made in an open way"]]
        ]
        [:div#mail-form]]
        [:div.mod-wide
          [:img.open {:src "/assets/img/desktop.png"}]
        ]
        [:div.footer
          [:span.copy "Powered by "
            [:a {:href "http://piweek.tumblr.com"} "Piweek"]
            ", made with &#9829; and Open Source"]
          [:span.email "infobaoqu [at] gmail.com"]
        ]
     [:script {:type "text/javascript" :src "/assets/js/app.js"}]
     [:script google-analytics-string]]]))

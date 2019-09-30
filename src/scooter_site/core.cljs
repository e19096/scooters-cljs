(ns scooter-site.core
    (:require
      [reagent.core :as r]
      [scooter-site.data :as data]))

(defn header []
  [:div {:class "Header-container"}
        [:span {:class "Header-title"} "E-scooter Emporium"]
        [:img {:src "/assets/logo.png" :class "Header-logo" :alt "logo"}]
        0 [:i {:class "material-icons"} "shopping_cart"]])

(defn product-index
  ([] [:div [:span "hey, i'm the product index"]])
  ([something] [:marquee something]))

(defn home-page []
  [:div [header]
        [product-index]
        [product-index "yo yo yo"]
        [product-index]
        ])

(defn mount-root []
  (r/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))

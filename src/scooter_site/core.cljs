(ns scooter-site.core
    (:require
      [reagent.core :as r]))

;; -------------------------
;; Views

(defn product-index []
  [:div "THIS IS THE PRODUCT INDEX"])


(defn home-page []
  [:div [:h2 "Welcome to Reagent"]
        [product-index]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (r/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))

(ns scooter-site.core
    (:require
      [reagent.core :as r]
      [scooter-site.components.products :as prod]))

;; -------------------------
;; Views


(defn home-page []
  [:div [:h2 "Welcome to Reagent"]
        [prod/product-index]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (r/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))

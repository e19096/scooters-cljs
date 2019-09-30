(ns scooter-site.core
    (:require
      [reagent.core :as r]
      [clojure.string :as str]
      [scooter-site.data :as data]))
      ; [scooter-site.components.products :as prod]))

;; -------------------------
;; Views

(defonce cart-count (r/atom 0))

(defn header []
  [:div {:class "Header-container"}
        [:span {:class "Header-title"} "E-scooter Emporium"]
        [:img {:src "/assets/logo.png" :class "Header-logo" :alt "logo"}]
        @cart-count [:i {:class "material-icons"} "shopping_cart"]])

(defn scooter->style [scooter]
  (if (clojure.string/includes? (:name scooter) "Red")
    {:color "red"}
    (cond
      (clojure.string/includes? (:name scooter) "Purple") {:color "mediumpurple"}
      (= (:name scooter) "Seat Scooter") {:border "2px dotted hotpink"}
      :else {})))

(defn red-scooter-style [scooter-name]
  (when (clojure.string/includes? scooter-name "Red")
    {:color "red"}))

(defn product-item [product]
  (let [{:keys [name price image] :as scooter} product]
    ; [:div {:class "prod-item" :style (red-scooter-style name)}
    [:div {:class "prod-item" :style (scooter->style scooter)}
         [:img {:src image}]
         [:marquee {:class "details"} ;; or div.details
                   [:div name]
                   [:div (-> scooter :price :currency-symbol)
                         (-> scooter :price :value)]
                   [:button {:on-click #(swap! cart-count inc)}
                            "Add"]]]))

; (defn product-item [product]
;   [:ul [:li (:name product)]
;        [:li (:price product)]
;        [:li [:img {:src (:image product)}]]])

(defn product-index []
  [:div {:class "prod-idx"}; "hi hi hi"
        (map product-item data/products)])
        ; (map #(-> % :name) data/products)])
        ; (map :name data/products)])
        ; (map #(:name %) data/products)])
        ; (map #(get % :name) data/products)])
        ; (map str data/products)])
        ; (map #(str %) data/products)])
        ; (map (fn [product] (str product)) data/products)])


(defn home-page []
  [:div [header]
        [product-index]])
        ; [prod/product-index]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (r/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))

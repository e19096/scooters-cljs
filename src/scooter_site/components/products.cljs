(ns scooter-site.components.products
    (:require [reagent.core :as r]
              [scooter-site.data :as data]))

(defonce cart-count (r/atom 0))

(defn product-item [product]
  (let [{:keys [name price image] :as scooter} product]
    [:div {:class "prod-item"}
         [:img {:src image}]
         [:div {:class "details"}
               [:div name]
               [:div (-> scooter :price :currency-symbol)
                     (-> scooter :price :value)]
               [:button {:on-click #(swap! cart-count inc)}
                        "Add"]]
     ]))

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

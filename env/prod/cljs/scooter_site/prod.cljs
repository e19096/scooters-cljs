(ns scooter-site.prod
  (:require
    [scooter-site.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)

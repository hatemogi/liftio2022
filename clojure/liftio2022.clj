(ns liftio2022
  [:require [clojure.core.reducers :refer [fold]]])

(reduce + (range 0 10))
(fold + (range 0 10))
(reverse [1 2 3])
(reverse (reverse [1 2 3]))


module Lib (replicate', length', someFunc) where

someFunc :: IO ()
someFunc = putStrLn "someFunc"

replicate' :: Int -> a -> [a]
replicate' 0 _ = []
replicate' n x = x : replicate' (n - 1) x

length' :: [a] -> Int
length' = foldr (const (+1)) 0
